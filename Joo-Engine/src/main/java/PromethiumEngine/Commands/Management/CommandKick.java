package PromethiumEngine.Commands.Management;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.PermissionException;

import java.util.List;

public class CommandKick {

    /**
     * Kicks all mentioned users from the guild
     * @param event MessageReceivedEvent from JDA
     */
    public static void kick(MessageReceivedEvent event) {

        Guild guild = event.getGuild();
        MessageChannel channel = event.getChannel();
        Member selfMember = guild.getSelfMember();
        Message message = event.getMessage();

        if (!selfMember.hasPermission(Permission.KICK_MEMBERS))
        {
            channel.sendMessage("Error: You Don't Have Permission to Kick Other Members!").queue();
            return;
        }

        List<User> mentionedUsers = message.getMentionedUsers();

        for (User user : mentionedUsers) {

            Member member = guild.getMember(user);

            if (selfMember.canInteract(member))
            {
                channel.sendMessage("Error: I Cannot Kick: ")
                        .append(member.getEffectiveName())
                        .append(", I Cannot Kick Members Higher Than Myself!")
                        .queue();
                continue;
            }

            guild.getController().kick(member).queue(
                    success -> channel.sendMessage("Successfully Kicked ").append(member.getEffectiveName()).queue(),
                    error -> {
                        if (error instanceof PermissionException)
                        {
                            PermissionException e = (PermissionException) error;
                            Permission missingPermission = e.getPermission();

                            channel.sendMessage("Error: PermissionError Kicking [")
                            .append(member.getEffectiveName()).append("]: ")
                            .append(error.getMessage()).queue();
                        }
                        else
                        {
                            channel.sendMessage("Error: Unknown Error Kicking [")
                                    .append(member.getEffectiveName()).append("]: ")
                                    .append(error.getMessage()).queue();
                        }
                    }
            );
        }
    }
}
