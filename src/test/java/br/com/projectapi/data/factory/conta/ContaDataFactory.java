package br.com.projectapi.data.factory.conta;

import br.com.projectapi.data.factory.conta.BaseContaData;
import br.com.projectapi.data.pojo.conta.BodyCadastrarConta;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.collections4.map.HashedMap;

import java.util.Map;

import static br.com.projectapi.data.specs.RequestSpecsConta.getDadosConta;
import static io.restassured.RestAssured.given;

/*Classe para gerar dados, para criar usuarios ou buscar dados do usuarios*/

public class ContaDataFactory {

    public static String NOME;
    public static int IDENTIFICADOR;
    Map<String, String> map = new HashedMap<>();

    public static BodyCadastrarConta dataCadastrarConta(){

        BodyCadastrarConta bodyCadastrarContas = new BodyCadastrarConta();
        bodyCadastrarContas.setNome(BaseContaData.NOME);
        return bodyCadastrarContas;
    }

    public static BodyCadastrarConta dataAlterarConta(){

        BodyCadastrarConta bodyCadastrarContas = new BodyCadastrarConta();
        bodyCadastrarContas.setNome("Conta alterada "+BaseContaData.NOME);
        return bodyCadastrarContas;
    }

    private void saveDadosUser(){
        Response  response = getDadosConta()
                .when()
                    .get(BaseContaData.URL_CONTAS)
                .then()
                    .extract().response();
        JsonPath extractor = response.jsonPath();
         map.put("ID",extractor.get("id[0]").toString());
         map.put("NOME",extractor.get("nome[0]"));
    }

    public String getDataUser(String dados){
        saveDadosUser();
        return map.get(dados);
    }


}
