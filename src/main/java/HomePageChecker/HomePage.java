package HomePageChecker;

import org.testng.annotations.Test;

import CSSXPaths.CSSandXpaths;

@Test(groups="HomePage")
public class HomePage extends CSSandXpaths
{
	public static String UserName;	
	
	@Test
	public void OpenHomePage()
	{
		System.out.println("Test Case 1 - Open the Home page URL and Verify if the page loads by verifying the page title, url and by verifying if JumpStart Logo  is Visible on the Header");
		SystemInformation();
		Clear();
		Login();
		OpenURL(HomePageURL,HomePageTitle,HomePageURL,JumpStartLogo);	
		MethodResult("OpenHomePage");	
	}	
	
	@Test(dependsOnMethods = { "OpenHomePage" })
	public void VerifySchoolOfDragonBrandSelector()
	{
		System.out.println("Test Case 2 - Verify Brand Selector School Of Dragons is Present and Also Verify the Text in the Section");
		Clear();
		VerifyElementVisibleByXpath(BrandSelectorSOD);
		VerifyElementVisibleByXpath(BrandSelectorSODText);
		VerifyElementVisibleByXpath(BrandSelectorSODSubText);
		MethodResult("VerifySchoolOfDragonBrandSelector");		
	}	
	
	
	
/*	@Test(dependsOnMethods = { "ClickOnSchoolOfDragonBrand" })
	
	
	@Test(dependsOnMethods = { "ClickOnLoginButton" })
	
	
	/*@Test(dependsOnMethods = { "ClickOnSignUpButton" })
	public void ClickOnPlayNowButton()
	{
		 System.out.println("Test Case 6");
		 Clear();		 
		 driver.navigate().back();
		 driver.navigate().back();
		 ClickAndGetURLXpathOnly(SchoolOfDragonsPlayNowButton,SODAfterPlayNow,SchoolOfDragonsPageAfterPlayNow,SchoolOfDragonsAfterPlayNow);
		 MethodResult("ClickOnSignUpButton");
	} */
	
/*	
	
	
	
	
	
	
	
/*	 @Test(dependsOnMethods = { "VerifyAuthorisationMailrecieved" })
	public void VerifyActivateAccountPage()
	{ */
	/*	System.out.println("Test Case 18");
		Clear();	
		CheckNewTabLinksPartialXpath(ClickHereToActivateAccount,ActivationURL,ActivationPageActivateButton);
		VerifyElementVisibleByXpath(ActivationPagePlayerAccountDetailsText); 
		VerifyElementVisibleByXpath(ActivationPagePlayerEmailText); 
		VerifyElementVisibleByXpath(ActivationPagePlayerAPasswordText); 
		VerifyElementVisibleByXpath(ActivationPageConfirmPasswordText); 
		VerifyElementVisibleByXpath(ActivationPagePlayersDOBText); 
		VerifyElementVisibleByXpath(ActivationPageRequiredInformationText); 
		VerifyElementVisibleByXpath(ActivationPageTermsAndConditionBox); 
		VerifyElementVisibleByXpath(ActivationPageScrollDownText); 
		VerifyElementVisibleByXpath(ActivationPageTermsAndConditionCheckBox); 
		VerifyElementVisibleByXpath(ActivationPageTermsAndConditionCheckBoxText); 
		VerifyElementVisibleByXpath(ActivationPageTermsAndConditionLink); 
		VerifyElementVisibleByXpath(ActivationPageActivateButton); 
		VerifyElementVisibleByXpath(ActivationPageAccountDetailsText); 
		VerifyElementVisibleByXpath(ActivationPagePlayerNameText); 
		VerifyElementVisibleByXpath(ActivationPagePlayerPasswordText); 
		VerifyElementVisibleByXpath(ActivationPagePlayerPasswordOptionalText); 
		VerifyElementVisibleByXpath(ActivationPagePlayerConfirmPasswordText); 
		VerifyElementVisibleByXpath(ActivationPagePlayerConfirmPasswordTextOptional); 
		VerifyElementVisibleByXpath(ActivationPageInfoText); 
		VerifyElementVisibleByXpath(ActivationPageParentEmail); 
		VerifyElementVisibleByXpath(ActivationPageParentPasswordField); 
		VerifyElementVisibleByXpath(ActivationPageParenPasswordConfirmationField); 
		VerifyElementVisibleByXpath(ActivationPageParentMonthField); 
		VerifyElementVisibleByXpath(ActivationPageParentDateField); 
		VerifyElementVisibleByXpath(ActivationPageParentYearField); 
		VerifyElementVisibleByXpath(ActivationPagePlayerPasswordField); 
		VerifyElementVisibleByXpath(ActivationPagePlayerPasswordConfirmationField);				
		MethodResult("VerifyActivateAccountPage");		
	}
	
/*	@Test(dependsOnMethods = { "VerifyActivateAccountPage" })
	public void VerifyActivateAccountPageFields()
	{
		System.out.println("Test Case 19");
		Clear();	
		ScrollDown();
		Pause(5000);
		VerifyElementVisibleByXpath(ActivationPageTermsAndConditionCheckBoxEnabled);	
		Pause(5000);
		VerifyAndClickXpath(ActivationPageTermsAndConditionCheckBoxEnabled);
		VerifyElementVisibleByXpath(ActivationPageActivateButton); 
		MethodResult("VerifyActivateAccountPageFields");	
	}
	
	@Test(dependsOnMethods = { "VerifyActivateAccountPageFields" })
	public void VerifyActivateAccountPageFields1()
	{
		System.out.println("Test Case 20");
		Clear();	
		EnterTextByXpath(ActivationPageParentPasswordField,"1");
		EnterTextByXpath(ActivationPageParenPasswordConfirmationField,"1");
		VerifyAndClickDropDownByXpath(ActivationPageParentMonthField,ActivationPageParentMonthFieldOption1);
		VerifyAndClickDropDownByXpath(ActivationPageParentDateField,ActivationPageParentDateFieldOption1);		
		VerifyElementVisibleByXpath(ActivationPageActivateButtonEnabled); 
		VerifyAndClickXpath(ActivationPageActivateButtonEnabled);
		VerifyElementVisibleByXpath(ActivationPageInvalidPasswordMessage);
		MethodResult("VerifyActivateAccountPageFields1");	
	}
	
	@Test(dependsOnMethods = { "VerifyActivateAccountPageFields1" })
	public void VerifyActivateAccountPageFields2()
	{
		System.out.println("Test Case 21");
		Clear();	
		EnterTextByXpath(ActivationPageParentPasswordField,"123456");
		EnterTextByXpath(ActivationPageParenPasswordConfirmationField,"654321");
		VerifyAndClickXpath(ActivationPageActivateButtonEnabled);
		VerifyElementVisibleByXpath(ActivationPagePasswordNoMatchMessage);	
		MethodResult("VerifyActivateAccountPageFields2");	
	}
	
	@Test(dependsOnMethods = { "VerifyActivateAccountPageFields2" })
	public void VerifyActivateAccountPageFields3()
	{
		System.out.println("Test Case 22");
		Clear();	
		EnterTextByXpath(ActivationPageParentPasswordField,"123456");
		EnterTextByXpath(ActivationPageParenPasswordConfirmationField,"123456");
		VerifyAndClickXpath(ActivationPageActivateButtonEnabled);
		VerifyElementVisibleByXpath(ActivationSuccessMessage);		
		driver.close();            
        driver.switchTo().window(OldTab);
        Pause(60000);
        VerifyAndClickXpath(GmailSchoolOfDragonsFolder);
		VerifyAndClickXpath(GmailMail);
		VerifyAndClickXpath(ActivationSuccessMailImage);
		VerifyAndClickXpath(ActivationSuccessMailText);
		VerifyAndClickXpath(ActivationSuccessMailExporeSiteButton);
		VerifyAndClickXpath(ActivationSuccessMailMoreMobileButton);
		AddUsernameToExcelToAuthorisedList(UserName);
		MethodResult("VerifyActivateAccountPageFields3");	
	} */
}
   