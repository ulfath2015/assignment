package com.imaginea.assignment;

import java.util.HashSet;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringMatcher implements Matcher
{
	public static final Logger LOG = LoggerFactory.getLogger(StringMatcher.class);

	public Set<String> getMatchStrings(Set<String> sourceText, Set<String> targetText, MATCHTYPE matchType) {

		Set<String> matchedText = new HashSet<String>();

		switch (matchType) {

			case EXACT:
				return exactMatch(sourceText, targetText);

			case SIMILAR:
				return similarMatch(sourceText, targetText, matchedText);
		}

		return matchedText;

	}

	private Set<String> similarMatch(Set<String> sourceText, Set<String> targetText, Set<String> commonSet) {

		for (String name : sourceText) {
			for (String targetName : targetText) {
				if (isMatch(name, targetName)) {
					commonSet.add(name);
				}
			}
		}

		return commonSet;
	}

	private Set<String> exactMatch(Set<String> sourceText, Set<String> targetText) {

		sourceText.retainAll(targetText);
		return sourceText;

	}

	public boolean isMatch(String sourceText, String targetText) {

		String[] sourceNameParts = sourceText.split(" ");
		String[] targetNameParts = targetText.split(" ");
		boolean result = true;

		int smallerNameLength = sourceNameParts.length > targetNameParts.length ? targetNameParts.length
				: sourceNameParts.length;

		for (int i = 0; i < smallerNameLength; i++) {

			if (!sourceNameParts[i].equalsIgnoreCase(targetNameParts[i])) {
				result = false;
				break;
			}

		}

		if (result) {
			LOG.debug(sourceText + " ~= " + targetText);
		}

		return result;
	}
}
