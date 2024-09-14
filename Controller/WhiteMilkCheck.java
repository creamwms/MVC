package Controller;

import java.util.Random;

public class WhiteMilkCheck {
    private int ageMonths; // Age in months

    public WhiteMilkCheck(int ageMonths) {
        this.ageMonths = ageMonths;
    }

    // Method to handle milking the cow for White cows
    public String milkCowForWhite(boolean addLemon) {
        Random random = new Random();
        double chance = random.nextDouble() * 100; // Random number between 0 and 100
        double probability = 0.5 * ageMonths; // 0.5% * ageMonths

        if (addLemon) {
            return "yogurt Milk";
        } else if (chance < probability) {
            return "BSOD: Soy Milk (Invalid)";
        } else {
            return "Regular Milk";
        }
    }
}
