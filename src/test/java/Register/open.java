package Register;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class open {
	FirefoxDriver driver;

	@BeforeTest

	public void openurl() {
		String geckopathe = System.getProperty("user.dir")+ "\\resources\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", geckopathe);
		// Take new Object from Chrome Driver
		driver = new FirefoxDriver();

		// open Google URL from WebDriver
		driver.navigate().to("https://www.airbnb.com");
	}
	@Test 
	public void searchCreteria() {
		//search the place "italy"
		WebElement where =	driver.findElement(By.cssSelector("button.ffgcxut:nth-child(1) > div:nth-child(2)"));
		where.click();
		WebElement insertDesti = driver.findElement(By.id("bigsearch-query-location-input"));
		insertDesti.clear();
		insertDesti.sendKeys("Rome, Italy");
		insertDesti.sendKeys(Keys.ENTER);
	 
		//search the time "7 days"
		//WebElement time = driver.findElement(By.className("pz9siyu dir dir-ltr"));
		//time.click();
		WebElement selectTimeCheckIn = driver.findElement(By.id("tab--tabs--2")) ;
		selectTimeCheckIn.click();
		WebElement selectWeek = driver.findElement(By.id("flexible_trip_lengths-one_week")) ;
		selectWeek.click();
		WebElement selectMonth = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div/div[2]/div[1]/div/div/div/header/div/div[2]/div[2]/div/div/div/form/div[2]/div[1]/div[3]/div[2]/div/div/section/div/div/div/div/div[2]/div[3]/div/div[2]/div[2]/div[2]/div[2]/div/button/div/div/div/div[1]")) ;
		selectMonth.click();
		//search the people "3 adults"
		WebElement navigateToperson = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div/div[2]/div[1]/div/div/div/header/div/div[2]/div[2]/div/div/div/form/div[2]/div[1]/div[5]/div[1]/div[1]/div/div[2]"));
		navigateToperson.click();
		WebElement selectAdults = driver.findElement(By.cssSelector("#stepper-adults > button:nth-child(3)"));
		selectAdults.click();
		selectAdults.click();
		WebElement selectChild = driver.findElement(By.cssSelector("#stepper-children > button:nth-child(3)"));
		selectChild.click();
		//click on search button
		WebElement clickingOnSearchButton = driver.findElement(By.cssSelector(".bhtghtc"));
		clickingOnSearchButton.click();
			}
	
	@Test 

	public void moreFilter() {
		//sclick on more filter button
		WebElement moreFilter =	driver.findElement(By.cssSelector(".t7zgiao"));
		moreFilter.click();
		//scroll down
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)");
		//search the for 5 beds
		WebElement select5bed = driver.findElement(By.cssSelector("div.iyjejn8:nth-child(2) > div:nth-child(2) > div:nth-child(6) > button:nth-child(1) > span:nth-child(1)")) ;
		select5bed.click();
		//active bool option
		WebElement showmore = driver.findElement(By.cssSelector("html.scrollbar-gutter.js-focus-visible.g5l85gq body.with-new-header div section div.cbkooad.dir.dir-ltr div.p1psejvv.dir.dir-ltr div.p1psejvv.dir.dir-ltr div.d1pe7dt2.drp3lcp.dir.dir-ltr div.cjzf2hd.dir.dir-ltr div.s37x9t1.dir.dir-ltr div.c1yo0219.dir.dir-ltr div div.s6ytrwv.dir.dir-ltr div.cprefbo.atm_j3_16vdio1.atm_lh_lhj8ft.atm_lb_sgh2xq.atm_mk_h2mmj6.atm_jb_hktyoi__oggzyc.atm_92_1yyfdc7_9in345.atm_9s_1ulexfb_9in345.atm_mk_stnw88_9in345.atm_26_1o0nnai_9in345.atm_e2_t94yts_9in345.atm_fq_k75hcd_9in345.atm_n3_k75hcd_9in345.atm_6i_idpfg4_9in345.dir.dir-ltr section div.h1dyxq2n.dir.dir-ltr div.lsqfxex.dir.dir-ltr button.l1ovpqvx.b1uxatsa.c1qih7tm.dir.dir-ltr span.l1d3yagp.dir.dir-ltr")) ;
		showmore.click();
		WebElement activeBool = driver.findElement(By.name("Pool")) ;
		activeBool.click();
		//click on search button
		WebElement clickingOnSearchButton2 = driver.findElement(By.cssSelector(".bmx2gr4"));
		clickingOnSearchButton2.click();
		//check that the result page contain 5beds
		String numberOFBeds = "5 beds";
    	String actualNumberBeds = driver.findElement(By.cssSelector(".gsgwcjk > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(3) > span:nth-child(1) > span:nth-child(1)")).getText();
    	Assert.assertEquals(actualNumberBeds,numberOFBeds);
   
			}
	@AfterTest
 	    public void closedriver() {
        driver.quit();

}
	
}
