import student.manager.Course;
import student.manager.CourseManagement;
import student.manager.Student;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StudentManagementGUI extends JFrame {
    // GUI Components
    private JButton addStudentButton;
    private JButton addCourseButton;
    private JButton updateStudentButton;
    private JButton viewStudentButton;
    private JButton enrollStudentButton;
    private JButton assignGradeButton;

    public StudentManagementGUI() {
        // Set up the JFrame
        setTitle("Student Management System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 1));

        // Initialize GUI components
        addStudentButton = new JButton("Add Student");
        addCourseButton = new JButton("Add Course");
        updateStudentButton = new JButton("Update Student");
        viewStudentButton = new JButton("View Student Details");
        enrollStudentButton = new JButton("Enroll Student");
        assignGradeButton = new JButton("Assign Grade");

        // Add action listeners for the buttons
        addStudentButton.addActionListener(e -> handleAddStudent());
        addCourseButton.addActionListener(e -> handleAddCourse());
        updateStudentButton.addActionListener(e -> handleUpdateStudent());
        viewStudentButton.addActionListener(e -> handleViewStudentDetails());
        enrollStudentButton.addActionListener(e -> handleEnrollStudent());
        assignGradeButton.addActionListener(e -> handleAssignGrade());

        // Add buttons to the JFrame
        add(addStudentButton);
        add(addCourseButton);
        add(updateStudentButton);
        add(viewStudentButton);
        add(enrollStudentButton);
        add(assignGradeButton);

        // Display the frame
        setVisible(true);
    }

    private void handleAddStudent() {
        // Create a JPanel to hold the form components
        JPanel panel = new JPanel(new GridLayout(3, 2));

        // Form components
        JTextField nameField = new JTextField();
        JTextField idField = new JTextField();

        // Add components to the panel
        panel.add(new JLabel("Student Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Student ID:"));
        panel.add(idField);
        panel.add(new JLabel()); // Empty label for spacing

        // Show the form using JOptionPane
        int result = JOptionPane.showConfirmDialog(null, panel, "Add Student",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        // Check if the user clicked "Submit"
        if (result == JOptionPane.OK_OPTION) {
            // Get user input
            String studentName = nameField.getText();
            String studentId = idField.getText();

            // Validate input
            if (!studentName.isEmpty() && !studentId.isEmpty()) {
                // Create a new Student object and add it to the list
                CourseManagement.addStudent(studentName, Integer.parseInt(studentId));

                // Update the GUI or perform other actions as needed
                JOptionPane.showMessageDialog(null, "Student added successfully.");
            } else {
                // Display an error message if input is invalid
                JOptionPane.showMessageDialog(null, "Please enter valid information.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void handleAddCourse() {
        // Create a JPanel to hold the form components
        JPanel panel = new JPanel(new GridLayout(4, 1));

        // Form components
        JTextField codeField = new JTextField();
        JTextField capacityField = new JTextField();
        JTextField nameField = new JTextField();

        // Add components to the panel
        panel.add(new JLabel("Enter course code:\n"));
        panel.add(codeField);
        panel.add(new JLabel("Enter maximum capacity:\n"));
        panel.add(capacityField);
        panel.add(new JLabel("Enter course name:"));
        panel.add(nameField);
        panel.add(new JLabel()); // Empty label for spacing

        // Show the form using JOptionPane
        int result = JOptionPane.showConfirmDialog(null, panel, "Add Course",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        // Check if the user clicked "Submit"
        if (result == JOptionPane.OK_OPTION) {
            // Get user input
            String courseName = nameField.getText();
            String courseCode = codeField.getText();
            String courseCapacity = capacityField.getText();

            // Validate input
            if (!courseName.isEmpty() && !courseCode.isEmpty() && !courseCapacity.isEmpty()) {
                // Create a new Student object and add it to the list
                CourseManagement.addCourse(courseName, Integer.parseInt(courseCapacity), courseCode);

                // Update the GUI or perform other actions as needed
                JOptionPane.showMessageDialog(null, "Course added successfully.");
            } else {
                // Display an error message if input is invalid
                JOptionPane.showMessageDialog(null, "Please enter valid information.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void handleUpdateStudent() {
        ArrayList<Student> students = CourseManagement.getStudents();
        // Check if there are students to update
        if (students.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No students available to update.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Create a JPanel to hold the form components
        JPanel panel = new JPanel(new GridLayout(3, 2));

        // Form components
        JComboBox<String> studentDropdown = new JComboBox<>();
        for (Student student : students) {
            studentDropdown.addItem(student.getName() + " (" + student.getId() + ")");
        }
        JTextField newNameField = new JTextField();

        // Add components to the panel
        panel.add(new JLabel("Select Student:"));
        panel.add(studentDropdown);
        panel.add(new JLabel("New Student Name:"));
        panel.add(newNameField);
        panel.add(new JLabel()); // Empty label for spacing

        // Show the form using JOptionPane
        int result = JOptionPane.showConfirmDialog(null, panel, "Update Student",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        // Check if the user clicked "Submit"
        if (result == JOptionPane.OK_OPTION) {
            // Get user input
            int selectedStudentIndex = studentDropdown.getSelectedIndex();
            String newStudentName = newNameField.getText();

            // Validate input
            if (selectedStudentIndex >= 0 && !newStudentName.isEmpty()) {
                // Update the selected student's name
                Student selectedStudent = students.get(selectedStudentIndex);
                selectedStudent.setName(newStudentName);

                // Update the GUI or perform other actions as needed
                JOptionPane.showMessageDialog(null, "Student updated successfully.");
            } else {
                // Display an error message if input is invalid
                JOptionPane.showMessageDialog(null, "Please select a student and enter valid information.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void handleViewStudentDetails() {
        ArrayList<Student> students = CourseManagement.getStudents();
        // Check if there are students to view
        if (students.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No students available to view.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Create a StringBuilder to build the details
        StringBuilder details = new StringBuilder("Student Details:\n\n");

        // Append details for each student
        for (Student student : students) {
            details.append("Name: ").append(student.getName()).append("\n");
            details.append("ID: ").append(student.getId()).append("\n");
            details.append("Overall Grade: ").append(student.calculateOverallGrade()).append("\n\n");
        }

        // Display the details using a JTextArea
        JTextArea textArea = new JTextArea(details.toString());
        textArea.setEditable(false);

        // Show the details using a JScrollPane in case of long content
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Create and show a dialog with the student details
        JOptionPane.showMessageDialog(null, scrollPane, "View Student Details",
                JOptionPane.PLAIN_MESSAGE);
    }

    private void handleEnrollStudent() {
        ArrayList<Student> students = CourseManagement.getStudents();
        ArrayList<Course> courses = CourseManagement.getCourses();
        // Check if there are students and courses to enroll
        if (students.isEmpty() || courses.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No students or courses available for enrollment.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Create a JPanel to hold the form components
        JPanel panel = new JPanel(new GridLayout(3, 2));

        // Form components
        JComboBox<String> studentDropdown = new JComboBox<>();
        for (Student student : students) {
            studentDropdown.addItem(student.getName() + " (" + student.getId() + ")");
        }

        JComboBox<String> courseDropdown = new JComboBox<>();
        for (Course course : courses) {
            courseDropdown.addItem(course.getName() + " (" + course.getCourseCode() + ")");
        }

        JButton submitButton = new JButton("Enroll");

        // Add components to the panel
        panel.add(new JLabel("Select Student:"));
        panel.add(studentDropdown);
        panel.add(new JLabel("Select Course:"));
        panel.add(courseDropdown);
        panel.add(new JLabel()); // Empty label for spacing
        panel.add(submitButton);

        // Show the form using JOptionPane
        int result = JOptionPane.showConfirmDialog(null, panel, "Enroll Student",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        // Check if the user clicked "Enroll"
        if (result == JOptionPane.OK_OPTION) {
            // Get user input
            int selectedStudentIndex = studentDropdown.getSelectedIndex();
            int selectedCourseIndex = courseDropdown.getSelectedIndex();

            // Validate input
            if (selectedStudentIndex >= 0 && selectedCourseIndex >= 0) {
                // Enroll the student in the selected course
                Student selectedStudent = students.get(selectedStudentIndex);
                Course selectedCourse = courses.get(selectedCourseIndex);

                // Perform enrollment logic here (update your data model)
                selectedStudent.enrollCourse(selectedCourse.getCourseCode());

                // Update the GUI or perform other actions as needed
                JOptionPane.showMessageDialog(null, "Student enrolled successfully.");
            } else {
                // Display an error message if input is invalid
                JOptionPane.showMessageDialog(null, "Please select a student and a course.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void handleAssignGrade() {
        ArrayList<Student> students = CourseManagement.getStudents();
        ArrayList<Course> courses = CourseManagement.getCourses();
        // Check if there are students and courses to assign grades
        if (students.isEmpty() || courses.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No students or courses available to assign grades.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Create a JPanel to hold the form components
        JPanel panel = new JPanel(new GridLayout(4, 2));

        // Form components
        JComboBox<String> studentDropdown = new JComboBox<>();
        for (Student student : students) {
            studentDropdown.addItem(student.getName() + " (" + student.getId() + ")");
        }

        JComboBox<String> courseDropdown = new JComboBox<>();
        for (Course course : courses) {
            courseDropdown.addItem(course.getName() + " (" + course.getCourseCode() + ")");
        }

        JTextField gradeField = new JTextField();

        JButton submitButton = new JButton("Assign Grade");

        // Add components to the panel
        panel.add(new JLabel("Select Student:"));
        panel.add(studentDropdown);
        panel.add(new JLabel("Select Course:"));
        panel.add(courseDropdown);
        panel.add(new JLabel("Enter Grade:"));
        panel.add(gradeField);
        panel.add(new JLabel()); // Empty label for spacing
        panel.add(submitButton);

        // Show the form using JOptionPane
        int result = JOptionPane.showConfirmDialog(null, panel, "Assign Grade",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        // Check if the user clicked "Assign Grade"
        if (result == JOptionPane.OK_OPTION) {
            // Get user input
            int selectedStudentIndex = studentDropdown.getSelectedIndex();
            int selectedCourseIndex = courseDropdown.getSelectedIndex();
            String gradeText = gradeField.getText().trim();

            // Validate input
            if (selectedStudentIndex >= 0 && selectedCourseIndex >= 0 && !gradeText.isEmpty()) {
                try {
                    // Parse the grade as a double
                    double grade = Double.parseDouble(gradeText);

                    // Assign the grade to the selected student and course
                    Student selectedStudent = students.get(selectedStudentIndex);
                    Course selectedCourse = courses.get(selectedCourseIndex);

                    selectedStudent.assignGrade(selectedCourse.getCourseCode(), grade);
                    // Perform grade assignment logic here (update your data model)

                    // Update the GUI or perform other actions as needed
                    JOptionPane.showMessageDialog(null, "Grade assigned successfully.");
                } catch (NumberFormatException e) {
                    // Display an error message if the grade is not a valid number
                    JOptionPane.showMessageDialog(null, "Please enter a valid numeric grade.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                // Display an error message if input is invalid
                JOptionPane.showMessageDialog(null, "Please select a student, a course, and enter a grade.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

