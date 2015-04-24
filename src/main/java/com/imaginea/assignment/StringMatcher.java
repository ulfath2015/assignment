package com.imaginea.assignment;

import java.util.HashSet;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.imaginea.assignment.api.Matcher;

public class StringMatcher implements Matcher<String>
{
	public static final Logger LOG = LoggerFactory.getLogger(StringMatcher.class);

	public Set<String> getMatchStrings(Set<String> sourceText, Set<String> targetText, MatchType matchType)
			throws MatcherException {

		switch (matchType) {

			case EXACT:
				return exactMatch(sourceText, targetText);

			case SIMILAR:
				return similarMatch(sourceText, targetText);

			default:
				throw new MatcherException("Invalid match type : " + matchType);
		}

	}

	private Set<String> similarMatch(Set<String> sourceText, Set<String> targetText) {

		Set<String> commonText = new HashSet<String>();

		for (String name : sourceText) {
			for (String targetName : targetText) {
				if (isMatch(name, targetName)) {
					commonText.add(name);
				}
			}
		}

		return commonText;
	}

	private Set<String> exactMatch(Set<String> sourceText, Set<String> targetText) {

		Set<String> commonText = new HashSet<String>();
		commonText.addAll(sourceText);
		commonText.retainAll(targetText);
		return commonText;

	}

	public boolean isMatch(String sourceText, String targetText) {

		String[] sourceTextParts = sourceText.split(" ");
		String[] targetTextParts = targetText.split(" ");
		boolean result = true;

		int smallerNameLength = sourceTextParts.length > targetTextParts.length ? targetTextParts.length
				: sourceTextParts.length;

		for (int i = 0; i < smallerNameLength; i++) {

			if (!sourceTextParts[i].equalsIgnoreCase(targetTextParts[i])) {
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
