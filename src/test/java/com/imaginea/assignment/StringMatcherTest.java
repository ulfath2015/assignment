package com.imaginea.assignment;

import static org.junit.Assert.assertTrue;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import com.imaginea.assignment.api.Matcher;

public class StringMatcherTest {

	StringDataSource sourceData;
	StringDataSource targetData;
	Matcher matcher;

	@Before
	public void init() throws IOException, MatcherException {

		sourceData = new StringDataSource();
		sourceData.initDataSource("src/test/resources/File1.txt");
		targetData = new StringDataSource();
		targetData.initDataSource("src/test/resources/File2.txt");
		matcher = new StringMatcher();

	}

	@Test
	public void getMatchStringTest() throws MatcherException {

		assertTrue(matcher.getMatchStrings(sourceData.getData(), targetData.getData(), MatchType.SIMILAR)
				.size() > 76);
		
		assertTrue(matcher.getMatchStrings(sourceData.getData(), targetData.getData(), MatchType.EXACT)
				.size() == 76);
		
		

	}
	
	@Test
	public void isMatchTest(){
		
		assertTrue(matcher.isMatch("manish kumar pandey", "manish kumar"));
		assertTrue(!matcher.isMatch("manish pandey", "manish kumar"));
		
	}
}
