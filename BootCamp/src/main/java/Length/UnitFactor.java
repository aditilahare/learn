package Length;

public enum UnitFactor {
    FEET(12),INCHES(1);

    private final double conversionRatio;

    UnitFactor(double conversionRatio) {
        this.conversionRatio = conversionRatio;
    }

    public double getConversionRatio() {
        return conversionRatio;
    }
}
