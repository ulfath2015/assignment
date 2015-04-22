package com.imaginea.assignment;

import java.util.Set;

public interface Matcher {

	public Set<String> getMatchStrings(Set<String> sourceText, Set<String> targetText, MatchType matchType);

	public boolean isMatch(String sourceText, String targetText);

}
