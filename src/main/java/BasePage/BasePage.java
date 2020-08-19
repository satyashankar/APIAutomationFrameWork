package BasePage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BasePage {
	
	public static Properties prop;
	
	public BasePage() throws IOException {
			
			try {			
			 prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\SandeepGoud\\eclipse-workspace\\RestApiAutommationFrameWork\\src\\main\\java\\ConfigProperties\\properties");
			
					prop.load(ip);
			
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
