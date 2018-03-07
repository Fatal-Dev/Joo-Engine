package PromethiumEngine.Commands.Base;

public class CommandCredits {

    /**
     * Sends some information about the Promethium Engine
     * to the channel that it was requested in
     */
    public static String credits() {
        return "```\r\n"
                + "This Bot is Powered By The Promethium Bot Engine\r\n"
                + "\r\n"
                + "Author: PwnedBySUMO"
                + "\r\n"
                + "\r\n"
                + "GitHub\r\n"
                + "https://github.com/PwnedBySUMO/Promethium-Engine"
                + "```\r\n";
    }
}
