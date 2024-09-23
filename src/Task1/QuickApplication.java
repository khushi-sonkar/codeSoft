package Task1;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuickApplication{
    static class QuizeQuestion{
        String question;
        String[] option;
        char correctAnswer;
        public QuizeQuestion(String question,String[] option,char correctAnswer){
            this.question = question;
            this.option =option;
            this.correctAnswer =correctAnswer;

        }
    }
    static QuizeQuestion[] questions ={
            new QuizeQuestion("What is the capital of france?", new String[]{"A) Paris","B)London","C)Berlin","D)Rome"},'A'),
            new QuizeQuestion("What is the largest planet in our Solar System?", new String[]{"A)Earth","B)Jupiter","C)Saturn","D)Mars"},'B'),
            new QuizeQuestion("Who Wrote 'HALMET'?",new String[]{"A)CHARLES DICKENS","B)J.K.ROWLING","C)WILLIAM SHAKESPEARE","D)Mark Twain"},'C')
    };
    static int score = 0;
    static int questionIndex =0;
    static boolean answerSubmitted = false;
    static Timer timer;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("WELCOME TO THE QUIZE");
        startQuiz(sc);
        sc.close();

    }
    public static void startQuiz(Scanner sc){
        for(questionIndex = 0; questionIndex < questions.length; questionIndex++){
            answerSubmitted = false;
            askQuestion(questions[questionIndex],sc);
            //start the timer (10 sec per question)
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    if(!answerSubmitted){
                        System.out.println("\n time's up! moving to next question... ");
                        System.out.println();
                        questionIndex++;
                        timer.cancel();
                    }
                }
            },10000);//10 sec
            waitForAnswer(sc);
        }
        System.out.println("quize over! your score:"+score+ "/"+questions.length);
    }
    public static void askQuestion(QuizeQuestion question,Scanner sc){
        System.out.println(question.question);
        for (String option : question.option){
            System.out.println(option);
        }
        System.out.println("you have 10 seconds to answer(A/B/C/D): ");
    }
    public static void waitForAnswer(Scanner sc){
        String answer = sc.nextLine().toUpperCase();

        if(answer.length()== 1 && "ABCD".indexOf(answer.charAt(0))>= 0){
            answerSubmitted = true;
            timer.cancel();
            if(answer.charAt(0) == questions[questionIndex].correctAnswer){
                System.out.println("Correct!");
                score++;
            }else{
                System.out.println("invalid input . moving to the next question.");
            }
            System.out.println();
        }
    }}

