package com.ratnamit.weatherapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/")
public class WeatherApiUIController {

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("")
	public ModelAndView index() {
		return new ModelAndView("index");
	}
	@RequestMapping(method = RequestMethod.GET, value = "/city/{cityName}")
	@HystrixCommand(fallbackMethod = "fallbackMethod")
	public String getWeatherInfoByCity(@PathVariable("cityName") String cityName) {		

		String response = restTemplate.exchange("http://weather-forecast-service/city/{cityName}", HttpMethod.GET, null,
				new ParameterizedTypeReference<String>() {
				}, cityName).getBody();

		return response;
	}

}
