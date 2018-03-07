package PromethiumEngine.Properties;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Game;

import java.util.Timer;
import java.util.TimerTask;

public class ChangePlaying {

    public static void startChange() {
        JDA jda = Properties.getPublicJDA();

        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                if (Properties.getCurrentMessage() == 0) {
                    jda.getPresence().setGame(Game.playing("Type " + Properties.getPrefix() + "help for Help"));
                    Properties.setCurrentMessage(1);
                } else {
                    jda.getPresence().setGame(Game.playing("Powered By Promethium"));
                    Properties.setCurrentMessage(0);
                }
            }
        }, 0, 300000);

    }
}
