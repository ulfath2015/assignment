package com.imaginea.assignment;

import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

public class FileComparatorTest {

	FileComparator fileComparator;

	@Before
	public void init() throws IOException {
		fileComparator = new FileComparator("FileNames.properties");
	}

	@Test
	public void findMatchingStringsTest() {

		assertTrue(fileComparator.findMatchingStrings().size() > 76);

	}
}
