package sed.lectures.mockObjects.restaurant;

public class HeadChef {

  private final Chef pastryChef;
  private final Waiter waiter;

  public HeadChef(Chef pastryChef, Waiter waiter) {
    this.pastryChef = pastryChef;
    this.waiter = waiter;
  }

  public void order(Order main, Order dessert) {
    pastryChef.order(dessert);
  }

  public void customerReadyFor(Order dessert) {
    if (pastryChef.isCooked(dessert)) {
      waiter.serve(dessert);
    }
  }

}
