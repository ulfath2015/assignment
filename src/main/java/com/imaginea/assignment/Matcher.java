package com.imaginea.assignment;

import java.util.Set;

public interface Matcher {

	public Set<String> getMatchStrings(Set<String> sourceNames, Set<String> targetNames, MATCHTYPE matchType);

	public boolean isMatch(String sourceName, String targetName);

}
