package com.imaginea.assignment;

import static org.junit.Assert.assertTrue;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

public class FileComparatorTest {

	DataSource dataSource;
	Matcher matcher;

	@Before
	public void init() throws IOException {

		dataSource = new DataSource("DataSource.properties");
		matcher = new StringMatcher();

	}

	@Test
	public void getMatchStringTest() {

		assertTrue(matcher.getMatchStrings(dataSource.getSourceText(), dataSource.getTargetText(), MATCHTYPE.EXACT)
				.size() == 77);
		assertTrue(matcher.getMatchStrings(dataSource.getSourceText(), dataSource.getTargetText(), MATCHTYPE.SIMILAR)
				.size() > 76);

	}
}
