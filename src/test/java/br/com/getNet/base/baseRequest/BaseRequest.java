package br.com.getNet.base.baseRequest;

import br.com.getNet.data.pojo.createUser.BodyCreateUser;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static br.com.getNet.base.BaseData.testingSupport;
import static io.restassured.RestAssured.given;

public class BaseRequest {

    public Response doPostRequest(String resource, BodyCreateUser body) {
        testingSupport.logRequestSimpleBody(resource, body);
        return given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(resource);
    }

    public Response doPatchRequest(String resource, BodyCreateUser body) {
        testingSupport.logRequestSimpleBody(resource, body);
        return given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .patch(resource);
    }

    public Response doPostRequestXml(String resource, BodyCreateUser body) {
        testingSupport.logRequestSimpleBody(resource, body);
        return given()
                .accept("application/xml")
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(resource);
    }

    public Response doPostRequestSimpleBody(String resource, String body) {
        testingSupport.logRequestSimpleBody(resource, body);
        return given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(resource);
    }

}
