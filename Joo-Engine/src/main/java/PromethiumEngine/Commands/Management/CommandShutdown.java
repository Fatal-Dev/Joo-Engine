package PromethiumEngine.Commands.Management;

import javafx.application.Platform;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class CommandShutdown {

    /**
     * Shuts down the bot
     * @param shutDownCode # determines how the bot will be shutdown
     * @param event MessageReceivedEvent from JDA
     */
    public static void shutDown(int shutDownCode, MessageReceivedEvent event) {
        JDA jda = event.getJDA();

        MessageChannel channel = event.getChannel();

        Member member = event.getMember();
        if (member.hasPermission(Permission.ADMINISTRATOR))
        {
            if (shutDownCode == 1)
            {
                channel.sendMessage("Shutting Down...").queue();
                jda.shutdown();
                System.out.println("Shutdown Successful");
                Platform.exit();
            }
            else if (shutDownCode == 2)
            {
                channel.sendMessage("Shutting Down NOW...").queue();
                jda.shutdownNow();
                System.out.println("Shutdown Successful");
                Platform.exit();
            }
            else
            {
                channel.sendMessage("Error: Must Provide a Proper Error Code").queue();
            }
        }
        else
        {
            channel.sendMessage("Error: You are not an Administrator").queue();
        }
    }
}
