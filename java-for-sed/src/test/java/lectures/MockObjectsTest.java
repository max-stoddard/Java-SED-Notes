package lectures;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

public class MockObjectsTest {

    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

    final Order ROAST_CHICKEN = new Order("roast chicken");
    final Order APPLE_TART = new Order("apple tart");

    Chef pastryChef = context.mock(Chef.class);
    HeadChef headChef = new HeadChef(pastryChef);

    @Test
    public void delegatesPuddingsToPastryChef() {
        context.checking(new Expectations() {{
            exactly(1).of(pastryChef).order(APPLE_TART);
        }});

        headChef.order(ROAST_CHICKEN, APPLE_TART);
    }
}

