# Java-Asm2
1 Understand
1.1 Know the Objectives
Upon project completion, you will have acquired a solid understanding of the following concepts and their
implementation in code:
• ArrayList
1.2 Understand the Problem
Once you have read the data into the ArrayList, creating objects for each record, you decide to sort the data
to ensure it is in the most usable order: 1 - country, state, city; 2 – population. For sorting you should create
an Enum Class Sort (Name, Population).
2 Design
2.1 Draw a Class Diagram
Provide a class diagram illustrating the project's structure, including interfaces and all classes, excluding Main.
2.2 Draw an Object Diagram
Submit an object diagram depicting the initial state of the system after adding a few countries and cities,
clearly illustrating the array data and parallelism.
3 Code
3.1 Understand the Details
3.1.1 Sort class
Create the Enum class Sort that has two fields: NAME and POPULATION.
This class will be used for sorting ArrayList.
3.1.2 City
Create a City class that has the following fields, in this order: Name, Country, State, and Population. All of these should
be of String type except Population (integer). Add preconditions to prevent null and empty parameter contents except
for State. Implement interface Comparable<City> and @Override compareTo() method that will use the Enum class
to sort the ArrayList by the specified field..
3.1.3 CityArrayList
This class manages city data, utilizing the CityInterface.java class. Implement methods to access city-data.
Ensure the constructor doesn’t accept any parameters. For the iterator() method, you must create an inner
private class CityIterator implements Iterator<City>.
3.1.4 Files
Utilize the provided data files: cities.txt cities data (for checking the project use citiesShort.txt file). The Main
class must read a file and add data to your CityArrayList.
Page 2 of 3
3.2 Use the Interface(s)
Implement the provided interface(s) exactly as specified. Add helper methods as necessary, without altering
the interface.
3.3 Implement Other Requirements
• Don’t use a standard ArrayList and its methods. You need to write all methods yourself.
• Minimize the use of global variables.
• Avoid public variables; public constants are permitted.
• Expose methods judiciously, hiding internal details.
• Limit I/O operations to Main class o
