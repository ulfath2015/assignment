package com.imaginea.assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataSource {

	private Properties props;
	public static final Logger LOG = LoggerFactory.getLogger(DataSource.class);
	private Set<String> sourceText;
	private Set<String> targetText;

	public DataSource() {

		props = new Properties();
	}
	
	void initDataSource( String fileName ) throws IOException {
		
		try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName)) {

			if (inputStream != null) {
				props.load(inputStream);
				sourceText = new HashSet<String>(Files.readAllLines(
						new File(props.get("SOURCE1").toString()).toPath(), Charset.forName("UTF-8")));
				targetText = new HashSet<String>(Files.readAllLines(
						new File(props.get("SOURCE2").toString()).toPath(), Charset.forName("UTF-8")));
			}
			else {
				throw new FileNotFoundException("property file '" + fileName + "' not found");
			}

		}
	}

	public Set<String> getSourceText() {
		return sourceText;
	}

	public void setSourceNames(Set<String> sourceText) {
		this.sourceText = sourceText;
	}

	public Set<String> getTargetText() {
		return targetText;
	}

	public void setTargetNames(Set<String> targetText) {
		this.targetText = targetText;
	}

}
