package com.bimabharosa.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonMethods extends BaseClass{

    public static void javascript_click(WebElement element){
        try{
            JavascriptExecutor js =(JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
        }
        catch (NoSuchElementException e){
            e.printStackTrace();
        }

    }

    public static void scrollToUpward(){
        try{
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,-400)");
        }
        catch (NoSuchElementException e){

        }
    }

    public static void scrollToDownward(){
        try{
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,400)");
        }
        catch (NoSuchElementException e){

        }
    }
}
