import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SimulaInvestimentosPageObject extends BasePage {


	public SimulaInvestimentosPageObject(WebDriver navegador) {
		super(navegador);
	}

	public SimulaInvestimentosPageObject escrever(String valorreais, String valorid) {
		navegador.findElement(By.id(valorid)).sendKeys(valorreais);
		return this;
	}

	public SimulaInvestimentosPageObject clicar() {
		navegador.findElement(By.className("simular")).click();
		return this;
	}
	
	public SimulaInvestimentosPageObject guardar(String mensagem, String valor) {
		String novamensagem = navegador.findElement(By.id(valor)).getText();
		Assert.assertEquals(mensagem, novamensagem);
		return this;
	}
	
	public SimulaInvestimentosPageObject guardartotal(String mensagem, String valor) {
		String novamensagem = navegador.findElement(By.className(valor)).getText();
		Assert.assertEquals(mensagem, novamensagem);
		return this;
	}
	
}
