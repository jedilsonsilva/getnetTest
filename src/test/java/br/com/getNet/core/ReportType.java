package br.com.getNet.core;

import io.restassured.response.Response;
import lombok.extern.log4j.Log4j;

import static br.com.getNet.core.AllureTypeFile.*;
import static io.qameta.allure.Allure.addAttachment;

@Log4j
public class ReportType {

    public static void reportAllureHeaderAndBodyResponse(Response response){
        addAttachment(RESPONSE_HEADERS, response.getHeaders().toString());
        addAttachment(RESPONSE_BODY, response.getBody().prettyPrint());
        addAttachment(RESPONSE_STATUSCODE, String.valueOf(response.getStatusCode()));
        log.info("Header: " + response.getHeaders().toString());
        log.info("Status Code: " + response.getStatusCode());
    }

    public static void reportAllureUriAndHeaderRequest(String uri, String dataHeader){
        addAttachment(REQUEST, uri);
        addAttachment(REQUEST_HEADERS, dataHeader);
        log.info("URI: " + uri);
        log.info("Header: " + dataHeader);
    }

    public static void reportAllureUriAndHeaderAndBodyRequest(String uri, String dataHeader, String body, String params){
        addAttachment(REQUEST, uri);
        addAttachment(REQUEST_HEADERS, dataHeader);
        addAttachment(REQUEST_BODY, body);
        addAttachment(REQUEST_PARAMS, params);
        log.info("URI: " + uri);
        log.info("Header: " + dataHeader);
        log.info("Request Body " + body);
    }

    public static void reportAllureParams(String uri, String params){
        addAttachment(REQUEST, uri);
        addAttachment(REQUEST_PARAMS, params);
        log.info("URI: " + uri);
        log.info("Params: " + params);
    }

    public static void reportAllureUriAndBodyRequest(String uri, String body){
        addAttachment(REQUEST, uri);
        addAttachment(REQUEST_BODY, body);
        log.info("URI: " + uri);
        log.info("Request Body " + body);
    }

    public static void reportAllureUriAndBodyAndHeaderRequest(String uri, String body, String dataHeader){
        addAttachment(REQUEST, uri);
        addAttachment(REQUEST_BODY, body);
        addAttachment(REQUEST_HEADERS, dataHeader);

        log.info("URI: " + uri);
        log.info("Request Body " + body);
    }

    public static void reportAllureUriRequest(String uri){
        addAttachment(REQUEST, uri);
        log.info("URI: " + uri);
    }


}
