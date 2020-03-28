package com.ratnamit.weatherapp.model;

import java.util.ArrayList;

import com.ratnamit.weatherapp.data.Forecast;

public class OpenWeatherResponse {

	private String cod;
	private float message;
	private float cnt;
	public ArrayList<Forecast> list = new ArrayList<>();
	/**
	 * @return the cod
	 */
	public String getCod() {
		return cod;
	}
	/**
	 * @param cod the cod to set
	 */
	public void setCod(String cod) {
		this.cod = cod;
	}
	/**
	 * @return the message
	 */
	public float getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(float message) {
		this.message = message;
	}
	/**
	 * @return the cnt
	 */
	public float getCnt() {
		return cnt;
	}
	/**
	 * @param cnt the cnt to set
	 */
	public void setCnt(float cnt) {
		this.cnt = cnt;
	}
	/**
	 * @return the list
	 */
	public ArrayList<Forecast> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(ArrayList<Forecast> list) {
		this.list = list;
	}
		
}

 











