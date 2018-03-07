package PromethiumEngine.FXML;

import PromethiumEngine.Management.HandleGUIInput;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import net.dv8tion.jda.core.JDA;
import PromethiumEngine.Promethium;
import PromethiumEngine.Properties.Properties;
import PromethiumEngine.Properties.Logging;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

public class MainController {

    //<editor-fold desc="FXML">
    @FXML public Button startBot;
    @FXML public Button stopBot;
    @FXML public Button stopBotNow;
    @FXML public Button restartBot;
    @FXML public Button restartBotNow;
    @FXML public TextField tokenField;
    @FXML public TextField prefixField;
    @FXML public TextField ownerIdField;
    @FXML public TextArea console;
    @FXML public TextArea consoleInput;
    @FXML public Button sendConsoleInput;
    @FXML public CheckBox reuseToken;
    @FXML public Button publicDiscord;
    @FXML public Button githubPage;
    //</editor-fold

    // When Buttons Are Pressed, Run These
    public void handleStartBotButton() {
        if (!reuseToken.isSelected()) {
            saveNewConfig();
        }
        Promethium.startBot();
        onStart();
        Logging instance = new Logging();
        instance.setConsole(console);
        instance.updateConsole();
    }

    //<editor-fold desc="Handle Stop/Restart Buttons">
    public void handleStopButton() {
        JDA jda = Properties.getPublicJDA();
        try {
            jda.shutdown();
            System.out.println("Bot Has Been Shutdown");
        } catch (Exception e) {
            System.out.println("Error: Could Not Shutdown Bot! Was The Bot Running?");
        }
        onStop();
    }
    public void handleStopNowButton() {
        JDA jda = Properties.getPublicJDA();
        jda.shutdownNow();
        System.out.println("Bot Has Been Shutdown");
        onStop();
    }
    public void handleRestartButton() {
        JDA jda = Properties.getPublicJDA();
        jda.shutdown();
        Promethium.startBot();
        onStop();
        onStart();
        System.out.println("Bot Has Been Restarted");
    }
    public void handleRestartNowButton() {
        JDA jda = Properties.getPublicJDA();
        jda.shutdownNow();
        Promethium.startBot();
        onStop();
        onStart();
        System.out.println("Bot Has Been Restarted");
    }
    //</editor-fold>

    public void handleConsoleInput() {
        String command = consoleInput.getText();
        HandleGUIInput.handleInput(command);
    }

    // Switches Buttons on Start or Stop
    private void onStart() {
        startBot.setDisable(true);
        stopBot.setDisable(false);
        stopBotNow.setDisable(false);
        restartBot.setDisable(false);
        restartBotNow.setDisable(false);
    }
    private void onStop() {
        startBot.setDisable(false);
        stopBot.setDisable(true);
        stopBotNow.setDisable(true);
        restartBot.setDisable(true);
        restartBotNow.setDisable(true);
    }

    // Saves New Token and Prefix to Config File
    private void saveNewConfig() {
        File configFile = Properties.getConfigFile();
        String newToken = tokenField.getText();
        String newPrefix = prefixField.getText();
        String newOwnerId = ownerIdField.getText();
        try {
            FileWriter fileWriter = new FileWriter(configFile);
            fileWriter.write(newToken + "\r\n");
            fileWriter.write(newPrefix + "\r\n");
            fileWriter.write(newOwnerId + "\r\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Properties.setToken(newToken);
        Properties.setPrefix(newPrefix);
    }

    public void handlePublicDiscord() {
        if (Desktop.isDesktopSupported()) {
            try {
                URI discord = new URI("https://discord.gg/bNvt6RC");
                Desktop.getDesktop().browse(discord);
            } catch (URISyntaxException | IOException e) {
                System.out.println("Error: Could Not Open URL In Browser");
            }
        }
    }
    public  void handleGithubPage() {
        if (Desktop.isDesktopSupported()) {
            try {
                URI discord = new URI("https://github.com/PwnedBySUMO/PlaidBot");
                Desktop.getDesktop().browse(discord);
            } catch (URISyntaxException | IOException e) {
                System.out.println("Error: Could Not Open URL In Browser");
            }
        }
    }

}
