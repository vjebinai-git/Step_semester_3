package topic_8.class_problems;

import java.util.*;
import java.util.regex.*;

abstract class ExamQuestion {
    protected final String correctAnswer;
    protected final String studentAnswer;
    protected final double points;

    ExamQuestion(String correctAnswer, String studentAnswer, double points) {
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    abstract double calculateScore();
}

class ObjectiveQuestion extends ExamQuestion {
    ObjectiveQuestion(String correctAnswer, String studentAnswer, double points) {
        super(correctAnswer, studentAnswer, points);
    }

    double calculateScore() {
        return correctAnswer.equals(studentAnswer) ? points : 0.0;
    }
}

class EssayQuestion extends ExamQuestion {
    EssayQuestion(String keywords, String studentAnswer, double points) {
        super(keywords, studentAnswer, points);
    }

    double calculateScore() {
        String[] keywords = correctAnswer.split(",");
        int matches = 0;
        String response = studentAnswer.toLowerCase(Locale.ROOT);

        for (String keyword : keywords) {
            String trimmed = keyword.trim().toLowerCase(Locale.ROOT);
            if (!trimmed.isEmpty()
                    && Pattern.compile("(?<![\\p{L}\\p{N}_])" + Pattern.quote(trimmed)
                    + "(?![\\p{L}\\p{N}_])").matcher(response).find()) {
                matches++;
            }
        }

        if (matches >= 2) return points * 0.75;
        if (matches == 1) return points * 0.50;
        return 0.0;
    }
}

public class ExaminationQuestionGrader {
    private static List<String> tokenize(String line) {
        List<String> tokens = new ArrayList<>();
        Matcher matcher = Pattern.compile("\"([^\"]*)\"|(\\S+)").matcher(line);
        while (matcher.find()) {
            tokens.add(matcher.group(1) != null ? matcher.group(1) : matcher.group(2));
        }
        return tokens;
    }

    private static ExamQuestion createQuestion(String type, String correct,
                                                 String student, double points) {
        if (type.equalsIgnoreCase("ESSAY")) {
            return new EssayQuestion(correct, student, points);
        }
        if (type.equalsIgnoreCase("MCQ") || type.equalsIgnoreCase("TF")) {
            return new ObjectiveQuestion(correct, student, points);
        }
        throw new IllegalArgumentException("Invalid question type: " + type);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0.0;

        for (int i = 0; i < n; i++) {
            List<String> tokens = tokenize(sc.nextLine());
            String type = tokens.get(0).toUpperCase();
            String questionText = tokens.get(1); // Retained as part of the input record.
            String correctAnswer = tokens.get(2);
            String studentAnswer = tokens.get(3);
            double points = Double.parseDouble(tokens.get(4));

            ExamQuestion question = createQuestion(type, correctAnswer, studentAnswer, points);
            double score = question.calculateScore();
            System.out.printf(Locale.US, "%s: %.2f%n", type, score);
            total += score;
        }

        System.out.printf(Locale.US, "Total Score: %.2f%n", total);
        sc.close();
    }
}
