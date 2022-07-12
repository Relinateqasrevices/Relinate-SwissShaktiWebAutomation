package com.shakticoin.utils;

import static io.restassured.RestAssured.given;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetUserStatus {

	public static String  getUserStatus = "https://gatewayservice-qa.shakticoin.com/usermanagement/api/v2/users/status";
	//public static String  getUserStatus = "https://gatewayservice-stg.shakticoin.com/usermanagement/api/v2/users/status";
    
    public static boolean getUserStatus(String email){
    	//QA
    	Response tokenRes = given().auth().preemptive()
				.basic("438cfcdc-f77a-4e5c-af59-7c3663fffe91", "d7QaOVA8vCAZV7gIci68DTW8JqWLCCZdKfX4qY90")
				.formParam("grant_type", "client_credentials").when()
				.post("https://iam-qa.shakticoin.com/oxauth/restv1/token");

    	//Staging    	
			/*		Response tokenRes = given().auth().preemptive()
    					.basic("3ec74ea5-78d8-488f-8abd-9cf55eede78c", "PhoWaSP41U2LeeSITmmczb5XQWBGGtBCGPP79T9E")
    					.formParam("grant_type", "client_credentials").when()
    					.post("https://iam-stg.shakticoin.com/oxauth/restv1/token");*/
		String TOKResp = tokenRes.getBody().asString();
		System.out.println("RESPONSE_BODY_IS" + TOKResp);

		JsonPath jsonResToken = new JsonPath(TOKResp);
		String access_token = jsonResToken.getString("access_token");
		System.out.println("ACCESS_TOKEN_IS" + access_token);

   
		Response questionsRes = given().contentType("application/json").auth().oauth2(access_token).when()
                        .queryParam("email",email)
                        .get(getUserStatus);
     

        String GET_Resp = questionsRes.getBody().asString();
        System.out.println("RESPONSE_BODY_IS" + GET_Resp);

        int GET_StatusCode = questionsRes.getStatusCode();
        System.err.println("RESPONSE_STATUS_CODE_IS" + GET_StatusCode);

        long GET_ResponseTime = questionsRes.getTime();
        System.err.println("RESPONSE_TIME_IS" + GET_ResponseTime);
        
        JsonPath emailOTP = new JsonPath(GET_Resp);
		String status = emailOTP.getString("data.isRegistered");
		System.out.println("User status is:--" + status);
		if(status.equalsIgnoreCase("true"))
			return true;
		else
			return false;
    }
    
    public static void main(String[] args) {
		getUserStatus("saurabhtestc2@gmail.com");
	}
}
