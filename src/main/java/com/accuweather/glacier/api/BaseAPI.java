package com.accuweather.glacier.api;

import static com.accuweather.glacier.Environment.PROD;

import static com.accuweather.glacier.Environment.QA;

import com.chameleon.AutomationException;

import com.chameleon.api.restServices.Headers.HeaderType;

import com.chameleon.api.restServices.ParameterBuilder;

import com.chameleon.api.restServices.ParameterBuilder.Parameters;

import com.chameleon.api.restServices.RestResponse;

import com.chameleon.api.restServices.RestService;

public class BaseAPI {

	// private final static String QA_URL =
	// "http://qa-accuweather-api-northcentral-us.cloudapp.net/";

	private final static String QA_URL = "http://ncus-gadc-api-production.trafficmanager.net/";

	// private final static String PROD_URL = "http://api.accuweather.com/";

	// private final static String QA_URL = "https://glacier-dev1.accuweather.com/";

	// private final static String PROD_URL =
	// "https://glacier-dev1.accuweather.com/";

	private final static String PROD_URL = "http://accuweather-api-glacier-northcentral-us.cloudapp.net/";

	private final static String KEY = "16803";

	// private final static String KEY = "328219";

	private ThreadLocal<String> language = ThreadLocal.withInitial(() -> "en-us");

	private ThreadLocal<Boolean> includeDetails = ThreadLocal.withInitial(() -> true);

	private ThreadLocal<Boolean> metricDetails = ThreadLocal.withInitial(() -> false);

	private ThreadLocal<String> dayCount = ThreadLocal.withInitial(() -> "3");

	protected void setDefaultLanguage(String language) {

		this.language.set(language);

	}

	protected void setDayCount3(String dayCount) {

		this.dayCount.set(dayCount);

	}

	protected void setDefaultLanguage(boolean includeDetails) {

		this.includeDetails.set(includeDetails);

	}

	protected void setDayCount3(boolean includeDetails) {

		this.includeDetails.set(includeDetails);

	}

	protected RestResponse sendGetRequest(String path) {

		Parameters params = new ParameterBuilder.Parameters();

		return rest().sendGetRequest(path, HeaderType.JSON, params.build());

	}

	protected RestResponse sendGetRequest(String path, Parameters params) {

		return rest().sendGetRequest(path, HeaderType.JSON, params.build());

	}

	private RestService rest() {

		return new RestService();

	}

	protected String pathBuilder(String... resources) {

		return String.join("/", resources);

	}

	protected Parameters buildParams(Parameters params) {

		params.add("language", language.get());

		params.add("dayCount", dayCount.get());

		params.add("details", includeDetails.get());

		params.add("metricdetails", metricDetails.get());

		params.add("apikey", KEY);

		return params;

	}

	protected String getRootURL(final String environment) {

		switch (environment.toLowerCase()) {

		case PROD:

			return PROD_URL;

		case QA:

			return QA_URL;

		default:

			throw new AutomationException("Environment [ " + environment + " ] not supported");

		}

	}

}