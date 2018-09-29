package java8.lambda;

public class LambdaExample {
    public static void main(String[] args) {
        // parentheses for multiple params
        Calculator calculatorAdd = (x, y) -> x + y;
        // return and braces for one liners
        Calculator calculatorAdd2 = (x, y) -> x + y;
        // effectively final
        int zero=0;
        Calculator calculatorAdd3 = (x, y) -> zero+x + y;//merge doar daca pentru zero nu se reasigneaza


    }
}
