package com.imaginea.assignment;

import java.util.Set;

public interface Matcher<T> {

	public Set<T> getMatchStrings(Set<T> sourceText, Set<T> targetText, MatchType matchType);

	public boolean isMatch(T sourceText, T targetText);

}
