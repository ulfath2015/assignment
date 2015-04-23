package com.imaginea.assignment;

import static org.junit.Assert.assertTrue;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

public class FileComparatorTest {

	StringDataSource dataSource;
	Matcher matcher;

	@Before
	public void init() throws IOException {

		dataSource = new StringDataSource();
		dataSource.initDataSource("DataSource.properties");
		matcher = new StringMatcher();

	}

	@Test
	public void getMatchStringTest() {

		assertTrue(matcher.getMatchStrings(dataSource.getSourceData(), dataSource.getTargetData(), MatchType.SIMILAR)
				.size() > 76);
		
		assertTrue(matcher.isMatch("manish kumar pandey", "manish kumar"));

	}
}
