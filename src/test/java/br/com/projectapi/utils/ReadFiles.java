package br.com.projectapi.utils;

import com.google.gson.JsonParser;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.junit.Assert;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.MatcherAssert.assertThat;


public class ReadFiles {

    private static final String HEADER =
            "campo1, campo2, campo3";

    /**
     * Método para validar os dados do aruivo CSV
     */
    public static void validateCsvFile(File resultFile) throws IOException {
        try (Reader in = new FileReader(resultFile.getCanonicalPath())) {
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in);

            String[] headers = HEADER.split(",");
            for (CSVRecord record : records) {
                for (int i = 0; i < headers.length; i++) {
                    Assert.assertTrue(headers[i].equals(record.get(i)));
                }
                break;
            }
        }
    }

    /**
     * Método para validar o schema do arquivo Json
     */

    public static void validateSchemaJson(File resultFile) {

        JsonParser parser = new JsonParser();
        Object obj = resultFile;
        try {
            obj = parser.parse(new FileReader("dowload-files/arquivo,json"));
        } catch (Exception e) {
        }
        assertThat(obj.toString(),
                matchesJsonSchema(
                        new File(Documents.getContractsBasePath("package", "nomeDoArquivo"))));
    }
}
