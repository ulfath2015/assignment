package com.imaginea.assignment;

import java.io.IOException;
import java.util.Set;

public interface DataSource<T> {
	
	void initDataSource( T fileName ) throws IOException;
	public Set<T> getSourceText();
	public void setSourceNames(Set<T> sourceText);
	public Set<T> getTargetText();
	public void setTargetNames(Set<T> targetText);

	}
