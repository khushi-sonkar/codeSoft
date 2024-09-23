package Task1;
import java.util.Scanner;
public class StudentGrade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //ask for the number of subjects
        System.out.println("Enter the number of subjects: ");
        int numSubjects = sc.nextInt();

        //array to store marks
        double[] marks = new double[numSubjects];
        double totalMarks = 0;

        //input marks for each subject
        for(int i = 0; i<numSubjects; i++){
            System.out.println("Enter marks for subject"+(i + 1)+ " : ");
            marks[i] = sc.nextDouble();
            totalMarks += marks[i];

        }
        //calculate average
        double averageMarks = totalMarks / numSubjects;

        // determine the grade
        String grade;
        if (averageMarks >= 90){
            grade = "A+";
        }else if (averageMarks > 80){
            grade = "A";
        } else if (averageMarks >= 70) {
            grade = "B";
        } else if (averageMarks >=60) {
            grade = "C";
        } else if (averageMarks >= 50) {
            grade = "D";
        }else {
            grade = "F";
        }

        // DISPLAY THE RESULT
        System.out.println("Total Marks: "+totalMarks);
        System.out.println("Average Marks: "+averageMarks);
        System.out.println("Grade:"+grade);

    }
}
