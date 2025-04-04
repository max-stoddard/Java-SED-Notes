package sed.lectures.mockObjects;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import sed.lectures.mockObjects.restaurant.Chef;
import sed.lectures.mockObjects.restaurant.HeadChef;
import sed.lectures.mockObjects.restaurant.Order;
import sed.lectures.mockObjects.restaurant.Waiter;

public class MockObjectsTest {
  @Rule
  public JUnitRuleMockery context = new JUnitRuleMockery();

  final Order APPLE_TART = new Order("apple tart");
  final Order ROAST_CHICKEN = new Order("roast chicken");

  Chef pastryChef = context.mock(Chef.class);
  Waiter waiter = context.mock(Waiter.class);

  @Test
  public void delegatesDessertsToPastryChef() {
    HeadChef headChef = new HeadChef(pastryChef, waiter);

    context.checking(new Expectations() {
      {
        exactly(1).of(pastryChef).order(APPLE_TART);
      }
    });

    headChef.order(ROAST_CHICKEN, APPLE_TART);
  }

  @Test
  public void asksWaiterToServeDessertWhenReady() {
    HeadChef headChef = new HeadChef(pastryChef, waiter);

    context.checking(new Expectations() {
      {
        exactly(1).of(pastryChef).isCooked(APPLE_TART);
        will(returnValue(true));
        exactly(1).of(waiter).serve(APPLE_TART);
      }
    });

    headChef.customerReadyFor(APPLE_TART);

  }

  @Test
  public void doesNotAskWaiterToServeWhenNotCooked() {
    HeadChef headChef = new HeadChef(pastryChef, waiter);

    context.checking(new Expectations() {
      {
        exactly(1).of(pastryChef).isCooked(APPLE_TART);
        will(returnValue(false));
      }
    });

    headChef.customerReadyFor(APPLE_TART);

  }
}
