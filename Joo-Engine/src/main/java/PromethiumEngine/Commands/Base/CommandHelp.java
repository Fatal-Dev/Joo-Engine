package PromethiumEngine.Commands.Base;

import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import PromethiumEngine.Properties.Properties;

public class CommandHelp {

    /**
     * Displays a help menu that can guide a person through
     * using the bot and getting certain commands working
     */
    public static void help(String[] msgSplit, MessageReceivedEvent event) {

        MessageChannel channel = event.getChannel();

        String prefix = Properties.getPrefix();

        //<editor-fold desc="Default"
        if (msgSplit.length == 1)
        {
            channel.sendMessage("```\r\n"
                    + "Main Help Menu\r\n"
                    + "\r\n"
                    + "For Specific Help Type:\r\n"
                    + prefix + "help \"command\"\r\n"
                    + "\r\n"
                    + "Fun:\r\n"
                    + prefix + "roll\r\n"
                    + prefix + "rolladv\r\n"
                    + "\r\n"
                    + "Management:\r\n"
                    + prefix + "purge\r\n"
                    + prefix + "kick\r\n"
                    + prefix + "ban\r\n"
                    + prefix + "restart\r\n"
                    + prefix + "shutdown\r\n"
                    + "\r\n"
                    + "Other:\r\n"
                    + prefix + "credits\r\n"
                    + prefix + "help\r\n"
                    + "```\r\n")
                    .queue();
        }
        //</editor-fold

        //<editor-fold desc="Other">
        else if (msgSplit.length == 2) {

            String neededMessage = msgSplit[1];

            switch (neededMessage) {

                //<editor-fold desc="Fun"
                //<editor-fold desc="Roll">
                case "roll":
                    channel.sendMessage("```\r\n"
                            + "Roll Help\r\n"
                            + "\r\n"
                            + prefix + "roll\r\n"
                            + "```\r\n"
                    ).queue();
                    break;
                //</editor-fold>

                //<editor-fold desc="Rolladv">
                case "rolladv":
                    channel.sendMessage("```\r\n"
                            + "Roll Advanced Help\r\n"
                            + "\r\n"
                            + prefix + "rolladv # # # #\r\n"
                            + "\r\n"
                            + "Number Meanings:\r\n"
                            + "1st = # of Dice Up To 3\r\n"
                            + "2nd = # of 1st Die Faces\r\n"
                            + "3rd = # of 2nd Die Faces\r\n"
                            + "4th = # of 3rd Die Faces\r\n"
                            + "\r\n"
                            + "Examples:\r\n"
                            + prefix + "rolladv 3 6 6 6\r\n"
                            + "```\r\n"
                    ).queue();
                    break;
                //</editor-fold>
                //</editor-fold>

                //<editor-fold desc="Management"
                //<editor-fold desc="Purge">
                case "purge":
                    channel.sendMessage("```\r\n"
                            + "Purge Help\r\n"
                            + "\r\n"
                            + prefix + "purge #\r\n"
                            + "\r\n"
                            + "Number Meanings:\r\n"
                            + "1st = # of Messages to Delete"
                            + "\r\n"
                            + "Examples:\r\n"
                            + prefix + "purge 12\r\n"
                            + "```\r\n"
                    ).queue();
                    break;
                //</editor-fold>

                //<editor-fold desc="Kick">
                case "kick":
                    channel.sendMessage("```\r\n"
                            + "Kick Help\r\n"
                            + "\r\n"
                            + "Warning: Command Requires The Following Permissions:\r\n"
                            + "\r\n"
                            + "Kick Members"
                            + "\r\n"
                            + prefix + "kick #\r\n"
                            + "\r\n"
                            + "Number Meanings:\r\n"
                            + "1st = Mentioned People to Kick(You Can Mention As Many As You Want)\r\n"
                            + "\r\n"
                            + "Examples:\r\n"
                            + prefix + "kick @person1 @person2 @person3\r\n"
                            + "```\r\n"
                    ).queue();
                    break;
                //</editor-fold>

                //<editor-fold desc="Ban">
                case "ban":
                    channel.sendMessage("```\r\n"
                            + "Ban Help\r\n"
                            + "\r\n"
                            + "Warning: Command Requires The Following Permissions:\r\n"
                            + "Ban Members\r\n"
                            + "\r\n"
                            + prefix + "ban #\r\n"
                            + "\r\n"
                            + "Number Meanings:\r\n"
                            + "1st = Mentioned People Ban(You Can Mention As Many As You Want)\r\n"
                            + "\r\n"
                            + "Examples:\r\n"
                            + prefix + "ban @person1 @person2 @person3\r\n"
                            + "```\r\n"
                    ).queue();
                    break;
                //</editor-fold>

                //<editor-fold desc="Restart">
                case "restart":
                    channel.sendMessage("```\r\n"
                            + "Restart Help\r\n"
                            + "\r\n"
                            + "Warning: Command Requires The Following Permissions:\r\n"
                            + "Administrator\r\n"
                            + "\r\n"
                            + prefix + "restart #\r\n"
                            + "\r\n"
                            + "Number Meanings:\r\n"
                            + "1st = Restart Code\r\n"
                            + "\r\n"
                            + "Restart Codes:\r\n"
                            + "1 = Proper Restart\r\n"
                            + "2 = Cancel Everything And Restart NOW\r\n"
                            + "\r\n"
                            + "Examples:\r\n"
                            + prefix + "restart 1\r\n"
                            + prefix + "restart 2\r\n"
                            + "```\r\n"
                    ).queue();
                    break;
                //</editor-fold>

                //<editor-fold desc="Shutdown">
                case "shutdown":
                    channel.sendMessage("```\r\n"
                            + "Shutdown Help\r\n"
                            + "\r\n"
                            + "Warning: Command Requires The Following Permissions:\r\n"
                            + "Administrator\r\n"
                            + "\r\n"
                            + prefix + "shutdown #\r\n"
                            + "\r\n"
                            + "Number Meanings:\r\n"
                            + "1st = Shutdown Code\r\n"
                            + "\r\n"
                            + "Shutdown Codes:\r\n"
                            + "1 = Proper Shutdown\r\n"
                            + "2 = Cancel Everything And Shutdown NOW\r\n"
                            + "\r\n"
                            + "Examples:\r\n"
                            + prefix + "shutdown 1\r\n"
                            + prefix + "shutdown 2\r\n"
                            + "```\r\n"
                    ).queue();
                    break;
                //</editor-fold>
                //</editor-fold>

                //<editor-fold desc="Other"
                //<editor-fold desc="Help">
                case "help":
                    channel.sendMessage("```\r\n"
                            + "Help Help\r\n"
                            + "\r\n"
                            + prefix + "help #\r\n"
                            + "\r\n"
                            + "Number Meanings:\r\n"
                            + "1st = Command To Post Help Message\r\n"
                            + "\r\n"
                            + "Examples:\r\n"
                            + prefix + "help shutdown\r\n"
                            + prefix + "help roll\r\n"
                            + "```\r\n"
                    ).queue();
                    break;
                //</editor-fold>

                //<editor-fold desc="Credits">
                case "credits":
                //</editor-fold>
                //</editor-fold>

                //<editor-fold desc="Default">
                default: channel.sendMessage("Error: That's Not A Command!").queue();
                //</editor-fold>

            }
        } else {
            channel.sendMessage("Error: To Many Arguments!").queue();
        }
        //</editor-fold>
    }

}
