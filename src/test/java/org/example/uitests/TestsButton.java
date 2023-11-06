package org.example.uitests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestsButton extends BaseTestClass {
    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    public void alertTestConfirmOk() {
        WebElement alertButton = driver.findElement(By.xpath("//button[contains(text(),'JS Confirm')]"));
        alertButton.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement result = driver.findElement(By.id("result"));
        Assert.assertEquals(result.getText(), "You clicked: Ok");
    }

    @Test
    public void alertTestConfirmCancel() {
        WebElement alertButton = driver.findElement(By.xpath("//button[contains(text(),'JS Confirm')]"));
        alertButton.click();

        Alert alert = driver.switchTo().alert();
        alert.dismiss();

        WebElement result = driver.findElement(By.id("result"));
        Assert.assertEquals(result.getText(), "You clicked: Cancel");
    }

    @Test
    public void alertTestPromptOk() {
        WebElement alertButton = driver.findElement(By.xpath("//button[contains(text(), 'Click for JS Prompt')]"));
        alertButton.click();

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Serhii");
        alert.accept();

        WebElement result = driver.findElement(By.id("result"));
        Assert.assertEquals(result.getText(), "You entered: Serhii");
    }

    @Test
    public void alertTestPromptCancel() {
        WebElement alertButton = driver.findElement(By.xpath("//button[contains(text(), 'Click for JS Prompt')]"));
        alertButton.click();

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Serhii");
        alert.dismiss();

        WebElement result = driver.findElement(By.id("result"));
        Assert.assertEquals(result.getText(), "You entered: null");
    }

}
