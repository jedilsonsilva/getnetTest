package br.com.projectapi.testes.tests;

import br.com.projectapi.base.baseTest.BaseTest;
import br.com.projectapi.data.factory.conta.ContaDataFactory;
import br.com.projectapi.testes.request.PostContaRequest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runners.Suite;

import static org.hamcrest.Matchers.*;


@Epic("PROJECT_BASE")
@Feature("Cadastrar Contas")
@DisplayName("Cadastrar Contas")
public class PostContaTest extends BaseTest {

    public static ContaDataFactory contafactory = new ContaDataFactory();
    private PostContaRequest cadastrarContas = new PostContaRequest();




    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({Suite.class})
    @DisplayName("Validar o cadastro de contas com sucesso")
    public void cadastrarConta() {
        cadastrarContas.cadastrarContas()
                .then()
                    .log()
                    .all()
                    .assertThat().body("nome", is(not(emptyOrNullString())))
                    .assertThat().body("usuario_id", is(not(emptyOrNullString())))
                    .statusCode(HttpStatus.SC_CREATED);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({Suite.class})
    @DisplayName("Validar a alteração de conta com sucesso")
    public void alterarConta() {
        cadastrarContas.alterarConta()
                .then()
                    .log()
                    .all()
                   // .body("nome", is("Conta alterada"))
                    .assertThat().body("usuario_id", is(not(emptyOrNullString())))
                    .statusCode(HttpStatus.SC_OK);
    }

}
