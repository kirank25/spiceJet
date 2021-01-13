package snapdealTest;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Generic.BaseTest;
import Generic.wrapperClass;
import snapdealPage.HomePage;


public class snapdeal_test extends BaseTest{
	
 HomePage objHomePage = new HomePage(this);

 @BeforeMethod
 public void inti()
 {
	this.intialSetUp();
 }
 @Test
 public void test() throws IOException
 {
	 
	//objHomePage.ListAllLinks();
	objHomePage.mouseOverOnElectronics();
	objHomePage.RandomSelectSpeakres();
	objHomePage.customerratingSelect();
	objHomePage.PrintAllListOfProduct();
	objHomePage.priceOfProduct();
	
	//objHomePage.getnoReview();
	objHomePage.getRatings();
	objHomePage.getReview();
 }
 
}
