package com.imaginea.assignment;

import java.io.File;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.imaginea.assignment.api.Matcher;

public class StringMatcherExecutor {

	public static final Logger LOG = LoggerFactory.getLogger(StringMatcherExecutor.class);

	public static void main(String args[]) throws IOException {

		StringDataSource sourceData = new StringDataSource();
		StringDataSource targetData = new StringDataSource();

		String sourceFile = "/File1.txt";
		String targetFile = "/File2.txt";

		int matchCount = 0;

		if (args.length == 2) {

			sourceFile = args[0];
			targetFile = args[1];
			sourceData.initDataSource(new File(sourceFile));
			targetData.initDataSource(new File(targetFile));
		}

		else {

			sourceData.initDataSource(sourceFile);
			targetData.initDataSource(targetFile);

		}

		Matcher<String> matcher = new StringMatcher();

		try {
			matchCount = matcher.getMatchStrings(sourceData.getData(), targetData.getData(), MatchType.EXACT).size();

			LOG.debug("#Exact match strings :" + matchCount);

			matchCount = matcher.getMatchStrings(sourceData.getData(), targetData.getData(), MatchType.SIMILAR).size();

			LOG.debug("#Similar strings :" + matchCount);

		} catch (MatcherException e) {

			LOG.error(e.getMessage());
		}
	}

}
