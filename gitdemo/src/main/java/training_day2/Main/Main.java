package training_day2.Main;


import training_day2.ex1.*;
import training_day2.ex2.Pair;


public class Main {

    private static <T> T getMiddle(T... vector)
    {
        return vector[vector.length/2];
    }

    public static Pair<Integer, Integer> minMax(int[] vector)
    {
        Integer aux1=vector[0];
        Integer aux2=vector[0];
        for(int i=1;i<vector.length;i++) {
            if(aux1.compareTo(vector[i])<0)
                aux1=vector[i];
            if(aux2.compareTo(vector[i])>=0)
                aux2=vector[i];
        }
        return (new Pair<Integer, Integer>(aux1,aux2));
    }
    public static Pair<Float,Float> minMaxF(float[] vector)
    {
        Float aux1=vector[0];
        Float aux2=vector[0];
        for(int i=1;i<vector.length;i++) {
            if(aux1.compareTo(vector[i])<0)
                aux1=vector[i];
            if(aux2.compareTo(vector[i])>=0)
                aux2=vector[i];
        }
        return new Pair<Float, Float>(aux1,aux2);
    }
    public static void main(String[] args) {
        Container<Elefant> containerElefant=new Container<>();
        containerElefant.addObject(new Elefant("Elefant1"));
        Container<Carti> containerCarti=new Container<>();
        containerCarti.addObject(new Carti("Algebra"));
        System.out.println(containerCarti.getObiect()+"\n"+containerElefant.getObiect());
//------------------
        ContainerTraining containerTraining = new ContainerTraining();//e nasol fiindca containerul nostru poate contine orice; si e nevoie de cast
        Elefant dumbo = new Elefant("Dumbo");
        Object o = containerTraining.loadContainer(dumbo);
        Elefant myElefant;
        if (o instanceof Elefant)
            myElefant = (Elefant) o;
//---------------------
        //Wrapper classes: Integer,Double, extends Number;

        int[] ints = {32,99,12,5,2};
        float[] floats = {3.14f,9.5f,12.4f,5.0f,2.0f};
        Pair<Integer,Integer> intMaxMin=minMax(ints);
        Pair<Float,Float> floatMaxMin=minMaxF(floats);
        System.out.println(intMaxMin+"\n" +floatMaxMin);
//----------------
        Container container=new Container<>();
        container.addObject("test");
//------------
        //Generic Methods
        Integer[] ints1 = {32,99,12,5,2};
        Float[] floats1 = {3.14f,9.5f,12.4f,5.0f,2.0f};
        System.out.println(getMiddle(ints1));
        System.out.println(getMiddle(floats1));
//------------
        //bounded types
        ContainerMultiple<Animal> boundedContainer=new ContainerMultiple<>();
        boundedContainer.addObject(new Elefant("rara"));
        boundedContainer.addObject(new Leu());
//-----------
        //wildcards <?>- unknown type
       // Container<?> wildCardGen=new Container<>();
       // wildCardGen.addObject(new Elefant("test")); nu va merge(compile error)
        Container<? extends Animal> upperBound=new Container<>();
        // you can't add
        Container<? super Leu> lowerBound=new Container<>();
        lowerBound.addObject(new Leu());//pot adauga tot ce este sub leu
        //pot sa adaug pana la tipul specificat
        //lowerBound.addObject(new Elefant("test"));

        //--------
        //Limitari:-nu se poate instantia tipul generic
        //-compilatorul va inlocui tipul generic cu Object
        //-tipul generic nu poate fi static fiindca e posibil ca 2 obiecte diferite sa aiba 2 tipuri generice diferite
        //-type erasure(liniuta 2)

        //Advantaje:-se elimina type casturile
        //- evitam runtime error, avem compile error
        //- se face boxing si unboxing(automat transforma primitivele in wrapper si invers pt unboxing)





    }
}
