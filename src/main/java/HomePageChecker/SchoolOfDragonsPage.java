package HomePageChecker;

import org.testng.annotations.Test;

import CSSXPaths.CSSandXpaths;

@Test(groups="SchoolOfDragonsPage", dependsOnGroups="HomePage")
public class SchoolOfDragonsPage extends CSSandXpaths
{
	@Test
	public void ClickOnSchoolOfDragonBrand()
	{
		System.out.println("Test Case 3 - Click on School Of Dragon brand button and Verify it takes the User to School of Dragon Brand Page by verifying the URL, and an element on that page");
		Clear();
		ClickAndGetURLXpathOnly(BrandSelectorSODText,HomePageTitle,SchoolOfDragonsPageURL,SchoolOfDragonsPlayNowButton);
		VerifyElementVisibleByXpath(SchoolOfDragonsHighlightedButton);
		VerifyElementVisibleByXpath(SchoolOfDragonsHeaderDropdownLink);
		VerifyElementVisibleByXpath(SchoolofDragonsHomePageLogoAbovePlayNow);
		VerifyElementVisibleByXpath(PromoAsset1);
		VerifyElementVisibleByXpath(PromoAsset2);
		MethodResult("ClickOnSchoolOfDragonBrand");
	}

}
