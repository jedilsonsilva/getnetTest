package br.com.getNet.tests.reqres.tests;

import br.com.getNet.base.baseResponse.ResponseSpecGeneral;
import br.com.getNet.base.baseTest.BaseTest;
import br.com.getNet.data.specs.ResponseSpecsUsers;
import br.com.getNet.tests.reqres.request.PostCreateUserRequest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runners.Suite;

import static br.com.getNet.base.BaseData.JOB;
import static br.com.getNet.base.BaseData.NAME;
import static org.apache.http.HttpStatus.SC_CREATED;

@Epic("ReqresIn")
@Feature("Create User")
@DisplayName("Criar Usuário")
public class PostCreateUserTest extends BaseTest{

    private PostCreateUserRequest createUserRequest = new PostCreateUserRequest();

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({Suite.class})
    @DisplayName("Validar a criacao de usuario com sucesso")
    public void testCriarUsuario() {
        Response response = createUserRequest.createUser(NAME, JOB);
        ResponseSpecsUsers.getResponseCreateUser(response);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({Suite.class})
    @DisplayName("Validar o contrato de criacao de usuario com sucesso")
    public void testContratoCriarUsuario() {
        Response response = createUserRequest.createUser(NAME, JOB);
        ResponseSpecGeneral.getResponseContract(response, SC_CREATED,"reqres", "PostCreateUser");
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({Suite.class})
    @DisplayName("Validar o endpoint invalido no post de criacao de usuario")
    public void testPathInvalido() {
        Response response = createUserRequest.pathInvalido();
        ResponseSpecGeneral.getResponseInvalidatePath(response);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({Suite.class})
    @DisplayName("Validar metodo nao suportado no post de criacao de usuario")
    public void testMetodoNaoSuportado() {
        Response response = createUserRequest.metodoNaoSuportado();
        ResponseSpecGeneral.getResponseMethodNotAllowed(response);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({Suite.class})
    @DisplayName("Validar recurso nao aceitavel no post de criacao de usuario")
    public void testRecursoNaoAceitavel() {
        Response response = createUserRequest.recursoNaoAceitavel();
        ResponseSpecGeneral.getResponseNotAcceptable(response);
    }
}
