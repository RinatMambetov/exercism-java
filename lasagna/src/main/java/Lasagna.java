public class Lasagna {
    // TODO: define the 'expectedMinutesInOven()' method
    public static int expectedMinutesInOven() {
        return 40;
    }

    // TODO: define the 'remainingMinutesInOven()' method
    public static int remainingMinutesInOven(int minutesHasBeenInTheOven) {
        return expectedMinutesInOven() - minutesHasBeenInTheOven;
    }

    // TODO: define the 'preparationTimeInMinutes()' method
    public static int preparationTimeInMinutes(int numberOfLayers) {
        return numberOfLayers * 2;
    }

    // TODO: define the 'totalTimeInMinutes()' method
    public static int totalTimeInMinutes(int numberOfLayers, int minutesHasBeenInTheOven) {
        return minutesHasBeenInTheOven + preparationTimeInMinutes(numberOfLayers);
    }
}
