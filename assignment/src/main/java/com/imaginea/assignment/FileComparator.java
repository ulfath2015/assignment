package com.imaginea.assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileComparator 
{
	private Properties props;
	public static final Logger LOG = LoggerFactory.getLogger(FileComparator.class);
	File file1,file2;
	
	public FileComparator(String propFile) throws IOException {
		
		props = new Properties();

		try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFile)) {

			if (inputStream != null) {
				props.load(inputStream);
				file1 = new File(props.get("FILE1").toString());
				file2 = new File(props.get("FILE2").toString());
			} 
			else {
				throw new FileNotFoundException("property file '" + propFile + "' not found in the classpath");
			}
		}
	}
	
	
    public List<String> findMatchingStrings(){
    	
	   
	   List<String> stringList1 = null;
		List<String> stringList2 = null;
    	try {
			stringList1 = FileUtils.readLines(file1, "utf-8");
			stringList2 = FileUtils.readLines(file2, "utf-8");
			stringList1.retainAll(stringList2);
			
			for( String string : stringList1 ){
				LOG.debug(string);
			}
		} catch (IOException e) {
			
			LOG.info("exception occured" + e );
		}
    	return stringList1;
    	
    	
    }
}
