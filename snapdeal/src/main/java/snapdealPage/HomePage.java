package snapdealPage;

import java.awt.Desktop.Action;
import java.awt.Robot;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import javax.imageio.stream.FileImageInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.google.common.base.Throwables;
import com.google.common.collect.Table.Cell;

import Generic.Pojo;

public class HomePage {

	
	Pojo objPojo;
	
	public HomePage(Pojo objPojo)
	{
		this.objPojo = objPojo;
	}
	//Locators:- 
 
	        By LinkAll = By.tagName("a");
			By LinkElectronics = By.xpath("//span[.='Electronics']");
			//By LinkSpeaker = By.xpath("//*[@id='category3Data']/div[1]/div/div/p");
			By LinkSpeaker = By.xpath("//div[@id='category3Data']/div/div/div/p/a/span[.='Speakers']");
			
			By element1 = By.xpath("//span[.='Home Audio Systems']");
			By element2 = By.xpath("//span[.='Bluetooth Speakers']");
			By element3 = By.xpath("//span[.='2.1 & 2.0 Speakers']");
			By LinkCustomerRating = By.xpath("//div[@data-displayname='Customer Rating']");
			By LinkfourRating = By.xpath("//div//input//following-sibling::label[@for='avgRating-4.0']");
			By allListProduct =By.xpath("//p[contains(@class,'product-title')]");
			By Price = By.xpath("//div[@class='lfloat marR10']//span[@class='lfloat product-price']");
	
			By ratings = By.xpath("//span[@class='total-rating showRatingTooltip']");
		    By review=By.xpath("//span[@class='numbr-review']");
		    By getReviews =By.xpath("//div[@class='head']");
//	public void ListAllLinks() throws IOException
//	{
//		List<WebElement> ListAll = objPojo.getDriver().findElements(LinkAll);
//		int size = ListAll.size();
//		System.out.println("count (number of) links on the homepage:-"+size);
//		for(int i=0;i<size;i++)
//		{
//			String names = ListAll.get(i).getText();
//		//System.out.println(names);
//		String url = ListAll.get(i).getAttribute("href");
//		//System.out.println(url);
//		FileWriter file = new FileWriter("C:\\Users\\Verve Square\\Desktop\\sh.txt",true);
//		file.write(names+"\n");
//		file.write(url+"\n");
//		file.close();
//		}
//	}
	public void mouseOverOnElectronics()
	{
		objPojo.getWrapper().mouseOvering(LinkElectronics);
	}
	public void RandomSelectSpeakres()
	{
		WebElement Home = objPojo.getDriver().findElement(element1);
		WebElement HoBlutooth = objPojo.getDriver().findElement(element2);
		WebElement Speakers = objPojo.getDriver().findElement(element3);
		
		ArrayList<WebElement> element = new ArrayList<WebElement>();
		
		element.add(0, Home);
		element.add(1,HoBlutooth);
		element.add(2,Speakers);
		
	    Random r = new Random();
	    int option = r.nextInt(element.size());
	    System.out.println("selected option :- "+ element.get(option).getText());
	   WebElement selected = element.get(option);
	   selected.click();		
	}
	public void customerratingSelect()
	{
		JavascriptExecutor js = (JavascriptExecutor)objPojo.getDriver();  
		   js.executeScript("window.scrollBy(0,1000)");
		   objPojo.getWrapper().click(LinkCustomerRating);
		
	}
	public void PrintAllListOfProduct()
	{
		List<WebElement> productList = objPojo.getDriver().findElements(allListProduct);
		for(int i=0;i<productList.size();i++)
		System.out.println(productList.get(i).getText());
	}
	public void priceOfProduct()
	{
		List<WebElement> listOfPrice = objPojo.getDriver().findElements(Price);
		int size = listOfPrice.size();
		for(int i=0;i<size;i++)
		{	
		     String cost = listOfPrice.get(i).getText();
		     System.out.println(cost+"=Cost Of Product");
		}
		Random r = new Random();
	    int option = r.nextInt(listOfPrice.size());
	    System.out.println("selected option :- "+ listOfPrice.get(option).getText());
	   WebElement selected = listOfPrice.get(option);
	   selected.click();
}
	public void getRatings()
    {
        objPojo.getWrapper().windowHandling();
    String str=objPojo.getDriver().findElement(ratings).getText();
    System.out.println(str);
    }
    public void getReview()
    {
         String str1=objPojo.getDriver().findElement(review).getText();
         System.out.println(str1);
    }
    public void clickOnReviews() throws IOException
    {
        objPojo.getWrapper().click(review);
        List<WebElement> list=objPojo.getDriver().findElements(getReviews);
        for (int i = 0; i < 1; i++) {
             //writting text in other page
            String review = list.get(i).getText();
            FileWriter fw=new FileWriter("C:\\Users\\Verve Square\\Desktop\\sh.txt",true);
            PrintWriter out=new PrintWriter(fw);
            out.println(review);
            out.close();
         }
	
    }}

	