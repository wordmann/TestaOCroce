package live.abgl.testacroce.helpers;


import java.util.Random;

public class Coin {
    
    public static String format(boolean flip) {
        if (flip)
            return "testa";
        else
            return "croce";
    }

    /**
     * 
     * @return True for heads, False for tails
     */
    public static boolean flip() {

        Random rand = new Random();

        return rand.nextBoolean();

    }

}
