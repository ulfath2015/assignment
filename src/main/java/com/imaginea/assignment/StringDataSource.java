package com.imaginea.assignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.imaginea.assignment.api.DataSource;

public class StringDataSource implements DataSource<String> {

	public static final Logger LOG = LoggerFactory.getLogger(StringDataSource.class);
	private Set<String> sourceText;

	public void initDataSource(File file) throws IOException {
		sourceText = new HashSet<String>(Files.readAllLines(Paths.get(file.getPath()), Charset.forName("UTF-8")));
	}

	public void initDataSource(String fileName) throws IOException {

		sourceText = new HashSet<String>();
		BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(fileName)));
		String lineText = null;
		while ((lineText = br.readLine()) != null) {
			sourceText.add(lineText);
		}
	}

	public Set<String> getData() {
		return sourceText;
	}

}
