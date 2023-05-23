package tests;


import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.WebDriver;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class AmazonTest {
    static WebDriver driver;

    @Test
    public void amazonTest(){


        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        String expectedUrl = ConfigReader.getProperty("youtubeUrl") ;
        String actualUrl = Driver.getDriver().getCurrentUrl();

        AmazonPage amazonPages = new AmazonPage();
        SoftAssert softAssert = new SoftAssert();


        softAssert.assertTrue(actualUrl.contains(expectedUrl));

        amazonPages.searchBox.sendKeys(ConfigReader.getProperty("searchText") + Keys.ENTER);

        softAssert.assertTrue(amazonPages.giftCards.isEnabled());
        amazonPages.giftCards.click();

        softAssert.assertTrue(amazonPages.birthdayButton.isEnabled());

        amazonPages.birthdayButton.click();

        String expectedBestSellersString = "Best sellers";
        String actualBestSellersString = amazonPages.bestSellers.getText();

        softAssert.assertEquals(actualBestSellersString, expectedBestSellersString);


        softAssert.assertAll();

        Driver.closeDriver();
    }
}
