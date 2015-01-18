package HomePageChecker;

import org.testng.annotations.Test;

import CSSXPaths.CSSandXpaths;

@Test(groups="SchoolOfDragonsLoginPage", dependsOnGroups="HomePage")
public class SchoolOfDragonsLoginPage extends CSSandXpaths
{
	@Test
	public void ClickOnLoginButton()
	{
		System.out.println("Test Case 4 - Click on School Of Dragon brand button and Verify it takes the User to School of Dragon Brand Page by verifying the URL, and an element on that page");
		Clear();
		Login();
		ClickAndGetURLXpathOnly(SchoolOfDragonsLoginButton,SODLoginPageTitle,SchoolOfDragonsLoginPage,SchoolOfDragonsLoginPageLoginText);
		VerifyElementVisibleByXpath(LoginPageUsernameText);
		VerifyElementVisibleByXpath(LoginPageUsernameField);
		VerifyElementVisibleByXpath(LoginPagePasswordText);
		VerifyElementVisibleByXpath(LoginPagePasswordField);
		VerifyElementVisibleByXpath(LoginPageForgotPasswordText);
		VerifyElementVisibleByXpath(LoginPagePlayNowButton);
		VerifyElementVisibleByXpath(LoginPagePrivacyPolicyText);		
		MethodResult("ClickOnLoginButton");	
	}

}
