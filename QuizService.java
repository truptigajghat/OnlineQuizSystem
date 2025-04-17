import java.util.*;

public class QuizService {
    private List<Question> questions;
    private Scanner scanner;

    public QuizService() {
        questions = new ArrayList<>();
        scanner = new Scanner(System.in);
        loadQuestions();
    }

    private void loadQuestions() {
        questions.add(new Question("What is the capital of India?", new String[]{"A) Mumbai", "B) Delhi", "C) Chennai", "D) Kolkata"}, 'B'));
        questions.add(new Question("Which keyword is used to inherit a class in Java?", new String[]{"A) super", "B) this", "C) extends", "D) implements"}, 'C'));
        questions.add(new Question("Which of these is not a Java feature?", new String[]{"A) Object-Oriented", "B) Use of pointers", "C) Portable", "D) Secure"}, 'B'));
        
    }

    public void startQuiz() {
        int score = 0;

        for (Question q : questions) {
            System.out.println("\n" + q.questionText);
            for (String option : q.options) {
                System.out.println(option);
            }

            System.out.print("Your answer (A/B/C/D): ");
            char answer = scanner.next().charAt(0);

            if (q.isCorrect(answer)) {
                System.out.println("✅ Correct!");
                score++;
            } else {
                System.out.println("❌ Wrong! Correct answer: " + q.correctOption);
            }
        }

        System.out.println("\n🎉 Quiz Completed! Your score: " + score + "/" + questions.size());
    }
}
