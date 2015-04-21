package com.imaginea.assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileComparator 
{
	private Properties props;
	public static final Logger LOG = LoggerFactory.getLogger(FileComparator.class);
	private List<String> namesList1;
	private List<String> namesList2;
	
	public FileComparator(String propFile) throws IOException {
		
		props = new Properties();

		try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFile)) {

			if (inputStream != null) {
				props.load(inputStream);
				namesList1 = Files.readAllLines(new File(props.get("FILE1").toString()).toPath(),Charset.forName("UTF-8"));
				namesList2 = Files.readAllLines(new File(props.get("FILE2").toString()).toPath(),Charset.forName("UTF-8"));
			} 
			else {
				throw new FileNotFoundException("property file '" + propFile + "' not found in the classpath");
			}
		}
		
	}
	
	
    public List<String> findMatchingStrings(){
    	
	   
	   List<String> matchingString = new ArrayList<String>();
    	for( String name : namesList1 ){
		    if(compare(name)){
		    	matchingString.add(name);
		    }
		}
		
		LOG.debug("number of matching string :" + matchingString.size());
    	return namesList1;
    	
    	
    }


	private boolean compare(String sourceName) {
		
		String[] sourceNameParts = sourceName.split(" ");
		for( String targetName : namesList2 ){
			
			boolean result = true;
			String targetNameParts[] = targetName.split(" ");
			int smallerNameLength = sourceNameParts.length > targetNameParts.length ? targetNameParts.length : sourceNameParts.length;
			for(int i=0;i<smallerNameLength;i++){
				if(! sourceNameParts[i].equalsIgnoreCase(targetNameParts[i]) ){
					result = false;
					break;
				}
			}
			
			if(result){
				LOG.debug(sourceName + "~=" + targetName ); 
				return result;
			}
		}
		return false;
	}
}
