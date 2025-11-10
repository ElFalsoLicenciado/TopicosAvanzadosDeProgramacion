package proyecto;

import com.itextpdf.text.Font;
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
        StateNames state = StateNames.values()[1];
        ArrayList<Record> records = RecordServices.getSpecificStateRecords(state);


    }
}
