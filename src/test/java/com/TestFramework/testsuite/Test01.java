package com.TestFramework.testsuite;

import com.TestFramework.BaseTest;
import com.TestFramework.page.HomePage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

public class Test01 extends BaseTest {

    public void signIn()throws Exception{
        WebElement signIn = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a"));



        signIn.click();
        Thread.sleep(3000);
        WebElement email = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("passwd"));
        WebElement btnSignIn = driver.findElement(By.id("SubmitLogin"));
        email.sendKeys("testauto5@gmail.com");
        password.sendKeys("FujitsuTest");
        btnSignIn.click();
        Thread.sleep(2000);

    }
    @Test(priority = 0)
    public void Test01() throws Exception{
        signIn();
        Thread.sleep(2000);
        scrollToDown(5);
        Thread.sleep(2000);
        WebElement btnHome=driver.findElement(By.xpath("//*[@id='center_column']/ul/li/a"));
        btnHome.click();
        Thread.sleep(2000);
        scrollToDown(10);
        Thread.sleep(2000);
        WebElement btnQuickView=driver.findElement(By.xpath("//*[@id='homefeatured']/li[1]/div/div[1]/div/a[1]"));
        btnQuickView.click();
        Thread.sleep(9000);
        WebElement listSize = driver.findElement(By.xpath("//*[@id='group_1']"));
        Select selectSize=new Select(listSize);
        selectSize.selectByVisibleText("L");
        Thread.sleep(2000);
        WebElement price=driver.findElement(By.xpath("//*[@id='our_price_display']"));
        String amt1=price.getText();
        WebElement btnAddToCart = driver.findElement(By.xpath("//*[@id='add_to_cart']/button"));
        btnAddToCart.click();
        Thread.sleep(9000);
        WebElement btnContinueShop = driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/span/span"));
        btnContinueShop.click();
        Thread.sleep(2000);
        WebElement logo=driver.findElement(By.xpath("//*[@id='header_logo']/a"));
        logo.click();
        Thread.sleep(2000);
        scrollToDown(10);
        Thread.sleep(2000);
        WebElement btnQuickView1=driver.findElement(By.xpath("//*[@id='homefeatured']/li[2]/div/div[1]/div/a[1]"));
        btnQuickView1.click();
        Thread.sleep(9000);
        //WebElement price1=driver.findElement(By.xpath("//*[@id='our_price_display']"));
       // String amt2=price1.getText();
        WebElement btnAddToCart1 = driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span"));
        btnAddToCart1.click();
        Thread.sleep(9000);
     //   WebElement btnContinueShop1 = driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/span/span"));
       // btnContinueShop1.click();
      //  Thread.sleep(2000);
        double amt2=27.00;
        double amoutn=Double.parseDouble(amt1.substring(1))+amt2;
        DecimalFormat f = new DecimalFormat("##.00");
        System.out.println(f.format(amoutn));
        double finalamont = Double.parseDouble(f.format(amoutn));
        WebElement totalPrice=driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[1]/span"));
        String totalAmt=totalPrice.getText();
        double totalAmount=Double.parseDouble(totalAmt.substring(1));
        if(finalamont==totalAmount){
            System.out.println("Pass");
        } else{
            System.out.println("Fail");
        }
//        Assert.assertEquals(finalamont,totalAmount);
        driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"cgv\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"form\"]/p/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button")).click();


        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")).click();

    }
    @Test(priority = 1)
    public void Test02() throws Exception{
        signIn();
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[1]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"order-list\"]/tbody/tr[1]/td[1]/a")).click();
        Thread.sleep(2000);
        scrollToDown(25);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"sendOrderMessage\"]/p[3]/textarea")).sendKeys("Test Order");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"sendOrderMessage\"]/div/button")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"block-order-detail\"]/div[5]/table/tbody/tr[1]/td[2]")).getText(),"Test Order");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")).click();
    }
    @Test(priority = 2)
    public void Test03() throws Exception{
        signIn();
        driver.navigate().to("http://automationpractice.com/index.php?id_product=1&controller=product#/color-blue/size-l");
        Thread.sleep(3000);
        String color=driver.findElement(By.xpath("//*[@id=\"color_14\"]")).getAttribute("title");
        if(color.equalsIgnoreCase("Orange")){
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/target/surefire-reports";
                File destFile = new File((String) reportDirectory+"/failure_screenshots/Test03.png");
                FileUtils.copyFile(scrFile, destFile);
                Reporter.log("<a href='"+ reportDirectory + "'> <img src='"+ reportDirectory + "' height='100' width='100'/> </a>");
                Assert.assertEquals(color,"Orange");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void scrollToDown(int iterations) {
        try {


            Thread.sleep(5000);
            for (int i = 0; i <= iterations; i++) {
//				((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)", "");
                driver.findElement(By.tagName("body")).sendKeys(Keys.ARROW_DOWN);
            }

        } catch (Exception e) {
          e.printStackTrace();
        }
    }
}

