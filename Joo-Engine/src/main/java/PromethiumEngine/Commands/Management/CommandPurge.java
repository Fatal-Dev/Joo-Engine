package PromethiumEngine.Commands.Management;

import net.dv8tion.jda.core.entities.MessageChannel;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class CommandPurge {

    /**
     * Deletes a mentioned amount of messages from the invokers text channel
     * @param msgCount # of messages to delete
     * @param event MessageReceivedEvent from JDA
     */
    public static void purge(int msgCount, MessageReceivedEvent event) {

        MessageChannel channel = event.getChannel();

        channel.sendMessage("Error: Command Borked!").queue();
    }
}
