package Controller;


import java.util.Random;

public class BrownMilkCheck {
    private int ageYears;

    public BrownMilkCheck(int ageYears) {
        this.ageYears = ageYears;
    }

    // Method to handle milking the cow
    public String milkCow1() {
        Random random = new Random();
        double chance = random.nextDouble() * 100; // change to made Almond milk
        double probability = 1.0 * (ageYears); // 1% * age year

        if (chance < probability) {
            return "BSOD: Almond Milk (Invalid)";
        } else {
            return "Chocolate Milk";
        }
    }

   
}

