package java8.lambda;

public class LambdaExercise {
    public static void main(String[] args) {
        // add
        Calculator calculatorAdd = (x, y) -> x + y;

        // TODO subtract
        Calculator calculatorSubtract=(x,y)->x-y;

        // TODO divide
        Calculator calculatorDivide=(x,y)->(y!=0)?x/y:-1;

        // TODO multiply
        Calculator calculatorMultiply=(x,y)->x*y;

        // test all
        System.out.println(calculatorAdd.calculate(1, 2));
        //TODO uncomment after handling the other todos
       System.out.println(calculatorSubtract.calculate(1, 2));
       System.out.println(calculatorDivide.calculate(1, 2));
       System.out.println(calculatorMultiply.calculate(1, 2));
    }
}
