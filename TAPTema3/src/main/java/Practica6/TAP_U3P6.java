package Practica6;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import Practica6.core_views.LoginFrame;

/**
 *
 * @author Link
 */
public class TAP_U3P6 {

    public static void main(String[] args) {
        FlatMacLightLaf.setup();
        new LoginFrame().setVisible(true);
    }
}
