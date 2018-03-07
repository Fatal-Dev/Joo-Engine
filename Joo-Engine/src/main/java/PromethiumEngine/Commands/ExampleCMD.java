package PromethiumEngine.Commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class ExampleCMD extends Command
{
    public ExampleCMD()
    {
        this.name = "example";
        this.aliases = new String[]{"test","demo"};
        this.help = "gives and example of commands";
    }

    @Override
    protected void execute(CommandEvent event)
    {
        event.reply("DOES BRUNO MARS IS GAY?!?!");
    }
}
