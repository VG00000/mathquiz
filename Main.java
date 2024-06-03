import java.util.Scanner;
import java.io.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        System.out.println("Enter your name: ");
        String userName = sc.nextLine();
        String fileName = userName + "-answers.txt";

        try (FileWriter writer = new FileWriter(String.valueOf(new FileWriter(fileName)))) {
            for(int i = 0;i <5; i++){
                int n1=r.nextInt(100) + 1;
                int n2=r.nextInt(100) + 1;
                char operation = "+-x".charAt(r.nextInt(3));

                int correctAns=0;
                boolean validOp= true;
                switch(operation){
                    case '+':
                        correctAns= n1+ n2;
                        break;
                    case '-':
                        correctAns= n1-n2;
                        break;
                    case 'x':
                        correctAns=n1*n2;
                        break;
                    default:
                        validOp=false;
                        break;
                }
                if(validOp){
                    System.out.printf("%d %c %d = ? ", n1, operation, n2);
                    int userAnswer=sc.nextInt();
                    boolean isCorrect = userAnswer ==correctAns;
                    writer.write(String.format("%d %c %d = %d (Your asnwer: %d) - %s\n", n1, operation, n2, correctAns, userAnswer, isCorrect ? "Correct" : "Incorrect"));
                }
                else{
                    i--;
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        System.out.println("Assessment completed! Your answers have been saved to " + fileName );
    }
}