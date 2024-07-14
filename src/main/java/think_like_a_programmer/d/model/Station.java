package think_like_a_programmer.d.model;

public class Station {

  private String name;
  private int parrotsNumber;

  public Station(String name, int observableParrotsNumber) {
    this.name = name;
    this.parrotsNumber = observableParrotsNumber;
  }

  public int getParrotsNumber() {
    return parrotsNumber;
  }

  public String getName() {
    return name;
  }
}
