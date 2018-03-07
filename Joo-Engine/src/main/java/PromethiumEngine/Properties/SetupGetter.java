package PromethiumEngine.Properties;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SetupGetter {

    public static void getProps() {

        //<editor-fold desc="Sets Working Directory">
        File workDir = new File("PromethiumFiles");
        if (!workDir.exists()) {
            if (workDir.mkdirs()) {
                System.out.println("Created Promethium Folder");
            } else {
                System.out.println("Error: Could Not Create Promethium Folder");
            }
        }
        Properties.setWorkDir(workDir);
        //</editor-fold>

        //<editor-fold desc="Creates Config File">
        File configFile = new File("PromethiumFiles\\config.txt");
        if (!configFile.exists()) {
            try {
                if (configFile.createNewFile()) {
                    System.out.println("Created Config File");
                } else {
                    System.out.println("Error: Could Not Create Config File");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Properties.setConfigFile(configFile);
        //</editor-fold>

        //<editor-fold desc="Creates Log Folder">
        File logDir = new File("PromethiumFiles\\Logs");
        if (!logDir.exists()) {
            if (logDir.mkdir()) {
                System.out.println("Created Log Folder");
            } else {
                System.out.println("Error: Could Not Create Log Folder");
            }
        }
        Properties.setLogDir(logDir);
        //</editor-fold>

        //<editor-fold desc="Creates Temp Log File">
        String newLogName = Logging.genLogName();
        File logFile = new File("PromethiumFiles\\Logs", newLogName);
        if (!logFile.exists()) {
            try {
                if (logFile.createNewFile()) {
                    System.out.println("Created Log File");
                } else {
                    System.out.println("Error: Could Not Create Temp Log Folder");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Properties.setLogFile(logFile);
        //</editor-fold>

        readConfig();

    }

    public static void readConfig() {

        //<editor-fold desc="Gets Token From Config File"
        String savedToken = null;
        String savedPrefix = null;
        String savedOwnerId = null;
        try {
            FileReader fileReader = new FileReader(Properties.getConfigFile());
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            savedToken = bufferedReader.readLine();
            savedPrefix = bufferedReader.readLine();
            savedOwnerId = bufferedReader.readLine();

        } catch (IOException e) {
            System.out.println("Error: Could Not Read Properties From Config");
            System.exit(0);
        }
        Properties.setToken(savedToken);
        Properties.setPrefix(savedPrefix);
        Properties.setOwnerId(savedOwnerId);
        //</editor-fold>

    }

}
