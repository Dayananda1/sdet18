package com.rmgyantra.genricLibs;

import java.util.Random;
/**
 * this is going generate a random number
 * @author Dayananda
 *
 */
public class JavaUtility 
{
	public int randomNumber() 
	{
		Random random = new Random();
		int randomData=random.nextInt(5000);
		return randomData;
	}

}
