package API.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class APIUtils {

    /**
     * This method enables us to wait until given Webelement is visibile.
     * @param element
     */
    public void waitForVisibility(WebElement element){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * This method refreshes the page.
     */
    public void refreshPage(){
        Driver.getDriver().navigate().refresh();
    }

    /**
     * This method provides us to sleep the code during the given time.
     * @param seconds
     */
    public void sleep(int seconds){
        try {
            Thread.sleep(seconds*500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void wait(int second){
        Driver.getDriver().manage().timeouts().implicitlyWait(second, java.util.concurrent.TimeUnit.SECONDS);
    }

}
