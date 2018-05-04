package Length;

import java.util.Objects;

public class Length {
    public enum LengthUnits {INCHES,FEET}
    protected final double value;
    private final LengthUnits unit;
    protected final double inchConversionRatio;

    private Length(double value, LengthUnits unit,double inchConversionRatio) {
        this.value = value;
        this.unit = unit;
        this.inchConversionRatio = inchConversionRatio;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Length length = (Length) other;
        return LengthUtils.compare(length,this);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unit);
    }

    public static Length inFeet(double feet) {
        return new Length(feet, LengthUnits.FEET,12);
    }

    public static Length inInches(double inches) {
        return new Length(inches, LengthUnits.INCHES,1);
    }

    @Override
    public String toString() {
        return "Length{" +
                "value=" + value +
                ", unit=" + unit +
                ", inchConversionRatio=" + inchConversionRatio +
                '}';
    }
}
