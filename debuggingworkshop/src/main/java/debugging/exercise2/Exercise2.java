package debugging.exercise2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercise2 {

    public static Map<Character, List<Integer>> createIndexList(String string)
    {
        Map<Character,List<Integer>> mapCharacterListIndex=new HashMap<>();
        List<Integer> listAux=null;
        Character aux=null;
        for (int i=0;i<string.length();i++) {
            aux = string.charAt(i);
            if(mapCharacterListIndex.containsKey(aux))
                mapCharacterListIndex.get(aux).add(i);
            else {
                listAux=new ArrayList<>();
                listAux.add(i);
                mapCharacterListIndex.put(aux, listAux);
            }
        }
            return mapCharacterListIndex;
    }

    public static Integer sumOfDigits(Integer number)
    {
        if(number.equals(0))
            return 0;
        else
            return number%10+sumOfDigits(number/10);

    }
    public static void main(String[] args) {

        String helloWorld="Hello world";
        System.out.println(createIndexList(helloWorld));
        System.out.println(sumOfDigits(123456));


    }
}
