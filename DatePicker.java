
package DatePicker;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import ACS_pesStream.Dashboard;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class DatePicker {

	public void datePicker(int req_date,int req_month_no,int req_year){


        driver.findElement(By.xpath("//android.widget.EditText[@text='Date']")).click();
				Date date=new Date();
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
				simpleDateFormat.applyPattern("YYYY");
				int year=Integer.parseInt(simpleDateFormat.format(date));
				simpleDateFormat.applyPattern("MM");
				int month_no=Integer.parseInt(simpleDateFormat.format(date));
        
      Dimension dim = driver.manage().window().getSize();
			int height = dim.getHeight();
			int width = dim.getWidth();
			TouchAction ts = new TouchAction(driver);
        
				for(int j=year;j<=req_year;j++)
					{
						for(int i=month_no;i<=12;i++)
						{
							
							ts.press(PointOption.point((int)(width*0.80),(int)(height/2))).moveTo(PointOption.point((int)(width*0.30),(int)(height/2))).release().perform();

							if(i==req_month_no && j==req_year)
							{				
								req_date=req_date-1;
								driver.findElement(By.xpath("//android.view.View[@text='"+req_date+"']")).click();
								driver.findElement(By.xpath("//android.widget.Button[@text='OK']")).click();
								break;
							}						
						}month_no=1;
					}
