package steps;

import org.junit.Assert;

import com.aventstack.extentreports.GherkinKeyword;
import com.edsoft.framework.base.web.BaseFuncionalidadeWeb;
import com.edsoft.framework.base.web.TestInitializeWeb;
import com.edsoft.framework.configs.Settings;
import com.edsoft.framework.constantes.massa.Massa;
import com.edsoft.framework.utilities.CucumberUtil;
import com.edsoft.framework.utilities.ExcelUtil;
import com.edsoft.framework.utilities.ExtentReport;

import cucumber.api.DataTable;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pagina.web.home.HomePage;
import pagina.web.home.LoginPage;
import pagina.web.quantidadeProduto.ManageProductPage;

public class AdicionarProdutoStep extends TestInitializeWeb  {

	@Dado("^que estou com a aplicacao aberta$")
	public void queEstouComAAplicacao() throws Throwable {
		CurrentPage = GetInstance(HomePage.class);
		ExtentReport.getScenario().createNode(new GherkinKeyword("Given"), "que estou com a aplicacao");
	}

	@Quando("^eu clico no link do login$")
	public void euClicoNoLinkDoLogin() throws Throwable {
		Settings.Logs.GravaLog("^Testetetet$");
		CurrentPage = CurrentPage.As(HomePage.class).acessarRequisicaoDELETAR();

		ExtentReport.getScenario().createNode(new GherkinKeyword("When"), "eu clico no link do login");
		Settings.Logs.GravaLog("^eu clico no link do login$");
	}

	@Entao("^eu insiro o userName e Password$")
	public void euInsiroUserNameAndPassword() throws Throwable {
		CurrentPage.As(LoginPage.class).Login(recuperarMassa(Massa.USERNAME), recuperarMassa(Massa.PASSWORD));
		
	}

	@E("^clico no botao logar$")
	public void clicoNoBotaoLogar() throws Throwable {
		CurrentPage = CurrentPage.As(LoginPage.class).btnLogar();
		ExtentReport.getScenario().createNode(new GherkinKeyword("And"), "clico no botao logar");
		Settings.Logs.GravaLog("^clico no botao logar$");
	}
	
	
	@E("^selecionou a categoria do produto$")
	public void selecionarProduto() throws Throwable {
		CurrentPage = CurrentPage.As(LoginPage.class).selecionarCategoria();	
		
	}

	@E("^E tipo selecinou o tipo de vestido$")
	public void selecionarTipo() throws Throwable {
		CurrentPage = CurrentPage.As(LoginPage.class).selecionarTipo();			
	}

	@E("^E clico no modelo do produto$")
	public void selecionarModelo() throws Throwable {
		CurrentPage = CurrentPage.As(LoginPage.class).selecionarCategoria();	
		
	}

	@Entao("^clico em adicionar produto$")
	public void adicionarAoCarrinho() throws Throwable {
		CurrentPage = CurrentPage.As(LoginPage.class).clicarEmAdicionar();	
		
	}

	@E("^clico em progresso de pagamento$")
	public void processoPagamento() throws Throwable {
		CurrentPage = CurrentPage.As(LoginPage.class).processoPagamento();	
		
	}

	@E("^valido a página de pagamento$")
	public void ValidaPágina() throws Throwable {
		CurrentPage = CurrentPage.As(LoginPage.class).validarPaginaPagamento();	
		
	}

	
	
	
	


}
