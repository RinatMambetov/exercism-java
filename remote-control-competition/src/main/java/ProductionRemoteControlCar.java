class ProductionRemoteControlCar implements RemoteControlCar, Comparable {
    private int distance = 0;
    private int victories = 0;

    public void drive() {
        final int DISTANCE_BY_ONE_DRIVE = 10;
        distance += DISTANCE_BY_ONE_DRIVE;
    }

    public int getDistanceTravelled() {
        return distance;
    }

    public int getNumberOfVictories() {
        return victories;
    }

    public void setNumberOfVictories(int numberOfVictories) {
        victories = numberOfVictories;
    }

    @Override
    public int compareTo(Object obj) {
        return ((ProductionRemoteControlCar) obj).getNumberOfVictories() - this.getNumberOfVictories();
    }
}
