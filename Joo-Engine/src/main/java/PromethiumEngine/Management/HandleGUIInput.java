package PromethiumEngine.Management;

import PromethiumEngine.Properties.Properties;
import PromethiumEngine.Properties.Logging;
import net.dv8tion.jda.core.JDA;

public class HandleGUIInput {

    /**
     * Handles commands sent from GUI
     * @param Message Message sent from GUI input
     */
    public static void handleInput(String Message) {

        JDA jda = Properties.getPublicJDA();

        String[] messageSplit = Message.split(" ");

        switch(messageSplit[0]) {
            case "say":
                if (messageSplit.length == 1) {
                    Logging.addToLog("Error: The \"Say\" Command Requires More Parameters\r\n");
                    break;
                }

                default:
                    Logging.addToLog("Error: Unknown Commad " + "\"" + Message + "\"" + "\r\n");
        }

    }

}
