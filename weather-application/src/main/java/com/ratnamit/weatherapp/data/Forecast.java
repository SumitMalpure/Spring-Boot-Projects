package com.ratnamit.weatherapp.data;

import java.util.ArrayList;
import java.util.List;

public class Forecast {
	private float dt;
	Main main;
	List<Weather> weather = new ArrayList<>();
	Clouds clouds;
	Wind wind;
	Rain rain;
	Sys sys;
	private String dt_txt;
	/**
	 * @return the dt
	 */
	public float getDt() {
		return dt;
	}
	/**
	 * @param dt the dt to set
	 */
	public void setDt(float dt) {
		this.dt = dt;
	}
	/**
	 * @return the main
	 */
	public Main getMain() {
		return main;
	}
	/**
	 * @param main the main to set
	 */
	public void setMain(Main main) {
		this.main = main;
	}
	/**
	 * @return the weather
	 */
	public List<Weather> getWeather() {
		return weather;
	}
	/**
	 * @param weather the weather to set
	 */
	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}
	/**
	 * @return the clouds
	 */
	public Clouds getClouds() {
		return clouds;
	}
	/**
	 * @param clouds the clouds to set
	 */
	public void setClouds(Clouds clouds) {
		this.clouds = clouds;
	}
	/**
	 * @return the wind
	 */
	public Wind getWind() {
		return wind;
	}
	/**
	 * @param wind the wind to set
	 */
	public void setWind(Wind wind) {
		this.wind = wind;
	}
	/**
	 * @return the rain
	 */
	public Rain getRain() {
		return rain;
	}
	/**
	 * @param rain the rain to set
	 */
	public void setRain(Rain rain) {
		this.rain = rain;
	}
	/**
	 * @return the sys
	 */
	public Sys getSys() {
		return sys;
	}
	/**
	 * @param sys the sys to set
	 */
	public void setSys(Sys sys) {
		this.sys = sys;
	}
	/**
	 * @return the dt_txt
	 */
	public String getDt_txt() {
		return dt_txt;
	}
	/**
	 * @param dt_txt the dt_txt to set
	 */
	public void setDt_txt(String dt_txt) {
		this.dt_txt = dt_txt;
	}
	


}