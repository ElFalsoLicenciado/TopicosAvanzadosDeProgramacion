package proyecto;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import proyecto.enums.StateNames;
import proyecto.models.Record;
import proyecto.services.RecordServices;
import proyecto.services.UserServices;
import proyecto.utils.Other;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.xmp.*;
import com.itextpdf.text.pdf.PdfWriter;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;


public class Test {
    public static void main(String[] args) {
        ArrayList<Record> records = RecordServices.getOrderedRecords();
        CreationHelper ch;
//        try(Workbook wb = new HSSFWorkbook()){
//            ch = wb.getCreationHelper();
//            Sheet sheet = wb.createSheet("Proyecto");
//            Row row = sheet.createRow(0);
//            Cell cell = row.createCell(0);
//            cell.setCellValue("Nombre");
//            row.createCell(1).setCellValue("Titulo");
//            row.createCell(2).setCellValue(ch.createRichTextString("Una cadena fodonga"));
//            row.createCell(3).setCellValue(true);
//            OutputStream fileOut = new FileOutputStream("results/try.xls");
//            wb.write(fileOut);
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        try(Workbook wb = new XSSFWorkbook()){
            Sheet sheet = wb.createSheet("Resumen");
            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("recordId");
            header.createCell(1).setCellValue("authorId");
            header.createCell(2).setCellValue("stateName");
            header.createCell(3).setCellValue("recordType");
            header.createCell(4).setCellValue("isPublic");
            header.createCell(5).setCellValue("title");
            header.createCell(6).setCellValue("description");
            header.createCell(7).setCellValue("imageUrl");
            header.createCell(8).setCellValue("deleted");

            for (Record record : records) {
                Row row = sheet.createRow(sheet.getLastRowNum() + 1);
                row.createCell(0).setCellValue(record.getRecordId());
                row.createCell(1).setCellValue(record.getAuthorId());
                row.createCell(2).setCellValue(record.getState().toString().replace("_", " "));
                row.createCell(3).setCellValue(Other.getTypes()[record.getRecordType().ordinal()]);
                row.createCell(4).setCellValue(record.isPublic());
                row.createCell(5).setCellValue(record.getTitle());
                row.createCell(6).setCellValue(record.getDescription());
                row.createCell(7).setCellValue(record.getImageUrl());
                row.createCell(8).setCellValue(record.isDeleted());
            }

            OutputStream fileOut = new FileOutputStream("results/try.xlsx");
            wb.write(fileOut);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
