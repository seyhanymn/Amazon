package packes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AmazonUrunEkle {
    public AmazonUrunEkle(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (xpath = "//input[@id='twotabsearchtextbox']")
    public WebElement aramaCubugu;

    @FindBy (xpath = "//input[@id='nav-search-submit-button']")
    public WebElement aramaButonu;
    @FindBy (xpath = "//input[@id='sp-cc-accept']")
    public WebElement cerezleriKabulEtButonu;
    @FindBy (xpath = "(//i[@class='a-icon a-icon-checkbox'])[2]")
    public WebElement amazonTarafındanGönderilir;

    @FindBy (xpath = "(//span[text()='Apple'])[1]")
    public WebElement appleMarka;

    @FindBy (xpath = "//span[@class='a-size-base-plus a-color-base a-text-normal']")
    public List<WebElement> appleUrunListe;

    @FindBy (xpath = "//input[@id='add-to-cart-button']")
    public WebElement sepeteEkle;
    @FindBy (xpath = "//span[@id='sw-gtc']")
    public WebElement sepeteGit;
    @FindBy (xpath = "(//span[@class='a-truncate-cut'])[1]")
    public WebElement secilenUrun;


}
