package HW2arrays; // Defines the package name
                                                                                      // Morgan Pickens
                                                                                      // 5/21/2024
import java.util.Iterator;
import java.util.NoSuchElementException;

// Class that implements CityInterface and Iterable<City>
public class CityArrayList implements CityInterface, Iterable<City> {
    private City[] cities; // Array to store City objects
    private int size; // Number of cities currently stored

    // Constructor to initialize the array and size
    public CityArrayList() {
        cities = new City[10]; // Initial capacity of 10
        size = 0; // Initial size is 0
    }

    // Ensures the array has enough capacity to add more cities
    private void ensureCapacity() {
        if (size >= cities.length) { // Check if the array is full
            City[] newCities = new City[cities.length * 2]; // Double the array size
            System.arraycopy(cities, 0, newCities, 0, cities.length); // Copy old array to new array
            cities = newCities; // Replace old array with new array
        }
    }

    @Override
    public int getCityCount() {
        return size; // Return the number of cities in the array
    }

    @Override
    public City getCity(int index) {
        if (index < 0 || index >= size) { // Check for invalid index
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return cities[index]; // Return the city at the specified index
    }

    @Override
    public void removeCity(int index) {
        if (index < 0 || index >= size) { // Check for invalid index
            throw new IndexOutOfBoundsException("Invalid index");
        }
        // Shift elements to the left to fill the gap
        System.arraycopy(cities, index + 1, cities, index, size - index - 1);
        cities[--size] = null; // Decrease size and nullify the last element
    }

    @Override
    public City[] getCityArray(String country, String state) {
        if (country == null || country.isEmpty() || state == null || state.isEmpty()) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        City[] result = new City[size]; // Temporary array to store matching cities
        int count = 0; // Counter for matching cities
        for (int i = 0; i < size; i++) {
            if (cities[i].getCountry().equals(country) && cities[i].getState().equals(state)) {
                result[count++] = cities[i]; // Add matching city to result array
            }
        }
        City[] trimmedResult = new City[count]; // Create a trimmed array of exact size
        System.arraycopy(result, 0, trimmedResult, 0, count); // Copy matching cities to trimmed array
        return trimmedResult; // Return the array of matching cities
    }

    @Override
    public City[] getCityArray(String country) {
        if (country == null || country.isEmpty()) {
            throw new IllegalArgumentException("Invalid argument");
        }
        City[] result = new City[size]; // Temporary array to store matching cities
        int count = 0; // Counter for matching cities
        for (int i = 0; i < size; i++) {
            if (cities[i].getCountry().equals(country)) {
                result[count++] = cities[i]; // Add matching city to result array
            }
        }
        City[] trimmedResult = new City[count]; // Create a trimmed array of exact size
        System.arraycopy(result, 0, trimmedResult, 0, count); // Copy matching cities to trimmed array
        return trimmedResult; // Return the array of matching cities
    }

    @Override
    public void addCity(City city) {
        if (city == null) {
            throw new IllegalArgumentException("City cannot be null");
        }
        ensureCapacity(); // Ensure there is enough capacity
        cities[size++] = city; // Add the city to the array and increase the size
    }

    @Override
    public void addCitySorted(City city) {
        if (city == null) {
            throw new IllegalArgumentException("City cannot be null");
        }
        ensureCapacity(); // Ensure there is enough capacity
        int i = size - 1;
        // Shift elements to the right to make room for the new city in sorted order
        while (i >= 0 && city.compareTo(cities[i]) < 0) {
            cities[i + 1] = cities[i];
            i--;
        }
        cities[i + 1] = city; // Insert the new city
        size++; // Increase the size
    }

    @Override
    public City[] getCityArray(int minP, int maxP) {
        City[] result = new City[size]; // Temporary array to store matching cities
        int count = 0; // Counter for matching cities
        for (int i = 0; i < size; i++) {
            if (cities[i].getPopulation() >= minP && cities[i].getPopulation() <= maxP) {
                result[count++] = cities[i]; // Add matching city to result array
            }
        }
        City[] trimmedResult = new City[count]; // Create a trimmed array of exact size
        System.arraycopy(result, 0, trimmedResult, 0, count); // Copy matching cities to trimmed array
        return trimmedResult; // Return the array of matching cities
    }

    @Override
    public Iterator<City> iterator() {
        return new CityIterator(); // Return a new CityIterator
    }

    // Inner class that implements Iterator<City> to iterate over City objects
    private class CityIterator implements Iterator<City> {
        private int currentIndex = 0; // Current index in the iteration

        @Override
        public boolean hasNext() {
            return currentIndex < size; // Check if there are more elements
        }

        @Override
        public City next() {
            if (!hasNext()) { // Check if there are no more elements
                throw new NoSuchElementException("No more elements");
            }
            return cities[currentIndex++]; // Return the next city
        }
    }
}
