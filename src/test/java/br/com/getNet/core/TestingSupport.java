package br.com.getNet.core;

import br.com.getNet.config.Configuration;
import com.google.gson.Gson;
import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.aeonbits.owner.ConfigCache;

import java.util.HashMap;

@Data
@AllArgsConstructor
public class TestingSupport {
    private JsonConverter jsonConverter = new JsonConverter();
    private Configuration configuration;
    private String URI;
    private Response response;
    private Gson gson = new Gson();
    private Integer lastId;
    private String schemaFile;
    private HashMap dataFile;

    public TestingSupport(){
        setConfiguration(ConfigCache.getOrCreate(Configuration.class));
    }

    public void logResponse(Response response){
        ReportType.reportAllureHeaderAndBodyResponse(response);
    }

    public void logRequestSimpleBody(String uri, Object body){
        String bodystr = jsonConverter.toJson(body);
        ReportType.reportAllureUriAndBodyRequest(uri, bodystr);
    }
}
