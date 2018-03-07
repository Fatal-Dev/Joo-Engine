package PromethiumEngine.Commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class howidentify extends Command
{
    public howidentify()
    {
        this.name = "amgey?";
        this.help = "gives and example of commands";
    }

    @Override
    protected void execute(CommandEvent event)
    {
        event.reply("Your are a big gey?!?!");
    }
}
