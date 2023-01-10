package br.com.getNet.data.specs;

import br.com.getNet.utils.DateUtils;
import io.restassured.response.Response;

import static br.com.getNet.base.BaseData.*;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.hamcrest.Matchers.*;


public class ResponseSpecsUsers {

    public static void getResponseCreateUser(Response response) {
        testingSupport.logResponse(response);
        response
                .then()
                .statusCode(SC_CREATED)
                .body("name", equalTo(NAME))
                .body("job", equalTo(JOB))
                .body("id", is(not(emptyOrNullString())));
             //   .body("createdAt", equalTo(DateUtils.getDateDifferenceDays(0)));
    }

    public static void getResponseException(Response response) {
        testingSupport.logResponse(response);
        response
                .then()
                .statusCode(SC_CREATED)
                .body("name", equalTo(NAME))
                .body("job", equalTo(JOB))
                .body("id", is(not(emptyOrNullString())))
                .body("createdAt", equalTo(DateUtils.getDateDifferenceDays(0)));
    }
}
