public class HealthStatus {
    private boolean isHealthy;
    private boolean hasValidVaccinationCard;

    public HealthStatus(boolean isHealthy, boolean hasValidVaccinationCard) {
        this.isHealthy = isHealthy;
        this.hasValidVaccinationCard = hasValidVaccinationCard;
    }

    public boolean isHealthy() {
        return isHealthy;
    }

    public boolean hasValidVaccinationCard() {
        return hasValidVaccinationCard;
    }
}