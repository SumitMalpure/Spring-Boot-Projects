/**
 * 
 */
package com.ratnamit.weatherapp.data;

import java.util.List;

/**
 * @author sumitmalpure1089
 *
 */
public class WeatherInfo {

	private String forecastMessage;
	private String cityName;
	private String statusCode;
	List<ForecastUI> forecastList;
	
	/**
	 * @return the forecastMessage
	 */
	public String getForecastMessage() {
		return forecastMessage;
	}
	/**
	 * @param forecastMessage the forecastMessage to set
	 */
	public void setForecastMessage(String forecastMessage) {
		this.forecastMessage = forecastMessage;
	}
	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}
	/**
	 * @param cityName the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	/**
	 * @return the statusCode
	 */
	public String getStatusCode() {
		return statusCode;
	}
	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	/**
	 * @return the forecastList
	 */
	public List<ForecastUI> getForecastList() {
		return forecastList;
	}
	/**
	 * @param forecastList the forecastList to set
	 */
	public void setForecastList(List<ForecastUI> forecastList) {
		this.forecastList = forecastList;
	}
}
