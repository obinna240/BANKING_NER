package com.search;

import java.io.File;
import java.io.IOException;


import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;



public class Prepare 
{
	private static String convertToLowerCase(String string)
	{
		if(StringUtils.isNotBlank(string))
		{
			string = StringUtils.lowerCase(string);
			string = StringUtils.normalizeSpace(string.replaceAll("[\\W]", " "));
			
		}
		return string;
	}
	
	public static void prepareFile(String fileName, String newFile)
	{
		String filstring = "";
		try {
			filstring = FileUtils.readFileToString(new File(fileName));
			filstring = convertToLowerCase(filstring);
			FileUtils.write(new File(newFile), filstring, "UTF-8");
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	
	
	public static void main(String[] args)
	{
		File dirs = new File("C:/Users/oonyimadu/Documents/PHD/DB/Documents");
		String[] farr = dirs.list();
		for(String fname:farr)
		{
			prepareFile("C:/Users/oonyimadu/Documents/PHD/DB/Documents"+"/"+fname,"C:/Users/oonyimadu/Documents/PHD/DB/PreparedDocuments"+"/"+fname);
		}
	}


}
