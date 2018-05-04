package com.thoughtworks.Measurement;

import org.junit.Before;
import org.junit.Test;

import static com.thoughtworks.Measurement.Unit.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ArithmaticMeasurementTest {
    private ArithmaticMeasurement oneFoot;
    private ArithmaticMeasurement oneCentimeter;
    private ArithmaticMeasurement tenMilimeter;
    private ArithmaticMeasurement oneGallon;
    private ArithmaticMeasurement literValueOfOneGallon;
    private ArithmaticMeasurement oneKg;
    private ArithmaticMeasurement thousandGrams;

    @Before
    public void setUp() {
        oneKg = ArithmaticMeasurement.inKg(1f);
        thousandGrams = ArithmaticMeasurement.inGrams(1000f);
        oneGallon = ArithmaticMeasurement.inGallon(1);
        literValueOfOneGallon = ArithmaticMeasurement.inLiter(3.78f);
        tenMilimeter = ArithmaticMeasurement.inMilimeter(10);
        oneFoot = ArithmaticMeasurement.inFeet((float) 1);
        oneCentimeter = ArithmaticMeasurement.inCentimeter(1);
    }

    @Test
    public void ShouldAssertWhenTwoEqualQuantityWithOneFootAreCompared() {
        assertEquals(oneFoot, oneFoot);
    }

    @Test
    public void ShouldAssertWhenOneFootComparedWithOneFoot() {
        assertEquals(oneFoot, oneFoot);
    }

    @Test
    public void ShouldAssertWhenOneFootComparedWithTwelveInches() {
        assertEquals(oneFoot, ArithmaticMeasurement.inInches((float) 12));
    }

    @Test
    public void ShouldAssertWhenTwelveInchesComparedWithOneFeet() {
        assertEquals(ArithmaticMeasurement.inInches((float) 12), oneFoot);
    }

    @Test
    public void ShouldAssertAnyGivenQuantity() {
        ArithmaticMeasurement twoFeets = ArithmaticMeasurement.inFeet((float) 2);
        assertEquals(ArithmaticMeasurement.inInches((float) 24), twoFeets);
    }

    @Test
    public void ShouldAssertWhenOneCentimeterIsComparedToOneCentimeter() {
        assertEquals(oneCentimeter, oneCentimeter);
    }

    @Test
    public void ShouldAssertWhenOneCmComparedWithRespectiveInches() {
        assertEquals(oneCentimeter, ArithmaticMeasurement.inInches(0.4f));
    }

    @Test
    public void ShouldAssertWhenAnyGivenValueInCmToItsRespectiveValueInInches() {
        ArithmaticMeasurement sixCentimeter = ArithmaticMeasurement.inCentimeter(6);
        ArithmaticMeasurement expectedInches = ArithmaticMeasurement.inInches(2.4f);
        assertEquals(sixCentimeter, expectedInches);
    }

    @Test
    public void ShouldAssertWhenOneCmComparedWithTenMm() {
        assertEquals(oneCentimeter, tenMilimeter);
    }

    @Test
    public void ShouldAssertWhenAnyGivenValueInCmComparedWithRespectiveMmValue() {
        ArithmaticMeasurement fiveCentimeter = ArithmaticMeasurement.inCentimeter(5);
        ArithmaticMeasurement fiftyMillimeter = ArithmaticMeasurement.inMilimeter(50);
        assertEquals(fiveCentimeter, fiftyMillimeter);
        assertEquals(fiveCentimeter.hashCode(), fiftyMillimeter.hashCode());
    }


    @Test
    public void ShouldAssertOneGallonWithOneGallon() {
        assertEquals(oneGallon, oneGallon);
    }

    @Test
    public void ShouldAssertOneGallonWithRespectiveLiterValue() {
        assertEquals(oneGallon, literValueOfOneGallon);
    }

    @Test
    public void ShouldAssertAnyGivenGallonWithRespectiveLiterValue() {
        ArithmaticMeasurement tenGallonsValueInLiters = ArithmaticMeasurement.inLiter(37.8f);
        ArithmaticMeasurement tenGallon = ArithmaticMeasurement.inGallon(10f);
        assertThat(tenGallonsValueInLiters,is(tenGallon));
    }

    @Test
    public void ShouldAssertOneKgWithOneKg() {
        assertEquals(oneKg, oneKg);
    }

    @Test
    public void ShouldAssertOneKgWithThousandGrams() {
        assertEquals(oneKg, thousandGrams);
    }

    @Test
    public void ShouldAssertAnyKgWithRespectiveValueInGrams() {
        ArithmaticMeasurement fiveThousandGrams = ArithmaticMeasurement.inGrams(5000f);
        ArithmaticMeasurement fiveKg = ArithmaticMeasurement.inKg(5f);
        assertEquals(fiveThousandGrams, fiveKg);
    }

    @Test
    public void ShouldAssertOneTonWithThousandKg() {
        ArithmaticMeasurement thousandKg = ArithmaticMeasurement.inKg(1000f);
        ArithmaticMeasurement oneTon = ArithmaticMeasurement.inTon(1f);
        assertEquals(thousandKg, oneTon);
    }

    @Test
    public void ShouldAssertAnyTonWithRespectiveKg() {
        ArithmaticMeasurement fiveThousandKg = ArithmaticMeasurement.inKg(5000f);
        ArithmaticMeasurement fiveTon = ArithmaticMeasurement.inTon(5f);
        assertEquals(fiveThousandKg, fiveTon);
    }

    @Test
    public void ShouldReturnFalseWhenComparingIncompatibleMeasurementTypes() {
        ArithmaticMeasurement fiveThousandKg = ArithmaticMeasurement.inKg(5000f);
        ArithmaticMeasurement fiveTon = ArithmaticMeasurement.inTon(5f);
        assertEquals(fiveThousandKg, fiveTon);
    }

    @Test(expected = IncompatibleMeasurementTypeException.class)
    public void ShouldThrowExceptionForIncompatibleMeasurementTypes() throws IncompatibleMeasurementTypeException {
        ArithmaticMeasurement twoInches = ArithmaticMeasurement.inInches(2);
        ArithmaticMeasurement fiveTon = ArithmaticMeasurement.inTon(5f);
        fiveTon.add(twoInches);
    }

    @Test
    public void ShouldAddTwoQuantitiesOfInches() throws IncompatibleMeasurementTypeException {
        ArithmaticMeasurement twoInches = ArithmaticMeasurement.inInches(2);
        ArithmaticMeasurement fourInches = ArithmaticMeasurement.inInches(4);
        assertEquals(twoInches.add(twoInches), fourInches);
    }

    @Test
    public void ShouldAssertFalsyWhileComparing3InchesWith4Inches() throws IncompatibleMeasurementTypeException {
        ArithmaticMeasurement twoInches = ArithmaticMeasurement.inInches(2);
        ArithmaticMeasurement threeInches = ArithmaticMeasurement.inInches(3);
        assertNotEquals(twoInches.add(twoInches), threeInches);
        assertNotEquals(twoInches.hashCode(), threeInches.hashCode());
    }

    @Test
    public void ShouldAddTwoDifferentUnitsOfSameMeasurementType() throws IncompatibleMeasurementTypeException {
        ArithmaticMeasurement twoInches = ArithmaticMeasurement.inInches(2);
        ArithmaticMeasurement twoPointFiveCentimeter = ArithmaticMeasurement.inCentimeter(2.5f);
        ArithmaticMeasurement threeInches = ArithmaticMeasurement.inInches(3);
        assertEquals(twoInches.add(twoPointFiveCentimeter), threeInches);
    }

    @Test
    public void ShouldAssertFalsyWhileComparingThreeInchesWithFourInches() throws IncompatibleMeasurementTypeException {
        ArithmaticMeasurement oneInch = ArithmaticMeasurement.inInches(1);
        ArithmaticMeasurement twoPointFiveCentimeter = ArithmaticMeasurement.inCentimeter(2.5f);
        ArithmaticMeasurement fiveCentimeter = ArithmaticMeasurement.inCentimeter(5);
        assertFalse(oneInch.add(twoPointFiveCentimeter).strictEquals(fiveCentimeter));
    }

    @Test
    public void ShouldConvertAnyUnitIntoGivenStandardUnit() throws IncompatibleMeasurementTypeException {
        ArithmaticMeasurement oneFeet = ArithmaticMeasurement.inFeet(1);
        ArithmaticMeasurement twelveInches = ArithmaticMeasurement.inInches(12);
        ArithmaticMeasurement convertedInches = oneFeet.toUnit(INCHES);
        assertEquals(twelveInches, convertedInches);
        assertTrue(twelveInches.strictEquals(convertedInches));
    }

    @Test
    public void shouldNotConvertIntoExceptGivenStandard() throws IncompatibleMeasurementTypeException {
        ArithmaticMeasurement thousandKg = ArithmaticMeasurement.inKg(1000);
        ArithmaticMeasurement oneTon = ArithmaticMeasurement.inTon(1);
        assertFalse(thousandKg.toUnit(GRAMS).strictEquals(oneTon));
    }

    @Test (expected = IncompatibleMeasurementTypeException.class)
    public void shouldThrowExceptionWhenConvertingIntoDifferentTypeOfMeasurement() throws IncompatibleMeasurementTypeException {
        ArithmaticMeasurement thousandKg = ArithmaticMeasurement.inKg(1000);
        thousandKg.toUnit(FEET);
    }

    @Test
    public void ShouldAddTwoDifferentUnitsOfVolume() throws IncompatibleMeasurementTypeException {
        ArithmaticMeasurement twoLiter = ArithmaticMeasurement.inLiter(2);
        ArithmaticMeasurement oneGallon = ArithmaticMeasurement.inGallon(1f);
        ArithmaticMeasurement fivePointSevenEightLiter = ArithmaticMeasurement.inLiter(5.78f);
        assertEquals(twoLiter.add(oneGallon), fivePointSevenEightLiter);
    }

    @Test
    public void shouldAddTwoDifferentUnitsOfLength() throws IncompatibleMeasurementTypeException {
        ArithmaticMeasurement twoKg = ArithmaticMeasurement.inKg(2);
        ArithmaticMeasurement twoThousandGrams = ArithmaticMeasurement.inGrams(2000);
        ArithmaticMeasurement fourKg = ArithmaticMeasurement.inKg(4);
        assertEquals(twoKg.add(twoThousandGrams),(fourKg));
    }
}
