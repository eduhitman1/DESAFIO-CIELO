package teste.web.regressivo.adicionarProduto;

import org.testng.annotations.Test;

import com.edsoft.framework.annotations.Jornada;
import com.edsoft.framework.base.web.TestInitializeWeb;
import com.edsoft.framework.configs.Settings;
import com.edsoft.framework.constantes.Jornadas;
import com.edsoft.framework.constantes.massa.Massa;

import funcionalidade.web.login.LoginFunc;
import funcionalidade.web.menu.MenuFunc;
import funcionalidade.web.quantidadeProduto.QuantidadeProdutoFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Jornada(Jornadas.ADICIONARPRODUTO)
public class CT0001 extends TestInitializeWeb {
	MenuFunc menu = new MenuFunc();
	LoginFunc login = new LoginFunc();
	QuantidadeProdutoFunc telaProduto = new QuantidadeProdutoFunc();

	@Test(description = "REG.ARPRO.01 - Adicionar produto no carrinho \\\"advantage\\\".\"")
	@Description("Validar quando finalizar a quantidade de produto adicionado")
	@Severity(SeverityLevel.NORMAL)
	public void CT0001() throws Exception{
			menu.carregaAplicacao();
			menu.requisicoesAPI();
		
			
			
			
			
			
			
			
			
			
			
			Settings.Logs.GravaLog("^eu clico no link do login$");
			
			
			//perfil já cadastrado
			login.preencherCamposLogin(recuperarMassa(Massa.USERNAME), recuperarMassa(Massa.PASSWORD));
			login.clicarBotaoLogar();
		
						
	}
}


