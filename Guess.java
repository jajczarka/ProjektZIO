package guessANumber;

import java.util.Random;
import javax.swing.JOptionPane;

public class Guess {
static boolean playAgain;
static int max; // LIczba bêdzie z przedzia³u 1 a podana liczba
static int objective; // Gracz próbuje odgadn¹æ liczbê
static int userGuess;

public Guess() {}
    public static void main(String[] args) {

        do {
        setMax();
        setObjective();
        userGuess();
        playAgain();
        } while (playAgain == true);

    }
    public static void setMax() {

        boolean valid = false;

        // Zapytaj o max
        while(!valid) {
            try {
                max = Integer.parseInt(JOptionPane.showInputDialog("Bêdziesz próbowa³ odgadn¹æ liczbê z przedzia³u od 1 do \"max\". Podaj max: "));
                valid = true;
                
                
                
            }
            catch (NumberFormatException e) {}
        }

        
        
        // Zapewniasz uzytkownika w jakim przedziale siê miesci liczba
        while (max < 1 || max > Integer.MAX_VALUE) {
            valid = false;
            while (!valid) {
                try {
                    max = Integer.parseInt(JOptionPane.showInputDialog("Max musi byæ pomiêdzy 1 i " + Integer.MAX_VALUE + ": "));
                    valid = true;
                }
                catch(NumberFormatException e) {}
            }
        }
    }
    public static void setObjective() {

        Random rand = new Random();
        if (max == 1)
            objective = 1;
        else
            objective = rand.nextInt(max - 1) + 1;
        System.out.println(objective);
    }   
    public static void userGuess() {
        do {
            userGuess = 0;

            try {
                userGuess = Integer.parseInt(JOptionPane.showInputDialog("Zgadnij liczbê pomiêdzy 1 i " + max + ": "));
            }
            catch (NumberFormatException e){}
            
            while (userGuess > max || userGuess < 1) {
                try {
                    userGuess = Integer.parseInt(JOptionPane.showInputDialog(null, "Twoja liczba musi byæ z przedzia³u 1 i " + max));
                    }
                catch (NumberFormatException e) {}
            }
            userWinLose();
        } while (userGuess != objective);

    }   
    public static void userWinLose() {

        // gracz ma za nisk¹ liczbê , za wysok¹ lub wygrywa
        if (userGuess < objective)
            JOptionPane.showMessageDialog(null, "Za niska!");
        else if (userGuess > objective)
            JOptionPane.showMessageDialog(null, "Za wysoka!");
        else
            JOptionPane.showMessageDialog(null, "Wygra³eœ !");
    }

   
    public static void playAgain() {

        boolean valid = false;
        while (!valid) {
            try {
                if (Integer.parseInt(JOptionPane.showInputDialog("Podaj 0 jeœli chcesz wyjœæ lub 1 by zagraæ ponownie: ")) == 0)
                    playAgain = false;
                else
                    playAgain = true;
                valid = true;
            }
            catch (NumberFormatException e) {}
        }
    }
}