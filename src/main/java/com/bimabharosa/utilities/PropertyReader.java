package com.bimabharosa.utilities;

import com.bimabharosa.enums.DriverType;
import com.bimabharosa.enums.OperatingSystem;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    static Properties properties = null;

    public PropertyReader(String filePath) {
        try {
            properties = new Properties();
            FileInputStream fis = new FileInputStream(filePath);
            properties.load(fis);
        } catch (IOException f) {
            f.printStackTrace();
        }
    }


    public static Properties readPropertiesFile(String filePath) throws IOException {
        try{
            properties = new Properties();
            FileInputStream fis = new FileInputStream(filePath);
            properties.load(fis);
        }
        catch (FileNotFoundException f){
            f.printStackTrace();
        }

        return properties;

    }

    public String getBaseURL(){
        String URL = properties.getProperty("URL");
        if(URL != null){
            return URL;
        }
        else{
            throw new RuntimeException("URL is not specified in credentials file");
        }
    }

    public String getLoginURL(){
        String loginURL = properties.getProperty("LoginPageURL");
        if(loginURL != null){
            return loginURL;
        }
        else{
            throw new RuntimeException("LoginPage URL is not specified in credentials file");
        }
    }

    public String getRegisterURL(){
        String regURL = properties.getProperty("RegPageURL");
        if(regURL != null){
            return regURL;
        }
        else{
            throw new RuntimeException("Register URL not specified in credentials file");
        }
    }

    public String getChromeDriverPath(){
        String chromeDriver = properties.getProperty("chromeDriverPath");
        if(chromeDriver != null){
            return chromeDriver;
        }
        else{
            throw new RuntimeException("ChromeDriver path not specified in credentials file");
        }
    }

    public String getFirefoxDriverPath(){
        String geckoDriver = properties.getProperty("firefoxDriverPath");
        if(geckoDriver != null){
            return geckoDriver;
        }
        else{
            throw new RuntimeException("FirefoxDriver path not specified in credentials file");
        }
    }

    public String getEdgeDriverPath(){
        String edgeDriver = properties.getProperty("edgeDriverPath");
        if(edgeDriver != null){
            return edgeDriver;
        }
        else{
            throw new RuntimeException("EdgeDriver path not specified in credentials file");
        }
    }

    public String getChromeDriverPathLinuxMax(){
        String chromeDriverLinuxMac = properties.getProperty("chromeDriverPathLinuxMac");
        if(chromeDriverLinuxMac != null){
            return chromeDriverLinuxMac;
        }
        else{
            throw new RuntimeException("chromeDriverPathLinuxMac path not specified in credentials file");
        }
    }

    public String getFirefoxDriverPathLinuxMax(){
        String firefoxDriverPathLinuxMac = properties.getProperty("firefoxDriverPathLinuxMac");
        if(firefoxDriverPathLinuxMac != null){
            return firefoxDriverPathLinuxMac;
        }
        else{
            throw new RuntimeException("firefoxDriverPathLinuxMac path not specified in credentials file");
        }
    }

    public String getEdgeDriverPathLinuxMac(){
        String edgeDriverPathLinuxMac = properties.getProperty("edgeDriverPathLinuxMac");
        if(edgeDriverPathLinuxMac != null){
            return edgeDriverPathLinuxMac;
        }
        else{
            throw new RuntimeException("edgeDriverPathLinuxMac path not specified in credentials file");
        }
    }

    public OperatingSystem getOperatingSystem(){
        String operatingSystem = properties.getProperty("OS");

        switch (operatingSystem){
            case "Windows":
                return OperatingSystem.WINDOWS;
            case "Linux":
                return OperatingSystem.LINUX;
            case "Mac":
                return OperatingSystem.MAC;
            default:
                throw new RuntimeException("Environment type key value in configuration file is not matched: " + operatingSystem);
        }
    }


    public DriverType getBrowser(){
        String browser = properties.getProperty("Browser");

        switch (browser){
            case "Chrome":
                return DriverType.CHROME;
            case "Firefox":
                return DriverType.FIREFOX;
            case "Edge":
                return DriverType.EDGE;
            case "IE":
                return DriverType.IE;
            default:
                throw new RuntimeException("Browser name key value in configuration file is not matched: " + browser);
        }
    }


    public long getTime() {
        String timeout = properties.getProperty("timeout");

        if (timeout != null) {
            return Long.parseLong(timeout);
        } else {
            throw new RuntimeException("Timeout not specified in the config file.");
        }
    }


}
