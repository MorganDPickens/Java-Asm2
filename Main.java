package HW2arrays;                                                                                              //Morgan Pickens
                                                                                                                //5/21/2024  
import java.io.BufferedReader;                                        
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        CityArrayList cityList = new CityArrayList(); // Create CityArrayList

        String fileName = "cities.txt"; // Use appropriate file name here

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) { // Read file
            String line;
            br.readLine(); // Skip the first malformed line
            while ((line = br.readLine()) != null) { // Loop through lines
                line = line.trim(); // Trim the line
                if (!line.isEmpty()) { // Skip empty lines
                    String[] parts = line.split("\\s+", 2); // Split line by whitespace into two parts
                    if (parts.length == 2) { // Check length
                        try {
                            int population = Integer.parseInt(parts[0].trim()); // Get population
                            String[] cityParts = parts[1].split(", "); // Split city details
                            String name = cityParts[0].trim(); // Get name
                            String country, state = "";
                            if (cityParts.length == 3) {
                                country = cityParts[2].trim(); // Get country
                                state = cityParts[1].trim(); // Get state
                            } else {
                                country = cityParts[1].trim(); // Get country if no state
                            }
                            cityList.addCitySorted(new City(name, country, state, population)); // Add city
                        } catch (NumberFormatException e) {
                            System.err.println("Skipping malformed line: " + line); // Print error
                        }
                    } else {
                        System.err.println("Skipping malformed line: " + line); // Print error
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Print error
        }

        for (City city : cityList) { // Print cities
            System.out.println(city);
        }
    }
}

