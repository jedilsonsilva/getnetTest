package br.com.getNet.base;

import br.com.getNet.core.TestingSupport;
import br.com.getNet.data.factory.users.UserDataFactory;
import br.com.getNet.utils.Documents;

import static br.com.getNet.config.ConfigurationManager.configuration;

public interface BaseData {

    UserDataFactory user = new UserDataFactory();
    TestingSupport testingSupport = new TestingSupport();

    String URL_USERS = String.format("/users",configuration().baseURI());
    String NAME = Documents.faker().name().fullName();
    String JOB = Documents.faker().job().position();

}
