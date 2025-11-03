package proyecto.utils;

import proyecto.enums.StateNames;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Other {

    public static final String [] folders = {
            "agus/", "baca/", "bacs/", "camp/",
            "cdmx/", "chia/", "chps/", "coah/",
            "coli/", "dura/", "edmx/", "guan/",
            "guer/", "hida/", "jali/", "mich/",
            "more/", "naya/", "nule/", "oaxa/",
            "pueb/", "quer/", "quin/", "sina/",
            "snlp/", "sono/", "taba/", "tama/",
            "tlax/", "vera/", "yuca/", "zaca/"
    };

    public static DefaultComboBoxModel<String> setComboStates(){
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();

        for (StateNames state : StateNames.values()) {
            String displayName = state.name().replace("_", " ");
            model.addElement(displayName);
        }
        return model;
    }

    public static boolean copiarArchivo(Path origin, String destiny ,String copy)
    {
        boolean result = false;
        try {
            Path path = Paths.get( destiny + copy);
            Files.copy(origin, path, StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Se copio correctamente: " + path.toString());

            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.errorMessageDialog("Error", "");
        }
        return result;
    }

    public static boolean moveImage(String name, String oldFolder, String newFolder) {
        try {
            Path origin = Paths.get("src/main/java/proyecto/resources/" + oldFolder + name);
            Path destiny = Paths.get("src/main/java/proyecto/resources/" + newFolder + name);

            if (Files.exists(origin)) {
                Files.createDirectories(destiny.getParent());

                Files.copy(origin, destiny, StandardCopyOption.REPLACE_EXISTING);

                Files.delete(origin);

                System.out.println("Imagen movida de " + oldFolder + " a " + newFolder);
                return true;
            } else {
                System.out.println("No se encontró el archivo original: " + origin);
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.errorMessageDialog( "Error al mover la imagen", "");
            return false;
        }
    }

    public static void createJSON(String FILE){
        File file = new File(FILE);

        // Check if the file already exists
        if (file.exists()) {
            System.out.println("File already exists: " + file.getAbsolutePath());
            return;
        }

        // If not, create it and write default content
        try (FileWriter writer = new FileWriter(file)) {
            writer.write("");
            System.out.println("File created successfully: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error creating JSON file: " + e.getMessage());
        }
    }
}
