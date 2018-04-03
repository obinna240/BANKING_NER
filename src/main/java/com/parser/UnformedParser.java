package com.parser;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.transform.sax.SAXSource;

import net.sf.saxon.s9api.SaxonApiException;
import net.sf.saxon.s9api.XdmNode;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.ccil.cowan.tagsoup.Parser;
import org.dom4j.DocumentException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.xmlcalabash.core.XProcConfiguration;
import com.xmlcalabash.core.XProcException;
import com.xmlcalabash.core.XProcRuntime;

public class UnformedParser 
{
	private XdmNode readAndConvertUnformedXML(String readTextFile) 
	{
			XdmNode doc = null;	
			File f = new File(readTextFile);
		
			String fs = "";
			try 
			{
				fs = FileUtils.readFileToString(f, "utf-8");
				StringReader inputStream = new StringReader(fs);
			    InputSource source = new InputSource(inputStream);
			   Parser parser = new Parser();
			   XProcRuntime runtime = new XProcRuntime(new XProcConfiguration());
			    parser.setEntityResolver(runtime.getResolver());
			    SAXSource saxSource = new SAXSource(parser, source);
			    net.sf.saxon.s9api.DocumentBuilder builder = runtime.getProcessor().newDocumentBuilder();
			    //try 
			   // {
			        
					try {
						doc = builder.build(saxSource);
					} catch (SaxonApiException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			        
			   // } 
			   // catch (Exception e)
			   // {
			    //    throw new XProcException(e);
			   // }
			} 
			catch (IOException e1)
			{
				System.out.println("");
				e1.printStackTrace();
			}
			
			return doc; 
	}
	
	/**
	 * Converts unformed Text File to Well formed XML
	 * @param readUnformedTextFile
	 * @param writeWellFormedXml
	 */
	public void convertToWellFormedXml(String readUnformedTextFile, String writeWellFormedXml)
	{
		XdmNode xdmObject =  readAndConvertUnformedXML(readUnformedTextFile);
		try 
		{
			if(xdmObject!=null)
			{
				FileUtils.write(new File(writeWellFormedXml), xdmObject.toString(), "UTF-8");
			}
			else
			{
				System.out.println("Object is null");
				return;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		System.out.println("Enter text file i.e sample_news.txt and the name of the xml file to return e.g sample_news.xml" );
		
		String sampleText = "";
		String writeXml = "";
		if(ArrayUtils.isNotEmpty(args))
		{
		sampleText = args[0];
		writeXml = args[1];
		}
		
		UnformedParser unformedParser = new UnformedParser();
		if(StringUtils.isNotBlank(sampleText) && StringUtils.isNotBlank(writeXml))
		{
			
			unformedParser.convertToWellFormedXml(sampleText, writeXml);
		}
		else if(StringUtils.isBlank(sampleText) && StringUtils.isBlank(writeXml))
		{
			unformedParser.convertToWellFormedXml("sample_news.txt", "writeXml");
			System.out.println("You must provide sample text and the name of an xml file to write to. However, the default sample_news.txt file has been written into well formed xml -- writeXml ");
		}
	}
}

/**
public static XdmNode x() throws IOException, DocumentException, SAXException
{
	File f = new File("sample_news.txt");
	
	String fs = FileUtils.readFileToString(f, "utf-8");
	 StringReader inputStream = new StringReader(fs);
	    InputSource source = new InputSource(inputStream);
	   Parser parser = new Parser();
	   XProcRuntime runtime = new XProcRuntime(new XProcConfiguration());
	    parser.setEntityResolver(runtime.getResolver());
	    SAXSource saxSource = new SAXSource(parser, source);
	    net.sf.saxon.s9api.DocumentBuilder builder = runtime.getProcessor().newDocumentBuilder();
	    try {
	        XdmNode doc = builder.build(saxSource);
	        return doc;
	    } catch (Exception e) {
	        throw new XProcException(e);
	    }
	
}

public static void main(String[] args) throws IOException, DocumentException, SAXException
{
	XdmNode c = x();
	FileUtils.write(new File("rewrittenXml.xml"), c.toString(), "UTF-8");
	//System.out.println(c.toString());
}
*/