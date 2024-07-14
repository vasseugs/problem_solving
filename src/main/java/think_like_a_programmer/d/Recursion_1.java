package think_like_a_programmer.d;

import think_like_a_programmer.d.model.Station;

import java.util.List;

public class Recursion_1 {

  /*
  Задача с рекурсией, про попугаев стр. 188
   */

  public static void main(String[] args) {
    Station station_1 = new Station("Art", 7);
    Station station_2 = new Station("Belinda", 5);
    Station station_3 = new Station("Cory", 3);
    Station station_4 = new Station("Debbie", 10);
    Station station_5 = new Station("Evan", 2);

    List<Station> stations = List.of(
        station_1,
        station_2,
        station_3,
        station_4,
        station_5
    );

    int overallParrotsCount = accumulateSumToTheEnd(stations, station_1, 0);
    System.out.println("After tail recursion: " + overallParrotsCount);

    overallParrotsCount = tailRecursion(stations, station_1);
    System.out.println("After tail recursion: " + overallParrotsCount);

    overallParrotsCount = headRecursion(stations);
    System.out.println("After head recursion: " + overallParrotsCount);
  }

  /*
  Каждый последующая станция суммирует количество попугаев с предыдущих станций со своим и передает эту информацию дальше
   */
  private static int accumulateSumToTheEnd(List<Station> stations, Station station, int overallParrotsNumber) {
    overallParrotsNumber += station.getParrotsNumber();

    System.out.println("Processing station: " + station.getName() + ". Parrots on station: " + station.getParrotsNumber()
        + " Overall parrots number: " + overallParrotsNumber);

    // если это последняя станция
    if (stations.indexOf(station) == stations.size() - 1) {
      System.out.println("Base case occured");
      return overallParrotsNumber;
    }

    Station nexStation = stations.get(stations.indexOf(station) + 1);
    System.out.println("Proceeding to the station " + nexStation.getName());

    return accumulateSumToTheEnd(stations, nexStation, overallParrotsNumber);
  }

  /**
   * Алгоритм доходит до последней станции, а оттуда по нарастающей
   * обратно передается количество попугаев к первой станции
   */
  private static int tailRecursion(List<Station> stations, Station station) {
    System.out.println("Processing station: " + station.getName() + ". Parrots on station: " + station.getParrotsNumber());

    // если это последняя станция
    if (stations.indexOf(station) == stations.size() - 1) {
      System.out.println("Base case occured");
      return station.getParrotsNumber();
    }

    Station nexStation = stations.get(stations.indexOf(station) + 1);
    System.out.println("Proceeding to the station " + nexStation.getName());

    return tailRecursion(stations, nexStation) + station.getParrotsNumber();
  }

  private static int headRecursion(List<Station> stations) {
    if (stations.isEmpty()) {
      return 0;
    }
    int result = headRecursion(stations.subList(1, stations.size()));
    return stations.get(0).getParrotsNumber() + result;
  }

}
