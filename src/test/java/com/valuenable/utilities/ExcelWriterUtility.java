package com.valuenable.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriterUtility {

	private static final String FILE_PATH = System.getProperty("user.dir") + File.separator + "TestData"
			+ File.separator + "ULPolicySheet2.xlsx";

	public static void markCellRed(int rowNum, int cellNum) {

	    try {

	        FileInputStream fis = new FileInputStream(FILE_PATH);

	        Workbook workbook = new XSSFWorkbook(fis);

	        Sheet sheet = workbook.getSheet("python_op");

	        Row row = sheet.getRow(rowNum);

	        if (row == null) {
	            row = sheet.createRow(rowNum);
	        }

	        Cell cell = row.getCell(cellNum);

	        if (cell == null) {
	            cell = row.createCell(cellNum);
	        }

	        CellStyle redStyle = workbook.createCellStyle();

	        redStyle.setFillForegroundColor(
	                IndexedColors.RED.getIndex());

	        redStyle.setFillPattern(
	                FillPatternType.SOLID_FOREGROUND);

	        cell.setCellStyle(redStyle);

	        fis.close();

	        FileOutputStream fos =
	                new FileOutputStream(FILE_PATH);

	        workbook.write(fos);

	        fos.close();

	        workbook.close();

	    } catch (Exception e) {

	        e.printStackTrace();
	    }
	}

	public static void writePolicyStatus(int rowNum, String status, String remarks) {

		try {

			FileInputStream fis = new FileInputStream(FILE_PATH);

			Workbook workbook = new XSSFWorkbook(fis);

			Sheet sheet = workbook.getSheet("python_op");

			Row row = sheet.getRow(rowNum);

			// Column 56 = BD
			Cell statusCell = row.getCell(56);

			if (statusCell == null) {

				statusCell = row.createCell(56);
			}

			statusCell.setCellValue(status);

			// Column 57 = BE
			Cell remarksCell = row.getCell(57);

			if (remarksCell == null) {

				remarksCell = row.createCell(57);
			}

			remarksCell.setCellValue(remarks);

			fis.close();

			FileOutputStream fos = new FileOutputStream(FILE_PATH);

			workbook.write(fos);

			fos.close();

			workbook.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}