package com.imaginea.assignment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringMatcherExecutor {

	public static final Logger LOG = LoggerFactory.getLogger(StringMatcherExecutor.class);

	public static void main(String args[]) {

		String propFile = args.length > 0 ? args[0] : "DataSource.properties";
		int matchCount = 0;
		DataSource dataSource = new DataSource(propFile);
		Matcher matcher = new StringMatcher();
		matchCount = matcher.getMatchStrings(dataSource.getSourceText(), dataSource.getTargetText(), MATCHTYPE.SIMILAR)
				.size();
		LOG.debug("#Similar strings :" + matchCount);
	}

	public StringMatcherExecutor(String propFile) {

	}

}
