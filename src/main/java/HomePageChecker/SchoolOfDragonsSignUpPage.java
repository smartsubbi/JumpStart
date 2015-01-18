package HomePageChecker;

import org.testng.annotations.Test;

import CSSXPaths.CSSandXpaths;

@Test(groups="SchoolOfDragonsSignUpPage", dependsOnGroups="HomePage")
public class SchoolOfDragonsSignUpPage extends CSSandXpaths
{
	int Age;
	String UserName;
	@Test
	public void ClickOnSignUpButton()
	{
		System.out.println("Test Case 5 - Click on School Of Dragon brand button and Verify it takes the User to School of Dragon Brand Page by verifying the URL, and an element on that page");
		Clear();		
		ClickAndGetURLXpathOnly(SchoolOfDragonsSignUpButton,SODSignUpPageTitle,SchoolOfDragonsSignUpPage,SchoolOfDragonsSignUpPageText);
		MethodResult("ClickOnSignUpButton");		
	}
	
	@Test(dependsOnMethods = { "ClickOnSignUpButton" })
	public void VerifySignUpPage()
	{
		System.out.println("Test Case 7");
		Clear();
		ClickAndGetURLXpathOnly(SchoolOfDragonsSignUpButton,SODSignUpPageTitle,SchoolOfDragonsSignUpPage,SchoolOfDragonsSignUpPageText);
		VerifyElementVisibleByXpath(SchoolOfDragonsSignUpPageText);
		VerifyElementVisibleByXpath(SignUpContentBoxHowOldAreYou);
		VerifyElementVisibleByXpath(SignUpContentBoxAgeDropDown);
		VerifyElementVisibleByXpath(SignUpContentBoxAgeConfirmButton);
		//VerifyElementVisibleByXpath(SignUpContentBoxFinishAndPlayDisabled);
		MethodResult("ClickOnSignUpButton");		
	}
	
	@Test(dependsOnMethods = { "VerifySignUpPage" })
	public void PerformSignUpJourneyAgeSelection()
	{
		System.out.println("Test Case 8");
		Clear();
		Age = RandomAge();
		System.out.println("Age is "+Age);		
		VerifyAndClickDropDownByXpathAndValue(SignUpPageAgeDropDownSelector,Age);
		Pause(3000);
		Enter();
		Pause(3000);
		VerifyElementVisibleByXpath(SignUpContentBoxAgeConfirmButtonAfterAgeSelection);		
		MethodResult("PerformSignUpJourneyAgeSelection");
	}
	
	@Test(dependsOnMethods = { "PerformSignUpJourneyAgeSelection" })
	public void PerformSignUpJourneyAfterAgeSelection()
	{
		System.out.println("Test Case 9");
		Clear();
		ClickAndGetURLXpathOnly(SignUpContentBoxAgeConfirmButtonAfterAgeSelection,SchoolOfDragonsPageTitleAfterAgeSelection,SchoolOfDragonsPageAfterAgeSelection,SignUpPageEmailText);
		VerifyElementVisibleByXpath(SignUpContentBoxHowOldAreYou);	
		VerifyElementVisibleByXpath(SignUpContentBoxAgeDropDown);	
		VerifyElementVisibleByXpath(SignUpPageEmailText);	
		VerifyElementVisibleByXpath(SignUpPageEmailField);	
		VerifyElementVisibleByXpath(SignUpPagePlayersLoginText);	
		VerifyElementVisibleByXpath(SignUpPagePlayersLoginTextSpan);	
		VerifyElementVisibleByXpath(SignUpPagePlayersLoginInputField);	
		VerifyElementVisibleByXpath(SignUpPagePasswordText);	
		VerifyElementVisibleByXpath(SignUpPagePasswordField);
		VerifyElementVisibleByXpath(SignUpPageFinishAndPlayButton);
		VerifyElementVisibleByXpath(SignUpPagePrivacyText);
		VerifyElementVisibleByXpath(SignUpPagePrivacyTextPrivacyPolicy);
		VerifyElementVisibleByXpath(SignUpPagePrivacyTextRulesOfConduct);		
		MethodResult("PerformSignUpJourneyAfterAgeSelection");
	}
	
	@Test(dependsOnMethods = { "PerformSignUpJourneyAfterAgeSelection" })
	public void ValidateSignUpPageFields()
	{
		System.out.println("Test Case 10");
		Clear();
		EnterTextByXpath(SignUpPageEmailField,"a");
		EnterTextByXpath(SignUpPagePlayersLoginInputField,"a@a");
		EnterTextByXpath(SignUpPagePasswordField,"12345");
		VerifyElementVisibleByXpath(SignUpContentBoxFinishAndPlayEnabled);
		VerifyAndClickXpath(SignUpContentBoxFinishAndPlayEnabled);
		VerifyElementVisibleByXpath(EmailAddressInvalidMessage);	
		VerifyElementVisibleByXpath(UserNameSpecialCharacters);	
		VerifyElementVisibleByXpath(PasswordInvalid);	
		MethodResult("ValidateSignUpPageFields");
	}
	
	@Test(dependsOnMethods = { "ValidateSignUpPageFields" })
	public void ValidateSignUpPageFields2()
	{
		System.out.println("Test Case 11");
		Clear();
		EnterTextByXpath(SignUpPageEmailField,"a@a.com");
		EnterTextByXpath(SignUpPagePlayersLoginInputField,"a");
		EnterTextByXpath(SignUpPagePasswordField,"123456");		
		VerifyElementVisibleByXpath(SignUpContentBoxFinishAndPlayEnabled);
		VerifyAndClickXpath(SignUpContentBoxFinishAndPlayEnabled);
		VerifyElementVisibleByXpath(LoginAlreadyExistMessage);		
		MethodResult("ValidateSignUpPageFields2");				
	}
	
	@Test(dependsOnMethods = { "ValidateSignUpPageFields2" })
	public void CreateNewUserID()
	{
		System.out.println("Test Case 12");
		Clear();
		UserName = RandomUsername();
		System.out.println("User name is "+UserName);		
		
		EnterTextByXpath(SignUpPageEmailField,"SeleniumSubbu@gmail.com");
		EnterTextByXpath(SignUpPagePlayersLoginInputField,UserName);
		EnterTextByXpath(SignUpPagePasswordField,"123456");		
		VerifyElementVisibleByXpath(SignUpContentBoxFinishAndPlayEnabled);
		VerifyAndClickXpath(SignUpContentBoxFinishAndPlayEnabled);
		VerifyElementVisibleByXpath(AlmostDoneText);
		VerifyElementVisibleByXpath(EmailSentText);
		VerifyElementVisibleByXpath(EmailSentOkButton);			
		AddUsernameToExcel(UserName);
		MethodResult("CreateNewUserID");		
	}	
	
	@Test(dependsOnMethods = { "CreateNewUserID" })
	public void VerifySignedInAfterCreation()
	{
		System.out.println("Test Case 13");
		Clear();
		OpenURL(HomePageURL,HomePageTitle,HomePageURL,JumpStartLogo);	
		VerifyElementVisibleByXpath(SchoolOfDragonsLogOutButton);	
		VerifyElementVisibleByXpath(SchoolOfDragonsHeaderPlayNowButton);	
		MethodResult("VerifySignedInAfterCreation");		
	} 
	
	@Test(dependsOnMethods = { "VerifySignedInAfterCreation" })
	public void VerifySignedOut()
	{
		System.out.println("Test Case 14");
		Clear();
		CloseErrorReport();
		ClickAndGetURLXpathOnly(SchoolOfDragonsLogOutButton,HomePageTitle,SchoolOfDragonsPageAfterSignedOut,SchoolOfDragonsLoginButton);
		MethodResult("VerifySignedOut");
	}
	
	@Test(dependsOnMethods = { "VerifySignedOut" })
	public void VerifySignedInAfterSignedOut()
	{
		System.out.println("Test Case 15");
		Clear();
		CloseErrorReport();
		ClickAndGetURLXpathOnly(SchoolOfDragonsLoginButton,SODLoginPageTitle,SchoolOfDragonsLoginPage,SchoolOfDragonsLoginPageLoginText);
	    EnterTextByXpath(LoginPageUsernameField,UserName);
	    EnterTextByXpath(LoginPagePasswordField,"123456");
	    VerifyAndClickXpath(LoginPagePlayNowButton);
	    VerifyElementVisibleByXpath(UnauthorisedPopUpMessage);
	    VerifyElementVisibleByXpath(UnauthorisedPopUpOkButton);
	    VerifyElementVisibleByXpath(UnauthorisedPopUpAccountEmailText);
	    VerifyElementVisibleByXpath(UnauthorisedPopUpAccountEmailField);
	    VerifyElementVisibleByXpath(UnauthorisedPopUpResendConfirmationMailButton);	    
		MethodResult("VerifySignedInAfterSignedOut");
	}
	
	@Test(dependsOnMethods = { "VerifySignedInAfterSignedOut" })
	public void VerifyUnityPlayerDisplayedAfterOK()
	{
		System.out.println("Test Case 16");
		Clear();
		CloseErrorReport();
		ClickAndGetURLXpathOnly(UnauthorisedPopUpOkButton,SchoolOfDragonsUnityPlayPageTitle,SchoolOfDragonsUnityPlayPage,UnityPlayer);
		MethodResult("VerifyUnityPlayerDisplayedAfterOK");
	}
}
