package student.manager;

import java.util.ArrayList;

/**
 * The Student class represents a university student with attributes such as name and ID.
 * Here, we employ one of the OOP and programming approaches,
 * encapsulation. We store the main student information and calculate grades and pointers to course IDs.
 * In this case, our student's logic is stored in one place, making it easy to understand what actions a
 * student object can perform. Additionally, we have added getters and setters to retrieve private data from the student object.
 * This provides us with the ability to access information while ensuring that nobody can change it from outside classes.
 */
public class Student {
    private String name; // Name of the student
    private int id;  // Unique identifier for the student
    private ArrayList<String> courses = new ArrayList<>();
    private ArrayList<Double> grades = new ArrayList<>();

    // Constructor

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    // when user enrolled to course we add default grade to easies
    // calculate sum in calculateOverallGrade method
    public void enrollCourse(String courseCode) {
        courses.add(courseCode);
        grades.add(0.0);
    }

    public void assignGrade(String courseCode, double grade) {
        int index = courses.indexOf(courseCode);
        if (index != -1) {
            grades.set(index, grade);
        }
    }

    public double calculateOverallGrade() {
        if (courses.isEmpty()) {
            return 0.0;
        }

        double sum = 0.0;
        for (double grade : grades) {
            sum += grade;
        }

        return sum / courses.size();
    }
}
