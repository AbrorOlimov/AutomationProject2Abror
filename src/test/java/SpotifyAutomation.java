import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class SpotifyAutomation {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://open.spotify.com/");

        driver.findElement(By.xpath("//span[contains(text(), 'Log in')]")).click();

        driver.findElement(By.xpath("//input[@id='login-username']")).sendKeys("wiuterian2019@gmail.com", Keys.TAB, "sdet1234", Keys.ENTER);

        WebElement icon = driver.findElement(By.xpath("//div[@class='KdxlBanhDJjzmHfqhP0X Q4hOdDPRDHPhfou2xbDg m95Ymx847hCaxHjmyXKX']"));
        Assert.assertTrue( icon.isDisplayed());

        driver.findElement(By.xpath("//span[contains(text(), 'Search')]")).click();
        driver.findElement(By.xpath("//input[@class = 'Type__TypeElement-sc-goli3j-0 ieTwfQ QO9loc33XC50mMRUCIvf']")).sendKeys("Adele Hello", Keys.ENTER);

        driver.findElement(By.xpath("//img[@class = 'mMx2LUixlnN_Fu45JpFB rkw8BWQi3miXqtlJhKg0 Yn2Ei5QZn19gria6LjZj']")).click();

        String songName = driver.findElement(By.xpath("//a[@data-testid='context-item-link']")).getText();
        Assert.assertTrue(songName.equals("Hello"));

        String artist = driver.findElement(By.xpath("//a[@data-testid='context-item-info-artist']")).getText();
        Assert.assertTrue(artist.equals("Adele"));

        Thread.sleep(5000);

        driver.findElement(By.xpath("//div[@class='KdxlBanhDJjzmHfqhP0X Q4hOdDPRDHPhfou2xbDg m95Ymx847hCaxHjmyXKX']")).click();

        driver.findElement(By.xpath("//span[contains(text(), 'Log out')]")).click();

        WebElement logInBtn = driver.findElement(By.xpath("//span[contains(text(), 'Log in')]"));
        Assert.assertTrue( logInBtn.isDisplayed());
        Thread.sleep(1000);

        driver.quit();

    }
}
