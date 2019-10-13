import java.util.ArrayList;
import java.util.LinkedList;

public class Student {
    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores = new ArrayList<Double>();

    public Student(String firstName, String lastName, double[] examScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        for (double score : examScores) {
            this.examScores.add(score);
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getNumberOfExamsTaken() {
        return examScores.size();
    }

    String getExamScores(){
        String answer = "Exam Scores: \n";
        int exam = 1;
        for (Double score : examScores){
            answer = answer.concat("\t" + "Exam " + exam + " -> " + score + "\n");
        }
        return answer.substring(0, answer.length()-3);
    }

    public void addExamScore(double score){
        examScores.add(score);
    }

    public void setExamScore(int test, double score){
        examScores.set(test, score);
    }

    double getAverageExamScore(){
        double answer = 0;
        for (double score : examScores){
            answer += score;
        }
        return answer / examScores.size();
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
        } else return Integer.compare(0, studentOne.getFirstName().compareTo(studentTwo.getFirstName()));
    }

    @Override
    public String toString(){
        return "Student name: " + firstName + " " + lastName + "\n" +
                "> Average Score: " + getAverageExamScore() + "\n" +
                "> " + getExamScores() + "\n";
    }
}
