package Controller;

import java.util.HashMap;
import java.util.Map;

public class MilkTracker {
    private Map<String, Integer> milkProduction;
    private Map<String, Boolean> bsodStatus;

    public MilkTracker() {
        milkProduction = new HashMap<>();
        bsodStatus = new HashMap<>();
    }

    // Update production
    public void recordMilk(String cowID, String milkType) {
        if (!milkProduction.containsKey(cowID)) {
            milkProduction.put(cowID, 0);
        }
        milkProduction.put(cowID, milkProduction.get(cowID) + 1);
    }

    //create Button for reset

    // Check if a cow has BSOD
    public boolean isBSOD(String cowID) {
        return bsodStatus.getOrDefault(cowID, false);
    }

    // Get production report
    public String getProductionReport() {
        StringBuilder report = new StringBuilder();
        int totalMilk = 0;
        for (Map.Entry<String, Integer> entry : milkProduction.entrySet()) {
            String cowID = entry.getKey();
            int count = entry.getValue();
            totalMilk += count;
            report.append("Cow ID: ").append(cowID).append(" | Bottles Produced: ").append(count).append("\n");
        }
        report.append("Total Bottles Produced: ").append(totalMilk).append("\n");
        return report.toString();
    }
}
