package br.com.getNet.tests.reqres.request;

import br.com.getNet.base.baseRequest.BaseRequest;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static br.com.getNet.base.BaseData.*;
import static br.com.getNet.config.ConfigurationManager.configuration;
import static br.com.getNet.data.factory.users.UserDataFactory.dataCreateUser;


public class PostCreateUserRequest extends BaseRequest {

    @Step("Criacao Usuario com sucesso")
    public Response createUser(String name, String job) {
        return doPostRequest(URL_USERS, dataCreateUser(name, job));
    }

    @Step("Criacao Usuario - Validacao de endpoint invalido feita com sucesso")
    public Response pathInvalido() {
        return doPostRequest(String.format("/users/test/invalido",configuration().baseURI()), dataCreateUser(NAME, JOB));
    }

    @Step("Criacao Usuario - Validacao de método nao suportado feita com sucesso")
    public Response metodoNaoSuportado() {
        return doPatchRequest(URL_USERS, dataCreateUser(NAME, JOB));
    }

    @Step("Criacao Usuario - Validacao de recurso nao aceitavel feita com sucesso")
    public Response recursoNaoAceitavel() {
        return doPostRequestXml(URL_USERS, dataCreateUser(NAME, JOB));
    }
}
