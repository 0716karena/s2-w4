/**
 * Represents a U.S. state (or DC) with renewable electricity data.
 * Mirrors the life expectancy and energy country exercises for assessment.
 */
public class StateRenewable {
    private String name;
    private double totalGenTWh;          // total electricity generation (TWh)
    private double percentRenewable;     // percent of generation from renewables
    private double renewableGenTWh;      // renewable generation (TWh)
    private double percentOfUSRenewable; // share of total U.S. renewables
    private double co2MtPerTWh;          // CO2 intensity (Mt per TWh)

    /**
     * Construct a StateRenewable.
     * @param name state or district name
     * @param totalGenTWh total generation in TWh
     * @param percentRenewable percent of generation from renewables
     * @param renewableGenTWh renewable generation in TWh
     * @param percentOfUSRenewable percent share of U.S. renewable total
     * @param co2MtPerTWh CO2 intensity in metric tons per TWh
     */
    public StateRenewable(String name, double totalGenTWh, double percentRenewable,
                          double renewableGenTWh, double percentOfUSRenewable, double co2MtPerTWh) {
        this.name = name;
        this.totalGenTWh = totalGenTWh;
        this.percentRenewable = percentRenewable;
        this.renewableGenTWh = renewableGenTWh;
        this.percentOfUSRenewable = percentOfUSRenewable;
        this.co2MtPerTWh = co2MtPerTWh;
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getTotalGenTWh() {
        return totalGenTWh;
    }

    public double getPercentRenewable() {
        return percentRenewable;
    }

    public double getRenewableGenTWh() {
        return renewableGenTWh;
    }

    public double getPercentOfUSRenewable() {
        return percentOfUSRenewable;
    }

    public double getCo2MtPerTWh() {
        return co2MtPerTWh;
    }

    /**
     * Calculate fossil generation (TWh) as the remainder after renewables.
     * @return estimated fossil generation
     */
    public double getFossilGenTWh() {
                return totalGenTWh-renewableGenTWh;

    }

    /**
     * Check if state is above a given renewable percent threshold.
     * @param threshold percent value to compare
     * @return true if percentRenewable >= threshold
     */
    public boolean isAboveRenewableThreshold(double threshold) {
        if(percentRenewable>=threshold){
            return true;
        }
        return false;
    }

    /**
     * String representation of StateRenewable.
     * Format: Name - XX.X% renewable (YY.Y TWh of ZZ.Z TWh)
     */
    public String toString() {
        return null;
    }
}
