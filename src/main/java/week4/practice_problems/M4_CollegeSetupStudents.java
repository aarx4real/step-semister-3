package week4.practice_problems;

public class M4_CollegeSetupStudents {
    public static void main(String[] args) {
        String[] names = {"Ravi", "Meera", "Karthik", "Divya", "Anitha"};

        for (int i = 0; i < names.length; i++) {
            SrmStudent student = new SrmStudent(names[i]);
            System.out.println("Student record created: " + student.name);
        }
    }
}

class SrmStudent {
    static String collegeName;
    static String academicYear;
    String name;

    static {
        collegeName = "SRM Institute of Science and Technology";
        academicYear = "2025-2026";
        System.out.println("College info loaded");
    }

    SrmStudent(String name) {
        this.name = name;
    }
}
