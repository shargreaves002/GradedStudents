import org.junit.Assert;
import org.junit.Test;

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
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGradeBook(){
        Classroom classroom = new Classroom(100);
        for (double i = 1; i <= 100; i++){
            Student student = new Student("Mary", "Jane", new double[]{i});
            classroom.addStudent(student);
        }

        System.out.println(classroom.getGradeBook().toString());
    }

}
