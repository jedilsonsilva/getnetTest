package br.com.projectapi.data.specs;

import br.com.projectapi.data.factory.conta.ContaDataFactory;
import br.com.projectapi.data.pojo.conta.BodyCadastrarConta;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import static br.com.projectapi.base.auth.PostAuthRequest.gerarToken;

public class RequestSpecsConta {

    /* Classe serve para nao repetir parametros, Authorization, headers */

    static BodyCadastrarConta bodyCadastrarContas = ContaDataFactory.dataCadastrarConta();
    static BodyCadastrarConta bodyAlterarContas = ContaDataFactory.dataAlterarConta();


    public static RequestSpecification getDadosConta() {
        return new RestAssured()
                .given()
                .header("Authorization", "JWT " + gerarToken());
    }

    public static RequestSpecification setCadastrarContas() {
        return bodyContas(bodyCadastrarContas);
    }

    public static RequestSpecification setAlterarConta() {
        return bodyContas(bodyAlterarContas);
    }

    private static RequestSpecification bodyContas(BodyCadastrarConta body) {
        return getDadosConta()
                .body(body);
    }
}
