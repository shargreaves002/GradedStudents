import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Classroom {
    private Student[] students;

    Classroom (int maxNumberOfStudents){
        this.students = new Student[maxNumberOfStudents];
    }

    Classroom (Student[] students){
        this.students = students;
    }

    Classroom (){
        this.students = new Student[30];
    }

    Student[] getStudents() {
        return students;
    }

    double getAverageExamScore(){
        double answer = 0;
        int tests = 0;
        for (Student student : students){
            answer += student.getAverageExamScore();
            tests += student.getNumberOfExamsTaken();
        }
        return answer / tests;
    }

    void addStudent(Student student){
        for (int index = 0; index < students.length; index++){
            if (students[index] == null){
                this.students[index] = student;
                break;
            }
        }
    }

    void removeStudent(String firstName, String lastName){
        for (int index = 0; index < students.length; index++){
            if (students[index].getFirstName().equals(firstName) && students[index].getLastName().equals(lastName)){
                if (index + 1 < students.length && students[index + 1] != null){
                    this.students[index] = students[index + 1];
                } else {
                    this.students[index] = null;
                    return;
                }
            }
        }
    }

    Student[] getStudentsByScore(){
        int index = -1;
        for (int i = 0; i < students.length; i++){
            if (students[i] == null){
                index = i;
                break;
            }
        }

        if (index != -1){
            Student[] arr = Arrays.copyOf(students, index);
            return Arrays.copyOf(sort(arr), 30);
        } else {
            return sort(students);
        }
    }

    private static Student[] sort(Student[] arr) {
        if (arr.length <= 1) {
            return arr;
        } else if (arr.length == 2) {
            if (Student.compare(arr[0], arr[1]) == 1) {
                return new Student[]{arr[0], arr[1]};
            } else {
                return new Student[]{arr[1], arr[0]};
            }
        } else {
            Student[] arr1 = sort(Arrays.copyOfRange(arr, 0, (arr.length + 1)/2));
            Student[] arr2 = sort(Arrays.copyOfRange(arr, (arr.length + 1)/2, arr.length));
            int oneTracker = 0;
            int twoTracker = 0;
            int totalTracker = 0;
            Student[] newArr = new Student[arr.length];
            while(totalTracker < newArr.length){
                if (oneTracker > arr1.length - 1){
                    newArr[totalTracker] = arr2[twoTracker];
                    totalTracker++;
                    twoTracker++;
                } else if (twoTracker > arr2.length - 1){
                    newArr[totalTracker] = arr1[oneTracker];
                    totalTracker++;
                    oneTracker++;
                } else if (Student.compare(arr1[oneTracker], arr2[twoTracker]) == 1) {
                    newArr[totalTracker] = arr1[oneTracker];
                    totalTracker++;
                    oneTracker++;
                } else {
                    newArr[totalTracker] = arr2[twoTracker];
                    totalTracker++;
                    twoTracker++;
                }
            }
            return newArr;
        }
    }

    HashMap<Character, Student[]> getGradeBook (){
        Student[] sortedStudents = getStudentsByScore();
        int indexOfA = getIndex(.90);
        int indexOfB = getIndex(.71);
        int indexOfC = getIndex(.50);
        int indexOfD = getIndex(.11);
        HashMap<Character, Student[]> gradeBook = new HashMap<>();
        gradeBook.put('A', Arrays.copyOfRange(sortedStudents, 0, indexOfA));
        gradeBook.put('B', Arrays.copyOfRange(sortedStudents, indexOfA, indexOfB));
        gradeBook.put('C', Arrays.copyOfRange(sortedStudents, indexOfB, indexOfC));
        gradeBook.put('D', Arrays.copyOfRange(sortedStudents, indexOfC, indexOfD));
        gradeBook.put('F', Arrays.copyOfRange(sortedStudents, indexOfD, sortedStudents.length));
        return gradeBook;
    }

    private int getIndex(double percentile){
        Student[] sortedStudents = sort(students);
        double highestGrade = sortedStudents[0].getAverageExamScore();
        for (int i = 0; i < sortedStudents.length; i++){
            if (sortedStudents[i].getAverageExamScore() < highestGrade * percentile){
                return i;
            }
        }
        return sortedStudents.length;
    }
}
