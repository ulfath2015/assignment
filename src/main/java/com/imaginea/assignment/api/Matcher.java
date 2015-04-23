package com.imaginea.assignment.api;

import java.util.Set;
import com.imaginea.assignment.MatchType;
import com.imaginea.assignment.MatcherException;

public interface Matcher<T> {

	public Set<T> getMatchStrings(Set<T> sourceText, Set<T> targetText, MatchType matchType) throws MatcherException;

	public boolean isMatch(T sourceText, T targetText);

}
