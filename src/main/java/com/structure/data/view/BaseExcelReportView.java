package com.structure.data.view;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

public abstract class BaseExcelReportView extends AbstractXlsxView {

	@Override
	protected Workbook createWorkbook(Map<String, Object> model, HttpServletRequest request) {
		return super.createWorkbook(model, request);
	}

	protected void createCellNull(Row row, Object obj, int col, CellStyle cellStyle) {
		Cell cell = row.createCell(col);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("");
	}

	protected void createCell(Row row, Object obj, int col, CellStyle cellStyle) {

		Cell cell = row.createCell(col);

		if (obj == null) {
			cell.setCellStyle(cellStyle);
			cell.setCellValue("");
		}

		if (obj instanceof Date) {

//			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			cell.setCellStyle(cellStyle);
			cell.setCellValue(sdf.format((Date) obj));

		} else if (obj instanceof Number) {

			if (obj instanceof BigDecimal) {
				cell.setCellStyle(cellStyle);
				cell.setCellValue(((BigDecimal) obj).doubleValue());
			} else if (obj instanceof Double) {
				cell.setCellStyle(cellStyle);
				cell.setCellValue((Double) obj);
			} else {
				cell.setCellStyle(cellStyle);
				cell.setCellValue((Integer) obj);
			}

		} else {
			cell.setCellStyle(cellStyle);
			cell.setCellValue((String) obj);
		}

	}

}
