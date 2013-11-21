package com.santhyreddy.toolMethods;

import java.io.File;

public class ReusableMethods {
public static Boolean ifFileExists(String filePath)
{
	if(new File(filePath).exists())
	{
	return true;
	}
	else
	{
	return false;
	}	
}
}
