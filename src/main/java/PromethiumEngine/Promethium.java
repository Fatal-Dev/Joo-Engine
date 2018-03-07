package PromethiumEngine;

import PromethiumEngine.Commands.ExampleCMD;
import PromethiumEngine.Properties.ChangePlaying;
import PromethiumEngine.Properties.SetupGetter;
import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import PromethiumEngine.Properties.Properties;

import javax.security.auth.login.LoginException;
import java.io.*;

/**
 * Starts the bot
 */
public class Promethium {

    /**
     * Starts the bot using the JDA API
     */
    public static void startBot() {
        SetupGetter.readConfig();
        clearConsole();

        CommandClientBuilder builder = new CommandClientBuilder();
        builder.setOwnerId(Properties.getOwnerId());
        builder.setPrefix(Properties.getPrefix());
        builder.addCommands(new ExampleCMD());
        CommandClient client = builder.build();

        try {
            JDA jda = new JDABuilder(AccountType.BOT)
                    .setToken(Properties.getToken())
                    .addEventListener(client)
                    .buildBlocking();
            Properties.setPublicJDA(jda);
        } catch (InterruptedException | LoginException e) {
            e.printStackTrace();        }
        ChangePlaying.startChange();
        Properties.switchBotRuning();
    }

    /**
     * Simple method that clears the screen in CLI mode
     */
    private static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) // Checks if OS is Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else // Checks if OS is MacOS or Linux
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
