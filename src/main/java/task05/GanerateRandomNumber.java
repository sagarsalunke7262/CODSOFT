package task05;

import java.util.Random;
import java.util.Scanner;
import java.util.random.RandomGenerator;

public class GanerateRandomNumber {

    private static Scanner scanner=new Scanner(System.in);
    private static int score=100;


    public static int ganerateRandomNo()
    {
        Random random=new Random();

        return random.nextInt(100);
    }

    public static int  getNoFromUser(){
        return scanner.nextInt();
    }

    public  static void guessNo(){

        int i=1;

        int num=ganerateRandomNo();
        while(i<=10){
            System.out.println("Enter No (1-100) : ");
            int no=getNoFromUser();
            if(no<num){
                System.out.println("low !");
            }
            else if(no==num){
                System.out.println("correct !");
                System.out.println("Your score is: "+(getScore()-10)+" /100" );
                break;
            }
            else{
                System.out.println("High !");
            }
            score-=10;
            System.out.println(10-i+" attempts are remaining !");
            i++;
        }
        System.out.println("");
    }

    public static int getScore()
    {
        return score;
    }

    public static void main(String[] args) {

        System.out.println(ganerateRandomNo());

        System.out.println("Select Option:");
        System.out.println("1) Start Game");
        int i = scanner.nextInt();
        if(i==1){
            guessNo();
        }
        else{
            System.out.println("Invalid Option !");
        }

    }


}
