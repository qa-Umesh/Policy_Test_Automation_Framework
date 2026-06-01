package com.valuenable.dataProvider;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.valuenable.pojo.PolicyPerformanceData;
import com.valuenable.utilities.ExcelReaderUtility;

public class PolicyDataProvider {
	
    @DataProvider(name = "policyData",parallel = false)
    public Object[][] getPolicyData() {

        List<PolicyPerformanceData> policyList =
                ExcelReaderUtility.getPolicyData();

        Object[][] data =
                new Object[policyList.size()][1];

        for (int i = 0; i < policyList.size(); i++) {

            data[i][0] = policyList.get(i);
        }

        return data;
    }

}
