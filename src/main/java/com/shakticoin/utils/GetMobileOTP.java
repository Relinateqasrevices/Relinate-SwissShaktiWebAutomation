package com.shakticoin.utils;

import static io.restassured.RestAssured.given;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetMobileOTP {
	
	static String getMobileOTP = "https://gatewayservice-qa.shakticoin.com/testproxy/api/v2/otp/mobile";
    //static String getMobileOTP = "https://gatewayservice-stg.shakticoin.com/testproxy/api/v2/otp/mobile";

	
	public static String getMobileOTP(String countryCode,String mobile, String requestedFlow) {
		String otp = "";

		//QA
		Response tokenRes = given().auth().preemptive()
				.basic("438cfcdc-f77a-4e5c-af59-7c3663fffe91", "d7QaOVA8vCAZV7gIci68DTW8JqWLCCZdKfX4qY90")
				.formParam("grant_type", "client_credentials").when()
				.post("https://iam-qa.shakticoin.com/oxauth/restv1/token");
		
		//Staging
	/*	Response tokenRes = given().auth().preemptive()
				.basic("3ec74ea5-78d8-488f-8abd-9cf55eede78c", "PhoWaSP41U2LeeSITmmczb5XQWBGGtBCGPP79T9E")
				.formParam("grant_type", "client_credentials").when()
				.post("https://iam-stg.shakticoin.com/oxauth/restv1/token");*/

		String TOKResp = tokenRes.getBody().asString();
		System.out.println("RESPONSE_BODY_IS" + TOKResp);

		JsonPath jsonResToken = new JsonPath(TOKResp);
		String access_token = jsonResToken.getString("access_token");
		System.out.println("ACCESS_TOKEN_IS" + access_token);

		System.out.println("========POST Endpoint Start=========");
		System.out.println("POST_GetMobileOTP: " + getMobileOTP);
		Response getMobileOTPRes = given().contentType("application/json").auth().oauth2(access_token).when()
				.body(getMobileBody(countryCode, mobile, requestedFlow)).post(getMobileOTP);		
		System.out.println(getMobileBody(countryCode, mobile, requestedFlow));		

		String GET_Resp = getMobileOTPRes.getBody().asString();
		System.out.println("RESPONSE_BODY_IS: " + GET_Resp);

		int GET_StatusCode = getMobileOTPRes.getStatusCode();
		System.err.println("RESPONSE_STATUS_CODE_IS: " + GET_StatusCode);

		long GET_ResponseTime = getMobileOTPRes.getTime();
		System.err.println("RESPONSE_TIME_IS: " + GET_ResponseTime);

		JsonPath mobileOTP = new JsonPath(GET_Resp);
		otp = mobileOTP.getString("data.otp");
		System.out.println("MOBILE_OTP_IS:--" + otp);

		return otp;
	}
	
	public static String getMobileBody(String countryCode,String mobile, String requestedFlow) {
        String smsBody =
                "{\n" +
                        "    \"countryCode\": \"" + countryCode + "\",\n" +
                        "    \"mobileNo\": \"" + mobile + "\",\n" +
                        "    \"requestedFlow\": \"" + requestedFlow + "\"\n" +
                        "}";
        return smsBody;
    }
	public static void main(String[] args) {
		getMobileOTP("+91","8074791500", "User_Mobile_Register_Flow");
	}
}
