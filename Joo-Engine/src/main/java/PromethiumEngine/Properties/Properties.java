package PromethiumEngine.Properties;

import net.dv8tion.jda.core.JDA;

import java.io.File;

public class Properties {

    /**
    Property getter and setter for various functions.
    Default value is 0 and means the function is enabled.

    Example: Op Mode(Operation Mode) is for running the bot in GUI or CLI mode.
        If set to 0 the bot will run in GUI mode or if set to 1 it will run in
        CLI mode.
     */

    //<editor-fold desc="Vars">

    private static String token;
    private static String prefix;
    private static int opMode = 0;
    private static File workDir;
    private static File configFile;
    private static File logDir;
    private static File logFile;
    private static int currentMessage = 0;
    private static JDA publicJDA;
    private static int botRunning = 0;
    private static String ownerId;

    //</editor-fold>

    //<editor-fold desc="Setters">

    public static void setToken(String newToken) {
        token = newToken;
    }
    public static void setPrefix(String newPrefix) {
        prefix = newPrefix;
    }
    public static void switchOpMode() {
        opMode = 1;
    }
    public static void setWorkDir(File newWorkDir) {
        workDir = newWorkDir;
    }
    public static void setConfigFile(File newConfigFile) {
        configFile = newConfigFile;
    }
    public static void setLogDir(File newLogDir) {
        logDir = newLogDir;
    }
    public static void setLogFile(File newLogFile) {
        logFile = newLogFile;
    }
    public static void setCurrentMessage(int a) {
        currentMessage = a;
    }
    public static void setPublicJDA(JDA newJDA) {
        publicJDA = newJDA;
    }
    public static void switchBotRuning() {
        if (botRunning == 0) {
            botRunning = 1;
        } else if (botRunning == 1) {
            botRunning = 0;
        } else {
            System.out.println("Error: Something Is Very Wrong!");
        }
    }
    public static void setOwnerId(String newOwnerId) {
        ownerId = newOwnerId;
    }

    //</editor-fold>

    //<editor-fold desc="Getters">

    public static String getToken() {
        return token;
    }
    public static String getPrefix() {
        return prefix;
    }
    public static String getVersionNum() {
        return "Beta8";
    }
    public static int getOpMode() {
        return opMode;
    }
    public static File getWorkDir() {
        return workDir;
    }
    public static File getConfigFile() {
        return configFile;
    }
    public static File getLogDir() {
        return logDir;
    }
    public static File getLogFile() {
        return logFile;
    }
    public static int getCurrentMessage() {
        return currentMessage;
    }
    public static JDA getPublicJDA() {
        return publicJDA;
    }
    public static int getBotRunning() {
        return botRunning;
    }
    public static String getOwnerId() {
        return ownerId;
    }

    //</editor-fold>

}
