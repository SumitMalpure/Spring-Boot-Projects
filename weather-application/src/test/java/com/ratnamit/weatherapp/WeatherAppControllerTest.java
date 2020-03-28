package com.ratnamit.weatherapp;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.TestExecutionListeners.MergeMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.ratnamit.weatherapp.controller.WeatherAppController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WeatherApplication.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@TestExecutionListeners(value = {
		DirtiesContextTestExecutionListener.class }, mergeMode = MergeMode.MERGE_WITH_DEFAULTS)
@ActiveProfiles(profiles = "TEST")
@SpringBootTest
public class WeatherAppControllerTest {

	@InjectMocks
	private WeatherAppController weatherAppController;

	private MockMvc mockMvc;

	//private HttpHeaders headers;

	@Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(weatherAppController).build();
	}

	@Test
	public void getWeatherInfo() throws Exception {

		// WeatherInfo weatherInfo = weatherAppController.getWeatherInfo("Limassol");
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("cityId", "Pune");
		((ResultActions) ((MockHttpServletRequestBuilder) this.mockMvc.perform(get("/cityId"))).params(params))
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("cod").exists());
	}
}
