import Length.Length;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LengthTest {
    @Test
    public void shouldEquals1FeetWith1Feet() {
        Length oneFoot = Length.inFeet(1.0);
        Length expectedFoot = Length.inFeet(1.0);
        assertThat(oneFoot,is(expectedFoot));
    }

    @Test
    public void shouldEquals1FeetWith12Inches() {
        Length oneFoot = Length.inFeet(1.0);
        Length twelveInches = Length.inInches(12);
        assertThat(oneFoot,is(twelveInches));
    }

    @Test
    public void equalsTwentyFourInchesWithTwoFeet() {
        Length twoFeet = Length.inFeet(2);
        Length twentyFourInches = Length.inInches(24);
        assertThat(twoFeet,is(twentyFourInches));
    }
}
