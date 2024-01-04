package studentManager;
/**
 * The Course class represents a course object for any university course.
 * It follows the same logic as in the Student class and is created to encapsulate the
 * logic related to our courses inside this class. It's important to highlight that we use the totalEnrolledStudents
 * static variable to count and share this number between instances of the same course object.
 */
public class Course {
    private String courseCode;
    private int maxCapacity;
    private String courseName;
    private static int totalEnrolledStudents = 0;

    // Constructor
    public Course(String courseCode, int maxCapacity, String courseName) {
        this.courseCode = courseCode;
        this.maxCapacity = maxCapacity;
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }
    public String getName() {
        return courseName;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public static int getTotalEnrolledStudents() {
        return totalEnrolledStudents;
    }

    public static void incrementTotalEnrolledStudents() {
        totalEnrolledStudents += 1;
    }
}
