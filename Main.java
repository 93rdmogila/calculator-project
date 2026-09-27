import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        final String SPACE = " ";
        System.out.println("You have to write your math problem through spaces.");
        System.out.println("For example 3 + 1 - correct, 3+1 - incorrect.");
        while(true){
            System.out.print("Write your math problem: ");
            String mathProblem = sc.nextLine();
            if(mathProblem.trim().toLowerCase().equals("exit")){
                break;
            }
            if(mathProblem == null || mathProblem == SPACE){
                System.out.println("Math problem can't be empty");
                return;
            }
            String[] mathProblemArr = mathProblem.split(SPACE);
            try{
                calculate(mathProblem, Integer.parseInt(mathProblemArr[0]), mathProblemArr[1], Integer.parseInt(mathProblemArr[2]));
            }catch(NumberFormatException e){
                System.out.println("Error. Incorrect format. Use: number + number.");
            }
        }
        
        

    }
    private static void calculate(String mathProblem, int firstNumber, String arithmeticSign, int secondNumber){
        switch(arithmeticSign){
            case "+" : System.out.println(mathProblem + " = " + (firstNumber + secondNumber)); break;
            case "-" : System.out.println(mathProblem + " = " + (firstNumber - secondNumber)); break;
            case "/" :
                try{
                    System.out.println(mathProblem + " = " + (firstNumber / secondNumber));
                }catch(ArithmeticException e){
                    System.out.println("Can't divide by zero");
                    break;
                }
                break;
            case "*":
                System.out.println(mathProblem + " = " + (firstNumber * secondNumber)); break;
            default:
                System.out.println("Your arithmetic sign doesn't match with allowed.");
        }
    }
}