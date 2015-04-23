package com.imaginea.assignment.api;

import java.io.IOException;
import java.util.Set;
import com.imaginea.assignment.MatcherException;

public interface DataSource<T> {

	void initDataSource(String fileName) throws MatcherException;

	public Set<T> getData();

}
