package PromethiumEngine.FXML;

import PromethiumEngine.Properties.Properties;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import net.dv8tion.jda.core.JDA;
import PromethiumEngine.PromethiumGUI;

public class ExitController {

    @FXML public Button exitButton;
    @FXML public Button cancelButton;

    public void handleExitButton() {
        JDA jda = Properties.getPublicJDA();
        try {
            jda.shutdown();
        } catch (RuntimeException e) {
            Platform.exit();
        }
        System.exit(0);
        Platform.exit();
    }
    public void handleCancelButton() {
        PromethiumGUI instance = new PromethiumGUI();
        instance.win2.close();
    }

}
