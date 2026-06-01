package com.valuenable.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.valuenable.pages.HomePage;
import com.valuenable.pojo.PolicyPerformanceData;
import com.valuenable.utilities.ExcelWriterUtility;
import com.valuenable.utilities.ValidationManager;

public class ULAutomation extends BaseTest {

    private HomePage homePage;

    private ValidationManager validationManager;

    @BeforeMethod
    public void LoginIntoApplication() {

        validationManager =
                new ValidationManager();

        homePage = login
                .enterEmail("swapnil@valuenable.in")
                .enterPassword("Valuenable@123")
                .clickOnLoginButton(validationManager);
    }

    @AfterMethod
    public void saveResults() {

        validationManager.clear();
    }

    @Test(
            dataProviderClass =
            com.valuenable.dataProvider.PolicyDataProvider.class,

            dataProvider = "policyData"
    )
    public void GoToAllPolicy(
            PolicyPerformanceData data) {

        homePage.navigateToAllPolicy();

        boolean policyFound =
                homePage.searchPolicyBy(
                        data.getPolicyNo());

        if (!policyFound) {

            ExcelWriterUtility.writePolicyStatus(
                    data.getExcelRowNum(),
                    "POLICY NOT FOUND",
                    "Policy does not exist in application");

            return;
        }

        // =====================================================
        // BASIC PERFORMANCE TABLE
        // =====================================================

        homePage.validatePolicyPerformanceTable(

                data.getExcelRowNum(),

                data.getPremiumPaid(),
                data.getFoundValue(),
                data.getReturns(),
                data.getCharges());

        // =====================================================
        // DON'T PAY JUST STAY
        // =====================================================

        homePage

        .navigateToPayConveneienceTab()

        .selectPayOption("Don't Pay Just Stay")

        .validate_FirstTable(

                data.getExcelRowNum(),
                32,

                data.getP0_T1_8(),
                data.getP0_T1_4(),
                data.getP0_T1_Historical_rat())

        .validateSecondTableValues(

                data.getExcelRowNum(),
                36,

                data.getP0_T2_R1_8(),
                data.getP0_T2_R1_4(),
                data.getP0_T2_R1_Historical_Growth(),

                data.getP0_T2_R2_8(),
                data.getP0_T2_R2_4(),
                data.getP0_T2_R2_Historical_Growth(),

                data.getP0_T2_R3_8(),
                data.getP0_T2_R3_4(),
                data.getP0_T2_R3_Historical_Growth())

        // =====================================================
        // PAY 1 AND STAY
        // =====================================================

        .selectPayOption("Pay 1 and Stay")

        .validate_FirstTable(

                data.getExcelRowNum(),
                6,

                data.getP1_T1_8(),
                data.getP1_T1_4(),
                data.getP1_T1_Historical_rate())

        .validateSecondTableValues(

                data.getExcelRowNum(),
                10,

                data.getP1_T2_R1_8(),
                data.getP1_T2_R1_4(),
                data.getP1_T2_R1_Historical_Growth(),

                data.getP1_T2_R2_8(),
                data.getP1_T2_R2_4(),
                data.getP1_T2_R2_Historical_Growth(),

                data.getP1_T2_R3_8(),
                data.getP1_T2_R3_4(),
                data.getP1_T2_R3_Historical_Growth())

        // =====================================================
        // PAY 3 AND STAY
        // =====================================================

        .selectPayOption("Pay 3 and Stay")

        .validate_FirstTable(

                data.getExcelRowNum(),
                19,

                data.getP3_T1_8(),
                data.getP3_T1_4(),
                data.getP3_T1_Historical_rat())

        .validateSecondTableValues(

                data.getExcelRowNum(),
                23,

                data.getP3_T2_R1_8(),
                data.getP3_T2_R1_4(),
                data.getP3_T2_R1_Historical_Growth(),

                data.getP3_T2_R2_8(),
                data.getP3_T2_R2_4(),
                data.getP3_T2_R2_Historical_Growth(),

                data.getP3_T2_R3_8(),
                data.getP3_T2_R3_4(),
                data.getP3_T2_R3_Historical_Growth())

        // =====================================================
        // PAY AS PER ORIGINAL
        // =====================================================

        .closePayConveience()

        .navigateToPayAsPerConvenience()

        .validate_FirstTable(

                data.getExcelRowNum(),
                45,

                data.getPayOriginal_T1_8(),
                data.getPayOriginal_T1_4(),
                data.getPayOriginal_T1_Historical_rat())

        .validateSecondTableValues(

                data.getExcelRowNum(),
                49,

                data.getPayOriginal_T2_R1_8(),
                data.getPayOriginal_T2_R1_4(),
                data.getPayOriginal_T2_R1_Historical_Growth(),

                data.getPayOriginal_T2_R2_8(),
                data.getPayOriginal_T2_R2_4(),
                data.getPayOriginal_T2_R2_Historical_Growth(),

                data.getPayOriginal_T2_R3_8(),
                data.getPayOriginal_T2_R3_4(),
                data.getPayOriginal_T2_R3_Historical_Growth());

        // =====================================================
        // FINAL STATUS
        // =====================================================

        if (validationManager.hasFailures()) {

            validationManager.writeResults();

            ExcelWriterUtility.writePolicyStatus(

                    data.getExcelRowNum(),

                    "FAIL",

                    validationManager
                            .getFailures()
                            .size()

                            + " validation mismatch(es)");

        } else {

            ExcelWriterUtility.writePolicyStatus(

                    data.getExcelRowNum(),

                    "PASS",

                    "All validations passed");
        }
    }
}