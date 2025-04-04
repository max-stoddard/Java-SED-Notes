package sed.lectures.mockObjects.restaurant;

public class HeadChef {

  private final Chef pastryChef;

  public HeadChef(Chef pastryChef) {
    this.pastryChef = pastryChef;
  }

  public void order(Order main, Order dessert) {
    pastryChef.order(dessert);

  }

}
