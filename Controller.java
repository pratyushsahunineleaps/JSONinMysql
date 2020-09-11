package com.example.crifdemo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crifdemo.bean.SelfieImageRequest;
import com.example.crifdemo.dao.User;
import com.example.crifdemo.dao.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
@RestController
@RequestMapping("/crif")
public class Controller {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/statusCheck")
	public String getStatus() {
		return "success";
	}
	@GetMapping
	public HttpResponse<String> test() {
		HttpResponse<String> response = null;
		try {
			String encodedString = getEncoder();
			response = Unirest.post("https://test.crifhighmark.com/Inquiry/do.getSecureService/DTC/initiate")
					.header("content-type", "text/plain").header("orderId", "123").header("accessCode", encodedString)
					.header("appID", "aP!$5E^&rRO!ty&&S!*I^@aS*").header("merchantID", "DTC0000088")
					.body("JEENA|JOHN|WILSON||10-04-1975|||7856397562|||abc@abc.com||VTLAN2506Q||||||||JOHN|||A-301, BALAJI APT, NEAR POLICE STATION, UTTAN ROAD|THANE|THANE|Maharashtra|401101|india|||||||DTC0000088|BBC_CONSUMER_SCORE#85#2.0|Y|").asString();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(response.);
		return response;
	}

	private String getEncoder() {
		/*DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime now = LocalDateTime.
		System.out.println(dtf.format(now)); */
		
		LocalDateTime myDateObj = LocalDateTime.now();
	    System.out.println("Before formatting: " + myDateObj);
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	    String formattedDate = myDateObj.format(myFormatObj);

		Encoder encoder = Base64.getEncoder();
		// String originalString = "basic";
		String originalString = "chm_bbc_uat@aspire.com|DTC0000088|BBC_CONSUMER_SCORE#85#2.0|F6615CC1AFC8BBC28BEAA9BFF942F605FE0960A6|"
				+ formattedDate;
		System.out.println(originalString);
		String encodedString = encoder.encodeToString(originalString.getBytes());
		System.out.println(encodedString);
		return encodedString;
	}
	@PostMapping("/jsonTest")
	public String saveJson(@RequestBody SelfieImageRequest status) throws JsonProcessingException {
		/*JSONObject jobject=new JSONObject();
		jobject.accumulate("status", "success");
		User u=new User();
		u.setUsername("pratyush");
		u.setJsonData(jobject);*/
	      ObjectMapper mapper = new ObjectMapper();
	      String jsonString= mapper.writeValueAsString(status);
		User user=new User();
		user.setUsername("Pratyush");
		user.setJsonData(new JSONObject(jsonString));
		userRepository.save(user);
		return "success";
	}
	@GetMapping("/gsonGet")
	private SelfieImageRequest getJsonData() {
		Gson g = new Gson();
		Optional<User> user=userRepository.findById((long) 84658);	
		JSONObject jsonString=user.get().getJsonData();
		 //jsonResponse = new JSONObject(resourceResponse);
		SelfieImageRequest selfieImageRequest=g.fromJson(jsonString.toString(), SelfieImageRequest.class);
		return selfieImageRequest;
	}
	
}
