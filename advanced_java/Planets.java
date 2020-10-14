import java.util.*;
public enum Planets {
    MERCURY("mercury"),
    VENUS("venus"),
    EARTH("earth03"),
    MARS("mars"),
    SATURN("saturn"),
    URANUS("uranus"),
    NEPTUNE("neptune"),
    PLUTO("pluto");

    private String name;
    private static HashMap<Planets, String> map = new HashMap<>();

    Planets(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    static {
        for (Planets planet: values()) {
            map.put(planet, planet.getName());
        }
    }

    public static String getText(Planets planet) {
        return map.get(planet);
    }
}