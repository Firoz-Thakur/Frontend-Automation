package UI;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ATMScenarios {

    WebDriver driver;
    @BeforeClass
    public void setup()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("atm_url");
    }

    @Test(description = "Withdraw amount from the ATM", priority = 1)
    public void withdrawalAmount() {

        try {

            WebElement cardNumberInput = driver.findElement(By.id("card_number"));
            cardNumberInput.sendKeys("73438382838");
            WebElement pinInput = driver.findElement(By.id("pin"));
            pinInput.sendKeys("12345");
            WebElement amountInput = driver.findElement(By.id("amount"));
            amountInput.sendKeys("5000");
            WebElement withdrawButton = driver.findElement(By.id("withDrawButton"));
            withdrawButton.click();
            WebElement successMessage = driver.findElement(By.id("successMessage"));
            System.out.println(successMessage.getText());

        } catch(Exception exception )
        {
            System.out.println(exception.getMessage());
        }
        finally {
            driver.quit();
        }
    }

    @Test(description = "Cancel the transaction")
    public void cancelTransaction() {
        try {

            WebElement cardNumberInput = driver.findElement(By.id("card_number"));
            cardNumberInput.sendKeys("73438382838");
            WebElement pinInput = driver.findElement(By.id("pin"));
            pinInput.sendKeys("12345");
            WebElement incorrectPinMessage = driver.findElement(By.id("IncorrectPinMessage"));
            Assert.assertEquals(incorrectPinMessage, "Your pin is matching , please enter the correct pin");
        } catch(Exception exception )
        {
            System.out.println(exception.getMessage());
        }
        finally {
            driver.quit();
        }
    }

    @Test(description = "Enter incorrect Pin")
    public void enterIncorrectPin() {
        try {

            WebElement cardNumberInput = driver.findElement(By.id("card_number"));
            cardNumberInput.sendKeys("73438382838");
            WebElement pinInput = driver.findElement(By.id("pin"));
            pinInput.sendKeys("22222");
            WebElement amountInput = driver.findElement(By.id("cancel"));
            WebElement successMessage = driver.findElement(By.id("Cancel Transaction"));
            System.out.println(successMessage.getText());
            Assert.assertEquals(successMessage, "Transaction canceled succesfully");

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        } finally {
            driver.quit();
        }
    }
}

