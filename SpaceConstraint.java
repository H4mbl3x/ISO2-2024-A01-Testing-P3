public class SpaceConstraint {
    private int currentCapacity;
    private int maxCapacity;

    public SpaceConstraint(int currentCapacity, int maxCapacity) {
        this.currentCapacity = currentCapacity;
        this.maxCapacity = maxCapacity;
    }

    public boolean isWithinCapacity() {
        return currentCapacity < maxCapacity;
    }
}