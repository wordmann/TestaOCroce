package live.abgl.testacroce;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import live.abgl.testacroce.helpers.Coin;
import live.abgl.testacroce.helpers.CoinPlayer;


public class Main {
    
    public static void pause() {

        InputStreamReader keyboard_raw = new InputStreamReader(System.in);
        BufferedReader keyboard = new BufferedReader(keyboard_raw);

        String value = "";
            try {
                value = keyboard.readLine();
            } catch (Exception e) {
            }

    }

    public static String fetchString() {

        InputStreamReader keyboard_raw = new InputStreamReader(System.in);
        BufferedReader keyboard = new BufferedReader(keyboard_raw);

        String value = "";
        boolean valid = false;
        while (!valid) {
            try {
                value = keyboard.readLine();
                if (value.equals(""))
                    System.out.println("Inserisci qualcosa.");
                else
                    valid = true;
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        return value;

    }

    /**
     * Fetches user input from console and returns it. It will ask the user for input until a valid one is given
     * @return  User inputted number
     */
    public static int fetchInt() {

        InputStreamReader keyboard_raw = new InputStreamReader(System.in);
        BufferedReader keyboard = new BufferedReader(keyboard_raw);

        int value = 0;
        boolean valid = false;
        while (!valid) {
            try {
                String temp = keyboard.readLine();
                value = Integer.parseInt(temp);
                valid = true;
            } catch (Exception e) {
                if (e instanceof NumberFormatException)
                    System.out.println("Inserisci un numero intero.");
                else 
                    System.out.println(e);
            }
        }

        return value;

    }

    public static void main(String[] args) {
        
        final int MAX_ROUNDS = 11;

        CoinPlayer player = new CoinPlayer();
        CoinPlayer cpu = new CoinPlayer("Computer", Coin.flip());
        int round_counter = 0;

        System.out.println("  ## TESTA O CROCE ##\n");
        System.out.println("Inserire dati giocatore!    ");
        System.out.print("Nome: ");
        player.name = fetchString();

        
        for (round_counter = 0; round_counter < MAX_ROUNDS; round_counter++) {
            
            System.out.println();
            System.out.println("Round " + (round_counter + 1) + "/" + MAX_ROUNDS);
            System.out.println(player.name.toUpperCase() + ": " + player.score + "\t\t" + cpu.name.toUpperCase() + ": " + cpu.score);
            System.out.println();

            String temp;
            do {
    
                System.out.print("[T]esta o [C]roce? ");
                temp = fetchString();
    
                if (temp.equals("T"))
                    player.choise = true;
                if (temp.equals("C"))
                    player.choise = false;
                    
            }   while (!temp.equals("T") && !temp.equals("C"));

            cpu.choise = Coin.flip();

            System.out.println();
            System.out.println("Stai giocando con " + Coin.format(player.choise) + ".");
            System.out.println("Il tuo avversario, " + cpu.name + ", sta giocando " + Coin.format(cpu.choise));
            System.out.print("Premi invio per lanciare la moneta!");

            pause();
            System.out.println("\n############");
            
            boolean resault = Coin.flip();

            player.check(resault);
            cpu.check(resault);

            System.out.println();
            System.out.println("E' uscito " + Coin.format(resault).toUpperCase() + "!");

        }

        System.out.println();
        System.out.println("-----------------------------");
        System.out.println();

        System.out.println(player.name.toUpperCase() + ": " + player.score + "\t\t" + cpu.name.toUpperCase() + ": " + cpu.score);

        if (player.score > cpu.score) {
            System.out.println(player.name + " ha vinto!");
        }

        if (cpu.score > player.score) {
            System.out.println(cpu.name + " ha vinto!");
        }

        if (cpu.score == player.score) {
            System.out.println("Pareggio! Tornate a casa!");
        }

        System.out.println();

    }


}
