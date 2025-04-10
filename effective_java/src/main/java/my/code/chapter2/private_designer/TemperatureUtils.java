package my.code.chapter2.private_designer;

public class TemperatureUtils {

    private TemperatureUtils() {
        throw new AssertionError("It's not allowed to instantiate");
    }

    public static double celsiusToFahrenheit(double celsius) {
        return celsius * 9 / 5 + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}
