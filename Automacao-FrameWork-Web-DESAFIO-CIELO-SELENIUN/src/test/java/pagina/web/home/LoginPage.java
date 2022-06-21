package pagina.web.home;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.edsoft.framework.base.web.BasePaginaWeb;
import com.edsoft.framework.base.web.DriverContextWeb;
import com.edsoft.framework.controls.elements.Button;
import com.edsoft.framework.controls.elements.TextBox;

import io.qameta.allure.Step;
import pagina.web.cadastro.CreateAccountPage;

public class LoginPage extends BasePaginaWeb {
	
	@FindBy(how = How.LINK_TEXT, using = "CREATE NEW ACCOUNT")
	public WebElement createCount;

	@FindBy(how = How.ID, using = "email")
	public TextBox Email;

	@FindBy(how = How.ID, using = "passwd")
	public TextBox Password;

	@FindBy(how = How.NAME, using = "SubmitLogin")
	public Button btnLogin;

	@FindBy(how = How.XPATH, using = "//*[@id=\"block_top_menu\"]/ul/li[2]/a")
	public Button categoria;


	@FindBy(how = How.XPATH, using = "//*[@id=\"categories_block_left\"]/div/ul/li[1]/a")
	public Button modelo;

	

	@FindBy(how = How.XPATH, using = "//*[@id=\"add_to_cart\"]/button/span")
	public Button compraProduto;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"add_to_cart\"]/button")
	public Button adicionarProduto;

	@FindBy(how = How.XPATH, using = "//*[@id=\"center_column\"]/p[2]/a[1]")
	public Button proceedCheckout2;

	
	@FindBy(how = How.NAME, using = "processAddress")
	public Button processAddress;

	@FindBy(how = How.XPATH, using = "//*[@id=\"cgv\"]")
	public Button aceitaAcordo;
	
	@FindBy(how = How.NAME, using = "processCarrier")
	public Button processCarrier;

	@FindBy(how = How.XPATH, using = "//*[@id=\"center_column\"]/h1")
	public Button validaTexto;
	

	@Step("Preemcher Formulario \"Username e password\"")
	public void Login(String userName, String password) throws Exception {
		try {
			DriverContextWeb.WaitForElementVisible(Email);
			Email.EnterText(userName);

			DriverContextWeb.WaitForElementVisible(Password);
			Password.EnterText(password);
		} catch (Exception e) {
		}
		DriverContextWeb.salvarEvidencia("Preemchido Formulario de login");
	}

	
	
	@Step("Tocar no botao \"Logar\"")
	public HomePage btnLogar() throws Exception {
		Thread.sleep(3000);
		
		//logar perfil cadastrado
		DriverContextWeb.clicarElemento(btnLogin, "não clicou em logar");
		
		//selecionar categoria
		DriverContextWeb.clicarElemento(categoria, "não clicou em logar");
		
	
		// seleciona tipo de modelo
		DriverContextWeb.WaitForElementVisible(modelo);
		DriverContextWeb.clicarElemento(modelo, "não clicou em logar");
		
		//descer barra de rolagem 
		JavascriptExecutor jse = (JavascriptExecutor)DriverContextWeb.Driver;
		jse.executeScript("scrollBy(0,750)", "");		
		
		//clicar no elemento popup
		WebElement element = DriverContextWeb.Driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li/div/div[1]/div/a[1]"));
		   JavascriptExecutor jscriptExecutor = (JavascriptExecutor) DriverContextWeb.Driver;
		   jscriptExecutor.executeScript("arguments[0].click();", element);
				
		//clicar no botão de adicionar ao carrinho
		DriverContextWeb.WaitForElementVisible(adicionarProduto);
		DriverContextWeb.clicarElemento(adicionarProduto, "não clicou em logar");
		
		
		//clicar no elemento popup no botão proceed to checkout
		WebElement proceedCheckout = DriverContextWeb.Driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a"));
		JavascriptExecutor jscriptExecutor1 = (JavascriptExecutor) DriverContextWeb.Driver;
		jscriptExecutor1.executeScript("arguments[0].click();", proceedCheckout);
		
		
		//clicar no botão proceed checkout botão 2
		DriverContextWeb.WaitForElementVisible(proceedCheckout2);
		DriverContextWeb.clicarElemento(proceedCheckout2, "não clicou em logar");
		
		//clicar no botão proceed checkout botão 3
		DriverContextWeb.WaitForElementVisible(processAddress);
		DriverContextWeb.clicarElemento(processAddress, "não clicou em logar");
		
		//clicar no ckeckbox para aceita o termo
		DriverContextWeb.WaitForElementVisible(aceitaAcordo);
		DriverContextWeb.clicarElemento(aceitaAcordo, "não clicou em logar");
		
			
		//clicar no botão proceed carrier botão 2
		DriverContextWeb.WaitForElementVisible(processCarrier);
		DriverContextWeb.clicarElemento(processCarrier, "não clicou em logar");
		
		//retorna texto da página de pagamento
		CurrentPage = CurrentPage.As(LoginPage.class).validarPaginaPagamento();	
		
		return GetInstance(HomePage.class);
	}
	
	
	
	public HomePage selecionarCategoria() throws Exception {	
		//selecionar categoria
		DriverContextWeb.clicarElemento(categoria, "não clicou em logar");
		return GetInstance(HomePage.class);
	}
	
	public HomePage selecionarTipo() throws Exception {
		// seleciona tipo de modelo
			DriverContextWeb.WaitForElementVisible(modelo);
			DriverContextWeb.clicarElemento(modelo, "não clicou em logar");
		//descer barra de rolagem 
			JavascriptExecutor jse = (JavascriptExecutor)DriverContextWeb.Driver;
			jse.executeScript("scrollBy(0,750)", "");		
	    	return GetInstance(HomePage.class);
	}
	
	
	
	public HomePage selecionarModelo() throws Exception {
		//clicar no elemento popup
	WebElement element = DriverContextWeb.Driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li/div/div[1]/div/a[1]"));
	  JavascriptExecutor jscriptExecutor = (JavascriptExecutor) DriverContextWeb.Driver;
	  jscriptExecutor.executeScript("arguments[0].click();", element);
	return GetInstance(HomePage.class);
	}

	
	public HomePage clicarEmAdicionar() throws Exception {
		//clicar no botão proceed checkout botão 2
		DriverContextWeb.WaitForElementVisible(proceedCheckout2);
		DriverContextWeb.clicarElemento(proceedCheckout2, "não clicou em logar");
		
		//clicar no botão proceed checkout botão 3
		DriverContextWeb.WaitForElementVisible(processAddress);
		DriverContextWeb.clicarElemento(processAddress, "não clicou em logar");
		
		return GetInstance(HomePage.class);
	}

	
	public HomePage processoPagamento() throws Exception {
		
		//clicar no ckeckbox para aceita o termo
		DriverContextWeb.WaitForElementVisible(aceitaAcordo);
		DriverContextWeb.clicarElemento(aceitaAcordo, "não clicou em logar");
		
		//clicar no botão proceed carrier botão 2
		DriverContextWeb.WaitForElementVisible(processCarrier);
		DriverContextWeb.clicarElemento(processCarrier, "não clicou em logar");
		
		return GetInstance(HomePage.class);
	}
	

	public HomePage validarPaginaPagamento() throws Exception {
		DriverContextWeb.retornarTexto(validaTexto, "não valido texto na tela");
		
		
		return GetInstance(HomePage.class);
	}
	
	@Step("Tocar no botao \"Criar conta\"")
	public CreateAccountPage criarConta() throws Exception{
		try {
			Thread.sleep(3000);
			createCount.click();
		} catch (Exception e) {
			System.out.println("botao criar com erro: " + e.getMessage());
		}
		return GetInstance(CreateAccountPage.class);
	}
}
