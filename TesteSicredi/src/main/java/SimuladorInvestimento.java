import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import Utilitarios.Gerador;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "src/main/resources/resultados.csv")

public class SimuladorInvestimento {
	private WebDriver navegador;
	
	String mensagemvalorminimo = "Valor mínimo de 20.00", mensagemobrigatorio = "Obrigatório", total = "R$ 2.802";
	
	@Rule
	public TestName nometeste = new TestName();
	
	@Before
	public void setUp() {
		navegador = Web.Firefox();
	}
	
	@After
	public void tearDown() {
		navegador.quit();
	}		
	
	@Test
	public void testeValidaValorMinimoAplicar() {
		new SimulaInvestimentosPageObject(navegador)
			.escrever("1999","valorAplicar")
			.clicar()
			.guardar(mensagemvalorminimo,"valorAplicar-error");
		Gerador.screenShot(navegador, "src/main/resources/"+ Gerador.dataHoraAtual() + nometeste.getMethodName() +".png");
		
	}
	
	@Test
	public void testeValidaValorMinimoInvestir() {
		new SimulaInvestimentosPageObject(navegador)
		.escrever("1999","valorAplicar")
		.clicar()
		.guardar(mensagemvalorminimo,"valorInvestir-error");
		Gerador.screenShot(navegador, "src/main/resources/"+ Gerador.dataHoraAtual() + nometeste.getMethodName() +".png");
	}
	
	@Test
	public void testeValidaCamposObrigatorios() {
		new SimulaInvestimentosPageObject(navegador)
		.clicar()
		.guardar(mensagemobrigatorio, "tempo-error");
		Gerador.screenShot(navegador, "src/main/resources/"+ Gerador.dataHoraAtual() + nometeste.getMethodName() +".png");
	}
	
	@Test
	public void testeSomenteAplicar() {
		new SimulaInvestimentosPageObject(navegador)
		.escrever("2000","valorAplicar")
		.escrever("12","tempo")
		.clicar()
		.guardar(mensagemvalorminimo, "valorInvestir-error");
		Gerador.screenShot(navegador, "src/main/resources/"+ Gerador.dataHoraAtual() + nometeste.getMethodName() +".png");
	}
	
	@Test
	public void testeSomenteInvestir() {
		new SimulaInvestimentosPageObject(navegador)
		.escrever("2000","valorInvestir")
		.escrever("12","tempo")
		.clicar()
		.guardar(mensagemvalorminimo, "valorAplicar-error");
		Gerador.screenShot(navegador, "src/main/resources/"+ Gerador.dataHoraAtual() + nometeste.getMethodName() +".png");
	}
	
	@Test
	public void testeSucesso() {
		new SimulaInvestimentosPageObject(navegador)
		.escrever("2449","valorAplicar")
		.escrever("2449","valorInvestir")
		.escrever("100","tempo")
		.clicar()
		.guardartotal(total, "valor");
		Gerador.screenShot(navegador, "src/main/resources/"+ Gerador.dataHoraAtual() + nometeste.getMethodName() +".png");
	}
	
	@Test
	public void testeResultados(@Param(name="meses")String meses, @Param(name="valores")String valores) {
		new SimulaInvestimentosPageObject(navegador)
		.escrever(valores,"valorAplicar")
		.escrever(valores,"valorInvestir")
		.escrever(meses,"tempo")
		.clicar();
		Gerador.screenShot(navegador, "src/main/resources/"+ Gerador.dataHoraAtual() + nometeste.getMethodName() +".png");
	}
}
