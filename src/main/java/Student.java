import java.util.ArrayList;
import java.util.LinkedList;

public class Student {
    private String firstName;
    private String lastName;
    private ArrayList<Double> testScores = new ArrayList<Double>();

    public Student(String firstName, String lastName, double[] testScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        for (double score : testScores) {
            this.testScores.add(score);
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ArrayList<Double> getTestScores() {
        return testScores;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getNumberOfExamsTaken() {
        return testScores.size();
    }

    String getExamScores(){
        String answer = "Exam Scores: \n";
        int exam = 1;
        for (Double score : testScores){
            answer = answer.concat("\t" + "Exam " + exam + " -> " + score + "\n");
        }
        return answer.substring(0, answer.length()-3);
    }

    public void addExamScore(double score){
        testScores.add(score);
    }

    public void setExamScore(int test, double score){
        testScores.set(test, score);
    }

    double getAverageExamScore(){
        double answer = 0;
        for (double score : testScores){
            answer += score;
        }
        return answer / testScores.size();
    }
    
    static int compare(Student studentOne, Student studentTwo){
        if (studentOne.getAverageExamScore() > studentTwo.getAverageExamScore()) {
            return 1;
        } else if (studentOne.getAverageExamScore() < studentTwo.getAverageExamScore()) {
            return -1;
        } else if (studentOne.getLastName().compareTo(studentTwo.getLastName()) < 0) {
            return 1;
        } else if (studentOne.getLastName().compareTo(studentTwo.getLastName()) > 0) {
            return -1;
        } else if (studentOne.getFirstName().compareTo(studentTwo.getFirstName()) < 0) {
            return 1;
        } else if (studentOne.getFirstName().compareTo(studentTwo.getFirstName()) > 0) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString(){
        return "Student name: " + firstName + " " + lastName + "\n" +
                "> Average Score: " + getAverageExamScore() + "\n" +
                "> " + getExamScores();
    }
}
