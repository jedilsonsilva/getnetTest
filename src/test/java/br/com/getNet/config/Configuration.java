package br.com.getNet.config;

import org.aeonbits.owner.Config;

@Config.Sources("file:src/test/resources/api-ambiente.properties")
public interface Configuration extends Config {

    @Key("baseURI")
    String baseURI();

    @Key("log.all")
    boolean logAll();
}
