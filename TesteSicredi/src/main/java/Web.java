import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Web {
	
	public static WebDriver Firefox() {
		System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
		WebDriver navegador = new FirefoxDriver();
		navegador.get("https://www.sicredi.com.br/html/ferramenta/simulador-investimento-poupanca/");
		return navegador;
	}
	
}
