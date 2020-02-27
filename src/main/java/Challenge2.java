/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Leandro Teodoro
 */
import java.util.concurrent.TimeUnit;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Challenge2 {

    public static WebDriver driver;

    @BeforeClass
    public static void openBrowser() {
        // OBSERVAÇÃO:
        // O script deve executar no browser Google Chrome
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void stepsChallenge1() throws InterruptedException {
        // PRÉ-CONDIÇÃO
        // Execute todos os passos do Desafio 1
        
        // PASSOS
        // Passo 1. Acesse a página https://www.grocerycrud.com/demo/bootstrap_theme
        driver.get("https://www.grocerycrud.com/demo/bootstrap_theme");

        // Passo 2. Mude o valor da combo Select version para "Bootstrap V4 Theme"
        Select combobox = new Select(driver.findElement(By.id("switch-version-select")));
        combobox.selectByVisibleText("Bootstrap V4 Theme");

        // Passo 3. Clique no botão Add Customer
        driver.findElement(By.cssSelector(".el.el-plus")).click();

        // Passo 4. Preencha os campos do formulário com as seguintes informações:
        driver.findElement(By.id("field-customerName")).sendKeys("Teste Sicredi");
        driver.findElement(By.id("field-contactLastName")).sendKeys("Teste");
        driver.findElement(By.id("field-contactFirstName")).sendKeys("Leandro");
        driver.findElement(By.id("field-phone")).sendKeys("51 9999-9999");
        driver.findElement(By.id("field-addressLine1")).sendKeys("Av Assis Brasil, 3970");
        driver.findElement(By.id("field-addressLine2")).sendKeys("Torre D");
        driver.findElement(By.id("field-city")).sendKeys("Porto Alegre");
        driver.findElement(By.id("field-state")).sendKeys("RS");
        driver.findElement(By.id("field-postalCode")).sendKeys("91000-000");
        driver.findElement(By.id("field-country")).sendKeys("Brasil");
        driver.findElement(By.xpath("//div[@id='field_salesRepEmployeeNumber_chosen']/a/span")).click();
        driver.findElement(By.cssSelector(".chosen-search > input")).sendKeys("Fixter", Keys.ENTER);
        driver.findElement(By.id("field-creditLimit")).sendKeys("200");

        // Passo 5. Clique no botão Save
        driver.findElement(By.id("form-button-save")).click();

        // Passo 6. Validar a mensagem "Your data has been successfully stored into the database." através de uma asserção
        String test1 = driver.findElement(By.xpath("//div[@id='report-success']/p")).getText();
        Assert.assertTrue("Test 1 DID NOT Pass!!!", test1.contains("Your data has been successfully stored into the database."));
    }

    @Test
    public void stepsChallenge2() throws InterruptedException {
        // PASSOS
        // Passo 1. Clique no link Go back to list
        driver.findElement(By.linkText("Go back to list")).click();

        // Passo 2. Clique no ícone da lupa (pesquisa) e digite o conteúdo do Name (Teste Sicredi)
        driver.findElement(By.cssSelector(".el-search")).click();
        driver.findElement(By.cssSelector(".search-input")).sendKeys("Teste Sicredi", Keys.ENTER);

        // Passo 3. Clicar no checkbox abaixo da palavra Actions
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();

        // Passo 4. Clicar no botão Delete
        driver.findElement(By.cssSelector(".btn > .text-danger:nth-child(2)")).click();

        // Passo 5. Validar o texto "Are you sure that you want to delete this 1 item?" através de uma asserção para a popup que será apresentada
        String test2 = driver.findElement(By.xpath("//p[contains(.,'\n                                Are you sure that you want to delete those ')]")).getText();
        Assert.assertEquals("Test 2 DID NOT Pass!!!", "Are you sure that you want to delete those 2 items?", test2);

        // Passo 6. Clicar no botão Delete da popup
        driver.findElement(By.cssSelector(".delete-multiple-confirmation-button")).click();

        // Passo 7. Aparecerá uma mensagem dentro de um box verde na parte superior direito da tela. 
        //          Adicione uma asserção na mensagem "Your data has been successfully deleted from the database."
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//p[contains(.,'Your data has been successfully deleted from the database.')]")));
        String test3 = driver.findElement(By.xpath("//p[contains(.,'Your data has been successfully deleted from the database.')]")).getText();
        Assert.assertEquals("Test 3 DID NOT Pass!!!", "Your data has been successfully deleted from the database.", test3);
    }

    @AfterClass
    public static void closeBrowser() {
        // Passo 8. Feche o driver web
        driver.close();
    }
}