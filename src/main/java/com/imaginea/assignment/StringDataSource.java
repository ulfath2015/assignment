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
import com.imaginea.assignment.api.DataSource;

public class StringDataSource implements DataSource<String> {

	public static final Logger LOG = LoggerFactory.getLogger(StringDataSource.class);
	private Set<String> sourceText;

	public void initDataSource(String fileName) throws MatcherException {

		try {
			sourceText = new HashSet<String>(Files.readAllLines(
					new File(fileName).toPath(), Charset.forName("UTF-8")));
		} catch (IOException exception) {

			throw new MatcherException(exception.getMessage());

		}

	}

	public Set<String> getData() {
		return sourceText;
	}

}
