package UI;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class ATMScenarios {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("atm_url");
        try {

            WebElement cardNumberInput = driver.findElement(By.id("card_number"));
            cardNumberInput.sendKeys("73438382838");
            WebElement pinInput = driver.findElement(By.id("pin"));
            pinInput.sendKeys("34324234");
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
}

