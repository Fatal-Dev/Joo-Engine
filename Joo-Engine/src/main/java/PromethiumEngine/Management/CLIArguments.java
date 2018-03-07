package PromethiumEngine.Management;

import PromethiumEngine.Promethium;
import PromethiumEngine.Properties.Properties;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CLIArguments {

    /**
     * Checks for valid args in CLI input
     * @param params CLI Parameters
     */
    public static void handleArgs(List params) {
        if (params.contains("-cli")) {
            Object[] paramsArray = params.toArray();
            if (paramsArray.length == 3)
            {
                String token = paramsArray[1].toString();
                String prefix = paramsArray[2].toString();
                saveNewConfig(token, prefix);
                Properties.switchOpMode();
                Promethium.startBot();
            }
            else if (paramsArray.length == 2)
            {
                Promethium.startBot();
            }
            else
            {
                System.out.println("Error You Must Enter A Token And Prefix!");
                System.out.println("Example: -cli **Token** **Prefix**");
                System.out.println("\r\n");
                System.out.println("You May Also Reuse Token and Prefix If Bot Has Been Launched Before");
                System.out.println("Example: -cli -r");
                System.exit(1);
            }
        }

        if (params.contains("-v") || params.contains("--version") || params.contains("-version") || params.contains("--v"))
        {
            System.out.println("Version: " + Properties.getVersionNum());
            System.exit(0);
        }
    }

    /**
     * Saves new token and prefix to config file
     * @param token JDA bot token
     * @param prefix Bot prefix
     */
    private static void saveNewConfig(String token, String prefix) {
        File configFile = Properties.getConfigFile();
        try {
            FileWriter fileWriter = new FileWriter(configFile);
            fileWriter.write(token + "\r\n");
            fileWriter.write(prefix + "\r\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}








