package proyecto.utils;

import proyecto.enums.RecordType;
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
            model.addElement("Selecciona un estado.");
        for (StateNames state : StateNames.values()) {
            String displayName = state.name().replace("_", " ");
            model.addElement(displayName);
        }
        return model;
    }

    public static String[] getStateNames() {
        String[] names = new String[StateNames.values().length];

        for (int i = 0; i < StateNames.values().length; i++) {
            names[i] = StateNames.values()[i].name().replace("_", " ");
        }
        return names;
    }

    public static String[] getTypes(){
        return new String[]{"Tradición","Gastronomía","Lugar","Regionalismo o localismo"};
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
