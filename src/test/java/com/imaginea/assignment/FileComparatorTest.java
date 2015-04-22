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

		dataSource = new DataSource();
		dataSource.initDataSource("DataSource.properties");
		matcher = new StringMatcher();

	}

	@Test
	public void getMatchStringTest() {

		assertTrue(matcher.getMatchStrings(dataSource.getSourceText(), dataSource.getTargetText(), MatchType.SIMILAR)
				.size() > 76);

	}
}
