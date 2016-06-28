import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UnreadMail 
{
    
    private static Scanner sc;

	public static void main(String[] args) throws InterruptedException 
    {
        sc = new Scanner(System.in);
        System.out.println("Enter your E-mail id");
        String[] id = {sc.nextLine()};
        System.out.println("Enter your Password");
        String[] pass = {sc.nextLine()};
        
        WebDriver driver = new FirefoxDriver();
        driver.get("https://accounts.google.com/ServiceLogin?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&hl=en&emr=1&elo=1");
        
        driver.findElement(By.id("Email")).sendKeys(id);
        driver.findElement(By.name("signIn")).click();
        Thread.sleep(2000);
        
        driver.findElement(By.id("Passwd")).sendKeys(pass);
        driver.findElement(By.id("signIn")).click();
        
        String inbox = driver.findElement(By.xpath("//a[@href='https://mail.google.com/mail/u/0/#inbox']")).getText();
        System.out.println(inbox+"\n");
        
        driver.close();
    }
    
}