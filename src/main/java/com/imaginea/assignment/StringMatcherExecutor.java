package com.imaginea.assignment;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.imaginea.assignment.api.Matcher;

public class StringMatcherExecutor {

	public static final Logger LOG = LoggerFactory.getLogger(StringMatcherExecutor.class);

	public static void main(String args[]) throws IOException, MatcherException {

		String sourceFile = "src/main/resources/File1.txt";
		String targetFile = "src/main/resources/File2.txt";
		if (args.length == 2) {

			sourceFile = args[0];
			targetFile = args[1];
		}

		int matchCount = 0;
		StringDataSource sourceData = new StringDataSource();
		sourceData.initDataSource(sourceFile);

		StringDataSource targetData = new StringDataSource();
		targetData.initDataSource(targetFile);

		Matcher<String> matcher = new StringMatcher();
		
		matchCount = matcher.getMatchStrings(sourceData.getData(), targetData.getData(), MatchType.EXACT).size();

		LOG.debug("#Exact match strings :" + matchCount);

		matchCount = matcher.getMatchStrings(sourceData.getData(), targetData.getData(), MatchType.SIMILAR).size();

		LOG.debug("#Similar strings :" + matchCount);
		
	}

}
