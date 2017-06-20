package Advanced;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Popups_Handling {
	static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","E:\\geckodriver-v0.17.0-win64\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("http://qtpselenium.com/test/unpredictable.php");
		closePopupIfPresent();
	

	}

	private static void closePopupIfPresent() {
		Set<String>winIds=driver.getWindowHandles();
		System.out.println("Total Windows"+winIds.size());
		
		if(winIds.size() == 2){
			Iterator<String>iter=winIds.iterator();
			String mainWinID=iter.next();
			String popupWinID=iter.next();
			driver.switchTo().window(popupWinID);
			driver.close();
			driver.switchTo().window(mainWinID);
			
			
			
		}
		
		
	}

}
