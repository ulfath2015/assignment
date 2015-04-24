package com.imaginea.assignment.api;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public interface DataSource<T> {

	void initDataSource(String fileName) throws IOException;

	void initDataSource(File file) throws IOException;

	public Set<T> getData();

}
