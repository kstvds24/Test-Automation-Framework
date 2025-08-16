package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.constants.ENV;
import com.utility.JSONUtility;

public class MyRetryAnalyzer implements IRetryAnalyzer {
//private static final int MAX_NO_OF_ATTEMPTS = Integer.parseInt(PropertiesUtility.readProperty(ENV.QA, "MAX_NUMBER_OF_ATTEMPTS"));
	private static final int MAX_NO_OF_ATTEMPTS = JSONUtility.readjson(ENV.QA).getMAX_NUMBER_OF_ATTEMPTS();
	private static int currentAttempts = 1;

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if (currentAttempts <= MAX_NO_OF_ATTEMPTS) {
			currentAttempts++;
			return true;
		}
		return false;
	}

}
