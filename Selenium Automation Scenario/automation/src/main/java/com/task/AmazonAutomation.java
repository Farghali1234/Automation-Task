package com.task;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.task.utils.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonAutomation {

    WebDriver driver;
    ConfigReader configReader;

    public AmazonAutomation() {
        configReader = new ConfigReader();
    }

    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void testAmazonShopping() {
        setup();
        driver.get(configReader.getAmazonUrl());

        loginToAmazon();
        openAllMenu();
        selectVideoGames();
        applyFilters();
        sortByPrice();
        addProductsToCart();
        verifyCartItems();
        addAddressAndChoosePayment();
        verifyTotalAmount();

        driver.quit();
    }

    public void loginToAmazon() {
        driver.findElement(By.id("nav-link-accountList")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_email")));

        driver.findElement(By.id("ap_email")).sendKeys(configReader.getAmazonEmail());
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("ap_password")).sendKeys(configReader.getAmazonPassword());
        driver.findElement(By.id("signInSubmit")).click();

        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("nav-link-accountList")));
    }

    public void openAllMenu() {
        WebElement allMenu = driver.findElement(By.id("nav-hamburger-menu"));
        allMenu.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='hmenu hmenu-visible']")));
    }

    public void selectVideoGames() {
        WebElement videoGamesLink = driver.findElement(By.xpath("//a[@data-menu-id='7']"));
        videoGamesLink.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Video Games']")));

        WebElement allVideoGamesLink = driver.findElement(By.xpath("//span[text()='All Video Games']"));
        allVideoGamesLink.click();
    }

    public void applyFilters() {
        driver.findElement(By.xpath("//span[text()='Free Shipping']")).click();
        driver.findElement(By.xpath("//span[text()='New']")).click();
    }

    public void sortByPrice() {
        WebElement sortMenu = driver.findElement(By.id("s-result-sort-select"));
        sortMenu.click();

        WebElement highToLowOption = driver.findElement(By.xpath("//option[@value='price-desc-rank']"));
        highToLowOption.click();
    }

    public void addProductsToCart() {
        List<WebElement> products = driver.findElements(By.xpath("//span[@class='a-price-whole']"));

        for (WebElement product : products) {
            String priceText = product.getText().replace(",", "");
            double price = Double.parseDouble(priceText);

            if (price < 15000) {
                WebElement addToCartButton = product.findElement(By.xpath("ancestor::div[@class='s-main-slot']//input[@value='Add to Cart']"));
                addToCartButton.click();
            }
        }

        WebElement nextPageButton = driver.findElement(By.xpath("//li[@class='a-last']/a"));
        if (nextPageButton != null) {
            nextPageButton.click();
        }
    }

    public void verifyCartItems() {
        driver.findElement(By.id("nav-cart")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("sc-subtotal-amount-buybox")));
        List<WebElement> cartItems = driver.findElements(By.xpath("//div[@class='sc-list-item-content']"));
        Assert.assertTrue(!cartItems.isEmpty(), "No products added to the cart!");
    }

    public void addAddressAndChoosePayment() {
        driver.findElement(By.xpath("//span[text()='Add a new address']")).click();
        driver.findElement(By.xpath("//input[@value='COD']")).click();
    }

    public void verifyTotalAmount() {
        WebElement totalAmount = driver.findElement(By.id("sc-subtotal-amount-buybox"));
        String totalAmountText = totalAmount.getText();
        Assert.assertTrue(totalAmountText.contains("EGP"), "Total amount is incorrect.");
    }
}
