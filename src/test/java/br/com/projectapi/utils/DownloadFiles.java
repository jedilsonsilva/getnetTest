package br.com.projectapi.utils;

import io.restassured.RestAssured;
import io.restassured.filter.log.UrlDecoder;
import io.restassured.response.Response;
import org.junit.Assert;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class DownloadFiles {

    /**
     * Este exemplo mostra como baixar um arquivo com Restassured
     * Isso fará download do arquivo como binário para que possa ser usado para imagens, arquivos, zip, etc.
     * O exemplo é codificado para baixar um arquivo fonte do github, mas você pode baixar qualquer coisa.
     * As vezes é utilizado durante a automação do GUI para baixar arquivos.
     * Também é utilizado isso ao interagir com sites que não fornecem uma API.
     */

    public void canDownloadFilesWithRestAssured() throws Exception {

        /*Por padrão esta será a subpasta do seu projeto, você pode altera-la para um
        caminho ou recursos absolutos. */

        File downloadFolder = new File("src/test/resources/files");
        File outputPath = (downloadFolder);
        //Criar a estrutura da pasta se ela não existir
        outputPath.mkdirs();

        Map<String, String> cookies = new HashMap<>();
        Map<String, String> headers = new HashMap<>();

        String urlToDownload = "urlParaDownloadDOArquivo"; //AQUI PODE CHAMAR O MÉTODO QUE FAZ O DOWNLOAD DO ARQUIVO
        urlToDownload = UrlDecoder.urlDecode(urlToDownload, Charset.defaultCharset(), false);

        String downloadFileName = "nomeArquivo" + System.currentTimeMillis() + "_.zip";

        File checkDownloaded = new File(outputPath.getPath(), downloadFileName);
        if (checkDownloaded.exists()) {
            checkDownloaded.delete();
        }

        downloadAsFile(cookies, headers, urlToDownload, outputPath, downloadFileName);
        checkDownloaded = new File(outputPath.getPath(),
                downloadFileName);
        Assert.assertTrue(checkDownloaded.exists());
        //Esta linha chama o método de descompactar um arquivo zipado (se o arquivo baixado nao for zipado, ignore esta linha
        File resultFile = UnzipUtils.UnzipFileList(checkDownloaded);
        //Esta linha chama o método para ler um arquivo Json após baixado/zipado (se o arquivo baixado nao for Json, ignore esta linha
        ReadFiles.validateSchemaJson(resultFile);
        //Esta linha chama o método para ler um arquivo CSV após baixado/zipado (se o arquivo baixado nao for CSV, ignore esta linha
        ReadFiles.validateCsvFile(resultFile);

    }

    /**
     * Método para realizar o download do arquivo utilizando RestAssured
     */

    public static void downloadAsFile(final Map<String, String> cookies, final Map<String, String> headers,
                                      final String urlToDownload, final File outputPath, String filename)
            throws IOException {
        File outputFile = new File(outputPath.getPath(), filename);
        final Response response =
                RestAssured
                        .given()
                        .headers(headers)
                        .cookies(cookies)
                        .when()
                        .get(urlToDownload)
                        .andReturn();
        if (response.getStatusCode() == 200) {
            if (outputFile.exists()) {
                outputFile.delete();
            }
            byte[] fileContents = response.getBody().asByteArray();

            try (OutputStream outStream = new FileOutputStream(outputFile)) {
                outStream.write(fileContents);
            }
        }
    }
}

