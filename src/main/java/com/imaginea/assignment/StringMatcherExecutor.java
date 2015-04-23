package com.imaginea.assignment;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringMatcherExecutor {

	public static final Logger LOG = LoggerFactory.getLogger(StringMatcherExecutor.class);

	public static void main(String args[]) throws IOException {

		String propFile = "DataSource.properties";
		int matchCount = 0;

		StringDataSource dataSource = new StringDataSource();
		dataSource.initDataSource(propFile);

		Matcher matcher = new StringMatcher();

		matchCount = matcher.getMatchStrings(dataSource.getSourceText(), dataSource.getTargetText(), MatchType.SIMILAR)
				.size();

		LOG.debug("#Similar strings :" + matchCount);
	}

}
