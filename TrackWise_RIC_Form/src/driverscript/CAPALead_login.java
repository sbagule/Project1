package driverscript;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class CAPALead_login {
	

	public static WebDriver driver;
	
	public static void main(String[] args) throws Exception 
    {
             
  //For Executing in IE11
    System.setProperty("webdriver.ie.driver", "D:\\Shruti Bagule\\Seleniumeclipse\\Selenium\\IEDriverServer.exe");
           
    WebDriver driver = new InternetExplorerDriver();
	
	//public void LogInAction(WebDriver driver) throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		driver.get("http://css-trackwise-dev.cookgroup.nao/TW_MED_DEV");
	       System.out.println("Trackwise");
	       
	       Thread.sleep(3000);
	       // Code to switch to next window
	       Set <String> handles =driver.getWindowHandles();
	       Iterator<String> it = handles.iterator();
	       
	       //iterate through your windows
	       while (it.hasNext()){
	       String newwin = it.next();
	       driver.switchTo().window(newwin);
	       }
	       Thread.sleep(3000);
	       driver.findElement(By.xpath(".//*[@name='tfUserName']")).sendKeys("capalead");
	       driver.findElement(By.xpath(".//*[@name='tfPassword']")).sendKeys("capalead");
	       Thread.sleep(2000);
	       driver.findElement(By.name("timezone")).click();
	       
	       Select oSelect = new Select(driver.findElement(By.name("timezone")));
	       oSelect.selectByValue("India Standard Time");   
	       System.out.println("Time Zone Selected");
	       
	       WebElement LogIn =  wait.until(ExpectedConditions.elementToBeClickable(By.id("btLoginId")));
	       LogIn.click();
	       
	       try 
	       {
	       driver.switchTo().alert().accept();
	       System.out.println("Unexpected alert present");
	       }
	       catch(Exception e)
	       {	
	       System.out.println("Unexpected alert not present");
	       }
	       Thread.sleep(2000);
	       System.out.println("logged in Successfully");  
	       
	       String acturl = null;
	       acturl= driver.getCurrentUrl();
	       System.out.println("current url" +acturl ); 	       
	    
	                  	       
	       driver.switchTo().frame("Login"); 
	    
	     driver.findElement(By.name("tfPRNum")).sendKeys("98270");
	    	        		System.out.println("PR# Entered");
	    	        		
	   WebElement Go = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@href,'javascript:singlePR()')]")));
	    	 Go.click();
	    	 
	    	 Thread.sleep(5000);
	    	
	    System.out.println("Clicked on Go & PR# Displayed");
	    	                		       
	  driver.findElement(By.xpath("//a[contains(@href,'javascript:parent.postActivity(-1,1523)')]")).click();
	      System.out.println("Capa link clicked");
	      Thread.sleep(4000);
	      	      	    	      	    
     
	       Set <String> handles11 =driver.getWindowHandles();
	       Iterator<String> it11 = handles11.iterator();
	       
	       //iterate through your windows
	       while (it11.hasNext())
	       {
	       String newwin1 = it11.next();
	       driver.switchTo().window(newwin1);
	       }
	       System.out.println("Wait on Selection Window 75");
	       Thread.sleep(2000);
	       
	     /*  driver.switchTo().defaultContent();
	       System.out.println("default frame");
	       Thread.sleep(4000);*/
	       
	       String acturl11 = null;
	       acturl11= driver.getCurrentUrl();
	       System.out.println("current url" +acturl11 );
	       
	       Thread.sleep(2000);
	       	       
	       //driver.findElement(By.xpath("//*[@id,'btNow_Date_Performed']")).click();
	       driver.findElement(By.id("btNow_Date_Performed")).click();
	       System.out.println("NowDate" );
	       driver.findElement(By.name("taSummary")).sendKeys("Approved");
	       
	       driver.findElement(By.xpath("//html/body/center/form[1]/table[2]/tbody/tr[2]/td/table/tbody/tr/td/div[3]/div[1]/div[1]/button")).click();
	      
	       Set <String> handles111 =driver.getWindowHandles();
	       Iterator<String> it111 = handles111.iterator();
	       
	       //iterate through your windows
	       while (it111.hasNext())
	       {
	       String newwin111 = it111.next();
	       driver.switchTo().window(newwin111);
	       }
	       System.out.println("post url chnged ");
	       Thread.sleep(2000);  
	       
	       String acturl111 = null;
	       acturl111= driver.getCurrentUrl();
	       System.out.println("current url" +acturl111 );
	       
	       
	       Thread.sleep(2000);
	       Set <String> handles1111 =driver.getWindowHandles();
	       Iterator<String> it1111 = handles1111.iterator();
	       
	       //iterate through your windows
	       while (it1111.hasNext())
	       {
	       String newwin1111 = it1111.next();
	       driver.switchTo().window(newwin1111);
	       }
	       System.out.println("Wait on esign ");
	       Thread.sleep(4000);  
	       
	       driver.findElement(By.name("dfPassword")).sendKeys("capalead");
	       
	       driver.findElement(By.xpath(".//*[@id='btns']/div[1]/div[1]/button")).click();
	       
	       Thread.sleep(2000);
	       Logout Log = new Logout();
	       Log.LogoutAction(driver);
	       
	
	}
	}





