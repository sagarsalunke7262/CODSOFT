package task04;

import java.sql.SQLOutput;
import java.util.*;

public class GradingSystem {
    private char grade;
    private float percentage;
    private float avg;
    private  float totalMark;
    Map<String,Float> marks=new HashMap<>();
    List<String> subjects=List.of("Hindi","English","Science","Math","History","Geography");
    Scanner scanner=new Scanner(System.in);


    private void setMark(){

        int n=0;
        float mark=0;
        while(n<subjects.size()){

            System.out.println("Enter marks for "+subjects.get(n));
            mark=scanner.nextFloat();
            marks.put(subjects.get(n),mark);

            n++;
        }
    }


    private void calculateResult(){
        setMark();
        Iterator<Map.Entry<String, Float>> iterator = marks.entrySet().iterator();

        while(iterator.hasNext()){
            totalMark+=iterator.next().getValue();
        }

        percentage=(totalMark)/subjects.size();
        avg=totalMark/marks.size();

        if (percentage>90.0){
            grade='O';

        }
        else if(percentage>70.0){
            grade='A';
        }
        else if(percentage>60)
        {
            grade='B';
        }
        else if(percentage>50)
        {
            grade='C';
        }
        else {
            grade='D';
        }
    }

    public void getResult(){
        calculateResult();
        System.out.println("Total marks="+totalMark);
        System.out.println("avrage percentage= "+percentage);
        System.out.println("Grade= "+grade);
    }
    public static void main(String[] args) {

        GradingSystem gradingSystem=new GradingSystem();
        gradingSystem.getResult();
    }
}
