package proyecto.services;

import proyecto.enums.RecordType;
import proyecto.enums.StateNames;
import proyecto.models.Record;
import proyecto.utils.DBConnection;
import proyecto.utils.DialogHelper;
import proyecto.utils.Other;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Base64;
import java.util.UUID;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class RecordServicesSQL {

    public static Record getRecord(String id_record, int record_number) throws Exception {
        Record record = null;
        String sql = "SELECT * FROM records WHERE id_record = ? AND record_number = ?;";

        Connection con = DBConnection.open();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, id_record);
        ps.setInt(2, record_number);

        ResultSet rs = ps.executeQuery();

        record = getQueryResult(rs);

        rs.close();
        ps.close();
        con.close();

        return record;
    }


    public static boolean addRecord(Record r) throws Exception {
        int record_number = getRecordNumbers(r.getId_record())+1;

        String id_record = r.getId_record();
        if (id_record.isEmpty()) id_record = UUID.randomUUID().toString().substring(0, 35);

        String sql = "INSERT INTO records VALUES ";
        sql += "(?,?,?,?,?,?,?,?,?,?,?);";
        //(id_record, record_number, id_author, state_name, record_type, title, description, image, image_name, is_hidden, is_public)

        Connection con = DBConnection.open();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, id_record);
        ps.setInt(2, record_number);
        ps.setString(3, r.getId_author());
        ps.setString(4, r.getState_name().toString());
        ps.setString(5, r.getRecord_type().toString());
        ps.setString(6, r.getTitle());
        ps.setString(7, r.getDescription());
        ps.setString(8, r.getImage());
        ps.setString(9, r.getImage_name());
        ps.setInt(10, r.is_hidden());
        ps.setInt(11, r.is_public());

        int rows = ps.executeUpdate();

        ps.close();
        con.close();

        if (rows > 0) {
            DialogHelper.infoMessageDialog("Registro guardado.", "Guardado exitoso.");
            return true;
        }
        DialogHelper.errorMessageDialog("Error al guardar, intente de nuevo.", "Error de guardado.");
        return false;
    }

    public static boolean deleteRecord(Record r) throws Exception {
        String sql = "UPDATE records SET is_hidden = 1 WHERE id_record =? AND record_number=?;";

        Connection con = DBConnection.open();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, r.getId_record());
        ps.setInt(2, r.getRecord_number());

        int rows = ps.executeUpdate();

        ps.close();
        con.close();

        if (rows > 0) {
            DialogHelper.warnMessageDialog("Tu registro ha sido eliminado", "Advertencia.");
            return true;
        }
        DialogHelper.errorMessageDialog("Error al eliminar el registro.", "Error de eliminado.");
        return false;
    }

    public static boolean setPublic(Record r) throws Exception {
        String sql = "UPDATE records SET is_public = 1 WHERE id_record =? AND record_number=?;";

        Connection con = DBConnection.open();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, r.getId_record());
        ps.setInt(2, r.getRecord_number());

        int rows = ps.executeUpdate();

        ps.close();
        con.close();

        return rows > 0;
    }

    public static ArrayList<Record> getUserRecords(String id_user) throws Exception {
        ArrayList<Record> records = new ArrayList<>();

        String sql = "SELECT * FROM records WHERE id_author = ? AND is_hidden = 0 ORDER BY state_name, record_type ASC;";

        Connection con = DBConnection.open();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, id_user);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Record r = getRecord(rs.getString("id_record"), rs.getInt("record_number"));
            records.add(r);
        }

        rs.close();
        ps.close();
        con.close();

        return records;
    }

    public static ArrayList<Record> getApprovedRecords() throws Exception {
        ArrayList<Record> records = new ArrayList<>();

        String sql = "SELECT * FROM records WHERE is_public = 1 AND is_hidden = 0 ORDER BY state_name, record_type ASC;";

        Connection con = DBConnection.open();

        ResultSet rs = con.prepareStatement(sql).executeQuery();

        while (rs.next()) {
            Record r = getRecord(rs.getString("id_record"), rs.getInt("record_number"));
            records.add(r);
        }

        rs.close();
        con.close();

        return records;
    }

    public static ArrayList<Record> getStateSpecificRecords(StateNames state) throws Exception {
        ArrayList<Record> records = new ArrayList<>();

        String sql = "SELECT * FROM records WHERE is_hidden = 0 AND is_public = 1 AND state_name = ? ORDER BY record_type;";

        Connection con = DBConnection.open();

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, state.toString());

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Record r = getRecord(rs.getString("id_record"), rs.getInt("record_number"));
            records.add(r);
        }

        rs.close();
        ps.close();
        con.close();

        return records;
    }

    public static ArrayList<Record> getTypeSpecificRecords(RecordType type) throws Exception {
        ArrayList<Record> records = new ArrayList<>();

        String sql = "SELECT * FROM records WHERE is_hidden = 0 AND is_public = 1 AND record_type = ? ORDER BY state_name;";

        Connection con = DBConnection.open();

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, type.toString());

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Record r = getRecord(rs.getString("id_record"), rs.getInt("record_number"));
            records.add(r);
        }

        rs.close();
        ps.close();
        con.close();

        return records;
    }

    public static ArrayList<Record> getVerySpecificRecords(StateNames state ,RecordType type) throws Exception {
        ArrayList<Record> records = new ArrayList<>();

        String sql = "SELECT * FROM records WHERE is_hidden = 0 AND is_public = 1 AND state_name = ? AND record_type = ? ;";

        Connection con = DBConnection.open();

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, state.toString());
        ps.setString(2, type.toString());

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Record r = getRecord(rs.getString("id_record"), rs.getInt("record_number"));
            records.add(r);
        }

        rs.close();
        ps.close();
        con.close();

        return records;
    }

    public static void getPDF(StateNames state) {
        ArrayList<Record> records = new ArrayList<>();
        try{
            records = getStateSpecificRecords(state);
        if (records.isEmpty()) {
            DialogHelper.errorMessageDialog("No se encontró ningún registro de: " + state.toString(), "Error de guardado.");
            return;
        }


            Document document = new Document(PageSize.A4, 50, 50, 40, 40);
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("results/" + Other.getStateNames()[state.ordinal()] + ".pdf"));

            document.open();

            Font pageTitle = new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD);
            Font labelFont = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
            Font valueFont = new Font(Font.FontFamily.HELVETICA, 13);
            Font body = new Font(Font.FontFamily.HELVETICA, 12);

            for (Record record : records) {
                Paragraph mainTitle = new Paragraph(Other.getStateNames()[state.ordinal()], pageTitle);
                mainTitle.setAlignment(Element.ALIGN_CENTER);
                mainTitle.setSpacingAfter(15f);
                document.add(mainTitle);

                Paragraph info = new Paragraph();
                info.add(new Chunk("ID del registro: ", labelFont));
                info.add(new Chunk(record.getId_record() + "\n", valueFont));
                info.setSpacingAfter(5f);
                document.add(info);

                info = new Paragraph();
                info.add(new Chunk("Título: ", labelFont));
                info.add(new Chunk(record.getTitle() + "\n", valueFont));
                info.setSpacingAfter(5f);
                document.add(info);

                info = new Paragraph();
                info.add(new Chunk("Tipo de registro cultural: ", labelFont));
                info.add(new Chunk(Other.getTypes()[record.getRecord_type().ordinal()] + "\n", valueFont));
                info.setSpacingAfter(5f);
                document.add(info);

                info = new Paragraph();
                info.add(new Chunk("Es público: ", labelFont));
                info.add(new Chunk(record.Is_public() ? "sí\n\n" : "no\n\n", valueFont));
                document.add(info);

                Paragraph desc = new Paragraph("Descripción:\n" + record.getDescription(), body);
                desc.setAlignment(Element.ALIGN_JUSTIFIED);
                desc.setLeading(16f);
                desc.setSpacingAfter(10f);
                document.add(desc);

                Image image;

                if (record.getImage() != null){
                image = Image.getInstance(Base64.getDecoder().decode(record.getImage()));
                } else image = Image.getInstance("src/main/java/proyecto/resources/imgnotfound.png");

                image.scaleAbsolute(150, 150);
                image.setAlignment(Element.ALIGN_CENTER);
                image.setSpacingBefore(10f);
                image.setSpacingAfter(15f);
                document.add(image);

                document.newPage();
            }

            document.close();
            DialogHelper.infoMessageDialog("Archivo guardado en directorio results, con nombre: " + state+ ".pdf", "Archivo guardado.");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getExcel(){
        int [] numberOfRecords = getNumberOfRecords();

        try(Workbook wb = new XSSFWorkbook()){
            Sheet sheet = wb.createSheet("Resumen");
            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("Estado:");
            header.createCell(1).setCellValue("Num. de registros:");

            for (StateNames state : StateNames.values()) {
                Row row = sheet.createRow(sheet.getLastRowNum() + 1);
                row.createCell(0).setCellValue(state.toString().replace("_", " "));
                row.createCell(1).setCellValue(numberOfRecords[state.ordinal()]);
            }

            OutputStream fileOut = new FileOutputStream("results/resumen.xlsx");
            DialogHelper.infoMessageDialog("Archivo guardado en directorio results, con nombre: resumen.xlsx", "Archivo guardado.");
            wb.write(fileOut);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static Record getQueryResult(ResultSet rs) throws Exception {
        Record r = null;
        try {
            if (rs.next()) {
                r = new Record(
                        rs.getString("id_record"),
                        rs.getInt("record_number"),
                        rs.getString("id_author"),
                        Enum.valueOf(StateNames.class, rs.getString("state_name")),
                        Enum.valueOf(RecordType.class, rs.getString("record_type")),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("image"),
                        rs.getString("image_name"),
                        rs.getInt("is_hidden"),
                        rs.getInt("is_public"),
                        UserServicesSQL.getUser(rs.getString("id_author"))
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }

    private static int getRecordNumbers(String id_record) throws  Exception{
        ArrayList<Record> records = new ArrayList<>();
        String sql = "SELECT * FROM records WHERE id_record = ?;";

        Connection con = DBConnection.open();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, id_record);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Record r = getRecord(rs.getString("id_record"), rs.getInt("record_number"));
            records.add(r);
        }

        rs.close();
        ps.close();
        con.close();

        return records.size();
    }

    private static int[] getNumberOfRecords() {
        int [] number = new int[32];
        for(StateNames names : StateNames.values()){
            try {
                number[names.ordinal()] = getStateSpecificRecords(names).size();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return number;
    }
}
