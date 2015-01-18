package HomePageChecker;

import org.testng.annotations.Test;

import CSSXPaths.CSSandXpaths;

public class SchoolOfDragonsAuthorisationMail extends CSSandXpaths
{
	String UserName;
	@Test(dependsOnMethods = { "VerifyUnityPlayerDisplayedAfterOK" })
	public void VerifyAuthorisationMailrecieved()
	{
		System.out.println("Test Case 17");
		Clear();
		Pause(50000);
		driver.get(GmailURL);	
		Pause(3000);
		EnterTextByXpath(GmailUsername,"SeleniumSubbu");
		Pause(3000);
		EnterTextByXpath(GmailPassword,"blademaster1");
		VerifyAndClickXpath(GmailSignIn);
		VerifyAndClickXpath(GmailSchoolOfDragonsFolder);
		VerifyAndClickXpath(GmailMail);
		VerifyElementVisibleByXpath(ActivationContentHeaderImage);
		VerifyElementVisibleByXpath(DearPlayerText);
		VerifyElementVisibleByXpath(PlayerAFirstDescription);
		VerifyElementVisibleByXpath(ClickHereToActivateAccount);
		VerifyElementVisibleByXpath(SecondDescription);
		VerifyElementVisibleByXpath(PlayerAThirdContent);
		VerifyElementVisibleByXpath(PlayersLogin);
		VerifyElementVisibleByXpath(PlayersPassword);
		VerifyElementVisibleByXpath(PlayerABenefitsImage);
		VerifyElementVisibleByXpath(PlayerAFourthContent);
		VerifyElementVisibleByXpath(PlayerAFifthContent);
		VerifyElementVisibleByXpath(PlayerASixthContent);
		VerifyElementVisibleByXpath(PlayersASeventhContent);	
		VerifyElementVisibleByXpath(EigthContent);
		VerifyElementVisibleByXpath(PlayerANinthContent);
		VerifyElementVisibleByXpath(TenthContent);
		VerifyElementVisibleByXpath(EleventhContent);
		VerifyElementVisibleByXpath(PlayerATwelthContent);
		VerifyElementVisibleByXpath(TirteenthContent);
		VerifyElementVisibleByXpath(FourteenthContent);
		VerifyElementVisibleByXpath(FifteenthContent);
		VerifyElementVisibleByXpath(SixteenthContent);
		VerifyElementVisibleByXpath(SeventeenthContent);
		VerifyElementVisibleByXpath(PlayerAEighteenthContent);
		VerifyElementVisibleByXpath(NineTeenContent);		
		VerifyElementVisibleByXpath(TwentyFirstContent);
		VerifyElementVisibleByXpath(TradeMark);
		VerifyElementVisibleByXpath(OfficialSiteLink);		
		VerifyElementVisibleByXpath(ClickHereToActivateAccount);		
		String PlayersUserName = "//tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td[text()[contains(.,'By activating this account, you consent to the collection and use')]][text()[contains(.,'for internal operational use only, of personal information.')]]/p/strong[text()[contains(.,'Player')]][text()[contains(.,'s Login: "+UserName+"')]]";
		VerifyElementVisibleByXpathMail(PlayersUserName);
		System.out.println("User name is "+UserName);		
		/* verify the user name is the 1 created above */		
		MethodResult("VerifyAuthorisationMailrecieved"); 
	}
}
