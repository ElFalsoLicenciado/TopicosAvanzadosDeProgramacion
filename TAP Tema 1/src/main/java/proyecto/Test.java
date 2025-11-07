package proyecto;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfWriter;
import proyecto.enums.StateNames;
import proyecto.models.Record;
import proyecto.services.RecordServices;
import com.itextpdf.xmp.*;
import proyecto.services.UserServices;
import proyecto.utils.Other;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import static proyecto.services.RecordServices.getSpecificStateRecords;

public class Test {
    public static void main(String[] args) {

        StateNames stateNames = StateNames.values()[1];

    }

}
