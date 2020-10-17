/*
 * Class to check: Planets.java | Enum functionality
 *
 */
package advanced_java.tests;

import advanced_java.src.*;
import java.text.MessageFormat;

class PlanetsTest {
    private static String loggerMsg = "Assertion Failed: Expected {0} but found {1}";

    public static void testEarth_WhenPlanetsGiven(Planets planets, String expected) {
        String actual = Planets.getText(planets.EARTH);
        assert actual == expected : MessageFormat.format(loggerMsg, expected, actual);
    }

    public static void main(String[] args) {
        testEarth_WhenPlanetsGiven(Planets.EARTH, "earth03");
    }


}