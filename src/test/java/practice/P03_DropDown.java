package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.List;

public class P03_DropDown extends TestBase {

    // go to url : https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/
//-->Task1 Find Dropdown on Multi Selection

//-->Task5 check until choise 6'
    @Test
    public void testDropdown(){
        driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
        WebElement dropDownElementi=driver.findElement(By.xpath("//input[@id='justAnInputBox']"));
        dropDownElementi.click();
//-->Task2 Find all Dropdown Elements
        List<WebElement> dropList=driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));

//-->Task3 printout DropDown Elements' number
        System.out.println("My DropDown List has  "+dropList.size()+" adettir.");

//-->Task4 choose all dropdown elements and printout dropdown elements' name
        System.out.println("My DropLIst");
        for (int i = 0; i<dropList.size(); i++)
             {
                 String text=dropList.get(i).getText();
                 System.out.println("Textim  " +text );
            if (!text.isEmpty()){
                dropList.get(i).click();
            }

            if (text.equals("choice 6")){
                dropList.get(i);
                break;
            }
        }




    }



}
