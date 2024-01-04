import studentManager.Course;
import studentManager.CourseManagement;
import studentManager.Student;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

//class SelectorWithListAndTablesExample extends JFrame {
//    private DefaultListModel<String> listModel;
//    private JList<String> itemList;
//    private JComboBox<String> selectorComboBox;
//
//    private DefaultTableModel studentsTableModel;
//    private JTable studentsTable;
//
//    private DefaultTableModel coursesTableModel;
//    private JTable coursesTable;
//
//    private JTextArea studentsTextArea;
//    private JTextArea coursesTextArea;
//
//    public SelectorWithListAndTablesExample() {
//        // Set up the JFrame
//        setTitle("Course Management System");
//        setSize(800, 400);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//
//        // Initialize the list model and add some items
//        listModel = new DefaultListModel<>();
//        listModel.addElement("Add new course");
//        listModel.addElement("Add new student");
//        listModel.addElement("Enroll student in a course");
//        listModel.addElement("Assign grade to a student");
//        listModel.addElement("Calculate overall grade for a student");
//
//        // Create the JList with the list model
//        itemList = new JList<>(listModel);
//        itemList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//
//        // Create the JComboBox
//        selectorComboBox = new JComboBox<>();
//
//        // Add an ActionListener to the JList to update the JComboBox when an item is selected
//        itemList.addListSelectionListener(e -> {
//            String selectedItem = itemList.getSelectedValue();
//            if (selectedItem != null) {
//                selectorComboBox.addItem(selectedItem);
//            }
//        });
//
//
//
//        // Create a button to clear the JComboBox and tables
////        JButton clearButton = new JButton("Clear");
////        clearButton.addActionListener(e -> clearComboBoxAndTables());
//
//        // Create a button to show a dialog with the selected item
//        JButton nextButton = new JButton("Next");
//        nextButton.addActionListener(e -> handleNextButton());
//
//        // Set up the layout using BorderLayout
//        setLayout(new GridLayout(5, 2));
//
//        // Create panels to hold the tables
//        JPanel studentsPanel = new JPanel(new BorderLayout());
//        studentsPanel.setBorder(BorderFactory.createTitledBorder("Students"));
//        studentsTextArea = new JTextArea();
//        studentsTextArea.setEditable(false); // Make it non-editable
//        // Create a JScrollPane for each JTextArea
//        JScrollPane studentsScrollPane = new JScrollPane(studentsTextArea);
//        // Add the JTextAreas with scroll panes to the frame
//        add(studentsScrollPane);
//
//        // Simulate adding some data initially
//        studentsTextArea.setText("Students:\nJohn Doe (ID: 1)\nJane Smith (ID: 2)\n");
//
//        // Create panels to hold the tables
//        JPanel coursesPanel = new JPanel(new BorderLayout());
//        coursesPanel.setBorder(BorderFactory.createTitledBorder("Courses"));
//        coursesTextArea = new JTextArea();
//        coursesTextArea.setEditable(false); // Make it non-editable
//        // Create a JScrollPane for each JTextArea
//        JScrollPane coursesTextAreaPane = new JScrollPane(coursesTextArea);
//        // Add the JTextAreas with scroll panes to the frame
//        add(coursesTextAreaPane);
//
//        // Create a layout for the frame
////        setLayout(new GridLayout(1, 2));
//
//        // Simulate adding some data initially
//        coursesTextArea.setText("Courses:\nCSCI101 (Capacity: 30)\nMATH202 (Capacity: 25)\n");
////
////        JPanel coursesPanel = new JPanel(new BorderLayout());
////        coursesPanel.setBorder(BorderFactory.createTitledBorder("Courses"));
////        coursesPanel.add(new JScrollPane(coursesTable), BorderLayout.CENTER);
//
//        // Add components to the JFrame
//        add(new JScrollPane(itemList), BorderLayout.WEST);
//        add(selectorComboBox, BorderLayout.SOUTH);
////        add(clearButton, BorderLayout.NORTH);
//        add(nextButton, BorderLayout.EAST);
////        add(studentsPanel, BorderLayout.CENTER);
////        add(coursesPanel, BorderLayout.EAST);
//    }
//
//    private void clearComboBoxAndTables() {
//        selectorComboBox.removeAllItems();
//        clearTable(studentsTableModel);
//        clearTable(coursesTableModel);
//    }
//
//    private void handleNextButton() {
//        String selectedItem = (String) selectorComboBox.getSelectedItem();
//        if (selectedItem != null) {
//            switch (selectedItem) {
//                case "Add new course" -> handleAddNewCourse();
//                case "Add new student" -> handleAddNewStudent();
//                case "Enroll student in a course" -> handleEnrollStudent();
//                case "Assign grade to a student" -> handleAssignGrade();
//                case "Calculate overall grade for a student" -> handleCalculateOverallGrade();
//            }
//        }
//    }
//
//    private void handleAddNewCourse() {
//        // Show a dialog box to get course information
//        String courseCode = JOptionPane.showInputDialog(this, "Enter course code:");
//        int maxCapacity = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter maximum capacity:"));
//        String courseName = JOptionPane.showInputDialog(this, "Enter course name:");
//
//        // Call your addCourse method with the provided information
//        String courseInfo = CourseManagement.addCourse(courseCode, maxCapacity, courseName);
//        coursesTextArea.setText(courseInfo);
//        JOptionPane.showMessageDialog(this, "Course added successfully.");
//    }
//
//    private void handleAddNewStudent() {
//        // Show a dialog box to get student information
//        int studentId = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter student ID:"));
//        String studentName = JOptionPane.showInputDialog(this, "Enter student name:");
//
//        // Call your addStudent method with the provided information
//        String studentInfo = CourseManagement.addStudent(studentName, studentId);
//        studentsTextArea.setText(studentInfo);
//        JOptionPane.showMessageDialog(this, "Student added successfully.");
//    }
//
//    private void handleEnrollStudent() {
//        // Show a dialog box to get enrollment information
//        int studentId = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter student ID:"));
//        String courseCode = JOptionPane.showInputDialog(this, "Enter course code to enroll in:");
//
//        // Call your enrollStudent method with the provided information
//        CourseManagement.enrollStudent(studentId, courseCode);
////        studentsTableModel.addRow(enrollmentInfo);
//        JOptionPane.showMessageDialog(this, "Student enrolled in the course successfully.");
//    }
//
//    private void handleAssignGrade() {
//        // Show a dialog box to get grade assignment information
//        int studentId = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter student ID:"));
//        String courseCode = JOptionPane.showInputDialog(this, "Enter course code:");
//        double grade = Double.parseDouble(JOptionPane.showInputDialog(this, "Enter grade:"));
//
//        // Call your assignGrade method with the provided information
//        CourseManagement.assignGrade(studentId, courseCode, grade);
////        studentsTableModel.addRow(gradeInfo);
//        JOptionPane.showMessageDialog(this, "Grade assigned successfully.");
//    }
//
//    private void handleCalculateOverallGrade() {
//        // Show a dialog box to get student ID for calculating overall grade
//        int studentId = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter student ID:"));
//
//        // Call your calculateOverallGrade method with the provided student ID
//        CourseManagement.calculateOverallGrade(studentId);
//
////        studentsTableModel.addRow(overallGradeInfo);
//        JOptionPane.showMessageDialog(this, "Overall grade calculated successfully.");
//    }
//
//    private void clearTable(DefaultTableModel tableModel) {
//        int rowCount = tableModel.getRowCount();
//        for (int i = rowCount - 1; i >= 0; i--) {
//            tableModel.removeRow(i);
//        }
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            SelectorWithListAndTablesExample example = new SelectorWithListAndTablesExample();
//            example.setVisible(true);
//        });
//    }
//}
class StudentManagementGUI extends JFrame {
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
        // Add action listeners for the buttons
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
        JPanel panel = new JPanel(new GridLayout(3, 2));

        // Form components
        JTextField codeField = new JTextField();
        JTextField capacityField = new JTextField();
        JTextField nameField = new JTextField();

        // Add components to the panel
        panel.add(new JLabel("Enter course code:"));
        panel.add(codeField);
        panel.add(new JLabel("Enter maximum capacity:"));
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
            details.append("ID: ").append(student.getId()).append("\n\n");
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


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentManagementGUI());
    }
}

/**
 * The AdministratorController represents the entry point of the program.
 * We display different options to the user and call corresponding reactions to them.
 * We encapsulate CourseManagement methods in the Administrator, and call them based on user inputs.
 * This helps us avoid directly using Course and Student classes, resulting in maintainable code and handling various cases
 * according to user inputs.
 * */
class AdministratorControllerGUI {
    public static void main(String[] args) {
        JFrame f = new JFrame(); //creating instance of JFrame
        JButton b=new JButton("click");//creating instance of JButton
        b.setBounds(130,100,100, 40);//x axis, y axis, width, height

        f.add(b); //adding button in JFrame

        f.setSize(400,500);//400 width and 500 height
        f.setLayout(null); //using no layout managers
        f.setVisible(true); //making the frame visible

//        SwingUtilities.invokeLater(() -> {
//            SelectorWithListExample example = new SelectorWithListExample();
//            example.setVisible(true);
//        });
//        Scanner scanner = new Scanner(System.in);

//        while (true) {
//            System.out.println("Course Enrollment and Grade Management System");
//            System.out.println("1. Add new course");
//            System.out.println("2. Add new student");
//            System.out.println("3. Enroll student in a course");
//            System.out.println("4. Assign grade to a student");
//            System.out.println("5. Calculate overall grade for a student");
//            System.out.println("6. Exit");
//            System.out.print("Enter your choice: ");
//
//            int choice = scanner.nextInt();
//            scanner.nextLine(); // Consume the newline
//
//            switch (choice) {
//                case 1:
//                    addNewCourse();
//                    break;
//                case 2:
//                    addNewStudent();
//                    break;
//                case 3:
//                    enrollStudent();
//                    break;
//                case 4:
//                    assignGrade();
//                    break;
//                case 5:
//                    calculateOverallGrade();
//                    break;
//                case 6:
//                    System.out.println("Exiting!");
//                    System.exit(0);
//                default:
//                    System.out.println("Invalid choice. Please enter a valid option.");
//            }
//        }
    }

    private static void addNewCourse() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter course code: ");
        String courseCode = scanner.nextLine();

        System.out.print("Enter maximum capacity: ");
        int maxCapacity = scanner.nextInt();

        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();

        CourseManagement.addCourse(courseCode, maxCapacity, courseName);
        System.out.println("Course added successfully.");
    }

    private static void addNewStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student ID: ");
        int studentId = scanner.nextInt();

        System.out.print("Add student name: ");
        String studentName = scanner.nextLine();

        CourseManagement.addStudent(studentName, studentId);
        System.out.println("Student added successfully.");
    }

    private static void enrollStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student ID: ");
        int studentId = scanner.nextInt();

        System.out.print("Enter course code to enroll in: ");
        String courseCode = scanner.next();

        CourseManagement.enrollStudent(studentId, courseCode);
    }

    private static void assignGrade() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student ID: ");
        int studentId = scanner.nextInt();

        System.out.print("Enter course code: ");
        String courseCode = scanner.next();

        System.out.print("Enter grade: ");
        double grade = scanner.nextDouble();

        CourseManagement.assignGrade(studentId, courseCode, grade);
    }

    private static void calculateOverallGrade() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student ID: ");
        int studentId = scanner.nextInt();

        CourseManagement.calculateOverallGrade(studentId);
    }
}

