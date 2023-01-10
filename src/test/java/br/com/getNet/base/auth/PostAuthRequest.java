package br.com.getNet.base.auth;

import br.com.getNet.config.Configuration;
        ;
import br.com.getNet.config.ConfigurationManager;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;


// CLASSE PARA GERAR O TOKEN
public class PostAuthRequest {

    private static String TOKEN;

    protected static Configuration configuration = ConfigurationManager.configuration();

    public static String gerarToken() {


        Map<String, String> login = new HashMap<>();
        login.put("email", "admin@admin.com.il");
        login.put("senha", "admin");

        TOKEN =
                given()
                    .body(login)
                .when()
                    .accept("application/json")
                    .post("/signin")
                .then()
                    .statusCode(HttpStatus.SC_OK)
                    .extract().path("token");
        return TOKEN;

    }


    @Step("Buscar o token")
    public Response token() {
        JSONObject payload = new JSONObject();
        payload.put("username", "quality.assurance");
       // payload.put("password", "password123");
        payload.put("password", "qualidade");


        return given()
                .header("Content-Type", "application/json")
                .when()
                .body(payload.toString())
                .post("auth");
    }


    @Step("Retornar o token")
    public String getToken() {

        return "token=" + this
                .token()
                .then()
                .statusCode(200)
                .extract().path("token");
    }

    @Step("Obtém o token da api SocioEducativo do ambiente de Qualidade - https://qa-sedu-api.stg.cloud.cnj.jus.br")
    public Response tokenPrivate() throws Exception {
        RestAssured.baseURI = "https://qa-sedu-api.stg.cloud.cnj.jus.br";
        return given()
                .header("Authorization", "Basic cmVubmVyLXBhcmNlaXJvOnBhcmNlaXJv")
                .contentType("application/json")
                .when().post("api/...");
    }
}
