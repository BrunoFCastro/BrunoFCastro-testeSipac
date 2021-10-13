package testeProgramacao.testeJunit;

import java.time.Duration;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class testeSelenium {
	WebDriver driver;
	Duration time = Duration.ofSeconds(20);
	@Before
	public	void	preCondicao(){
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://acesso.ufba.br:65443/remote/login?lang=en");
		driver.manage().window().maximize();
	}
	@Test
	public	void	teste() {
	    WebDriverWait wait = new WebDriverWait(driver,time);
	    String abaInicial = driver.getWindowHandle();
		driver.findElement(By.id("username")).sendKeys("bruno.fortunato");
        driver.findElement(By.id("credential")).sendKeys("Bobesponja01");
        driver.findElement(By.id("login_button")).click();
        wait.until(ExpectedConditions.urlMatches("https://acesso.ufba.br:65443/sslvpn/portal.html#/"));
        driver.findElement(By.xpath("//*[@id=\"navbar-view-section\"]/div/div/div[4]/div[2]/button[1]")).click();
        driver.findElement(By.id("url")).sendKeys("https://teste2sipac.ufba.br/");
        driver.findElement(By.xpath("//*[@id=\'navbar-view-section\']/div/div/div[2]/form/div[2]/button[1]")).click();
        Set<String>	abas = driver.getWindowHandles();
        for(String	aba:	abas){
			if(!aba.equals(abaInicial)){
				driver.switchTo().window(aba);
			}
        }
        driver.findElement(By.className("acesso_centro_bg")).click();
        driver.findElement(By.name("login")).sendKeys("fortunado");
        driver.findElement(By.name("senha")).sendKeys("nova123");
        driver.findElement(By.xpath("//*[@id='conteudo']/div[3]/form/table/tfoot/tr/td/input")).click();
	}				
	@After
	public	void	posCondicao(){
		driver.quit();
	}

}