package Commands;

import Browser.Browser;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;


/**
 * Created by Subramanya on 22-05-2014.
 */
public class Commands extends Browser
{

    public static String browserName;
    public static String v;
    public static String os;
    public static String PlayerName;
    public int rg;
    public static Workbook wbook;
    public static WritableWorkbook wwbCopy;
    public static String ExecutedTestCasesSheet;
    public static WritableSheet shSheet;
    
    public static String URL;
    public static String[] ResultUrl;
    public static String OldTab;

    public static WebElement W;
    WebElement W1;
    WebElement W2;
    WebElement W3;
    WebElement W4;
    WebElement W5;
    WebElement W6;
    String Text;
    String Result;
    public static List<String> Error = new ArrayList<String>();
    public static List<String> ElementsPresent = new ArrayList<String>();
    public static List<String> ElementsVisible = new ArrayList<String>();
    public static List<String> VerifyText = new ArrayList<String>();
    public static List<String> VerifyURL = new ArrayList<String>();
    public static List<String> VerifyTitle = new ArrayList<String>();
    public List<String> SleepError = new ArrayList<String>();
    public ArrayList<String> NewTab;
    
   


   /* Verify Element Present Using CSS Selector */
    
    public void VerifyElementPresentCSS(WebDriver driver, String locator)
    {
        //Set the timeout to something low
        try
        {
            W = driver.findElement(By.cssSelector(locator));
            ElementsPresent.add(locator+" : Element is Present");

        }
        catch (NoSuchElementException NSEE)
        {
            //If element isn't found, set the timeout and return false
            Error.add(locator+" : Element is not Present");

        }
    }
    
    /* Verify Element Present Using XPath Selector */
    
    public void VerifyElementPresentXpath(WebDriver driver, String locator)
    {
        //Set the timeout to something low
        try
        {
            W = driver.findElement(By.cssSelector(locator));
            ElementsPresent.add(locator+" : Element is Present");

        }
        catch (NoSuchElementException NSEE)
        {
            //If element isn't found, set the timeout and return false
            Error.add(locator+" : Element is not Present");

        }
    }

    /* Verify Element Present and Visible using CSS Selector */
    
    public static void VerifyElementVisibleCSS(String locator)
    {
        try
        {
            W = driver.findElement(By.cssSelector(locator));
            ElementsPresent.add(locator+" : Element is Present");
            Assert.assertTrue(W.isDisplayed());
            ElementsVisible.add(locator+" : Element is Present and is Displayed / Visible");

        }
        catch (NoSuchElementException NSEE)
        {
            //If element isn't found, set the timeout and return false
            Error.add(locator+" : Element is not Present");

        }
        catch (AssertionError AE)
        {
            //If element isn't found, set the timeout and return false
            Error.add(locator+" : Element is Present but not Displayed / Visible");

        }
    }
    
    /* Verify Element Present and Visible using XPath Selector */
    
    public static void VerifyElementVisibleByXpath(String locator)
    {
        try
        {
            W = driver.findElement(By.xpath(locator));
            ElementsPresent.add(locator+" : Element is Present");
        
            
            
            Assert.assertTrue(W.isDisplayed());
            ElementsVisible.add(locator+" : Element is Present and is Displayed / Visible");
        
         
        }
        catch (NoSuchElementException NSEE)
        {
            //If element isn't found, set the timeout and return false
            Error.add(locator+" : Element is not Present");
            Reporter.log(locator+" : Element is not Present");

        }
        catch (AssertionError AE)
        {
            //If element isn't found, set the timeout and return false
            Error.add(locator+" : Element is Present but not Displayed / Visible");
            Reporter.log(locator+" : Element is Present but not Displayed / Visible");

        }
    }

    /* Verify Text Present using CSS Selector */
    
    public void VerifyTextCSS(String locator, String ExpectedText)
    {
        try
        {
            W = driver.findElement(By.cssSelector(locator));
            ElementsPresent.add(locator+" : Element is Present");
            Assert.assertTrue(W.isDisplayed());
            ElementsVisible.add(locator+" : Element is Present ");
            try
            {
                Text = W.getText();
                Assert.assertEquals(Text, ExpectedText);
                VerifyText.add("Actual Text is : " + Text + " and matches Expected Text : " + ExpectedText);
            }
            catch (AssertionError AE)
            {
                Error.add("Actual Text is : " + Text + " and does not match Expected Text : " + ExpectedText);
            }
            catch(NullPointerException npe)
            {
                Error.add("Text is Null");
            }
        }
        catch (NoSuchElementException NSEE)
        {
            //If element isn't found, set the timeout and return false
            Error.add(locator + " : Element is not Present");
        }
        catch (AssertionError AE)
        {
            //If element isn't found, set the timeout and return false
            Error.add(locator+" : Element is Present but not Displayed / Visible ");
        }
    }
    
 /* Verify Text Present using XPath Selector */
    
    public void VerifyTextXPath(String locator, String ExpectedText)
    {
        try
        {
            W = driver.findElement(By.xpath(locator));
            ElementsPresent.add(locator+" : Element is Present");
            Assert.assertTrue(W.isDisplayed());
            ElementsVisible.add(locator+" : Element is Present ");
            try
            {
                Text = W.getText();
                Assert.assertEquals(Text, ExpectedText);
                VerifyText.add("Actual Text is : " + Text + " and matches Expected Text : " + ExpectedText);
            }
            catch (AssertionError AE)
            {
                Error.add("Actual Text is : " + Text + " and does not match Expected Text : " + ExpectedText);
            }
            catch(NullPointerException npe)
            {
                Error.add("Text is Null");
            }

        }
        catch (NoSuchElementException NSEE)
        {
            //If element isn't found, set the timeout and return false
            Error.add(locator + " : Element is not Present");
        }
        catch (AssertionError AE)
        {
            //If element isn't found, set the timeout and return false
            Error.add(locator+" : Element is Present but not Displayed / Visible ");
        }
    }
    

    public void CheckNewTabLinks(WebDriver driver, String locator, String ExpectedURL)
    {
        try
        {
            /* Check for Cookie Banner Present and Displayed */
          //  VerifyAndClick(locator);
            Pause(5000);
            ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs2.get(1));
            String URL = driver.getCurrentUrl();
            String[] ResultUrl = URL.split("/");
            URL = ResultUrl[0]+"//"+ResultUrl[2]+"/";
            driver.close();
            Pause(5000);
            driver.switchTo().window(tabs2.get(0));
            driver.switchTo().frame(0);
            try
            {
                Assert.assertEquals(URL,ExpectedURL);
                VerifyURL.add("Actual URL is : " + URL + " and matches Expected URL : " + ExpectedURL);
            }
            catch(AssertionError AE)
            {
                Error.add("Actual URL is : " + URL + " and does not match Expected URL : " + ExpectedURL);
            }
        }
        catch (NoSuchElementException nsee)
        {
            Error.add(locator+" : Element is not Present");
        }
        catch (AssertionError ae)
        {
            Error.add(locator+" : Element is Present but not Displayed / Visible ");
        }
        catch (IndexOutOfBoundsException ioobe)
        {
            Error.add(" No Tabs ");
        }
    }

    public void CheckCurrentTabURL(WebDriver driver, String locator, String ExpectedURL,String ExpectedTitle,String ExpectedElement,String ExpectedText)
    {
        try
        {
            /* Check for Cookie Banner Present and Displayed */
          //  VerifyAndClick(locator);
            Pause(5000);
            String URL = driver.getCurrentUrl();
            String[] ResultUrl = URL.split("=");
            URL = ResultUrl[0];
            VerifyTextCSS(ExpectedElement,ExpectedText);
            try
            {
                Assert.assertEquals(URL,ExpectedURL);
                VerifyURL.add("Actual URL is : " + URL + " and matches Expected URL : " + ExpectedURL);
            }
            catch(AssertionError AE)
            {
                Error.add("Actual URL is : " + URL + " and does not match Expected URL : " + ExpectedURL);
            }

        }
        catch (NoSuchElementException nsee)
        {
            Error.add(locator+" : Element is not Present");
        }
        catch (AssertionError ae)
        {
            Error.add(locator+" : Element is Present but not Displayed / Visible ");
        }
        catch (IndexOutOfBoundsException ioobe)
        {
            Error.add(" No Tabs ");
        }
    }
    
    public void CheckNewTabPartialURLXpathOnly(String locator, String ExpectedURL,String ExpectedTitle,String ExpectedElement)
    {
            VerifyAndClickXpath(locator);        
            String CurrentURL = driver.getCurrentUrl();
            String[] ResultUrl = CurrentURL.split("=");
            CurrentURL = ResultUrl[0];

            try
            {
                Assert.assertEquals(CurrentURL,ExpectedURL);
                VerifyURL.add("Actual URL is : " + CurrentURL + " and matches Expected URL : " + ExpectedURL);
            }
            catch (AssertionError AE)
            {
                Error.add("Actual URL is : " + CurrentURL + " and does not match Expected URL : " + ExpectedURL);
            }

            String CurrentTitle = driver.getTitle();

            try
            {
                Assert.assertEquals(CurrentTitle,ExpectedTitle);
                VerifyTitle.add("Actual URL is : " + CurrentTitle + " and matches Expected URL : " + ExpectedTitle);
            }
            catch (AssertionError AE)
            {
                Error.add("Actual Title is : " + CurrentTitle + " and does not match Expected Title : " + ExpectedTitle);
            }

         //   VerifyElementVisibleByXpath(ExpectedElement,VariableName);
            
    }
    

    public void CheckNewTabLinks(String locator, String Text1)
    {
        try
        {
            WebElement e = driver.findElement(By.cssSelector(locator));
            Assert.assertTrue(e.isDisplayed());
            e.click();
            Pause(5000);
            ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs2.get(1));
            String URL = driver.getCurrentUrl();
            driver.close();
            Pause(5000);
            driver.switchTo().window(tabs2.get(0));
            try
            {
                Assert.assertEquals(URL,Text1);
                VerifyURL.add("Actual URL is : " + URL + " and matches Expected URL : " + Text1);
            }
            catch(AssertionError AE)
            {
                Error.add("Actual URL is : " + URL + " and does not match Expected URL : " + Text1);
            }
        }
        catch (NoSuchElementException nsee)
        {
            Error.add(locator+" : Element is not Present");
        }
        catch (AssertionError ae)
        {
            Error.add(locator+" : Element is Present but not Displayed / Visible ");
        }
        catch (IndexOutOfBoundsException ioobe)
        {
            Error.add(" No Tabs ");
        }
    }
    
    public void CheckNewTabLinksXpath(String locator, String Text1)
    {
    	
    	String OldTab = driver.getWindowHandle();
        try
        {        	
        	WebElement e = driver.findElement(By.xpath(locator));
            Assert.assertTrue(e.isDisplayed());
           // Login();
            e.click();
            ArrayList<String> NewTab = new ArrayList<String>(driver.getWindowHandles());
            NewTab.remove(OldTab);
                        
            driver.switchTo().window(NewTab.get(0));          
            String URL = driver.getCurrentUrl();
            driver.close();            
            driver.switchTo().window(OldTab);
            
            try
            {
                Assert.assertEquals(URL,Text1);
                VerifyURL.add("Actual URL is : " + URL + " and matches Expected URL : " + Text1);
                
            }
            catch(AssertionError AE)
            {
                Error.add("Actual URL is : " + URL + " and does not match Expected URL : " + Text1);
            }
        }
        catch (NoSuchElementException nsee)
        {
            Error.add(locator+" : Element is not Present");
        }
        catch (AssertionError ae)
        {
            Error.add(locator+" : Element is Present but not Displayed / Visible ");
        }
        catch (IndexOutOfBoundsException ioobe)
        {
            Error.add(" No Tabs ");
        }
    }
    
    public void CheckNewTabLinksPartialXpath(String locator, String ExpectedURL, String ExpectedElement)
    {
    	
    	OldTab = driver.getWindowHandle();
        try
        {        	
        	WebElement e = driver.findElement(By.xpath(locator));
            Assert.assertTrue(e.isDisplayed());
           // Login();
            e.click();
            ArrayList<String> NewTab = new ArrayList<String>(driver.getWindowHandles());
            NewTab.remove(OldTab);
                        
            driver.switchTo().window(NewTab.get(0));          
            URL = driver.getCurrentUrl();
            ResultUrl = URL.split("=");
            URL = ResultUrl[0];
           // driver.close();            
           // driver.switchTo().window(OldTab);
            
            try
            {
                Assert.assertEquals(URL,ExpectedURL);
                VerifyURL.add("Actual URL is : " + URL + " and matches Expected URL : " + ExpectedURL);
                
            }
            catch(AssertionError AE)
            {
                Error.add("Actual URL is : " + URL + " and does not match Expected URL : " + ExpectedURL);
            }            
            
        }
        catch (NoSuchElementException nsee)
        {
            Error.add(locator+" : Element is not Present");
        }
        catch (AssertionError ae)
        {
            Error.add(locator+" : Element is Present but not Displayed / Visible ");
        }
        catch (IndexOutOfBoundsException ioobe)
        {
            Error.add(" No Tabs ");
        }
    }

    public void CheckNewTabLinks2(WebDriver driver, String locator, String Text1)
    {
        try
        {

           /* Check for Cookie Banner Present and Displayed */

            // WebElement e = driver.findElement(By.cssSelector(locator));
            // Assert.assertTrue(e.isDisplayed());
            // driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
      //      VerifyAndClick(locator);
            Pause(5000);
            ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs2.get(1));
            String URL = driver.getCurrentUrl();
            String[] ResultUrl = URL.split("/");
            URL = ResultUrl[0]+"//"+ResultUrl[2]+"/";
            driver.close();
            Pause(5000);
            driver.switchTo().window(tabs2.get(0));
            try
            {
                Assert.assertEquals(URL,Text1);
                VerifyURL.add("Actual URL is : " + URL + " and matches Expected URL : " + Text1);
            }
            catch(AssertionError AE)
            {
                Error.add("Actual URL is : " + URL + " and does not match Expected URL : " + Text1);
            }
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        }
        catch (NoSuchElementException nsee)
        {

            Error.add(locator+" : Element is not Present");

        }
        catch (AssertionError ae)
        {

            Error.add(locator+" : Element is Present but not Displayed / Visible ");

        }
        catch (IndexOutOfBoundsException ioobe)
        {
            Error.add(" No Tabs ");
        }
    }

    public void EncoderAndVerifyText(WebDriver driver, String locator, String Text1)
    {
        try
        {
            W = driver.findElement(By.cssSelector(locator));
            ElementsPresent.add(locator+" : Element is Present");
            Assert.assertTrue(W.isDisplayed());
            ElementsVisible.add(locator+" : Element is Present ");
            try
            {
                Text = W.getText();
                Result = new String(Text1.getBytes("ISO-8859-1"), "UTF-8");
                Assert.assertEquals(Result, Text);
                VerifyText.add("Actual Text is : " + Text + " and matches Expected Text : " + Result);
            }
            catch (AssertionError AE)
            {
                Error.add("Actual Text is : " + Text + " and does not match Expected Text : " + Text1);
            }
            catch(NullPointerException npe)
            {
                Error.add("Text is Null");
            }
        }
        catch (UnsupportedEncodingException UEE)
        {
            Error.add("Encoding Error");
        }
        catch (NoSuchElementException NSEE)
        {
            //If element isn't found, set the timeout and return false
            Error.add(locator+" : Element is not Present");
        }
        catch (AssertionError AE)
        {
            //If element isn't found, set the timeout and return false
            Error.add(locator+" : Element is Present but not Displayed / Visible ");

        }

    }

    public void ClickEncoderAndVerifyText(WebDriver driver, String locator, String locator1, String Text1)
    {
        try
        {

          //  VerifyAndClick(locator1);
            W = driver.findElement(By.cssSelector(locator));
            ElementsPresent.add(locator+" : Element is Present");
            Assert.assertTrue(W.isDisplayed());
            ElementsVisible.add(locator+" : Element is Present ");
            try
            {
                Text = W.getText();
                Result = new String(Text1.getBytes("ISO-8859-1"), "UTF-8");
                Assert.assertEquals(Result, Text);
                VerifyText.add("Actual Text is : " + Text + " and matches Expected Text : " + Result);
            }
            catch (AssertionError AE)
            {
                Error.add("Actual Text is : " + Text + " and does not match Expected Text : " + Text1);
            }
            catch(NullPointerException npe)
            {
                Error.add("Text is Null");
            }
        }
        catch (UnsupportedEncodingException UEE)
        {
            Error.add("Error Encoding");
        }
        catch (NoSuchElementException NSEE)
        {
            //If element isn't found, set the timeout and return false
            Error.add(locator+" : Element is not Present");
        }
        catch (AssertionError AE)
        {
            //If element isn't found, set the timeout and return false
            Error.add(locator+" : Element is Present but not Displayed / Visible ");
        }

    }

    public static void EnterText(String locator, String Text)
    {

        try
        {
            W = driver.findElement(By.cssSelector(locator));
            ElementsPresent.add(locator+" : Element is Present");
            Assert.assertTrue(W.isDisplayed());
            ElementsVisible.add(locator+" : Element is Present and is Displayed / Visible");
            W.clear();
            W.sendKeys(Text);
        }
        catch (NoSuchElementException NSEE)
        {
            //If element isn't found, set the timeout and return false
            Error.add(locator+" : Element is not Present");

        }
        catch (AssertionError AE)
        {
            //If element isn't found, set the timeout and return false
            Error.add(locator+" : Element is Present but not Displayed / Visible");

        }


    }
    
    public static void EnterTextByXpath(String locator, String Text)
    {

        try
        {
            W = driver.findElement(By.xpath(locator));
            ElementsPresent.add(locator+" : Element is Present");
            Assert.assertTrue(W.isDisplayed());
            ElementsVisible.add(locator+" : Element is Present and is Displayed / Visible");
            W.clear();
            W.sendKeys(Text);
        }
        catch (NoSuchElementException NSEE)
        {
            //If element isn't found, set the timeout and return false
            Error.add(locator+" : Element is not Present");

        }
        catch (AssertionError AE)
        {
            //If element isn't found, set the timeout and return false
            Error.add(locator+" : Element is Present but not Displayed / Visible");

        }


    }

    public void Login(WebDriver driver, String locator, String SignInText, String Username, String UsernameText,String Password, String PasswordText, String Login, String LoginText, String MyAccount, String MyAccountText, String SignOut, String SignOutText, String LogOutConfirm, String LogOutConfirmText)
    {
            VerifyTextCSS(locator,SignInText);
     //       VerifyAndClick(locator);
            EnterText(Username,UsernameText);
            EnterText(Password,PasswordText);
            VerifyTextCSS(Login,LoginText);
       //     VerifyAndClick(Login);
            VerifyTextCSS(MyAccount,MyAccountText);
            VerifyTextCSS(SignOut,SignOutText);
         //   VerifyAndClick(SignOut);
            VerifyTextCSS(LogOutConfirm,LogOutConfirmText);
         //   VerifyAndClick(LogOutConfirm);
            VerifyTextCSS(locator,SignInText);
    }

    public void Login2(WebDriver driver, String locator, String SignInText, String Username, String UsernameText,String Password, String PasswordText, String Login, String LoginText, String MyAccount, String MyAccountText, String SignOut, String SignOutText)
    {
        VerifyTextCSS(locator,SignInText);
       // VerifyAndClick(locator);
        Pause(5000);
        EnterText(Username,UsernameText);
        EnterText(Password,PasswordText);
        VerifyTextCSS(Login,LoginText);
       // VerifyAndClick(Login);
        Pause(5000);
        VerifyTextCSS(MyAccount,MyAccountText);
        VerifyTextCSS(SignOut,SignOutText);
    }

    public void Login1(WebDriver driver, String locator, String SignInText, String Username, String UsernameText,String Password, String PasswordText, String Login, String LoginText, String MyAccount, String MyAccountText, String SignOut, String SignOutText)
    {

        VerifyTextCSS(locator,SignInText);
      //  VerifyAndClick(locator);
        Pause(5000);
        EnterText(Username,UsernameText);
        EnterText(Password,PasswordText);
        VerifyTextCSS(Login,LoginText);
     //   VerifyAndClick(Login);
        Pause(5000);
        VerifyTextCSS(MyAccount,MyAccountText);
        VerifyTextCSS(SignOut,SignOutText);
     //   VerifyAndClick(SignOut);
        Pause(5000);
        VerifyTextCSS(locator,SignInText);

    }

    public void LoginToMyAccount(WebDriver driver, String locator, String SignInText, String Username, String UsernameText,String Password, String PasswordText, String Login, String LoginText, String MyAccount, String MyAccountText, String SignOut, String SignOutText)
    {

        VerifyTextCSS(locator,SignInText);
     //   VerifyAndClick(locator);
        Pause(5000);
        EnterText(Username,UsernameText);
        EnterText(Password,PasswordText);
        VerifyTextCSS(Login,LoginText);
     //   VerifyAndClick(Login);
        Pause(5000);
        VerifyTextCSS(MyAccount,MyAccountText);
        VerifyTextCSS(SignOut,SignOutText);
     //   VerifyAndClick(MyAccount);
        Pause(5000);

    }

    public void Pause(int TimeMilliSeconds)
    {
        try
        {
            Thread.sleep(TimeMilliSeconds);
        }

        catch (InterruptedException IE)
        {
            Error.add("Sleep Error");
        }

    }


    public static void ClickAndGetURL(String locator, String ExpectedTitle, String ExpectedURL, String Element)
    {

      //  VerifyAndClick(locator);        
        String CurrentURL = driver.getCurrentUrl();

        try
        {
            Assert.assertEquals(CurrentURL,ExpectedURL);
            VerifyURL.add("Actual URL is : " + CurrentURL + " and matches Expected URL : " + ExpectedURL);
        }
        catch (AssertionError AE)
        {
            Error.add("Actual URL is : " + CurrentURL + " and does not match Expected URL : " + ExpectedURL);
        }

        String CurrentTitle = driver.getTitle();

        try
        {
            Assert.assertEquals(CurrentTitle,ExpectedTitle);
            VerifyTitle.add("Actual URL is : " + CurrentTitle + " and matches Expected URL : " + ExpectedTitle);
        }
        catch (AssertionError AE)
        {
            Error.add("Actual Title is : " + CurrentTitle + " and does not match Expected Title : " + ExpectedTitle);
        }

        VerifyElementVisibleCSS(Element);

    }
    

    public void ClickAndVerifyElement(WebDriver driver,String locator, String ExpectedElement)
    {
      //  VerifyAndClick(locator);
        Pause(3000);
        VerifyElementVisibleCSS(ExpectedElement);
    }
    
    public static void ClickAndGetURLXpath(String locator, String ExpectedTitle, String ExpectedURL, String Element)
    {

    	VerifyAndClickXpath(locator);        
        String CurrentURL = driver.getCurrentUrl();

        try
        {
            Assert.assertEquals(CurrentURL,ExpectedURL);
            VerifyURL.add("Actual URL is : " + CurrentURL + " and matches Expected URL : " + ExpectedURL);
        }
        catch (AssertionError AE)
        {
            Error.add("Actual URL is : " + CurrentURL + " and does not match Expected URL : " + ExpectedURL);
        }

        String CurrentTitle = driver.getTitle();

        try
        {
            Assert.assertEquals(CurrentTitle,ExpectedTitle);
            VerifyTitle.add("Actual URL is : " + CurrentTitle + " and matches Expected URL : " + ExpectedTitle);
        }
        catch (AssertionError AE)
        {
            Error.add("Actual Title is : " + CurrentTitle + " and does not match Expected Title : " + ExpectedTitle);
        }

        VerifyElementVisibleCSS(Element);

    }
    
    public static void ClickAndGetURLXpath1(String locator, String ExpectedTitle, String ExpectedURL, String Element)
    {

    //	VerifyAndClick(locator);        
        String CurrentURL = driver.getCurrentUrl();

        try
        {
            Assert.assertEquals(CurrentURL,ExpectedURL);
            VerifyURL.add("Actual URL is : " + CurrentURL + " and matches Expected URL : " + ExpectedURL);
        }
        catch (AssertionError AE)
        {
            Error.add("Actual URL is : " + CurrentURL + " and does not match Expected URL : " + ExpectedURL);
        }

        String CurrentTitle = driver.getTitle();

        try
        {
            Assert.assertEquals(CurrentTitle,ExpectedTitle);
            VerifyTitle.add("Actual URL is : " + CurrentTitle + " and matches Expected URL : " + ExpectedTitle);
        }
        catch (AssertionError AE)
        {
            Error.add("Actual Title is : " + CurrentTitle + " and does not match Expected Title : " + ExpectedTitle);
        }

        VerifyElementVisibleByXpath(Element);

    }
    
    
    public static void ClickAndGetURLXpathOnly(String locator, String ExpectedTitle, String ExpectedURL, String Element)
    {

    	VerifyAndClickXpath(locator);        
        String CurrentURL = driver.getCurrentUrl();

        try
        {
            Assert.assertEquals(CurrentURL,ExpectedURL);
            VerifyURL.add("Actual URL is : " + CurrentURL + " and matches Expected URL : " + ExpectedURL);
        }
        catch (AssertionError AE)
        {
            Error.add("Actual URL is : " + CurrentURL + " and does not match Expected URL : " + ExpectedURL);
        }

        String CurrentTitle = driver.getTitle();

        try
        {
            Assert.assertEquals(CurrentTitle,ExpectedTitle);
            VerifyTitle.add("Actual URL is : " + CurrentTitle + " and matches Expected URL : " + ExpectedTitle);
        }
        catch (AssertionError AE)
        {
            Error.add("Actual Title is : " + CurrentTitle + " and does not match Expected Title : " + ExpectedTitle);
        }

        VerifyElementVisibleByXpath(Element);

    }
   

    public void GetURL1(WebDriver driver,String ExpectedTitle, String ExpectedURL, String Element)
    {

        String CurrentURL = driver.getCurrentUrl();

        try
        {
            Assert.assertEquals(CurrentURL,ExpectedURL);
            VerifyURL.add("Actual URL is : " + CurrentURL + " and matches Expected URL : " + ExpectedURL);
        }
        catch (AssertionError AE)
        {
            Error.add("Actual URL is : " + CurrentURL + " and does not match Expected URL : " + ExpectedURL);
        }

        String CurrentTitle = driver.getTitle();

        try
        {
            Assert.assertEquals(CurrentTitle,ExpectedTitle);
            VerifyTitle.add("Actual URL is : " + CurrentTitle + " and matches Expected URL : " + ExpectedTitle);
        }
        catch (AssertionError AE)
        {
            Error.add("Actual Title is : " + CurrentTitle + " and does not match Expected Title : " + ExpectedTitle);
        }

        VerifyElementVisibleCSS(Element);

    }

    public void GetURL(WebDriver driver,String GetTheURL,String ExpectedTitle, String ExpectedURL, String Element)
    {
        driver.get(GetTheURL);
        Pause(5000);
        String CurrentURL = driver.getCurrentUrl();
        try
        {
            Assert.assertEquals(CurrentURL,ExpectedURL);
            VerifyURL.add("Actual URL is : " + CurrentURL + " and matches Expected URL : " + ExpectedURL);
        }
        catch (AssertionError AE)
        {
            Error.add("Actual URL is : " + CurrentURL + " and does not match Expected URL : " + ExpectedURL);
        }
        String CurrentTitle = driver.getTitle();
        try
        {
            Assert.assertEquals(CurrentTitle,ExpectedTitle);
            VerifyTitle.add("Actual URL is : " + CurrentTitle + " and matches Expected URL : " + ExpectedTitle);
        }
        catch (AssertionError AE)
        {
            Error.add("Actual Title is : " + CurrentTitle + " and does not match Expected Title : " + ExpectedTitle);
        }
        VerifyElementVisibleCSS(Element);
    }

    public void WaitAndGetURL(WebDriver driver,String GetTheURL,String ExpectedTitle, String ExpectedURL, String Element)
    {
        driver.get(GetTheURL);
        Pause(30000);
        String CurrentURL = driver.getCurrentUrl();
        try
        {
            Assert.assertEquals(CurrentURL,ExpectedURL);
            VerifyURL.add("Actual URL is : " + CurrentURL + " and matches Expected URL : " + ExpectedURL);
        }
        catch (AssertionError AE)
        {
            Error.add("Actual URL is : " + CurrentURL + " and does not match Expected URL : " + ExpectedURL);
        }
        Pause(30000);
        String CurrentTitle = driver.getTitle();
        try
        {
            Assert.assertEquals(CurrentTitle,ExpectedTitle);
            VerifyTitle.add("Actual URL is : " + CurrentTitle + " and matches Expected URL : " + ExpectedTitle);
        }
        catch (AssertionError AE)
        {
            Error.add("Actual Title is : " + CurrentTitle + " and does not match Expected Title : " + ExpectedTitle);
        }
        Pause(30000);
        VerifyElementVisibleCSS(Element);
    }


    public static void VerifyAndClickCSS(String Locator)
    {
        try
        {
            W = driver.findElement(By.cssSelector(Locator));
            ElementsPresent.add(Locator+" : Element is Present");
            Assert.assertTrue(W.isDisplayed());
            ElementsVisible.add(Locator+" : Element is Present and is Displayed / Visible");
            W.click();

        }
        catch (NoSuchElementException NSEE)
        {
            //If element isn't found, set the timeout and return false
            Error.add(Locator+" : Element is not Present");

        }
        catch (AssertionError AE)
        {
            //If element isn't found, set the timeout and return false
            Error.add(Locator+" : Element is Present but not Displayed / Visible");

        }
        catch(StaleElementReferenceException e)
        {
            Error.add(Locator + " : Clicking Error");
        }

    }
    
    public static void VerifyAndClickXpath(String Locator)
    {
        try
        {
            W = driver.findElement(By.xpath(Locator));
            ElementsPresent.add(Locator+" : Element is Present");
            Assert.assertTrue(W.isDisplayed());
            ElementsVisible.add(Locator+" : Element is Present and is Displayed / Visible");
            W.click();

        }
        catch (NoSuchElementException NSEE)
        {
            //If element isn't found, set the timeout and return false
            Error.add(Locator+" : Element is not Present");

        }
        catch (AssertionError AE)
        {
            //If element isn't found, set the timeout and return false
            Error.add(Locator+" : Element is Present but not Displayed / Visible");

        }
        catch(StaleElementReferenceException e)
        {
            Error.add(Locator + " : Clicking Error");
        }

    }


    public void VerifyAndClickDropDown(String Locator, String Locator1)
    {

        try
        {
            W = driver.findElement(By.cssSelector(Locator));
            ElementsPresent.add(Locator+" : Element is Present");
            Assert.assertTrue(W.isDisplayed());
            ElementsVisible.add(Locator1+" : Element is Present and is Displayed / Visible");
            W.click();


            W1 = driver.findElement(By.cssSelector(Locator1));
            ElementsPresent.add(Locator1+" : Element is Present");
            Assert.assertTrue(W1.isDisplayed());
            ElementsVisible.add(Locator+" : Element is Present and is Displayed / Visible");
            W1.click();

        }
        catch (NoSuchElementException NSEE)
        {
            //If element isn't found, set the timeout and return false
            Error.add(Locator+" : Element is not Present");

        }
        catch (AssertionError AE)
        {
            //If element isn't found, set the timeout and return false
            Error.add(Locator+" : Element is Present but not Displayed / Visible");

        }
        catch(StaleElementReferenceException e)
        {
            Error.add(Locator + " : Clicking Error");
        }

    }
    
    public void VerifyAndClickDropDownByXpathAndValue(String Locator, int Value)
    {
        try
        {
            W = driver.findElement(By.xpath(Locator));
            ElementsPresent.add(Locator+" : Element is Present");
            Assert.assertTrue(W.isDisplayed());
            ElementsVisible.add(Locator+" : Element is Present and is Displayed / Visible");
            W.click();      
            Pause(5000);
            Select dropdown = new Select(W);         
            dropdown.selectByIndex(Value);
        }
        catch (NoSuchElementException NSEE)
        {
            //If element isn't found, set the timeout and return false
            Error.add(Locator+" : Element is not Present");
        }
        catch (AssertionError AE)
        {
            //If element isn't found, set the timeout and return false
            Error.add(Locator+" : Element is Present but not Displayed / Visible");
        }
        catch(StaleElementReferenceException e)
        {
            Error.add(Locator + " : Clicking Error");
        }
    }


    public void VerifyAndClear(WebDriver driver, String Locator)
    {
        try
        {
            W = driver.findElement(By.cssSelector(Locator));
            ElementsPresent.add(Locator+" : Element is Present");
            Assert.assertTrue(W.isDisplayed());
            ElementsVisible.add(Locator+" : Element is Present and is Displayed / Visible");
            W.clear();

        }
        catch (NoSuchElementException NSEE)
        {
            //If element isn't found, set the timeout and return false
            Error.add(Locator+" : Element is not Present");

        }
        catch (AssertionError AE)
        {
            //If element isn't found, set the timeout and return false
            Error.add(Locator+" : Element is Present but not Displayed / Visible");

        }
        catch(StaleElementReferenceException e)
        {
            Error.add(Locator + " : Clicking Error");
        }

    }

    public static void Clear()
    {
        Error.clear();
        ElementsPresent.clear();
        ElementsVisible.clear();
        VerifyText.clear();
        VerifyURL.clear();
        VerifyTitle.clear();
    }

    public static void MethodResult(String MethodName)
    {
        String b[] = Error.toArray(new String[Error.size()]);
        System.out.println("Total Elements Present : "+ElementsPresent.size());
        Reporter.log("Total Elements Present : "+ElementsPresent.size());
        System.out.println("Total Elements Visible : "+ElementsVisible.size());
        Reporter.log("Total Elements Visible : "+ElementsVisible.size());
        System.out.println("Total Verified Texts : "+VerifyText.size());
        Reporter.log("Total Verified Texts : "+VerifyText.size());
        System.out.println("Total Verified URLS : "+VerifyURL.size());
        Reporter.log("Total Verified URLS : "+VerifyURL.size());
        System.out.println("Total Verified Titles : "+VerifyTitle.size());
        Reporter.log("Total Verified Titles : "+VerifyTitle.size());
        System.out.println("Total Errors : "+Error.size());
        Reporter.log("Total Errors : "+Error.size());
        

        try 
        {
            Assert.assertEquals(0, Error.size());
            System.out.println("Method "+MethodName+"  has Passed");
            Reporter.log(MethodName+" Method has Passed");
        }
        catch (AssertionError AE) 
        {
            System.out.println("Method "+MethodName+" Method has failed and the issues are as below : ");
            Reporter.log(MethodName+" Method has failed and the issues are as below : ");
            for (int a = 0; a < Error.size(); a++) 
            {
                System.out.println(b[a]);
                Reporter.log(b[a]);
            }
            Assert.fail();            
        }
    }

    public static void SystemInformation()
    {
        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
        browserName = cap.getBrowserName().toLowerCase();
        v = cap.getVersion().toString();
        os = cap.getPlatform().toString();
        System.out.println("Browser Name : "+browserName);
        System.out.println("Browser Version : "+v);
        System.out.println("Windows Operating System : "+os);
    }
    
    public static void Login()
    {
    	try
		{
			Runtime.getRuntime().exec("Authenticate1.exe");	
		}
		catch(IOException ioe)
		{
			System.out.println("error");
		}				
    }
    
    public static void Enter()
    {
    	try
		{
			Runtime.getRuntime().exec("Enter.exe");	
		}
		catch(IOException ioe)
		{
			System.out.println("error");
		}				
    }
    
    public static void Scroll()
    {
    	try
		{
			Runtime.getRuntime().exec("TabScroll.exe");	
		}
		catch(IOException ioe)
		{
			System.out.println("error");
		}				
    }
    
    public static void OpenURL(String GetTheURL,String ExpectedTitle,String ExpectedURL,String Locator)
    {
        //Login();
    	driver.get(GetTheURL);        
        String CurrentURL = driver.getCurrentUrl();
        try
        {
            Assert.assertEquals(CurrentURL,ExpectedURL);
            VerifyURL.add("Actual URL is : " + CurrentURL + " and matches Expected URL : " + ExpectedURL);
        }
        catch (AssertionError AE)
        {
            Error.add("Actual URL is : " + CurrentURL + " and does not match Expected URL : " + ExpectedURL);
        }
        String CurrentTitle = driver.getTitle();
        try
        {
            Assert.assertEquals(CurrentTitle,ExpectedTitle);
            VerifyTitle.add("Actual URL is : " + CurrentTitle + " and matches Expected URL : " + ExpectedTitle);
        }
        catch (AssertionError AE)
        {
            Error.add("Actual Title is : " + CurrentTitle + " and does not match Expected Title : " + ExpectedTitle);
        }
    //   VerifyElementVisibleByXpath(Locator);       
        
    }
    
    public static void Refresh()
    {
    	driver.navigate().refresh();
    }
    
    public String RandomUsername()
    {
    	Random rg = new Random();		
		int randomInt = rg.nextInt(10000);
		int randomInt1 = rg.nextInt(10000);
		PlayerName = randomInt+"Subbu"+randomInt1;	
		return PlayerName;
    }
    
    public int RandomAge()
    {
    	Random rg = new Random();		
		int randomInt = rg.nextInt(90);		
		return randomInt;
    }
    
    public static void VerifyElementVisibleByXpathMail(String locator)
    {
        try
        {
            W = driver.findElement(By.xpath(locator));
            ElementsPresent.add(locator+" : Element is Present");
            Assert.assertTrue(W.isDisplayed());
            ElementsVisible.add(locator+" : Element is Present and is Displayed / Visible");

        }
        catch (NoSuchElementException NSEE)
        {
            //If element isn't found, set the timeout and return false
            Error.add(locator+" : Element is not Present and the Authorisation mail has been not recieved");

        }
        catch (AssertionError AE)
        {
            //If element isn't found, set the timeout and return false
            Error.add(locator+" : Element is Present but not Displayed / Visible and the Authorisation mail has been not recieved");

        }
    }  
    
    public static void AddUsernameToExcel(String Result) 
    {    	 
      try{
    	    	String FilePath = "E:\\SeleniumUsernames.xls";
    			FileInputStream fs = new FileInputStream(FilePath);
    	        wbook = Workbook.getWorkbook(fs);    
    	        wwbCopy = Workbook.createWorkbook(new File("E:\\SeleniumUsernames.xls"), wbook);
    	        shSheet = wwbCopy.getSheet(0);
    	 }
    	 catch(Exception e)
    	 {
    		   Error.add("Exception");
    	 }
      WritableSheet wshTemp = wwbCopy.getSheet("Sheet1");   
      int iRowNumber = shSheet.getRows();
      System.out.println(iRowNumber);
      System.out.println(Result+" is the field");
      Label labTemp = new Label(0,iRowNumber++,Result);
              
      try {
              wshTemp.addCell(labTemp);
          } 
      catch (Exception e) 
          {
    	      Error.add("Exception");
          }
      try {
          // Closing the writable work book
              wwbCopy.write();
              wwbCopy.close();
          // Closing the original work book
              wbook.close();
	       }
     catch (Exception e)
	       {
    	       Error.add("Exception");
           }
    }	
    
    public static void AddUsernameToExcelToAuthorisedList(String Result) 
    {    	 
      try{
    	    	String FilePath = "E:\\SeleniumUsernames.xls";
    			FileInputStream fs = new FileInputStream(FilePath);
    	        wbook = Workbook.getWorkbook(fs);    
    	        wwbCopy = Workbook.createWorkbook(new File("E:\\SeleniumUsernames.xls"), wbook);
    	        shSheet = wwbCopy.getSheet(0);
    	 }
    	 catch(Exception e)
    	 {
    		   Error.add("Exception");
    	 }
      WritableSheet wshTemp = wwbCopy.getSheet("Sheet1");   
      int iRowNumber = shSheet.getRows();
      iRowNumber = iRowNumber - 1;
      System.out.println(iRowNumber);
      System.out.println(Result+" is the field");
      Label labTemp = new Label(1,iRowNumber,Result);
              
      try {
              wshTemp.addCell(labTemp);
          } 
      catch (Exception e) 
          {
    	      Error.add("Exception");
          }
      try {
          // Closing the writable work book
              wwbCopy.write();
              wwbCopy.close();
          // Closing the original work book
              wbook.close();
	       }
     catch (Exception e)
	       {
    	       Error.add("Exception");
           }
    }	
    
    public static void ScrollDown()
    {
    	try
		{
			Runtime.getRuntime().exec("TabScroll.exe");	
		}
		catch(IOException ioe)
		{
			System.out.println("error");
		}				
    }
    
    public static void CloseErrorReport()
    {
    	try
		{
			Runtime.getRuntime().exec("CloseErrorReport.exe");	
		}
		catch(IOException ioe)
		{
			System.out.println("error");
		}				
    }
    
    public void VerifyAndClickDropDownByXpath(String Locator, String Locator1)
    {

        try
        {
            W = driver.findElement(By.xpath(Locator));
            ElementsPresent.add(Locator+" : Element is Present");
            Assert.assertTrue(W.isDisplayed());
            ElementsVisible.add(Locator+" : Element is Present and is Displayed / Visible");
          //  W.click();
            
            Select dropdown = new Select(W);
            dropdown.selectByValue("1");


          /*  W1 = driver.findElement(By.xpath(Locator1));
            ElementsPresent.add(Locator1+" : Element is Present");
            Assert.assertTrue(W1.isDisplayed());
            ElementsVisible.add(Locator+" : Element is Present and is Displayed / Visible");
            W1.click(); */

        }
        catch (NoSuchElementException NSEE)
        {
            //If element isn't found, set the timeout and return false
            Error.add(Locator+" : Element is not Present");

        }
        catch (AssertionError AE)
        {
            //If element isn't found, set the timeout and return false
            Error.add(Locator+" : Element is Present but not Displayed / Visible");

        }
        catch(StaleElementReferenceException e)
        {
            Error.add(Locator + " : Clicking Error");
        }

    }
}
