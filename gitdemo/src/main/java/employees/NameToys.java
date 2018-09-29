package employees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NameToys {
    public static final String IRINA = "Irina";
    public static final String MARIA = "Maria";
    public static Map<String, Integer> employeeFirstNamesFrequencyMap = new HashMap<String, Integer>();

    public static void addEmployeeToFrequencyMap(Employee employee) {
        String firstName = employee.getFirstName();
        if (employeeFirstNamesFrequencyMap.containsKey(firstName)) {
            Integer frequency = employeeFirstNamesFrequencyMap.get(firstName);
            frequency += 1;

            employeeFirstNamesFrequencyMap.put(firstName, frequency);
        } else {
            employeeFirstNamesFrequencyMap.put(firstName, 1);
        }
    }

    public static ArrayList<String> chooseToysName(int n, Map<String, Integer> employeeFirstNamesFrequency) {

        int mapSize = employeeFirstNamesFrequencyMap.entrySet().size();
        if (n <= mapSize) {
            Set<Map.Entry<String, Integer>> setMap = employeeFirstNamesFrequency.entrySet();

            List<Map.Entry<String, Integer>> listSetMap = new ArrayList<Map.Entry<String, Integer>>(setMap);
            Collections.sort(listSetMap, new Comparator<Map.Entry<String, Integer>>() {
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return (-1) * o1.getValue().compareTo(o2.getValue());
                }
            });
            ArrayList<String> toysNames = new ArrayList<String>();
            for (int i = 0; i < n; i++) {
                toysNames.add(listSetMap.get(i).getKey());
            }

            return toysNames;
        }
        System.out.println("Wrong number of toys names. It should be lower or equals to  !!" + mapSize);

        return null;

    }

    public static void main(String[] args) {
        Employee employee1 = new Employee(IRINA, "Ciobotea");
        Employee employee2 = new Employee("Andreea", "X");
        Employee employee3 = new Employee(MARIA, "Y");
        Employee employee4 = new Employee("Cristi", " Z");
        Employee employee5 = new Employee("Liviu", "D");
        Employee employee6 = new Employee(IRINA, "J");
        Employee employee7 = new Employee(MARIA, "Y");
        Employee employee8 = new Employee(IRINA, "Y");
        Employee employee9 = new Employee("Marius", "Z");
        Employee employee10 = new Employee("Georgiana", "D");

        addEmployeeToFrequencyMap(employee1);
        addEmployeeToFrequencyMap(employee2);
        addEmployeeToFrequencyMap(employee3);
        addEmployeeToFrequencyMap(employee4);
        addEmployeeToFrequencyMap(employee5);
        addEmployeeToFrequencyMap(employee6);
        addEmployeeToFrequencyMap(employee7);
        addEmployeeToFrequencyMap(employee8);
        addEmployeeToFrequencyMap(employee9);
        addEmployeeToFrequencyMap(employee10);

        ArrayList<String> strings = chooseToysName(10, employeeFirstNamesFrequencyMap);

        if (strings != null) {
            for (String toyName : strings) {
                System.out.println(toyName);
            }
        }


    }
}
