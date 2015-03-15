package com.finkurs.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.finkurs.testbase.TestBase;

public class EurRateTestCase extends TestBase {

	@Test(groups = { "group" })
	// TS 1.1
	public void EurVerificationPage() {
		finHome.moveToNbu(websiteFinUrl);
		System.out.println("TestPath = " + pathToExcelFile);
		finNbu.currencyVerification(finNbu.NbuEur, websiteFinUrl, "EUR",
				pathToExcelFile);
		kursHome.moveToMigBank(websiteKursUrl);
		kursMig.currencyVerification(kursMig.MigEur, websiteKursUrl, "EUR",
				pathToExcelFile);
		Assert.assertTrue(kursMig.checkResultKurs("EUR", pathToExcelFile),
				"Kurs EUR difference is more than 30%");
	}
}
