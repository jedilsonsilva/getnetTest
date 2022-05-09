package br.com.projectapi.testes.request;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static br.com.projectapi.data.factory.conta.BaseContaData.URL_CONTAS;
import static br.com.projectapi.data.factory.conta.BaseContaData.URL_CONTAS_ALTERAR;
import static br.com.projectapi.data.specs.RequestSpecsConta.setAlterarConta;
import static br.com.projectapi.data.specs.RequestSpecsConta.setCadastrarContas;


/* Classe onde é montado todos os metodos até o when. Não se coloca o then*/
public class PostContaRequest {

    @Step("Cadastra contas com sucesso")
    public Response cadastrarContas() {
        return setCadastrarContas()
                .when()
                    .log()
                    .all()
                .post(URL_CONTAS);
    }

    @Step("Alterar contas com sucesso")
    public Response alterarConta() {
        return setAlterarConta()
                .when()
                    .log()
                    .all()
                    .put(URL_CONTAS_ALTERAR);

    }

}
