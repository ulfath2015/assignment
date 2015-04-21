package com.imaginea.assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileComparator 
{
	private Properties props;
	public static final Logger LOG = LoggerFactory.getLogger(FileComparator.class);
	private Set<String> namesList1;
	private Set<String> namesList2;
	
	public FileComparator(String propFile) {
		
		props = new Properties();

		try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFile)) {

			if (inputStream != null) {
				props.load(inputStream);
				namesList1 = new HashSet<String>(Files.readAllLines(new File(props.get("FILE1").toString()).toPath(),Charset.forName("UTF-8")));
				namesList2 = new HashSet<String>(Files.readAllLines(new File(props.get("FILE2").toString()).toPath(),Charset.forName("UTF-8")));
			} 
			else {
				throw new FileNotFoundException("property file '" + propFile + "' not found in the classpath");
			}
		} catch (FileNotFoundException e) {
			LOG.error("file not found exception" + e );
		} catch (IOException e) {
			LOG.error("io exception" + e );
		}
		
	}
	
	
    public Set<String> findMatchingStrings(){
    	
	   
	   Set<String> matchedString = new HashSet<String>();
    	for( String name : namesList1 ){
		    if(compare(name)){
		    	matchedString.add(name);
		    }
		}
		
		LOG.debug("number of matching string :" + matchedString.size());
		
    	return matchedString;
    	
    	
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
