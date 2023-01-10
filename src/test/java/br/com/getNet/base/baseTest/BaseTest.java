package br.com.getNet.base.baseTest;

import br.com.getNet.config.*;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import org.junit.BeforeClass;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.baseURI;
import static org.hamcrest.Matchers.lessThan;

public class BaseTest implements Constants{

    protected static Configuration configuration = ConfigurationManager.configuration();

    @BeforeClass
    public static void setup() {


        baseURI = configuration.baseURI();

        RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
        reqBuilder.setContentType(APP_CONTENT_TYPE);
        RestAssured.requestSpecification = reqBuilder.build();

        ResponseSpecBuilder resBuilder = new ResponseSpecBuilder();
        resBuilder.expectResponseTime(lessThan(MAX_TIMEOUT), TimeUnit.SECONDS);
        RestAssured.responseSpecification = resBuilder.build();

       // RestAssured.registerParser("charset=utf-8", Parser.JSON);
       // RestAssured.defaultParser = Parser.JSON;
        determineLog();
    }

    /* TODOS OS TESTES QUE TIVEREM ERRO( SE A VARIAVEL "log.all = FALSE" NO ARQUIVO DE PROPETIES), VAI TER UM LOG ALL AUTOMATICAMENTE
    * log.all = true vai ter log all independente se falhar
   */
    private static void determineLog() {
        if (configuration.logAll()) {
            RestAssured.filters(new RequestLoggingFilter(), new RequestLoggingFilter());
        } else {
            RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        }
    }
}
