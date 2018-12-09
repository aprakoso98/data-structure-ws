package com.structure.data.mutasi.view;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.structure.data.view.BaseExcelReportView;

public abstract class MutasiExcelReportView extends BaseExcelReportView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> map = (Map<String, Object>) model.get("param");

		try {
			Sheet sheet = workbook.createSheet("Mutasi");
			List<com.structure.data.entity.MutasiSiswa> siswas = (List<com.structure.data.entity.MutasiSiswa>) map.get("tx");

			/* Style Title */
			CellStyle styleTitle = workbook.createCellStyle();
			styleTitle.setAlignment(CellStyle.ALIGN_LEFT);
			Font font1 = sheet.getWorkbook().createFont();
			font1.setBold(true);
			font1.setFontHeightInPoints((short) 13);
			styleTitle.setFont(font1);

			/* Style Title 2 */
			CellStyle styleTitle2 = workbook.createCellStyle();
			styleTitle2.setAlignment(CellStyle.ALIGN_LEFT);

			/* Center */
			CellStyle center = workbook.createCellStyle();
			center.setAlignment(CellStyle.ALIGN_CENTER);
			center.setBorderBottom((short) 1);
			center.setBorderTop((short) 1);
			center.setBorderLeft((short) 1);
			center.setBorderRight((short) 1);

			/* Left */
			CellStyle left = workbook.createCellStyle();
			left.setAlignment(CellStyle.ALIGN_LEFT);
			left.setBorderBottom((short) 1);
			left.setBorderTop((short) 1);
			left.setBorderLeft((short) 1);
			left.setBorderRight((short) 1);

			/* Right */
			CellStyle right = workbook.createCellStyle();
			right.setAlignment(CellStyle.ALIGN_RIGHT);
			right.setBorderBottom((short) 1);
			right.setBorderTop((short) 1);
			right.setBorderLeft((short) 1);
			right.setBorderRight((short) 1);

			CellStyle cellStyle = workbook.createCellStyle();
			Font font = sheet.getWorkbook().createFont();
			font.setBold(true);
			font.setFontHeightInPoints((short) 10);
			cellStyle.setFont(font);
			cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
			cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
			cellStyle.setLocked(true);
			cellStyle.setBorderBottom((short) 1);
			cellStyle.setBorderTop((short) 1);
			cellStyle.setBorderLeft((short) 1);
			cellStyle.setBorderRight((short) 1);

			Row rowHeader = sheet.createRow(0);

			createCell(rowHeader, "Nomor", 0, cellStyle);
			createCell(rowHeader, "NIS", 1, cellStyle);
			createCell(rowHeader, "NISN", 2, cellStyle);
			createCell(rowHeader, "Nama Siswa", 3, cellStyle);
			createCell(rowHeader, "JK", 4, cellStyle);
			createCell(rowHeader, "Kelas", 5, cellStyle);
			createCell(rowHeader, "Tanggal", 6, cellStyle);
			createCell(rowHeader, "Asal Sekolah", 7, cellStyle);
			createCell(rowHeader, "Status", 8, cellStyle);

			int rowNum = 1;
			int no = 1;
			for (com.structure.data.entity.MutasiSiswa cc : siswas) {
				Row row = sheet.createRow(rowNum++);
				int col = 0;

				createCell(row, no++, col++, right);
				createCell(row, cc.getNis(), col++, left);
				createCell(row, cc.getNisn(), col++, left);
				createCell(row, cc.getNama(), col++, left);
				createCell(row, cc.getJenisKelamin(), col++, left);
				createCell(row, cc.getKelas(), col++, left);
				if (cc.getModifiedDt() != null) {
					createCell(row, cc.getModifiedDt(), col++, left);
				} else {
					createCell(row, cc.getCreatedDt(), col++, left);
				}
				createCell(row, cc.getAsalSekolah(), col++, left);
				createCell(row, cc.getStatus(), col++, left);
			}

			for (int x = 0; x < sheet.getRow(0).getPhysicalNumberOfCells(); x++) {
				sheet.autoSizeColumn(x);
			}

			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String dt = sdf.format(new Date());
			String fileName = "Export_Excel_Mutasi";
			response.setHeader("Content-Disposition", "attachment;filename=\"" + fileName + dt + ".xlsx\"");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
