package testeProgramacao.testeJunit;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AbrirProcesso {

	WebDriver	driver;	
	@Test
	public void abreProcesso(){
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://treinamentosipac.ufba.br/sipac/");
		driver.findElement(By.name("login")).sendKeys("tcoutinho");
        driver.findElement(By.name("senha")).sendKeys("Coutinho.123");
        driver.findElement(By.xpath("//*[@id=\"conteudo\"]/div[3]/form/table/tbody/tr[1]/td/input")).submit();
        driver.navigate().to("https://treinamentosipac.ufba.br/sipac/protocolo/index.jsf");
		driver.navigate().to("https://treinamentosipac.ufba.br/sipac/protocolo/menu.jsf");
		driver.navigate().to("https://treinamentosipac.ufba.br/sipac/protocolo/processo/cadastro/abrir_processo_1.jsf");
		driver.getCurrentUrl().contains("https://treinamentosipac.ufba.br/sipac/protocolo/processo/cadastro/abrir_processo_1.jsf");
	}
	@After
	public void finalizaTeste() {
		driver.quit();
	}
}