package com.finkurs.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.finkurs.testbase.TestBase;

public class UsdRateTestCase extends TestBase {

	@Test(groups = { "group" })
	// TS 1.1
	public void UsdVerificationPage() {
		finHome.moveToNbu(websiteFinUrl);
		System.out.println("TestPath = " + pathToExcelFile);
		finNbu.currencyVerification(finNbu.NbuUsd, websiteFinUrl, "USD",
				pathToExcelFile);
		kursHome.moveToMigBank(websiteKursUrl);
		kursMig.currencyVerification(kursMig.MigUsd, websiteKursUrl, "USD",
				pathToExcelFile);
		Assert.assertTrue(kursMig.checkResultKurs("USD", pathToExcelFile),
				"Kurs USD difference is more than 30%");
	}

}
