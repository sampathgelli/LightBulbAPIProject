package com.qantas.lightbulb.api.test.stepDefs;

import org.junit.rules.ErrorCollector;

import java.util.Properties;

public class GenericDeclarationClass {
	
	public static String Configpath=System.getProperty("user.dir")+"\\config.properties";
	public final ErrorCollector collector= new ErrorCollector();
	public static Properties prop;
}
