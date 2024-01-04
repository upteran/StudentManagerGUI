package studentManager;

import java.util.ArrayList;

/**
 * The CourseManagement class represents the connection element between our course and student objects.
 * Inside, we create new instances and enroll students in courses.
 * It acts like a controller that uses methods of our classes and manipulates them based on commands.
 * In cases where we need to use methods from both classes, we place them inside a method of CourseManagement.
 * In these cases, we do not mix different object data and get more secure code because we do not change our main objects directly.
 */
public class CourseManagement {
    private static ArrayList<Course> courses = new ArrayList<>();
    private static ArrayList<Student> students = new ArrayList<>();

    public static void addCourse(String courseCode, int maxCapacity, String courseName) {
        Course newCourse = new Course(courseCode, maxCapacity, courseName);
        courses.add(newCourse);
    }

    public static ArrayList<Student> getStudents() {
        return students;
    }

    public static ArrayList<Course> getCourses() {
        return courses;
    }

    public static void enrollStudent(int studentId, String courseCode) {
        Student student = findStudentById(studentId);
        Course course = findCourseByCode(courseCode);

        if (student != null && course != null) {
            if (course.getMaxCapacity() > Course.getTotalEnrolledStudents()) {
                student.enrollCourse(courseCode);
                Course.incrementTotalEnrolledStudents();
                System.out.println("Enrolled successfully.");
            } else {
                System.out.println("Course has reached its maximum capacity.");
            }
        } else {
            System.out.println("Invalid student ID or course code.");
        }
    }

    public static void assignGrade(int studentId, String courseCode, double grade) {
        Student student = findStudentById(studentId);
        Course course = findCourseByCode(courseCode);

        if (student != null && course != null) {
            student.assignGrade(courseCode, grade);
            System.out.println("Grade assigned successfully.");
        } else {
            System.out.println("Invalid input data.");
        }
    }

    public static void calculateOverallGrade(int studentId) {
        Student student = findStudentById(studentId);

        if (student != null) {
            double overallGrade = student.calculateOverallGrade();
            System.out.println("Overall grade for student " + student.getName() + ": " + overallGrade);
        } else {
            System.out.println("Invalid student ID.");
        }
    }

    public static void addStudent(String name, int id) {
        Student newStudent = new Student(name, id);
        students.add(newStudent);
        System.out.println("Student added successfully.");
    }

    private static Student findStudentById(int studentId) {
        for (Student student : students) {
            if (student.getId() == studentId) {
                return student;
            }
        }
        return null;
    }

    private static Course findCourseByCode(String courseCode) {
        for (Course course : courses) {
            if (course.getCourseCode().equals(courseCode)) {
                return course;
            }
        }
        return null;
    }
}
