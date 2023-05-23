package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPage {

    public AmazonPage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBox;

    @FindBy(xpath = "//*[text()=\"Gift Cards\"]")
    public WebElement giftCards;

    @FindBy(xpath = "//a[@aria-label=\"Birthday\"]")
    public WebElement birthdayButton;

    @FindBy(xpath = "(//span[@class=\"acswidget-carousel__title\"])[1]")
    public WebElement bestSellers;


}
