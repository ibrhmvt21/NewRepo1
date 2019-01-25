package com.cybertek.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.cybertek.utilities.TestBase;

import java.util.List;

public class WebTablesExample extends TestBase {


    //prints entire table
    @Test
    public void printWholeTable() {
        login();
        WebElement table = driver.findElement(By.id("ctl00_MainContent_orderGrid"));
        System.out.println(table.getText());
    }


    public void login() {
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test" + Keys.ENTER);
    }


    //printing headers of the table
    @Test
    public void printAllHeaders() {
        login();

//        for (int i=1; i<14; i++){
//            System.out.println( driver.findElement(By.xpath("//table[@class='SampleTable']/*/*/*["+i+"]")).getText());
//        }

        List<WebElement> headers =
                driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//th"));
        for (WebElement h : headers) {
            System.out.println(h.getText());
        }
    }
    @Test
    public void printRows() {
        login();
        List<WebElement> rows = driver.findElements(
                By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr"));

        //prints the number of rows
        System.out.println("number of rows= " + rows.size());

        for (WebElement r : rows) {
            System.out.println(r.getText());
        }

        //print the nth row
        System.out.println("Printing 4th row");
        System.out.println(rows.get(4).getText());

    }

    @Test
    public void printTableSize() {
        login();
        List<WebElement> allRowes = driver.findElements(
                By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr"));
        System.out.println("Number of Rows= " + allRowes.size());

        List<WebElement> allCols = driver.findElements(
                By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[1]/th"));
        System.out.println("Number of Columns= " + allCols.size());
    }

    @Test
    public void printRow2() {
        login();
        WebElement row2 = driver.findElement(
                By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[1]"));
        System.out.println(row2.getText());
    }

    //print all the cells of a row whose index is given in xpath
    @Test
    public void printAllCellsInOneRow() {
        login();
        List<WebElement> cells = driver.findElements(
                By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[2]/td"));

        for (WebElement w : cells) {
            System.out.println(w.getText());
        }

    }
    //print by coordinates
    @Test
    public void printByCoordinates() {
        login();

        WebElement cell = driver.findElement(
                By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[6]/td[11]"));

        //  System.out.println(cell.getText());

        System.out.println(getCell(6,11).getText());
    }

    public WebElement getCell(int row, int col){
        String xpath="//table[@id='ctl00_MainContent_orderGrid']/tbody/tr["+row+"]/td["+col+"]";

        return driver.findElement(By.xpath(xpath));
    }

    /*
    print all the values in a single column
     */
    @Test
    public void printColumn(){
        login();
        List<WebElement> allNames=driver.findElements(
                By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[3]"));

        for (WebElement c:allNames){
            System.out.println(c.getText());
        }
    }

    @Test
    public void selectCheckBox(){
        login();
        WebElement checkbox= driver.findElement(
                By.xpath("//td[.='Susan McLaren']/../td[1]/input"));

        System.out.println(checkbox.isSelected());
        checkbox.click();
        System.out.println(checkbox.isSelected());
    }
    /*
    verify that name 'Mark Smith' exists in the names column
    verify that city 'anytown' exists in the cities column
     */
    @Test
    public void test() {
        login();
        int nameIndex = getColumnIndex("Name");
        System.out.println(nameIndex);
        List<WebElement> allNames = driver.findElements(
                By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[" + nameIndex + "]"));
        boolean found = false;
        for (int i = 0; i < allNames.size(); i++) {
            if (allNames.get(i).getText().equalsIgnoreCase("Mark Smith")) {
                found = true;
                break;
                //pass
                //break
            }
        }
        Assert.assertTrue(found);
        found = false;
        int cityIndex = getColumnIndex("City");
        System.out.println(cityIndex);
        List<WebElement> allCities = driver.findElements(
                By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[" + cityIndex + "]"));
        for (int i = 0; i < allCities.size(); i++) {
            if (allCities.get(i).getText().equalsIgnoreCase("Whitestone, British")) {
                found = true;
                break;
            }

        }
        Assert.assertTrue(found);
    }
    /*
    get a column name as parameters
    returns the index of column name
     */
    public int getColumnIndex (String column){
        List<WebElement> allheaders = driver.findElements(
                By.xpath("//table[@id='ctl00_MainContent_orderGrid']//th"));

        for (int i = 0; i < allheaders.size(); i++) {
            if (allheaders.get(i).getText().equalsIgnoreCase(column)) {
                return i + 1;
            }
        }

        return 0;
    }

}
