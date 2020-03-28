/**
 * 
 */
package com.ratnamit.springbootdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sumitmalpure1089
 *
 */
@RestController
public class WeatherForecastController {

	@RequestMapping(path = "ratnamit")
	public String sayHello() {
		return "Hello SpringBoot";
	}
}
