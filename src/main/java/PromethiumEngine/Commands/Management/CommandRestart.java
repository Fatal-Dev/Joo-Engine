package PromethiumEngine.Commands.Management;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import PromethiumEngine.Promethium;

public class CommandRestart {

    /**
     * Restarts the bot
     * @param restartCode # determines how the bot will be shutdown
     * @param event MessageReceivedEvent from JDA
     */
    public static void restart(int restartCode, MessageReceivedEvent event) {
        JDA jda = event.getJDA();

        MessageChannel channel = event.getChannel();

        Member member = event.getMember();
        if (member.hasPermission(Permission.ADMINISTRATOR))
        {
            if (restartCode == 1)
            {
                channel.sendMessage("Restarting...").queue();
                jda.shutdown();
                Promethium.startBot();
            }
            else if (restartCode == 2)
            {
                channel.sendMessage("Restarting NOW...").queue();
                jda.shutdownNow();
                Promethium.startBot();
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
