package com.accuweather.api.locations.searchByCountryCode;

import static com.accuweather.glacier.Environment.PROD;
import static com.accuweather.glacier.Environment.QA;

import org.testng.annotations.Test;

import com.accuweather.glacier.LocationData;
import com.accuweather.glacier.api.AccuweatherRest;
import com.chameleon.BaseTest;
import com.chameleon.api.restServices.ResponseCodes;
import com.chameleon.api.restServices.RestResponse;
import com.chameleon.utils.TestReporter;
import com.chameleon.validators.JsonObjectComparator;

public class Test_SearchByCountryCode_HighPoint extends BaseTest {

    LocationData locationData = LocationData.HIGH_POINT_NC;

    @Test
    public void textSearchByCountryCodeAndAdminCode_HighPoint() {
        final RestResponse qaResponse = AccuweatherRest.locations().v1(QA).textSearchByCountryCodeAndAdminCode(locationData.getCountry(), locationData.getState(), locationData.getCity());
        TestReporter.logAPI(qaResponse.getStatusCode() == ResponseCodes.OK, "failed to get qa city data", qaResponse);

        final RestResponse prodResponse = AccuweatherRest.locations().v1(PROD).textSearchByCountryCodeAndAdminCode(locationData.getCountry(), locationData.getState(), locationData.getCity());
        TestReporter.logAPI(prodResponse.getStatusCode() == ResponseCodes.OK, "failed to get prod city data", prodResponse);

        JsonObjectComparator validator = new JsonObjectComparator();
        validator.validate(qaResponse, prodResponse);
    }

    @Test
    public void textSearchByCountryCodeAndAdminCode_HighPoint_ExcludePassingResults() {
        final RestResponse qaResponse = AccuweatherRest.locations().v1(QA).textSearchByCountryCodeAndAdminCode(locationData.getCountry(), locationData.getState(), locationData.getCity());
        TestReporter.logAPI(qaResponse.getStatusCode() == ResponseCodes.OK, "failed to get qa city data", qaResponse);

        final RestResponse prodResponse = AccuweatherRest.locations().v1(PROD).textSearchByCountryCodeAndAdminCode(locationData.getCountry(), locationData.getState(), locationData.getCity());
        TestReporter.logAPI(prodResponse.getStatusCode() == ResponseCodes.OK, "failed to get prod city data", prodResponse);

        JsonObjectComparator validator = new JsonObjectComparator();
        validator.setReportSuccessfulValidations(false)
                .validate(qaResponse, prodResponse);
    }

    @Test
    public void textSearchByCountryCode_HighPoint() {
        final RestResponse qaResponse = AccuweatherRest.locations().v1(QA).textSearchByCountryCode(locationData.getCountry(), locationData.getCity());
        TestReporter.logAPI(qaResponse.getStatusCode() == ResponseCodes.OK, "failed to get qa city data", qaResponse);

        final RestResponse prodResponse = AccuweatherRest.locations().v1(PROD).textSearchByCountryCode(locationData.getCountry(), locationData.getCity());
        TestReporter.logAPI(prodResponse.getStatusCode() == ResponseCodes.OK, "failed to get prod city data", prodResponse);

        JsonObjectComparator validator = new JsonObjectComparator();
        validator.validate(qaResponse, prodResponse);
    }

    @Test
    public void textSearchByCountryCode_HighPoint_ExcludePassingResults() {
        final RestResponse qaResponse = AccuweatherRest.locations().v1(QA).textSearchByCountryCode(locationData.getCountry(), locationData.getCity());
        TestReporter.logAPI(qaResponse.getStatusCode() == ResponseCodes.OK, "failed to get qa city data", qaResponse);

        final RestResponse prodResponse = AccuweatherRest.locations().v1(PROD).textSearchByCountryCode(locationData.getCountry(), locationData.getCity());
        TestReporter.logAPI(prodResponse.getStatusCode() == ResponseCodes.OK, "failed to get prod city data", prodResponse);

        JsonObjectComparator validator = new JsonObjectComparator();
        validator.setReportSuccessfulValidations(false)
                .validate(qaResponse, prodResponse);
    }

    @Test
    public void textSearchByCountryCodeAndAdminCode_HighPoint_ExpectedFailure() {
        final RestResponse qaResponse = AccuweatherRest.locations().v1(QA).textSearchByCountryCodeAndAdminCode(locationData.getCountry(), locationData.getState(), locationData.getCity());
        TestReporter.logAPI(qaResponse.getStatusCode() == ResponseCodes.OK, "failed to get qa city data", qaResponse);

        final RestResponse prodResponse = AccuweatherRest.locations().v1(PROD).textSearchByCountryCodeAndAdminCode(locationData.getCountry(), locationData.getState(), locationData.getCity());
        TestReporter.logAPI(prodResponse.getStatusCode() == ResponseCodes.OK, "failed to get prod city data", prodResponse);

        JsonObjectComparator validator = new JsonObjectComparator();
        validator.validate(qaResponse.getResponse(), prodResponse.getResponse().replace("America/New_York", "America/Chicago"));
    }

    @Test
    public void textSearchByCountryCodeAndAdminCode_HighPoint_ExcludePassingResults_ExpectedFailure() {
        final RestResponse qaResponse = AccuweatherRest.locations().v1(QA).textSearchByCountryCodeAndAdminCode(locationData.getCountry(), locationData.getState(), locationData.getCity());
        TestReporter.logAPI(qaResponse.getStatusCode() == ResponseCodes.OK, "failed to get qa city data", qaResponse);

        final RestResponse prodResponse = AccuweatherRest.locations().v1(PROD).textSearchByCountryCodeAndAdminCode(locationData.getCountry(), locationData.getState(), locationData.getCity());
        TestReporter.logAPI(prodResponse.getStatusCode() == ResponseCodes.OK, "failed to get prod city data", prodResponse);

        JsonObjectComparator validator = new JsonObjectComparator();
        validator.setReportSuccessfulValidations(false)
                .validate(qaResponse.getResponse(), prodResponse.getResponse().replace("America/New_York", "America/Chicago"));
    }

    @Test
    public void textSearchByCountryCodeAndAdminCode_HighPoint_AddOptionalProperties_NoMissingData() {
        final RestResponse qaResponse = AccuweatherRest.locations().v1(QA).textSearchByCountryCodeAndAdminCode(locationData.getCountry(), locationData.getState(), locationData.getCity());
        TestReporter.logAPI(qaResponse.getStatusCode() == ResponseCodes.OK, "failed to get qa city data", qaResponse);

        final RestResponse prodResponse = AccuweatherRest.locations().v1(PROD).textSearchByCountryCodeAndAdminCode(locationData.getCountry(), locationData.getState(), locationData.getCity());
        TestReporter.logAPI(prodResponse.getStatusCode() == ResponseCodes.OK, "failed to get prod city data", prodResponse);

        JsonObjectComparator validator = new JsonObjectComparator();
        validator.addOptionalPropertyPath("TimeZone.Name")
                .addOptionalPropertyPath("SupplementalAdminAreas.Name")
                .addOptionalPropertyPath("DataSets.Name")
                .validate(qaResponse, prodResponse);
    }

    @Test
    public void textSearchByCountryCodeAndAdminCode_HighPoint_AddOptionalProperties_MissingData() {
        final RestResponse qaResponse = AccuweatherRest.locations().v1(QA).textSearchByCountryCodeAndAdminCode(locationData.getCountry(), locationData.getState(), locationData.getCity());
        TestReporter.logAPI(qaResponse.getStatusCode() == ResponseCodes.OK, "failed to get qa city data", qaResponse);

        final RestResponse prodResponse = AccuweatherRest.locations().v1(PROD).textSearchByCountryCodeAndAdminCode(locationData.getCountry(), locationData.getState(), locationData.getCity());
        TestReporter.logAPI(prodResponse.getStatusCode() == ResponseCodes.OK, "failed to get prod city data", prodResponse);

        JsonObjectComparator validator = new JsonObjectComparator();
        validator.addOptionalPropertyPath("TimeZone.Name")
                .addOptionalPropertyPath("SupplementalAdminAreas.Name")
                .addOptionalPropertyPath("DataSets.Name")
                .validate(qaResponse.getResponse(), prodResponse.getResponse().replace("America/New_York", "America/Chicago"));
    }

    @Test
    public void textSearchByCountryCodeAndAdminCode_HighPoint_ExcludePassingResults_AddOptionalProperties() {
        final RestResponse qaResponse = AccuweatherRest.locations().v1(QA).textSearchByCountryCodeAndAdminCode(locationData.getCountry(), locationData.getState(), locationData.getCity());
        TestReporter.logAPI(qaResponse.getStatusCode() == ResponseCodes.OK, "failed to get qa city data", qaResponse);

        final RestResponse prodResponse = AccuweatherRest.locations().v1(PROD).textSearchByCountryCodeAndAdminCode(locationData.getCountry(), locationData.getState(), locationData.getCity());
        TestReporter.logAPI(prodResponse.getStatusCode() == ResponseCodes.OK, "failed to get prod city data", prodResponse);

        JsonObjectComparator validator = new JsonObjectComparator();
        validator.setReportSuccessfulValidations(false)
                .addOptionalPropertyPath("TimeZone.Name")
                .addOptionalPropertyPath("SupplementalAdminAreas.Name")
                .addOptionalPropertyPath("DataSets.Name")
                .validate(qaResponse.getResponse(), prodResponse.getResponse().replace("America/New_York", "America/Chicago"));
    }
}
