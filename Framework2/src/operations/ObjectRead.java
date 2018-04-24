package operations;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ObjectRead {
	Properties pro = new Properties();
	 
	public Properties getObjectRepository() throws IOException{
		//Read the object repository (object.properties)
		InputStream stream = new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\objects\\object.properties"));
		//load the properties file
		pro.load(stream);
		return pro;
	}

}
