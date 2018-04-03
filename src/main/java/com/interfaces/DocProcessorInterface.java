package com.interfaces;

import java.io.InputStream;
import java.util.List;

import com.object.DBDoc;

public interface DocProcessorInterface 
{
	
	public List<DBDoc> extractDocumentFromXML(String xmlFile);
	public DBDoc extractNamedEntities(String text);
	public void extractNamedEntities(InputStream inputStream);
}
