package br.com.getNet.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@Slf4j
public class JsonConverter {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public String toJson(Object object) {
        if (object == null) {
            return "";
        }
        if (object instanceof String) {
            return (String) object;
        }
        try {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        } catch (JsonProcessingException ex) {
            var msg = String.format("Error on parse object %s to json. Error: %s", object, ex.getMessage());
            log.error(msg, ex);
        }
        return "";
    }


}
