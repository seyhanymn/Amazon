package tests;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import packes.AmazonUrunEkle;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.List;
import java.util.Set;

public class UrunEkle extends TestBaseRapor {

   /*

   amazona gidilir
   cookie kabuul eddilir
   aramaya airpods yazılır
   ürün sacdece amazon tarafından gönderillir filtresi secilir
   marka apple secilir
   ilk ürün secilir
   sepete eklenir
   sepete  gidilir
   ürünün sepete geldiği kontrol edilir

    */
@Test

    public void test()  {

    AmazonUrunEkle amazonUrunEkle=new AmazonUrunEkle();

    extentTest=extentReports.createTest("Pozitif Test","Amazon sayfasinda sepete Airpods eklenir");

    Driver.getDriver().get(ConfigReader.getProperty("amznUrl"));
    extentTest.info("Amazon sitesine gidildi");

    amazonUrunEkle.cerezleriKabulEtButonu.click();
    extentTest.info("çerezler kabul edildi");
    Driver.getDriver().manage().deleteAllCookies();
    ReusableMethods.waitFor(1);
    amazonUrunEkle.aramaCubugu.sendKeys("airpods");
    ReusableMethods.waitFor(1);
    extentTest.info("Amazon sitesinde arama çubuğuna  airpods yazildi");
    amazonUrunEkle.aramaButonu.click();
    extentTest.info("Arama butonuna tiklandi");

    amazonUrunEkle.cerezleriKabulEtButonu.click();
    extentTest.info("Crerezleri KAbul et butonuna tiklandi");
    amazonUrunEkle.amazonTarafındanGönderilir.click();
    extentTest.info("Sadece Amazon saticisi tarafindan secilir tiklandi");

    amazonUrunEkle.appleMarka.click();
    extentTest.info("Sadece Apple markasi secilir");

    String arananSonuc=null;
    List<WebElement> liste = amazonUrunEkle.appleUrunListe;
    for (WebElement w : liste) {

        if(!w.isSelected())
            System.out.println(w.getText());
        arananSonuc= w.getText();

           w.click();
        break;
    }
    extentTest.info("Tüm airpodslar listelenir ve ilk ürün secilir");
    System.out.println("aranansonuc" +" "+ arananSonuc);
    amazonUrunEkle.sepeteEkle.click();
    extentTest.info("Sepete eklenir");
    ReusableMethods.waitFor(1);
    amazonUrunEkle.sepeteGit.click();
    extentTest.info("Sepete gidilir");
    String beklenenSonuc=amazonUrunEkle.secilenUrun.getText();
    System.out.println("beklenen"+beklenenSonuc);

    Assert.assertEquals(arananSonuc,beklenenSonuc);
    extentTest.pass("Ürün basarili sekilde sepete eklendi");



}




}
