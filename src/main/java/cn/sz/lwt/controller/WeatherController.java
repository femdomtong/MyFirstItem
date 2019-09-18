package cn.sz.lwt.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.sz.lwt.pojo.Weather;

@RestController
@RequestMapping("/wc")
public class WeatherController {
		@Autowired
		RestTemplate restTemplate;
		
		@RequestMapping("getWeather")
		public  Weather httpUrlConnectionGet(Model model,String cityCode) {
	        System.out.println("----------");
	        String apiURL = "http://t.weather.sojson.com/api/weather/city/"+cityCode;
	        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiURL, String.class);
	        ObjectMapper objectMapper = new ObjectMapper();
	        Weather weather = null;
	        String strBody = null;
	        if(200==responseEntity.getStatusCodeValue()){
	        	strBody = responseEntity.getBody();
	        	 try {
	 	        	weather = objectMapper.readValue(strBody, Weather.class);
	 	        	model.addAttribute("info", "成功!");
	 	        } catch (Exception e) {
	 	            e.printStackTrace();
	 	        }
	        }else{
	        	model.addAttribute("info", "失败!");
	        }
	       
	        return weather;

	        
	    }
	    
		
	
	
}
