package Controller;

public class CowIDCheck {
    public boolean cowIDCheck(String cowID) {
        // checking for IsNumber
        for (char c : cowID.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        
        // checking for 8 digits
        if (cowID.length() != 8) {
            return false; // is not 8 digits
        }

        // checking for not starting with 0
        if (cowID.startsWith("0")) {
            return false; // starting with 0
        }

        return true; // pass
    }
}
