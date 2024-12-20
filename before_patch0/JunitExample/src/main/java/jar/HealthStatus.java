package jar;
public class HealthStatus {
    private boolean isHealthy;
    private boolean hasValidVaccinationCard;

    public HealthStatus(boolean isHealthy, boolean hasValidVaccinationCard) {
        setHealthy(isHealthy);
        setValidVaccinationCard(hasValidVaccinationCard);
    }

    public boolean isHealthy() {
        return isHealthy;
    }

    public void setHealthy(boolean isHealthy) {
        this.isHealthy = isHealthy;
    }

    public boolean hasValidVaccinationCard() {
        return hasValidVaccinationCard;
    }

    public void setValidVaccinationCard(boolean hasValidVaccinationCard) {
        this.hasValidVaccinationCard = hasValidVaccinationCard;
    }
}