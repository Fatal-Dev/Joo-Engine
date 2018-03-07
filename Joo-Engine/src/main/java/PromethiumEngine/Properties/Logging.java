package PromethiumEngine.Properties;

import javafx.scene.control.TextArea;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

public class Logging {

    private TextArea console;

    // Sets Console To Be Updated
    public void setConsole(TextArea newConsole) {
        console = newConsole;
    }

    // Timer To Update Console
    public void updateConsole() {
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                checkLogFile();
                try {
                    String currentLog = getCurrentLog();
                    console.setText(currentLog);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }, 0,500);
    }

    // Checks If Log File Is Over 8mb
    private void checkLogFile() {
        File currentLogFile = Properties.getLogFile();
        if (currentLogFile.length() >= 8000) {
            File newLogFile = new File(Properties.getLogDir() + "\\" + genLogName());
            if (!newLogFile.exists()) {
                try {
                    if (newLogFile.createNewFile()) {
                        Properties.setLogFile(newLogFile);
                        System.out.println("Created New Log File");
                    } else {
                        System.out.println("Error: Could Not Create New Log File");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Makes New Log Name With Time
    public static String genLogName() {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH.mm.ss");
        LocalDateTime now = LocalDateTime.now();

        String logDate = dtf.format(now);

        return "log"+"["+logDate+"]"+".txt";
    }

    // Returns the Current Log
    private String getCurrentLog() throws UnsupportedEncodingException {
        File logFile = Properties.getLogFile();
        byte[] data = new byte[0];
        try {
            FileInputStream fis = new FileInputStream(logFile);
            data = new byte[(int) logFile.length()];
            fis.read(data);
            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(data, "UTF-8");
    }

    public static void addToLog(String message) {
        File logFile = Properties.getLogFile();
        FileWriter fW = null;
        BufferedWriter bF = null;
        try {
            fW = new FileWriter(logFile,true);
            bF = new BufferedWriter(fW);
            bF.write(message);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert bF != null;
                bF.close();
                fW.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
