package training_day3.collections;


import sun.awt.SunHints;
import training_day3.emplyee.Employee;

import java.util.*;

/*ListIterator permite parcurgerea si in stanga si dreapta
for(ListItearator<Type> it=list.listIterator(list.size());it.hasPrevious;){
    Type t= it.previous();
}
-------
ArrayList -simplu inlantuita
LinkedList- dublu inlantuita
--------
Vector fata de ArrayList are toate metodele synchronised

Queue
pentru insert: -add(e)-adauga dar nu tine de restrictiile cozii
               -offer(e)- adauga dar tine cont de restrictii cozii
pentru remove: -remove()
               -poll()-intoarece capul cozii sau null daca e goala coada
                -peek()- returneaza capul
Priority Queue
----
hashcode-metoda care calculeaza un hash
        -suprascriere cand se doreste ca obiectul sa avem un identificator unic
        -hashcode-el este acelasi pentru 2 obiecte equals
        -hashscode-ul este equals pentru 2 obiecte nu inseamna neaparat ca acele 2 obiecte sunt equals
        -obiecte care nu sunt equals au acelasi hashcode
        -hashcode trebuie sa aiba aceeasi valoare indiferent de cate ori se apeleaza functia

HashMap <=> HashTable

interface Collection
class Collections
 */
public class Main {
    private static Employee employee1=new Employee ("Irina", "Ciobotea");
    private static Employee employee2=new Employee ("Maria", "Ciobotea");
    private static Employee employee3=new Employee ("Andreea", "Ciobotea");
    private static Employee employee4=new Employee ("Cristi", "Ciobotea");
    private static Employee employee5=new Employee ("Liviu", "Ciobotea");
    private static Employee employee6=new Employee ("Irina", "Ciobotea");
    private static Employee employee7=new Employee ("Maria", "Ciobotea");
    private static Employee employee8=new Employee ("Irina", "Ciobotea");
    private static Employee employee9=new Employee ("Marius", "Ciobotea");
    private static Employee employee10=new Employee ("Georgiana", "Ciobotea");
    private static Employee employee11=new Employee ("Alin", "Ciobotea");

    public static Collection<String> alegePrenumele(int n,Collection<Employee> employeeList)
    {

        Map<String, Integer> mapName=new HashMap<>();

        for(Employee employee:employeeList)
            if(mapName.containsKey(employee.getLast_name()))
                mapName.replace(employee.getLast_name(),mapName.get(employee.getLast_name()),mapName.get(employee.getLast_name())+1);
            else
                mapName.put(employee.getLast_name(),1);
            Set<Map.Entry<String,Integer>> set=mapName.entrySet();

            List<Map.Entry<String,Integer>> entries= new ArrayList<>(set);
            Collections.sort(entries,Comparator.comparing(Map.Entry::getValue) );
            List<String> listName = new ArrayList<>();
            for(int i=entries.size()-1;i>=entries.size()-n;i--)
                listName.add(entries.get(i).getKey());
            return listName;



    }
    public static void main(String[] args) {

        Employee[] employees={employee1,employee2,employee3,employee4,employee5,employee6,employee7,employee8,employee9,employee10,employee11};
        List<String> list= (List<String>) alegePrenumele(2,Arrays.asList(employees));

        System.out.println(list);


    }
}
