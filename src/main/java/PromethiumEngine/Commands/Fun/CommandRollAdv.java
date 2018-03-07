package PromethiumEngine.Commands.Fun;

import java.util.ArrayList;
import java.util.Random;

public class CommandRollAdv {

    /**
     * Not just your average die rolling method, can calculate up to 3
     * dice at a time with how ever many faces you want
     * @param dieCount # of dice to be rolled up to 3
     * @param dieType1 # of sides of die 1
     * @param dieType2 # of sides of die 2
     * @param dieType3 # of sides of die 3
     * @return Sends die information back to Discord
     */
    public static String roll(int dieCount, int dieType1, int dieType2, int dieType3) {

        ArrayList<Object> diceValue = new ArrayList<>();

        if (dieCount == 0) {
            diceValue.add("Error: You Must Enter a Number!");
            return diceValue.toString().replace("[", "").replace("{", "").replace("]", "");
        } else if (dieCount > 3) {
            diceValue.add("Error: Too Many Dice!");
            return diceValue.toString().replace("[", "").replace("{", "").replace("]", "");
        }

        Random random = new Random();
        int dieValue1 = 0;
        int dieValue2 = 0;
        int dieValue3 = 0;

        if (dieType1 != 0) {
            dieValue1 = random.nextInt(dieType1) + 1;
        }
        if (dieType2 != 0) {
            dieValue2 = random.nextInt(dieType2) + 1;
        }
        if (dieType3 != 0) {
            dieValue3 = random.nextInt(dieType3) + 1;
        }

        if (dieValue1 != 0 && dieCount == 1) {
            diceValue.add("Die 1 = " + dieValue1);
        }
        if (dieValue2 != 0 && dieCount == 2) {
            diceValue.add("Die 1 = " + dieValue1);
            diceValue.add("Die 2 = " + dieValue2);
        }
        if (dieValue3 != 0 && dieCount == 3) {
            diceValue.add("Die 1 = " + dieValue1);
            diceValue.add("Die 2 = " + dieValue2);
            diceValue.add("Die 3 = " + dieValue3);
        }

        return diceValue.toString().replace("[", "").replace("{", "").replace("]", "");
    }
}
