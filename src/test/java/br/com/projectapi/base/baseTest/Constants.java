package br.com.projectapi.base.baseTest;

import io.restassured.http.ContentType;

public interface Constants {
    ContentType APP_CONTENT_TYPE = ContentType.JSON;
    Long MAX_TIMEOUT = 50000L;
}
