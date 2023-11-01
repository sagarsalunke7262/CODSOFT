package task02;

import java.util.*;

class  Question{
    String question;
    List<String> option=new ArrayList<>(4);

    public Question(String question, List<String> option) {
        this.question = question;
        this.option = option;
    }
}

public class QuizApp {

    static Scanner scanner=new Scanner(System.in);

   // private  List<Question> questions=new ArrayList<>(10);
   private Map<Question,Character> question=new HashMap<>();
   private Map<Question,Character> userAnswer=new HashMap<>();


    public void setQuestionAndOptionAndAnswer(){
        question.put(new Question("what is your name",List.of("Sagar","Mahi","Aniket","Shubham")),'a');
        question.put(new Question("what is your village name",List.of("Vaijapur","Gangapur","Mahalgoan","non of these")),'c');
        question.put(new Question("what is your country name",List.of("USA","Caneda","Pakistan","India")),'d');
        question.put(new Question("what is you brothers name",List.of("sagar","mahi","aniket","shubham","rani")),'b');
        question.put(new Question("what is you sisters name",List.of("sagar","mahi","aniket","shubham","rani")),'c');
        question.put(new Question("what is you mothers name",List.of("sagar","mahi","aniket","shubham","rani")),'d');
    }

    public int noOfQuestions()
    {
        return question.size();
    }



    public  void getQuestion() throws InterruptedException {

        int qNo=1;
        Iterator<Map.Entry<Question, Character>> itr = question.entrySet().iterator();
        while(itr.hasNext()){
            Map.Entry<Question, Character> entry = itr.next();
            Question q=entry.getKey();
            List<String> option=q.option;
            Iterator<String> op = option.iterator();

            System.out.println("\n Q."+qNo+" "+q.question);
            char c ='a';
            while(op.hasNext())
            {
                Thread.sleep(300);
                System.out.println(c+") "+op.next());
                c++;
            }
            System.out.print("Ans:- ");
            Thread.sleep(10000);

            char ans= scanner.next().trim().charAt(0);

            userAnswer.put(q,ans);
            qNo++;
        }
    }

    public  void startQuiz() throws InterruptedException {
        setQuestionAndOptionAndAnswer();
        getQuestion();

    }


    public void getScore()
    {
        int score=0;

        Iterator<Map.Entry<Question, Character>> itr = question.entrySet().iterator();
        while(itr.hasNext()) {
            Map.Entry<Question, Character> entry = itr.next();
            Question q = entry.getKey();
            userAnswer.get(q);
            if (userAnswer.containsKey(q) && question.get(q) == userAnswer.get(q)) {
                score=score+10;
            }
        }

        System.out.println("Your score is : "+score+" /"+(noOfQuestions())*10);
    }

    public  void getcorrectAnswer(){

        int qNo=1;
        Iterator<Map.Entry<Question, Character>> itr = question.entrySet().iterator();
        while(itr.hasNext()) {
            Map.Entry<Question, Character> entry = itr.next();
            Question q = entry.getKey();
            List<String> option=q.option;
            Iterator<String> op = option.iterator();

            System.out.println("\nQ."+qNo+" "+q.question);
            char c ='a';
            while(op.hasNext())
            {
                System.out.println(c+") "+op.next());
                c++;
            }
            System.out.println("Correct Answer:- " +entry.getValue());
            System.out.println("Your Answer:- "+userAnswer.get(q));
            System.out.println("\n");
            qNo++;
        }
    }

    public static void main(String[] args) throws InterruptedException {


        QuizApp quizApp=new QuizApp();

        System.out.println("You want to start Quiz??");
        System.out.println("if yes type y");
        String ch=scanner.next();
        if(ch.startsWith("y")||ch.startsWith("Y") ){
            System.out.println("Your test start within 5 seconds!!!");

            quizApp.startQuiz();
           // Thread.sleep(2000);
            quizApp.getcorrectAnswer();
            Thread.sleep(2000);
            System.out.println("======================================");
            quizApp.getScore();

        }


    }
}
