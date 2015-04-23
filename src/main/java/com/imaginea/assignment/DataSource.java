package com.imaginea.assignment;

import java.io.IOException;
import java.util.Set;

public interface DataSource<T> {

	void initDataSource(String fileName) throws IOException;

	public Set<T> getSourceData();

	public void setSourceData(Set<T> sourceText);

	public Set<T> getTargetData();

	public void setTargetData(Set<T> targetText);

}
