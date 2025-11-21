package Practica3;

import Practica3.core_views.LoginFrame;
import com.formdev.flatlaf.themes.FlatMacLightLaf;

public class TAP3U3 {
    public static void main(String[] args) {
        FlatMacLightLaf.setup();
        new LoginFrame().setVisible(true);
    }
}
