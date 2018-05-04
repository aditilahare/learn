package Length;

public class LengthUtils {
    public static double convert(Length length, UnitFactor unit){
        double convertedValue = length.value * unit.getConversionRatio();
        return convertedValue;

    }
    public static boolean compare(Length first,Length second) {
        return (first.inchConversionRatio * first.value)==(second.inchConversionRatio * second.value);
    }
}
