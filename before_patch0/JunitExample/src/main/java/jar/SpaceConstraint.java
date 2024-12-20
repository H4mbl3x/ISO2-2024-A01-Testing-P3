package jar;
public class SpaceConstraint {
    private int currentCapacity;
    private int maxCapacity;

    public SpaceConstraint(int currentCapacity, int maxCapacity) {
        setCurrentCapacity(currentCapacity);
        setMaxCapacity(maxCapacity);
    }

    public void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public boolean isWithinCapacity() {
        return currentCapacity < maxCapacity;
    }
}