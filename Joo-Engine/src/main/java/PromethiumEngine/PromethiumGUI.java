package PromethiumEngine;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import PromethiumEngine.Management.CLIArguments;
import PromethiumEngine.Properties.SetupGetter;
import PromethiumEngine.Properties.Properties;

import java.io.IOException;
import java.util.List;

/**
 * Main Class of Promethium Engine
 * @author PwnedBySUMO
 */
public class PromethiumGUI extends Application {

    /**
     * Run the property getter and then launches JavaFX
     * @param args Main methods args
     */
    public static void main(String[] args) {
        SetupGetter.getProps();
        launch(args);
    }

    /**
     * Start method for JavaFX, another obvious one
     * @param primaryStage JavaFX Main Stage
     * @throws IOException Thrown by openMainWindow()
     * @throws NullPointerException Thrown by openMainWindow()
     */
    @Override
    public void start(Stage primaryStage) throws IOException, NullPointerException {

        // Gets CLI Arguments and Stores Them In A List
        final Parameters parameters = getParameters();
        final List<String> params = parameters.getRaw();

        // If No CLI Arguments, Open Main Window, Else, Run CLIArguments Method
        if (params.isEmpty())
        {
            openMainWindow();
        }
        else
        {
            Properties.switchOpMode();
            CLIArguments.handleArgs(params);
        }
    }


    /**
     * Makes the main window closeable to the rest of the program
     */
    public Stage win1 = new Stage();

    /**
     * Makes the exit window closeable to the rest of the program
     */
    public Stage win2 = new Stage();


    /**
     * Opens the main JavaFX management console of the bot
     * @throws IOException Thrown by FXMLLoader.load
     * @throws NullPointerException Thrown by getClass().gerResource()
     */
    public void openMainWindow() throws IOException, NullPointerException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("MainWindow.fxml"));
        win1.setTitle("Promethium Config Panel");
        win1.setScene(new Scene(root));
        win1.show();
        win1.setOnCloseRequest(e -> {
            e.consume();
            if (Properties.getBotRunning() == 0)
            {
                Platform.exit();
            }
            else
            {
                try
                {
                    openExitWindow();
                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        });
    }

    /**
     * Opens an exit window if the program is shutdown while the bot is running
     * @throws IOException Thrown by FXMLLoader.load
     * @throws NullPointerException Thrown by getClass().gerResource()
     */
    public void openExitWindow() throws IOException, NullPointerException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("ExitWindow.fxml"));
        win2.setTitle("Exit?");
        win2.setScene(new Scene(root));
        win2.show();
    }
}
