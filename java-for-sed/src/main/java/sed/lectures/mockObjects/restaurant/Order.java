package sed.lectures.mockObjects.restaurant;

public class Order {
  public final String name;

  public Order(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Order {" +
        "name='" + name + '\'' +
        '}';
  }
}
