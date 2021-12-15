package config;

import java.util.*;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import static executionEngine.DriverScript.OR;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import executionEngine.DriverScript;
import utility.Log;
import org.openqa.selenium.Keys;

import java.io.IOException;
import java.text.ParseException;



public class ActionKeywords {
	
		public static WebDriver driver;
			
	public static void openBrowser(String object,String data){		
		Log.info("Opening Browser");
		try{				
			if(data.equals("Mozilla")){
				driver=new FirefoxDriver();
				driver.manage().window().maximize();
				Log.info("Mozilla browser started");				
				}
			else if(data.equals("IE")){
				//Dummy Code, Implement you own code
				driver=new InternetExplorerDriver();
				driver.manage().window().maximize();
				Log.info("IE browser started");
				}
			else if(data.equals("Chrome")){
				//Dummy Code, Implement you own code
				System.setProperty("webdriver.chrome.driver", "/Users/jaisreekasera/HybridKeywordDriven/src/utility/chromedriver");
				driver=new ChromeDriver();
				driver.manage().window().maximize();
				Log.info("Chrome browser started");
				}
			
			int implicitWaitTime=(10);
			driver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
		}catch (Exception e){
			Log.info("Not able to open the Browser --- " + e.getMessage());
			DriverScript.bResult = false;
		}
	}
	
	public static void navigate(String object, String data){
		try{
			Log.info("Navigating to URL");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(Constants.URL);
		}catch(Exception e){
			Log.info("Not able to navigate --- " + e.getMessage());
			DriverScript.bResult = false;
			}
		}
	
	public static void navigatetoDynamic(String object, String data){
		try{
			Log.info("Navigating to dynamics URL");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(Constants.URL1);
		}catch(Exception e){
			Log.info("Not able to navigate --- " + e.getMessage());
			DriverScript.bResult = false;
			}
		}
	
	public static void navigatetoAPP(String object, String data){
		try{
			Log.info("Navigating to dynamics Application");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.navigate().to(data);
		}catch(Exception e){
			Log.info("Not able to navigate --- " + e.getMessage());
			DriverScript.bResult = false;
			}
		}
	public static void click(String object, String data){
		try{
			Log.info("Clicking on Webelement "+ object);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath(OR.getProperty(object))).click();
		 }catch(Exception e){
 			Log.error("Not able to click --- " + e.getMessage());
 			DriverScript.bResult = false;
         	}
		}
	public static void clickCSS(String object, String data){
		try{
			Log.info("Clicking on Webelement "+ object);
			driver.manage().timeouts().implicitlyWait(18, TimeUnit.SECONDS);
			driver.findElement(By.cssSelector(OR.getProperty(object))).click();
		 }catch(Exception e){
 			Log.error("Not able to click --- " + e.getMessage());
 			DriverScript.bResult = false;
         	}
		}
	
	public static void get_Dialogbox(String object, String data){
		try{
		//Log.info("Fetching the text associated to" + object);
		//Constants.APPLICATION_ID= driver.findElement(By.xpath(OR.getProperty(object))).getText();
		//og.info("Fetching the text associated to" + Constants.APPLICATION_ID);
		//driver.quit();
		String dialog_text = driver.switchTo().alert().getText();
		System.out.println(dialog_text);
		}catch(Exception e){
		Log.error("Not able to Fetching the associated text --- " + e.getMessage());
		DriverScript.bResult = false;
		}
	}
	
	public static void linkclick(String object, String data){
		try{
			Log.info("Clicking on link txt "+ object);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.partialLinkText(OR.getProperty(object))).click();
		 }catch(Exception e){
 			Log.error("Not able to click --- " + e.getMessage());
 			DriverScript.bResult = false;
         	}
		}
	public static void input(String object, String data){
		try{
			Log.info("Entering the text in " + object);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(data);
			//driver.findElement(By.cssSelector(OR.getProperty(object))).sendKeys(data);
		 }catch(Exception e){
			 Log.error("Not able to Enter UserName --- " + e.getMessage());
			 DriverScript.bResult = false;
		 	}
		}
	
	public static void inputCSS(String object, String data){
		try{
			Log.info("Entering the text in " + object);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			//driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(data);
			driver.findElement(By.cssSelector(OR.getProperty(object))).sendKeys(data);
		 }catch(Exception e){
			 Log.error("Not able to Enter UserName --- " + e.getMessage());
			 DriverScript.bResult = false;
		 	}
		}
	
	
	public static void selectPartyDropDown(String object, String data){
		try{
			Log.info("Entering the text in " + object);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			WebElement web =driver.findElement(By.xpath(OR.getProperty(object)));
			web.click();
			web.sendKeys(data);
			Thread.sleep(5000);
			driver.findElement(By.xpath(("(//ul[contains(@id,'fieldControl-LookupResultsDropdown_eo_partyid')])[1]"))).click();				
		 }catch(Exception e){
			 Log.error("Not able to Select value from Drop Down --- " + e.getMessage());
			 DriverScript.bResult = false;
		 	}
		}
	
	public static void selectPersonDropDown(String object, String data){
		try{
			Log.info("Entering the text in " + object);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			WebElement web =driver.findElement(By.xpath(OR.getProperty(object)));
			web.click();
			web.sendKeys(data);
			Thread.sleep(5000);
			driver.findElement(By.xpath(("(//ul[contains(@id,'fieldControl-LookupResultsDropdown_eo_personid')])[1]"))).click();				
		 }catch(Exception e){
			 Log.error("Not able to Select value from Drop Down --- " + e.getMessage());
			 DriverScript.bResult = false;
		 	}
		}
	
	public static void selectDropDown(String object, String data)
	{
		Log.info("Entering the text in Dropdown" + object);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Select drpCountry = new Select(driver.findElement(By.xpath(OR.getProperty(object))));
		drpCountry.selectByVisibleText(data);
	
	}
	
	
	public static void waitFor(String object, String data) throws Exception{
		try{
			Log.info("Wait for 5 seconds");
			Thread.sleep(5000);
		 }catch(Exception e){
			 Log.error("Not able to Wait --- " + e.getMessage());
			 DriverScript.bResult = false;
         	}
		}

	public static void closeBrowser(String object, String data){
		try{
			Log.info("Closing the browser");
			driver.quit();
		 }catch(Exception e){
			 Log.error("Not able to Close the Browser --- " + e.getMessage());
			 DriverScript.bResult = false;
         	}
		}
	
	public static void get_Text(String object, String data){
		try{
			//Log.info("Fetching the text associated to" + object);
			Constants.APPLICATION_ID= driver.findElement(By.xpath(OR.getProperty(object))).getText();
			Log.info("Fetching the text associated to" + Constants.APPLICATION_ID);
			//System.out.println("APPLICATION_ID");
			//driver.quit();
		 }catch(Exception e){
			 Log.error("Not able to Fetching the associated text --- " + e.getMessage());
			 DriverScript.bResult = false;
         	}
		}
	
	public static void keys_down(String object, String data){
		try{
			WebElement dp_down = driver.findElement(By.xpath(OR.getProperty(object)));
			dp_down.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
			Log.info("Cannot get keys down" + object);		
		 }catch(Exception e){
			 Log.error("Not able to get  --- " + e.getMessage());
			 DriverScript.bResult = false;
         	}
		}


		
		//MASTER WORKED	
		public static void get_Table_content(String object, String excel_data){
			try{
				
				//fetch the enquiry from the table
				
				
				WebElement webTable = driver.findElement(By.xpath("//*[@class='table table-striped table-fluid']/tbody"));
				List<WebElement> rowElements = webTable.findElements(By.xpath("//*[@class='table table-striped table-fluid']/tbody/tr"));
				int rowSize = rowElements.size();
				
				List<WebElement> columnElements = webTable.findElements(By.xpath("//*[@class='table table-striped table-fluid']/tbody/tr/td"));
				int colSize = columnElements.size();
		
				
				String sColValue = excel_data;
				
				for (int i =1; i<rowSize; i++) {
					
					String table_data = driver.findElement(By.xpath("//*[@class='table table-striped table-fluid']/tbody/tr["+ i +"]/td[6]")).getText();
					Log.info("Status reason for row "+ i +" is " + table_data);
					
					
		
						if (excel_data.equals("Submitted") && table_data.equals(excel_data)) {
							
							for(int j=1; j<=7; j++) {	
								
								//driver.findElement(By.xpath("//a[contains(text(),'Submitted')]/parent::*/following-sibling::td[6]"));
								
								String get_text = driver.findElement(By.xpath("//*[@class='table table-striped table-fluid']/tbody/tr["+ i +"]/td["+ j +"]")).getText();
								Log.info("Enquiry number for "+ table_data + " is " + get_text);
						
								driver.findElement(By.xpath("//*[@class='table table-striped table-fluid']/tbody/tr["+ i +"]/td[7]")).click();
								Log.info("dropdown button clicked for " + get_text + " enquiry");
								
								Thread.sleep(2000);
								
								driver.findElement(By.xpath("//*[@id='mainContent']//table/tbody/tr["+ i +"]/td[7]//a")).click();
								
								
								break;
								
							}
							
							break;	
				
						}
						
						
						else if (excel_data.equals("Draft") && table_data.equals(excel_data)) {
							
							for(int j=1; j<=7; j++) {	
								
								//driver.findElement(By.xpath("//a[contains(text(),'Submitted')]/parent::*/following-sibling::td[6]"));
								
								String get_text = driver.findElement(By.xpath("//*[@class='table table-striped table-fluid']/tbody/tr["+ i +"]/td["+ j +"]")).getText();
								Log.info("Enquiry number for "+ table_data + " is " + get_text);
						
								driver.findElement(By.xpath("//*[@class='table table-striped table-fluid']/tbody/tr["+ i +"]/td[7]")).click();
								Log.info("dropdown button clicked for " + get_text + " enquiry");
						
								break;
								
							}
							
							break;	
				
						}
						
						else if (excel_data.equals("Closed") && table_data.equals(excel_data)) {
							
							for(int j=1; j<=7; j++) {	
								
								//driver.findElement(By.xpath("//a[contains(text(),'Submitted')]/parent::*/following-sibling::td[6]"));
								
								String get_text = driver.findElement(By.xpath("//*[@class='table table-striped table-fluid']/tbody/tr["+ i +"]/td["+ j +"]")).getText();
								Log.info("Enquiry number for "+ table_data + " is " + get_text);
						
								driver.findElement(By.xpath("//*[@class='table table-striped table-fluid']/tbody/tr["+ i +"]/td[7]")).click();
								Log.info("dropdown button clicked for " + get_text + " enquiry");
						
								break;
								
							}
							
							break;	
				
						}
						
						else if (excel_data.equals("Withdrawn") && table_data.equals(excel_data)) {
							
							for(int j=1; j<=7; j++) {	
								
								//driver.findElement(By.xpath("//a[contains(text(),'Submitted')]/parent::*/following-sibling::td[6]"));
								
								String get_text = driver.findElement(By.xpath("//*[@class='table table-striped table-fluid']/tbody/tr["+ i +"]/td["+ j +"]")).getText();
								Log.info("Enquiry number for "+ table_data + " is " + get_text);
						
								driver.findElement(By.xpath("//*[@class='table table-striped table-fluid']/tbody/tr["+ i +"]/td[7]")).click();
								Log.info("dropdown button clicked for " + get_text + " enquiry");
						
								break;
								
							}
							
							break;	
				
						}
						
						else if (excel_data.equals("In Progress") && table_data.equals(excel_data)) {
							
							for(int j=1; j<=7; j++) {	
								
								//driver.findElement(By.xpath("//a[contains(text(),'Submitted')]/parent::*/following-sibling::td[6]"));
								
								String get_text = driver.findElement(By.xpath("//*[@class='table table-striped table-fluid']/tbody/tr["+ i +"]/td["+ j +"]")).getText();
								Log.info("Enquiry number for "+ table_data + " is " + get_text);
						
								driver.findElement(By.xpath("//*[@class='table table-striped table-fluid']/tbody/tr["+ i +"]/td[7]")).click();
								Log.info("dropdown button clicked for " + get_text + " enquiry");
						
								break;
								
							}
							
							break;	
				
						}
					}
					
					
			}
			catch(Exception e){
				 Log.error("Not able to fetch the enquiry --- " + e.getMessage());
				 DriverScript.bResult = false;
	         	}
		}			


		public static void get_Table_content_with_pagination(String object, String excel_data){
			try{
				
				//fetch the enquiry from the table
				
				
				WebElement webTable = driver.findElement(By.xpath("//*[@class='table table-striped table-fluid']/tbody"));
				List<WebElement> rowElements = webTable.findElements(By.xpath("//*[@class='table table-striped table-fluid']/tbody/tr"));
//				List<WebElement> rowElements = webTable.findElements(By.tagName("tr"));
				int rowSize = rowElements.size();
				System.out.println("row size is " + rowElements.size());
				
				List<WebElement> columnElements = webTable.findElements(By.xpath("//*[@class='table table-striped table-fluid']/tbody/tr[1]/td"));
				int colSize = columnElements.size();
				System.out.println("Column size is " + columnElements.size());
				
				List<String> table_data_array = new ArrayList<String>();
				
//				String sColValue = excel_data;
				
				//Pagination
				
				for(int r=1; r<= rowSize; r++) {
					
//					List<WebElement> status = webTable.findElements(By.xpath("//*[@class='table table-striped table-fluid']/tbody/tr["+ r +"]/td[6]")).getText();
					
					String table_data = driver.findElement(By.xpath("//*[@class='table table-striped table-fluid']/tbody/tr["+ r +"]/td[6]")).getText();
					Log.info("Status reason for row "+ r +" is " + table_data);
					table_data_array.add(table_data);
					
					
					if(!table_data_array.contains(excel_data)) {
						
						System.out.println("Status is not same as expected, so searching on Next page...");
							
						}
					else {
						
						for(int c=1; c<= colSize; c++) {
							System.out.println("Status is same as expected");
							//driver.findElement(By.xpath("//a[contains(text(),'Submitted')]/parent::*/following-sibling::td[6]"));
							
							String get_text = driver.findElement(By.xpath("//*[@class='table table-striped table-fluid']/tbody/tr["+ r +"]/td["+ c +"]")).getText();
							Log.info("Enquiry number for "+ table_data + " is " + get_text);
					
							driver.findElement(By.xpath("//*[@class='table table-striped table-fluid']/tbody/tr["+ r +"]/td[7]")).click();
							Log.info("dropdown button clicked for " + get_text + " enquiry");
							
							Thread.sleep(2000);
							
							driver.findElement(By.xpath("//*[@id='mainContent']//table/tbody/tr["+ r +"]/td[7]//a")).click();
							
							
							break;	
						}
						
						
					}
				}
					
				boolean hasNextPage=true;
				
				while (!table_data_array.contains(excel_data) && hasNextPage) {
					
					List<WebElement> enabled_next_page_btn=driver.findElements(By.xpath("//div/ul/li/a[contains(@aria-label, 'Next page')]"));
					System.out.println(enabled_next_page_btn.size());
					
					List<WebElement> disabled_next_page_btn=driver.findElements(By.xpath("//div/ul/li/a[contains(@aria-disabled, 'true')]"));
		
					if(enabled_next_page_btn.size()>0){
			        	
			        	WebDriverWait wait = new WebDriverWait(driver, 50);
			        	System.out.println("One more Next page " + enabled_next_page_btn.size());
			            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/ul/li/a[contains(@aria-label, 'Next page')]")));
			            Thread.sleep(5000);
			            enabled_next_page_btn.get(0).click();
			            Thread.sleep(5000);
			            hasNextPage=true;   
			            System.out.println("Clicked on Next page");
			            
			            WebElement webTable1 = driver.findElement(By.xpath("//*[@class='table table-striped table-fluid']/tbody"));
						List<WebElement> rowElements1 = webTable.findElements(By.xpath("//*[@class='table table-striped table-fluid']/tbody/tr"));

						int rowSize1 = rowElements1.size();
						System.out.println("row size is " + rowElements1.size());
						
						List<WebElement> columnElements1 = webTable.findElements(By.xpath("//*[@class='table table-striped table-fluid']/tbody/tr[1]/td"));
						int colSize1 = columnElements1.size();
						System.out.println("Column size is " + columnElements1.size());
						
						List<String> table_data_array1 = new ArrayList<String>();
			            
			            for(int i=1; i<= rowSize1; i++) {
							
//							List<WebElement> status = webTable.findElements(By.xpath("//*[@class='table table-striped table-fluid']/tbody/tr["+ r +"]/td[6]")).getText();
							
							String table_data = driver.findElement(By.xpath("//*[@class='table table-striped table-fluid']/tbody/tr["+ i +"]/td[6]")).getText();
							Log.info("Status reason for row "+ i +" is " + table_data);
							table_data_array.add(table_data);
							
							
							if(!table_data_array.contains(excel_data)) {
								
								System.out.println("Status is not same as expected, so searching on Next page...");
									
								}
							else {
								
								for(int j=1; j<= colSize; j++) {
									System.out.println("Status is same as expected");
									//driver.findElement(By.xpath("//a[contains(text(),'Submitted')]/parent::*/following-sibling::td[6]"));
									
									String get_text = driver.findElement(By.xpath("//*[@class='table table-striped table-fluid']/tbody/tr["+ i +"]/td["+ j +"]")).getText();
									Log.info("Enquiry number for "+ table_data + " is " + get_text);
							
									driver.findElement(By.xpath("//*[@class='table table-striped table-fluid']/tbody/tr["+ i +"]/td[7]")).click();
									Log.info("dropdown button clicked for " + get_text + " enquiry");
									
									Thread.sleep(2000);
									
									driver.findElement(By.xpath("//*[@id='mainContent']//table/tbody/tr["+ i +"]/td[7]//a")).click();
									
									
									break;	
								}
								
								
							}
						}
			            
					}
					else if(disabled_next_page_btn.size()>0){
			            System.out.println("No more Pages Available");
			            break;
			        }
     
					}
			
//						
//				for (int m =0; m<=rowSize; m++) {
//					
//					String table_data1 = driver.findElement(By.xpath("//*[@class='table table-striped table-fluid']/tbody/tr["+ m +"]/td[6]")).getText();
//					Log.info("Status reason for row "+ m +" is " + table_data1);
//					
//					List<WebElement> enabled_next_page_btn1=driver.findElements(By.xpath("//div/ul/li/a[contains(@aria-label, 'Next page')]"));
//					System.out.println(enabled_next_page_btn1.size());
//					
//					
//					
//					for(int j=0; j<= colSize; j++) {	
//						
//						//driver.findElement(By.xpath("//a[contains(text(),'Submitted')]/parent::*/following-sibling::td[6]"));
//						
//						String get_text = driver.findElement(By.xpath("//*[@class='table table-striped table-fluid']/tbody/tr["+ m +"]/td["+ j +"]")).getText();
//						Log.info("Enquiry number for "+ table_data + " is " + get_text);
//				
//						driver.findElement(By.xpath("//*[@class='table table-striped table-fluid']/tbody/tr["+ m +"]/td[7]")).click();
//						Log.info("dropdown button clicked for " + get_text + " enquiry");
//						
//						Thread.sleep(2000);
//						
//						driver.findElement(By.xpath("//*[@id='mainContent']//table/tbody/tr["+ m +"]/td[7]//a")).click();
//						
//						
//						break;
//					}
//					break;
//				}
	}
			catch(Exception e){
				 Log.error("Not able to fetch the enquiry --- " + e.getMessage());
				 DriverScript.bResult = false;
	         	}
		}
            
            
		public static void pagination(String object, String data) {
			try {
				
//				WebElement Next_button = driver.findElement(By.xpath("//div/ul[@class='pagination']/li[2]/a"));
				
			    boolean hasNextPage=true;

			    while(hasNextPage){
			        
//			        List<WebElement> pagination=driver.findElements(By.xpath("//div/ul[@class='pagination']"));
			        
			        List<WebElement> enabled_next_page_btn=driver.findElements(By.xpath("//div/ul/li/a[contains(@aria-label, 'Next page')]"));
			        List<WebElement> disabled_next_page_btn=driver.findElements(By.xpath("//div/ul/li/a[contains(@aria-disabled, 'true')]"));
			        		
			        //If the Next button is enabled/available, then enabled_next_page_btn size will be one.
			        // So,you can perform the click action and then do the action
			        
			        if(enabled_next_page_btn.size()>0){
			        	
			        	WebDriverWait wait = new WebDriverWait(driver, 50);
			        	System.out.println(enabled_next_page_btn.size());

			            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/ul/li/a[contains(@aria-label, 'Next page')]")));
			            enabled_next_page_btn.get(0).click();
			            Thread.sleep(3000);
			            hasNextPage=true;
			            
			            
			        }
			        else if(disabled_next_page_btn.size()>0){
			            System.out.println("No more Pages Available");
			            break;
			        }
			    }
			}
			    

		 catch(Exception e){
			 Log.error("Not able to find pagination  --- " + e.getMessage());
			 DriverScript.bResult = false;
	     	}
		}
		

		


	public static void modalWindow(String object, String data){
		try{
			
			//driver.switchTo().frame(driver.findElement(By.className("modal-content")));
			//Alert alert = driver.switchTo().alert();
			//String alertMessage = driver.switchTo().alert().getText();
			//Log.info(alertMessage);
			//Thread.sleep(2000);
	
//			WebElement currentElement = driver.switchTo().activeElement();
//			String windowName = currentElement.getText();
//			Log.info(windowName);
			

			
			String windowName = driver.findElement(By.className("modal-title")).getText();
			Log.info(windowName);
			
			WebElement windowBody = driver.findElement(By.className("modal-body"));
			//driver.switchTo().frame(windowBody);
			Log.info(windowBody.getText());
			
			Thread.sleep(2000);
			
			WebElement new_iframe = windowBody.findElement(By.xpath("//iframe[@title=' Edit']"));
			//driver.switchTo().frame(windowBody).switchTo().frame(new_iframe);
			
			driver.switchTo().frame(new_iframe);
			Thread.sleep(2000);			
			
//			driver.findElement(By.xpath(".//*[@id='eo_enquirytitle']")).sendKeys("testing title");
//			Thread.sleep(2000);	
			
			//driver.switchTo().defaultContent();

		 }catch(Exception e){
			 Log.error("Not able to focus on modal window  --- " + e.getMessage());
			 DriverScript.bResult = false;
	     	}
		}
	

	public static void SwitchBackToDefault(String object, String data){
		try{
			
			driver.switchTo().defaultContent();

		 }catch(Exception e){
			 Log.error("Not able to close the window  --- " + e.getMessage());
			 DriverScript.bResult = false;
	     	}
		}
	
}




