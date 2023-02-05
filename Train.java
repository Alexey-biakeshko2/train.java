import java.util.Arrays;
import java.util.Comparator;

public class Train {

  String destination;
  int number;
  int departureTime;

  public Train(String destination, int number, int departureTime) {
    this.destination = destination;
    this.number = number;
    this.departureTime = departureTime;
  }

  public static void main(String[] args) {
    Train[] trains = new Train[5];

    trains[0] = new Train("London", 42, 1);
    trains[1] = new Train("Manchester", 38, 2);
    trains[2] = new Train("Brighton", 73, 3);
    trains[3] = new Train("London", 54, 4);
    trains[4] = new Train("Liverpool", 32, 5);

    sortByTrainNumber(trains);

    System.out.println("Sorted by train number:");
    printTrains(trains);

    sortByDestination(trains);

    System.out.println();
    System.out.println("Sorted by destination:");
    printTrains(trains);

    System.out.println();
    System.out.println("Train info by train number: 73");
    showInfo(trains, 73);
  }

  private static void sortByTrainNumber(Train[] trains) {
    Arrays.sort(trains, Comparator.comparing(t -> t.number));
  }

  private static void sortByDestination(Train[] trains) {
    Comparator<Train> compareByDestination = Comparator.comparing(t -> t.destination);
    Comparator<Train> compareByDepartureTime = Comparator.comparing(t -> t.departureTime);
    Comparator<Train> comparator = compareByDestination.thenComparing(compareByDepartureTime);

    Arrays.sort(trains, comparator);
  }


  private static void printTrains(Train[] trains) {
    for (Train train : trains) {
      System.out.println(train.number + ": " + train.destination + ", departing at: " + train.departureTime);
    }
  }

  private static void showInfo(Train[] trains, int trainNumber) {
    for (Train train : trains) {
      if (train.number == trainNumber) {
        System.out.println(train.number + ": " + train.destination + ", departing at: " + train.departureTime);
      }
    }
  }
}