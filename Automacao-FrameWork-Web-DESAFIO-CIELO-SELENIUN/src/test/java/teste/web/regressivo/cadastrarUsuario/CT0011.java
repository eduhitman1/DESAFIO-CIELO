package teste.web.regressivo.cadastrarUsuario;

import org.testng.annotations.Test;

import com.edsoft.framework.annotations.Jornada;
import com.edsoft.framework.base.web.TestInitializeWeb;
import com.edsoft.framework.configs.Settings;
import com.edsoft.framework.constantes.Jornadas;
import com.edsoft.framework.constantes.massa.Massa;

import funcionalidade.web.criarConta.CreatAccountFunc;
import funcionalidade.web.login.LoginFunc;
import funcionalidade.web.menu.MenuFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Jornada(Jornadas.CADASTRARUSUARIO)
public class CT0011 extends TestInitializeWeb {
	MenuFunc menu = new MenuFunc();
	LoginFunc login = new LoginFunc();
	CreatAccountFunc criaContaFunc = new CreatAccountFunc();

	@Test(description = "REG.CADAS.11 - Cadastrar Usuário no Sistema \\\"advantage\\\".\"")
	@Description("Validar Usuário Cadastrado no Sistema")
	@Severity(SeverityLevel.NORMAL)
	public void CT00011() throws Exception {
		menu.carregaAplicacao();
		menu.requisicoesAPI();
		Settings.Logs.GravaLog("^eu clico no link do login$");

		
		
		
	}

}
