package org.in28minutes.springboot.violation_tpa.service;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.in28minutes.springboot.violation_tpa.dto.IncidentFormDTO;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ExcelService {

    public void exportIncidentToExcel(
            IncidentFormDTO dto,
            HttpServletResponse response) throws IOException {

        Workbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet("Incident");

        //-------------------------------------------------
        // Header Style
        //-------------------------------------------------

        CellStyle headerStyle = workbook.createCellStyle();

        Font headerFont = workbook.createFont();

        headerFont.setBold(true);

        headerStyle.setFont(headerFont);

        //-------------------------------------------------
        // HEADER
        //-------------------------------------------------

        Row header = sheet.createRow(0);

        int col = 0;

        createHeader(header, col++, "ΣΧΗΜΑΤΙΣΜΟΙ", headerStyle);
        createHeader(header, col++, "Α/Φ", headerStyle);
        createHeader(header, col++, "ΟΠΛΑ", headerStyle);
        createHeader(header, col++, "ΕΜΠΛΟΚΕΣ", headerStyle);
        createHeader(header, col++, "ΔΥΤΙΚΑ ΤΟΥ 25", headerStyle);

        //-------------------------------------------------
        // DATA
        //-------------------------------------------------

        Row data = sheet.createRow(1);

        col = 0;

        createNumberCell(data, col++, dto.getSxhmatismoi());
        createNumberCell(data, col++, dto.getAircraft());
        createNumberCell(data, col++, dto.getOplaSxhmatismoi());
        createNumberCell(data, col++, dto.getOplaAircrafts());
        createNumberCell(data, col++, dto.getEngagements());
        createNumberCell(data, col++, dto.getWestTo25());

        //-------------------------------------------------
        // Resize columns automatically
        //-------------------------------------------------

        for (int i = 0; i < sheet.getRow(0).getPhysicalNumberOfCells(); i++) {
            sheet.autoSizeColumn(i);
        }

        //-------------------------------------------------
        // Download
        //-------------------------------------------------

        response.setContentType(
                "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

        response.setHeader(
                "Content-Disposition",
                "attachment; filename=incident.xlsx");

        ServletOutputStream outputStream = response.getOutputStream();

        workbook.write(outputStream);

        outputStream.close();

        workbook.close();
    }

    //-------------------------------------------------
    // Helper Methods
    //-------------------------------------------------

    private void createHeader(
            Row row,
            int column,
            String title,
            CellStyle style) {

        Cell cell = row.createCell(column);

        cell.setCellValue(title);

        cell.setCellStyle(style);
    }

    private void createNumberCell(
            Row row,
            int column,
            Integer value) {

        Cell cell = row.createCell(column);

        if (value != null) {
            cell.setCellValue(value);
        }
    }

}