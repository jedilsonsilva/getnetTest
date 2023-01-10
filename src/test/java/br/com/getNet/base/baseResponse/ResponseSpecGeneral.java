package br.com.getNet.base.baseResponse;

import br.com.getNet.utils.Documents;
import io.restassured.response.Response;

import java.io.File;

import static br.com.getNet.base.BaseData.testingSupport;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.apache.http.HttpStatus.*;

public class ResponseSpecGeneral {

    public static void getResponseContract(Response response, Integer statusCode, String pack, String fileName) {
        testingSupport.logResponse(response);
        response.then()
                .statusCode(statusCode)
                .assertThat().body(matchesJsonSchema(
                        new File(Documents.getContractsBasePath(pack, fileName))));
    }

    public static void getResponseMethodNotAllowed(Response response) {
        testingSupport.logResponse(response);
        response
                .then()
                .statusCode(SC_METHOD_NOT_ALLOWED);
    }

    public static void getResponseInvalidatePath(Response response) {
        testingSupport.logResponse(response);
        response
                .then()
                .statusCode(SC_NOT_FOUND);
    }

    public static void getResponseNotAcceptable(Response response) {
        testingSupport.logResponse(response);
        response
                .then()
                .statusCode(SC_NOT_ACCEPTABLE);
    }

}
