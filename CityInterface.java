package HW2arrays;                                                                                     //Morgan Pickens
                                                                                                       //5/21/2024
import java.util.Iterator;

public interface CityInterface {
    public int getCityCount();

    public City getCity(int index);

    public void removeCity(int index);

    public City[] getCityArray(String country, String state);

    public City[] getCityArray(String country);

    public void addCity(City city);

    public void addCitySorted(City city);

    public City[] getCityArray(int minP, int maxP);

    public Iterator<City> iterator();
}
