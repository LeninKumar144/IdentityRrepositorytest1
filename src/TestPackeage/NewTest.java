package TestPackeage;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class NewTest {
	public static WebDriver driver;
	
	public static Logger LOG=Logger.getLogger("NewTest");
  @Test
  public void NewTest() {
	  
	  PropertyConfigurator.configure("C:\\Users\\Lenin\\Test-SeleniumwithGit\\Log4j.properties");
	  
	  //WebElement PASS=driver.findElement(By.xpath("//*[@name='password_protected_pwd']"));
	  //PASS.sendKeys("IdentityIQ1");
	  //WebElement BUTT=driver.findElement(By.xpath("//*[@name='wp-submit']"));
	  //BUTT.click();
	  //WebElement terms=driver.findElement(By.xpath("//*[@id='menu-item-837']"));
	  //terms.click();
	  
	  //driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  WebElement USER= driver.findElement(By.xpath("//input[@id='txtUsername']"));   
	  Actions User = new Actions(driver);
      User.moveToElement(USER).click().sendKeys("matthewplanz@gmail.com").perform();
      
	  
	  //driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  WebElement Password=driver.findElement(By.xpath("//input[@id='txtPassword']"));
	  Actions Pass = new Actions(driver);
      Pass.moveToElement(Password).click().sendKeys("Harshi2010").perform();
	  
	  WebElement Button=driver.findElement(By.xpath("//input[@id='imgBtnLogin']"));
	  Button.click();
	  
 
	  try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	      String Actual=driver.getCurrentUrl();
		  String expected="https://tst.identityiq.com/SecurityQuestions.aspx";
	      System.out.println(Actual);
	
	 
	 if(!expected.equals(Actual)){
	    	  
	    	  WebElement userLoginCredentialError=driver.findElement(By.xpath("//*[@id='li-line']"));
	    	  System.out.println(userLoginCredentialError.getText());
	    	  Reporter.log("Login Page Error--->"+userLoginCredentialError);
	    	  
	      }
	  
	  else {
		 
		  WebElement SocialSN=driver.findElement(By.xpath("//input[@name='FBfbforcechangesecurityanswer$txtSecurityAnswer']"));
		  SocialSN.sendKeys("0013");
		 
		  WebElement Submit=driver.findElement(By.xpath("//input[@name='FBfbforcechangesecurityanswer$ibtSubmit']"));
		  Submit.click();
		  	  
		  try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		  //WebElement userHomePage=driver.findElement(By.xpath("//*[@class='dash']"));
		  
		  String dashboardPageUrl=driver.getCurrentUrl();
		  String expectedDashboardUrl="https://tst.identityiq.com/Dashboard.aspx";
		  System.out.println(dashboardPageUrl);
		  
		  if(!expectedDashboardUrl.equals(dashboardPageUrl)){
          
			  WebElement Security=driver.findElement(By.xpath("//*[@class='userid1']"));
	    	  System.out.println(Security.getText());
	    	  Reporter.log("Security Answer Error--->"+Security);
	      //String Security="//*[@class='align_center nomargin']";
	      //String Answerpage=Security;
		  //String SecAns=driver.findElement(By.xpath(Answerpage)).getText();
		  //System.out.println(SecAns);   
	      //Reporter.log("Security Answer--->"+SecAns);
		  }
		  else{
		    //String UserHome="//*[@class='dash']";
		      //String HomePage=UserHome;
			 // WebElement UserHomePage=driver.findElement(By.xpath(HomePage));
				  
			  WebElement Gear= driver.findElement(By.xpath("//*[@id=\"Navbar1_liSetting\"]"));   
			  Actions Icon = new Actions(driver);
			  Icon.moveToElement(Gear).perform();
			 		  
			     try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				  
			   //*[@href="javascript:void(0)"]//following::span[1]
			   String MemberName="//*[@id='Navbar1_lblName']";
		       String actualMembership=MemberName;
			   String Member=driver.findElement(By.xpath(actualMembership)).getText();
			   System.out.println(Member);   
			   Reporter.log("User Name--->"+Member);
				  
				  
				  
			    //*[@href="javascript:void(0)"]//following::span[3]
				String MemberNo="//*[@id='Navbar1_lblAccountID']";
			    String Actual1=MemberNo;
				String Membershipno=driver.findElement(By.xpath(Actual1)).getText();
				System.out.println(Membershipno);
					
				//LOG.info("Member Login successfully--->"+Membershipno);
				Reporter.log("Membership Number--->"+Membershipno);
					
				WebElement Logout=driver.findElement(By.xpath("//*[@href='/Logout.aspx']"));
				Logout.click();
		  }	    
			  
	  }
	  //LOG.info("Member Login successfully");
	  //Reporter.log("Member Login successfully");
	  
	
		//String Actual=driver.getCurrentUrl();
		//String expected="http://tst.identityiq.com/Dashboard.aspx";
	  
	  //WebElement ContinueTo=driver.findElement(By.xpath("//*[@id='lbtContinueToDashboard']"));
	  //ContinueTo.click();
		
		
  }
  @BeforeMethod
  public void beforeMethod() {
	    System.setProperty("webdriver.chrome.driver","C:\\Users\\Lenin\\OneDrive\\Documents\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tst.identityiq.com/login.aspx");
  }

  @AfterMethod
  public void afterMethod() {
	  
	  //driver.close();
	  //Sendmail.email();
  }

}
