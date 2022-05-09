package br.com.projectapi.config;

import org.aeonbits.owner.Config;

@Config.Sources("file:src/test/resources/api-ambiente.properties")
public interface Configuration extends Config {
    @Key("urlUsers")
    String urlUsers();

    @Key("Urlsignin")
    String Urlsignin();

    @Key("urlContas")
    String urlContas();

    @Key("baseURI")
    String baseURI();

    @Key("port")
    Integer port();

    @Key("log.all")
    boolean logAll();
}
