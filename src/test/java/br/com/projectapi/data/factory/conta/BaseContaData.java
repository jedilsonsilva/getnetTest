package br.com.projectapi.data.factory.conta;

import br.com.projectapi.utils.Documents;

import static br.com.projectapi.config.ConfigurationManager.configuration;

public interface BaseContaData {

    ContaDataFactory user = new ContaDataFactory();

    String URL_CONTAS = String.format("/contas",configuration().urlContas());
    String URL_CONTAS_ALTERAR = "/contas/"+user.getDataUser("ID");
    String NOME = Documents.faker().name().firstName();
}
