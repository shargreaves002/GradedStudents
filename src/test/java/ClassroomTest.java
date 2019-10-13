import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ClassroomTest {
    @Test
    public void testGetSortedStudents(){
        Classroom classroom = new Classroom();
        double[] billyTestScores = new double[]{100};
        double[] bobTestScores = new double[]{100};
        double[] billTestScores = new double[]{100};
        Student billy = new Student("Billy", "Smith", billyTestScores);
        Student bob = new Student("Bob", "Smith", bobTestScores);
        Student bill = new Student("Bill", "Smith", billTestScores);
        classroom.addStudent(billy);
        classroom.addStudent(bill);
        classroom.addStudent(bob);
        classroom.addStudent(bill);
        Student[] expected = new Student[30];
        expected[0] = bill;
        expected[1] = bill;
        expected[2] = billy;
        expected[3] = bob;
        Student[] actual = classroom.getStudentsByScore();
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testGradeBook(){
        Classroom classroom = new Classroom(100);
        for (int i = 1; i <= 100; i++){
            double grade = Math.random()*1000;
            Student student = new Student(Double.toString(i), "Jane", new double[]{grade});
            classroom.addStudent(student);
        }
        classroom.getGradeBook().forEach((k,v) -> System.out.println("key: "+ k +" value:"+ Arrays.toString(v)));
    }

}
