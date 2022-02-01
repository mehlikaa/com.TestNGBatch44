package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

//Tests packagenin altina bir class oluşturun : C05_UploadFile
public class C05_FileUpload extends TestBase {


//Yuklemek istediginiz dosyayi secelim.
//Upload butonuna basalim.
//“File Uploaded!” textinin goruntulendigini test edelim
@Test
public void test01(){
    //https://the-internet.herokuapp.com/upload adresine gidelim
//chooseFile butonuna basalim
    driver.get("https://the-internet.herokuapp.com/upload");
    WebElement fileSecButonu=driver.findElement(By.id("file-upload"));


}
}
