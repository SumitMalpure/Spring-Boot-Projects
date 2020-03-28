/**
 * 
 */
package com.ratnamit.weatherapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ratnamit.weatherapp.data.Forecast;
import com.ratnamit.weatherapp.data.ForecastUI;
import com.ratnamit.weatherapp.data.WeatherInfo;
import com.ratnamit.weatherapp.model.OpenWeatherResponse;

/**
 * @author sumitmalpure1089
 *
 */
@RestController
@RequestMapping("weather-forecast")
public class WeatherAppController {

	@Autowired
	RestTemplate restTemplate;
	
	@Value("${weather.api.key}")
	private String apiKey;
	
	@RequestMapping(method=RequestMethod.GET,value="city/{cityName}")
	public WeatherInfo getWeatherInfo(@PathVariable("cityName") String cityName){
	//	WeatherInfo weatherInfo= restTemplate.getForObject("https://api.openweathermap.org/data/2.5/weather?q="+cityId+"&appid="+apiKey+"&units=metric", WeatherInfo.class);
		String url="https://api.openweathermap.org/data/2.5/forecast?q="+cityName+"&mode=JSON&appid="+apiKey+"&units=metric&cnt=3";
		OpenWeatherResponse openWeatherResponse= restTemplate.getForObject(url, OpenWeatherResponse.class);
		WeatherInfo weatherInfo=new WeatherInfo();
		if("200".equalsIgnoreCase(openWeatherResponse.getCod())) {
			weatherInfo.setStatusCode("200");
			List<ForecastUI> forecastUIList=new ArrayList<>();
			List<Forecast> forecastList=openWeatherResponse.getList();
			String forecastMessage="";
			for(Forecast forecast:forecastList) {
				ForecastUI forecastUI =new ForecastUI();
				forecastUI.setForecastDate(forecast.getDt_txt());
				forecastUI.setLowTemp(forecast.getMain().getTemp_max());
				forecastUI.setHighTemp(forecast.getMain().getTemp_min());
				if(forecast.getMain().getTemp_max()>40) {
					forecastMessage="Use Sunscreen";
				}
				if(forecastMessage.isEmpty() && forecast.getWeather()!=null && forecast.getWeather().size()>0) {
					forecastMessage+=" Carry Umbrella";
				}
				forecastUIList.add(forecastUI);
			}
			weatherInfo.setForecastList(forecastUIList);
			weatherInfo.setForecastMessage(forecastMessage);
			
		}else {
			weatherInfo.setStatusCode("500");	
		}
		return weatherInfo ;
	}
}
