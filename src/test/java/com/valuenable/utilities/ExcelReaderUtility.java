package com.valuenable.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.valuenable.pojo.PolicyPerformanceData;

public class ExcelReaderUtility {

    public static List<PolicyPerformanceData> getPolicyData() {

        List<PolicyPerformanceData> policyList =
                new ArrayList<>();

        DataFormatter formatter =
                new DataFormatter();

        try {

            String filePath =
                    System.getProperty("user.dir")
                    + File.separator
                    + "TestData"
                    + File.separator
                    + "ULPolicySheet2.xlsx";

            FileInputStream fis =
                    new FileInputStream(filePath);

            XSSFWorkbook workbook =
                    new XSSFWorkbook(fis);

            XSSFSheet sheet =
                    workbook.getSheet("python_op");

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {

                Row row = sheet.getRow(i);

                if (row == null) {
                    continue;
                }

                PolicyPerformanceData data =
                        new PolicyPerformanceData();

                // =====================================================
                // BASIC DETAILS
                // =====================================================

                data.setPolicyNo(
                        formatter.formatCellValue(row.getCell(0)));
                
                if (data.getPolicyNo() == null
                        || data.getPolicyNo().trim().isEmpty()) {

                    continue;
                }

                data.setPremiumPaid(
                        formatter.formatCellValue(row.getCell(1)));

                data.setFoundValue(
                        formatter.formatCellValue(row.getCell(2)));

                data.setReturns(
                        formatter.formatCellValue(row.getCell(3)));

                data.setCharges(
                        formatter.formatCellValue(row.getCell(4)));
                
                
                // =====================================================
                // DON'T PAY JUST STAY
                // =====================================================

               

                data.setP0_T1_8(
                        formatter.formatCellValue(row.getCell(5)));

                data.setP0_T1_4(
                        formatter.formatCellValue(row.getCell(6)));

                data.setP0_T1_Historical_rat(
                        formatter.formatCellValue(row.getCell(7)));

                data.setP0_T2_R1_8(
                        formatter.formatCellValue(row.getCell(8)));

                data.setP0_T2_R1_4(
                        formatter.formatCellValue(row.getCell(9)));

                data.setP0_T2_R1_Historical_Growth(
                        formatter.formatCellValue(row.getCell(10)));

                data.setP0_T2_R2_8(
                        formatter.formatCellValue(row.getCell(11)));

                data.setP0_T2_R2_4(
                        formatter.formatCellValue(row.getCell(12)));

                data.setP0_T2_R2_Historical_Growth(
                        formatter.formatCellValue(row.getCell(13)));

                data.setP0_T2_R3_8(
                        formatter.formatCellValue(row.getCell(14)));

                data.setP0_T2_R3_4(
                        formatter.formatCellValue(row.getCell(15)));

                data.setP0_T2_R3_Historical_Growth(
                        formatter.formatCellValue(row.getCell(16)));



                // =====================================================
                // PAY 1 AND STAY
                // =====================================================

                data.setP1_T1_8(
                        formatter.formatCellValue(row.getCell(17)));

                data.setP1_T1_4(
                        formatter.formatCellValue(row.getCell(18)));

                data.setP1_T1_Historical_rate(
                        formatter.formatCellValue(row.getCell(19)));

                data.setP1_T2_R1_8(
                        formatter.formatCellValue(row.getCell(20)));

                data.setP1_T2_R1_4(
                        formatter.formatCellValue(row.getCell(21)));

                data.setP1_T2_R1_Historical_Growth(
                        formatter.formatCellValue(row.getCell(22)));

                data.setP1_T2_R2_8(
                        formatter.formatCellValue(row.getCell(23)));

                data.setP1_T2_R2_4(
                        formatter.formatCellValue(row.getCell(24)));

                data.setP1_T2_R2_Historical_Growth(
                        formatter.formatCellValue(row.getCell(25)));

                data.setP1_T2_R3_8(
                        formatter.formatCellValue(row.getCell(26)));

                data.setP1_T2_R3_4(
                        formatter.formatCellValue(row.getCell(27)));

                data.setP1_T2_R3_Historical_Growth(
                        formatter.formatCellValue(row.getCell(28)));

                // =====================================================
                // PAY 3 AND STAY
                // =====================================================

              

                data.setP3_T1_8(
                        formatter.formatCellValue(row.getCell(29)));

                data.setP3_T1_4(
                        formatter.formatCellValue(row.getCell(30)));

                data.setP3_T1_Historical_rat(
                        formatter.formatCellValue(row.getCell(31)));

                data.setP3_T2_R1_8(
                        formatter.formatCellValue(row.getCell(32)));

                data.setP3_T2_R1_4(
                        formatter.formatCellValue(row.getCell(33)));

                data.setP3_T2_R1_Historical_Growth(
                        formatter.formatCellValue(row.getCell(34)));

                data.setP3_T2_R2_8(
                        formatter.formatCellValue(row.getCell(35)));

                data.setP3_T2_R2_4(
                        formatter.formatCellValue(row.getCell(36)));

                data.setP3_T2_R2_Historical_Growth(
                        formatter.formatCellValue(row.getCell(37)));

                data.setP3_T2_R3_8(
                        formatter.formatCellValue(row.getCell(38)));

                data.setP3_T2_R3_4(
                        formatter.formatCellValue(row.getCell(39)));

                data.setP3_T2_R3_Historical_Growth(
                        formatter.formatCellValue(row.getCell(40)));

           
                // =====================================================
                // PAY AS PER ORIGINAL
                // =====================================================

              

                data.setPayOriginal_T1_8(
                        formatter.formatCellValue(row.getCell(41)));

                data.setPayOriginal_T1_4(
                        formatter.formatCellValue(row.getCell(42)));

                data.setPayOriginal_T1_Historical_rat(
                        formatter.formatCellValue(row.getCell(43)));

                data.setPayOriginal_T2_R1_8(
                        formatter.formatCellValue(row.getCell(44)));

                data.setPayOriginal_T2_R1_4(
                        formatter.formatCellValue(row.getCell(45)));

                data.setPayOriginal_T2_R1_Historical_Growth(
                        formatter.formatCellValue(row.getCell(46)));

                data.setPayOriginal_T2_R2_8(
                        formatter.formatCellValue(row.getCell(47)));

                data.setPayOriginal_T2_R2_4(
                        formatter.formatCellValue(row.getCell(48)));

                data.setPayOriginal_T2_R2_Historical_Growth(
                        formatter.formatCellValue(row.getCell(49)));

                data.setPayOriginal_T2_R3_8(
                        formatter.formatCellValue(row.getCell(50)));

                data.setPayOriginal_T2_R3_4(
                        formatter.formatCellValue(row.getCell(51)));

                data.setPayOriginal_T2_R3_Historical_Growth(
                        formatter.formatCellValue(row.getCell(52)));

                data.setExcelRowNum(i);
                policyList.add(data);
            }

            workbook.close();
            fis.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return policyList;
    }
}