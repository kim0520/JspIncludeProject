package com.sist.temp;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.sql.DataSource;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLHandler extends DefaultHandler{

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
	
		try
		{
			if(qName.equals("Resource"))
			{
				String driver=attributes.getValue("driverClassName");
				String url=attributes.getValue("url");
				String username=attributes.getValue("username");
				String password=attributes.getValue("password");
			/*	Class clsName =Class.forName(attributes.getValue("type"));
				DataSource ds =(DataSource)clsName.newInstance();*/
				System.out.println("driver:"+driver);
				System.out.println("url:"+url);
				System.out.println("username:"+username);
				System.out.println("password:"+password);
				
				Class.forName(driver);
				for(int i=0;i<5;i++)
				{
				
					Connection conn=DriverManager.getConnection(url,username,password);
				    System.out.println((i+1)+":"+conn);
				}
			}
		}catch(Exception ex) {}
	}

	

}
