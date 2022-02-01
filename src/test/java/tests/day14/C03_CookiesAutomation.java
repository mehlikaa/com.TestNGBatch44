package tests.day14;

import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class C03_CookiesAutomation extends TestBase {
    //Yeni bir class olusturun : cookiesAutomation
    //1- Amazon anasayfaya gidin
    //2- tum cookie’leri listeleyin
    //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
    //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
    //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
    //6- eklediginiz cookie’nin sayfaya eklendigini test edin
    //7- ismi skin olan cookie’yi silin ve silindigini test edin
    //8- tum cookie’leri silin ve silindigini test edin
    @Test
    public void test01(){

    driver.get("https://www.amazon.com");
        //2- tum cookie’leri listeleyin
        Set<Cookie> cookieSet=driver.manage().getCookies();
        System.out.println(cookieSet);
        int count=1;
        for (Cookie w:cookieSet
             ) {
            System.out.println(count+". Cookie : "+ w);
            count++;
        }
        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        Assert.assertTrue(cookieSet.size()>5);

        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        // String  cookieNamei18n=driver.manage().getCookieNamed("i18n-prefs");      //data turu String degils
        Cookie cookieNamei18n=driver.manage().getCookieNamed("i18n-prefs");
        System.out.println(" Cookie i18n nam : "+cookieNamei18n);

        Assert.assertTrue(driver.manage().getCookieNamed("i18n-prefs").getValue().equals("USD"))  ;

        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
        Cookie myCookie=new Cookie("En sevdigim Cookie","Cikolatali");
        driver.manage().addCookie(myCookie);

        //6- eklediginiz cookie’nin sayfaya eklendigini test edin
        Set<Cookie> cookieSet2=driver.manage().getCookies();

        count=1;
        for (Cookie w:cookieSet2
        ) {
            System.out.println(count+". Cookie : "+ w);
            count++;
        }
    Assert.assertTrue(cookieSet2.contains(myCookie));

        //7- ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        Set<Cookie> cookieSet3=driver.manage().getCookies();

        count=1;
        for (Cookie w:cookieSet3
        ) {
            System.out.println(count+". Cookie : "+ w);
            count++;
        }
        Assert.assertFalse(cookieSet3.contains(driver.manage().getCookieNamed("skin")));
        //8- tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();

        Set<Cookie> cookieSet4=driver.manage().getCookies();

        count=1;
        for (Cookie w:cookieSet4
        ) {
            System.out.println(count+". Cookie : "+ w);
            count++;
        }
        Assert.assertTrue(cookieSet4.size()==0);
    }

}
