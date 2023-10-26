package live.abgl.testacroce.helpers;

public class CoinPlayer {

    public boolean choise; 
    public int score = 0;
    public String name;

    public CoinPlayer(){}

    public CoinPlayer(String name, boolean choise) {

        this.name = name;
        this.choise = choise;

    }
    
    /**
     * Checks if the flipped coin the same as the users choise, adds to the score and returns true if so
     */
    public boolean check(boolean resault) {

        if ( resault == choise ){

            score++;
            return true;

        }

        return false;

    } 

}
