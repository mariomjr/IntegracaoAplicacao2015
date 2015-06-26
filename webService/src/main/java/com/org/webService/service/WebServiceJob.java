package com.org.webService.service;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;

import com.google.gson.Gson;


public class WebServiceJob {
	
	public String testarWebServiceGet(String url){
		try{
			
			ClientRequest request = new ClientRequest(url);
			request.accept("application/json");
            ClientResponse<String> response = request.get(String.class);
            
            if (response.getStatus() != 200) {
				return "Failed : HTTP error code : " + response.getStatus();
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(
        			new ByteArrayInputStream(response.getEntity().getBytes())));
            String output = "";
            StringBuilder resposta = new StringBuilder();
    		while ((output = br.readLine()) != null) {
    			System.out.println(output);
    			resposta.append(output);
    		}
    		
			return resposta.toString();

		}catch(Exception e){
			
		}
		return "";
	}
	
	public String testarWebServicePost(String url, Object object){
		try{
			
			ClientRequest request = new ClientRequest(url);
			request.accept("application/json");
            ClientResponse<String> response = request.post(String.class);
            Gson gson = new Gson();
            String strJson = gson.toJson(object);
            
            request.body("application/json", strJson);
            if (response.getStatus() != 200) {
				return "Failed : HTTP error code : " + response.getStatus();
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(
        			new ByteArrayInputStream(response.getEntity().getBytes())));
            String output;
    		while ((output = br.readLine()) != null) {
    			System.out.println(output);
    		}
    		return output;

		}catch(Exception e){
			
		}
		return "";
	}
}
