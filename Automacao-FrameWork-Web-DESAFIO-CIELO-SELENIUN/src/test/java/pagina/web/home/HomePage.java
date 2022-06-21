package pagina.web.home;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.edsoft.framework.base.web.BasePaginaWeb;
import com.edsoft.framework.base.web.DriverContextWeb;
import com.edsoft.framework.configs.Settings;
import com.edsoft.framework.controls.elements.Button;
import com.edsoft.framework.controls.elements.TextBox;
import com.edsoft.framework.exception.EdsoftException;
import com.itextpdf.text.DocumentException;

import io.qameta.allure.Step;
import pagina.web.quantidadeProduto.ManageProductPage;

public class HomePage extends BasePaginaWeb {

	@FindBy(how = How.XPATH, using = "//*[@id=\"menuUserLink\"]/span")
	public WebElement linkUserName;

	@FindBy(how = How.ID, using = "menuUserLink")
	public Button btnDeslogar;

	@FindBy(how = How.ID, using = "menuUser")
	public WebElement btnLogin;

	// categorias
	@FindBy(how = How.ID, using = "speakersLink")
	public WebElement catSpeakers;
	@FindBy(how = How.ID, using = "tabletsTxt")
	public WebElement catTables;
	@FindBy(how = How.ID, using = "laptopsTxt")
	public WebElement catLaptops;
	@FindBy(how = How.ID, using = "miceTxt")
	public WebElement catMice;
	@FindBy(how = How.ID, using = "headphonesTxt")
	public WebElement catHeadphones;

	// Acionar contato
	@FindBy(how = How.NAME, using = "categoryListboxContactUs")
	public WebElement categoriaProdutoCombo;
	@FindBy(how = How.NAME, using = "productListboxContactUs")
	public WebElement modeloProdutoCombo;
	@FindBy(how = How.NAME, using = "emailContactUs")
	public TextBox emailContato;
	@FindBy(how = How.NAME, using = "subjectTextareaContactUs")
	public WebElement areaText;

	
	///////////////////////////////////////////////////////////////////////
	
	
	// subir Barra
	@FindBy(how = How.LINK_TEXT, using = "Coffees")
	public Button botaoCoffees;

	@FindBy(how = How.XPATH, using = "//*[@id=\"Coffees_Coffees_Delete\"]/div[1]/h3/span[1]/a")
	public Button botaoDeletar;
	
	@FindBy(how = How.NAME, using = "key")
	public TextBox campoKeyDeletar;
	@FindBy(how = How.NAME, using = "id")
	public TextBox campoDescricaoDeletar;

	
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"Coffees_Coffees_GetById\"]/div[1]/h3/span[2]/a")
	public Button botaoGET;


	@FindBy(how = How.XPATH, using = "//*[@id=\"Coffees_Coffees_Post\"]/div[1]/h3/span[2]/a")
	public Button botaoPOST;

	@FindBy(how = How.XPATH, using = "//*[@id=\"Coffees_Coffees_Put\"]/div[1]/h3/span[2]/a")
	public Button botaoPUT;
	

	
	

	@Step("Tocar em \"icone login\"")
	public HomePage acessarRequisicaoDELETAR() throws EdsoftException {
		
		DriverContextWeb.WaitForElementVisible(botaoCoffees);
		botaoCoffees.click();

		DriverContextWeb.WaitForElementVisible(botaoDeletar);
		botaoDeletar.click();
		
		
		DriverContextWeb.WaitForElementVisible(campoKeyDeletar);
		campoKeyDeletar.EnterText("teste");

		DriverContextWeb.WaitForElementVisible(campoDescricaoDeletar);
		campoDescricaoDeletar.EnterText("teste");

		DriverContextWeb.WaitForElementVisible(botaoDeletar);
		botaoDeletar.click();
		
		
		return GetInstance(HomePage.class);
	}
	
	
	@Step("Tocar em \"icone login\"")
	public HomePage acessarRequisicaoGET() throws EdsoftException {
		
		DriverContextWeb.WaitForElementVisible(botaoGET);
		botaoGET.click();
		
		DriverContextWeb.WaitForElementVisible(botaoGET);
		botaoGET.click();

		return GetInstance(HomePage.class);
	}
	
	
	
	@Step("Tocar em \"icone login\"")
	public HomePage acessarRequisicaoPOST() throws EdsoftException {
		
		DriverContextWeb.WaitForElementVisible(botaoPOST);
		botaoPOST.click();
		
		DriverContextWeb.WaitForElementVisible(botaoPOST);
		botaoPOST.click();

		return GetInstance(HomePage.class);
	}

	
	@Step("Tocar em \"icone login\"")
	public HomePage acessarRequisicaoPUT() throws EdsoftException {
		
		DriverContextWeb.WaitForElementVisible(botaoPUT);
		botaoPUT.click();
		
		DriverContextWeb.WaitForElementVisible(botaoPUT);
		botaoPUT.click();
		
		return GetInstance(HomePage.class);
	}

	

	///////////////////////////////////////////////////////////////////////////////
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public boolean isLogin() throws Exception {
		return btnLogin.isDisplayed();
	}

	@Step("Valida Usuario Cadastrado")
	public String txtUsuarioLogado() throws Exception {
		DriverContextWeb.retornarTexto(linkUserName, "erros ao retorna texto");
		DriverContextWeb.salvarEvidencia("Usuário cadastrado");
		return linkUserName.getText();
	}

	@Step("Selecionar \"Categoria do produto\"")
	public ManageProductPage selecionarCategorira(String categoria) throws Exception {
		switch (categoria) {
		case "SPEAKERS":
			DriverContextWeb.WaitForElementVisible(catSpeakers);
			catSpeakers.click();
			break;
		case "TABLETS":
			DriverContextWeb.WaitForElementVisible(catTables);
			catTables.click();
			break;
		case "LAPTOPS":
			DriverContextWeb.WaitForElementVisible(catLaptops);
			catLaptops.click();
			break;
		case "MICE":
			DriverContextWeb.WaitForElementVisible(catMice);
			catMice.click();
			break;
		case "HEADPHONES":
			DriverContextWeb.WaitForElementVisible(catHeadphones);
			catHeadphones.click();
			break;
		default:
			break;
		}
		DriverContextWeb.salvarEvidencia("Selecionado categoria");
		return GetInstance(ManageProductPage.class);
	}

	public HomePage descerBarraDeRolagem() throws IOException, DocumentException, Exception {
		try {
			Thread.sleep(9000);
			DriverContextWeb.barraDeRolagem(1900);
		} catch (Exception e) {
			Settings.Logs.GravaLog("Erro de rolagem para baixo: " + e.getStackTrace());
		}
		return GetInstance(HomePage.class);
	}

	public HomePage selecionarCategoriaDeProdutoCombo(String produto) throws Exception {
		DriverContextWeb.selectElementByVisibleText(categoriaProdutoCombo, produto);
		return GetInstance(HomePage.class);
	}

	public HomePage selecionarModeloDeProdutoCombo(String modelo) throws Exception {
		DriverContextWeb.selectElementByVisibleText(modeloProdutoCombo, modelo);
		return GetInstance(HomePage.class);
	}

	public HomePage selecionarEmail(String email) throws Exception {
		DriverContextWeb.WaitForElementVisible(emailContato);
		emailContato.EnterText(email);
		return GetInstance(HomePage.class);
	}

	public HomePage digitarAreaDeTexto(String texto) throws Exception {
		DriverContextWeb.WaitForElementVisible(areaText);
		areaText.sendKeys(texto);
		return GetInstance(HomePage.class);
	}

//	public HomePage clicarNoBotaoGoUp() throws Exception {
//		DriverContextWeb.WaitForElementVisible(imgGoUp);
//		imgGoUp.Click();
//		return GetInstance(HomePage.class);
//	}
}
