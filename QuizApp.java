package Default;

import java.util.*;

public class QuizApp {
    
    private static final int NUM_QUESTIONS = 5; // Number of questions in the quiz
    
    public static void main(String[] args) {
        // Create a list of questions
        List<Question> questions = createQuestions();
        
        // Shuffle the questions
        Collections.shuffle(questions);
        
        // Start the quiz
        int score = startQuiz(questions);
        
        // Display the final score
        System.out.println("Quiz ended. Your score: " + score + "/" + NUM_QUESTIONS);
    }
    
    private static List<Question> createQuestions() {
        // Create a list of questions
        
        List<Question> questions = new ArrayList<>();
        
        // Question 1
        Question question1 = new Question("What is the capital of France?", "Paris");
        questions.add(question1);
        
        // Question 2
        Question question2 = new Question("Who painted the Mona Lisa?", "Leonardo da Vinci");
        questions.add(question2);
        
        // Question 3
        Question question3 = new Question("What is the largest planet in our solar system?", "Jupiter");
        questions.add(question3);
        
        // Question 4
        Question question4 = new Question("What is the chemical symbol for gold?", "Au");
        questions.add(question4);
        
        // Question 5
        Question question5 = new Question("Who wrote the play 'Hamlet'?", "William Shakespeare");
        questions.add(question5);
        
        return questions;
    }
    
    private static int startQuiz(List<Question> questions) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        
        System.out.println("Welcome to the Quiz!");
        System.out.println("Answer the following " + NUM_QUESTIONS + " questions:");
        System.out.println("---------------------------------------");
        
        for (int i = 0; i < NUM_QUESTIONS; i++) {
            Question question = questions.get(i);
            
            System.out.println("Question " + (i + 1) + ": " + question.getQuestion());
            
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine();
            
            if (userAnswer.equalsIgnoreCase(question.getAnswer())) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect!");
                System.out.println("The correct answer is: " + question.getAnswer());
            }
            
            System.out.println("---------------------------------------");
        }
        
        return score;
    }
}

class Question {
    private String question;
    private String answer;
    
    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }
    
    public String getQuestion() {
        return question;
    }
    
    public String getAnswer() {
        return answer;
    }
}
