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

public class StringDataSource implements DataSource<String> {

	private Properties props;
	public static final Logger LOG = LoggerFactory.getLogger(StringDataSource.class);
	private Set<String> sourceText;
	private Set<String> targetText;

	public StringDataSource() {

		props = new Properties();
	}

	public void initDataSource(String fileName) throws IOException {

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

	public Set<String> getSourceData() {
		return sourceText;
	}

	public void setSourceData(Set<String> sourceText) {
		this.sourceText = sourceText;
	}

	public Set<String> getTargetData() {
		return targetText;
	}

	public void setTargetData(Set<String> targetText) {
		this.targetText = targetText;
	}

}
