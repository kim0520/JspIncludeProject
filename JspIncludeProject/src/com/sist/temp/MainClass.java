package com.sist.temp;

import java.io.File;

import javax.xml.parsers.SAXParserFactory;

import com.sun.org.apache.xerces.internal.parsers.SAXParser;

public class MainClass {
      
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			SAXParserFactory spf = SAXParserFactory.newInstance();
			Object sp = spf.newSAXParser();
			((javax.xml.parsers.SAXParser) sp).parse(new File("C:\\webDev\\webstudy\\JspIncludeProject\\WebContent\\xml\\dbcp.xml"), new XMLHandler());
		}catch(Exception ex) {}
	}
}
