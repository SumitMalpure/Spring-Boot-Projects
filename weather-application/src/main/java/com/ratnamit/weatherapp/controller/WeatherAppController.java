/**
 * 
 */
package com.ratnamit.weatherapp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ratnamit.weatherapp.data.WeatherInfo;

/**
 * @author sumitmalpure1089
 *
 */
@RestController
@RequestMapping("/weatherapp")
public class WeatherAppController {

	@Autowired
	RestTemplate restTemplate;
	
	@Value("${api.key}")
	private String apiKey;
	
	@RequestMapping("/cityId")
	public WeatherInfo getWeatherInfo(@PathVariable("cityId") String cityId){
		
		WeatherInfo weatherInfo= restTemplate.getForObject("https://api.openweathermap.org/data/2.5/weather?q="+cityId+"&appid="+apiKey+"&units=metric", WeatherInfo.class);
		
		Map<String,String> uriVariables = new HashMap<>();
		ResponseEntity<WeatherInfo> response=restTemplate.getForEntity("https://api.openweathermap.org/data/2.5/weather?q="+cityId+"&appid="+apiKey+"&units=metric", WeatherInfo.class, uriVariables);
		response.getBody();
		return weatherInfo ;
		
	}
}
