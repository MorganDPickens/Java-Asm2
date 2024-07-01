package HW2arrays;                                                                                     // Morgan Pickens
                                                                                                       // 5/21/2024
public class City implements Comparable<City> {
    private String name; // this is 4 City name
    private String country; // 4 Country name
    private String state; // 4 State name (can be null)
    private int population; // 4 Population

    private static Sort sortCriteria = Sort.NAME; // Default srt criteria

    public City(String name, String country, String state, int population) {
        if (name == null || name.isEmpty() || country == null || country.isEmpty() || population < 0) {
            throw new IllegalArgumentException("Invalid arguments"); // Pre conditions
        }
        this.name = name;
        this.country = country;
        this.state = state;
        this.population = population;
    }

    public static void setSortCriteria(Sort criteria) {
        sortCriteria = criteria; // Set sort criteria
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public int getPopulation() {
        return population;
    }

    @Override
    public int compareTo(City other) {
        switch (sortCriteria) {
            case POPULATION:
                return Integer.compare(this.population, other.population); // Compare by population
            case NAME:
            default:
                int countryCmp = this.country.compareTo(other.country); // Compare by country
                if (countryCmp != 0) return countryCmp;
                int stateCmp = this.state.compareTo(other.state); // Compare by state
                if (stateCmp != 0) return stateCmp;
                return this.name.compareTo(other.name); // Compare by name
        }
    }

    @Override
    public String toString() {
        return name + ", " + country + ", " + state + ", " + population; // String representation
    }
}

