package com.shakticoin.utils;

import io.restassured.response.Response;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;
import static org.testng.Assert.assertNotNull;
import static org.hamcrest.Matchers.*;

public class GetEmailOTP {
	static String getEmailOTP = "https://gatewayservice-qa.shakticoin.com/testproxy/api/v2/otp/email";
	//static String getEmailOTP = "https://gatewayservice-stg.shakticoin.com/testproxy/api/v2/otp/email";
	
	public static String getEmailOTP(String email, String requestedFlow) {
		String otp = "";

		//QA
		Response tokenRes = given().auth().preemptive()
				.basic("438cfcdc-f77a-4e5c-af59-7c3663fffe91", "d7QaOVA8vCAZV7gIci68DTW8JqWLCCZdKfX4qY90")
				.formParam("grant_type", "client_credentials").when()
				.post("https://iam-qa.shakticoin.com/oxauth/restv1/token");
		//Staging
		/*Response tokenRes = given().auth().preemptive()
				.basic("3ec74ea5-78d8-488f-8abd-9cf55eede78c", "PhoWaSP41U2LeeSITmmczb5XQWBGGtBCGPP79T9E")
				.formParam("grant_type", "client_credentials").when()
				.post("https://iam-stg.shakticoin.com/oxauth/restv1/token");*/

		String TOKResp = tokenRes.getBody().asString();
		System.out.println("RESPONSE_BODY_IS" + TOKResp);

		JsonPath jsonResToken = new JsonPath(TOKResp);
		String access_token = jsonResToken.getString("access_token");
		System.out.println("ACCESS_TOKEN_IS" + access_token);

		System.out.println("========POST Endpoint Start=========");
		System.out.println("POST_GetEmailOTP: " + getEmailOTP);
		Response getEmailOTPRes = given().contentType("application/json").auth().oauth2(access_token).when()
				.body(getEmailBody(email, requestedFlow)).post(getEmailOTP);		

		// assertNotNull(getEmailOTPRes);
		System.out.println(getEmailBody(email, requestedFlow));
		String GET_Resp = getEmailOTPRes.getBody().asString();
		System.out.println("RESPONSE_BODY_IS: " + GET_Resp);

		int GET_StatusCode = getEmailOTPRes.getStatusCode();
		System.err.println("RESPONSE_STATUS_CODE_IS: " + GET_StatusCode);

		long GET_ResponseTime = getEmailOTPRes.getTime();
		System.err.println("RESPONSE_TIME_IS: " + GET_ResponseTime);

		JsonPath emailOTP = new JsonPath(GET_Resp);
		otp = emailOTP.getString("data.otp");
		System.out.println("EMAIL_OTP_IS:--" + otp);

		return otp;
	}
	
	public static String getEmailBody(String email, String requestedFlow) {
		String emailBody = "{\n" + "    \"email\":\"" + email + "\", \n" + "    \"requestedFlow\":\"" + requestedFlow
				+ "\" \n" + "}";
		return emailBody;
	}	
	public static void main(String[] args) {
		getEmailOTP("saurabhtestc2+test@gmail.com", "User_Email_Register_Flow");
	}
}
