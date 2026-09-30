import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fulloutput {

    static final Scanner sc = new Scanner(System.in);

    // ------------------------------------------------------------------
    // MENU
    // ------------------------------------------------------------------
    public static void main(String[] args) {
        String again;
        do {
            System.out.println("\nChoose the program you want to run");
            for (int i = 1; i <= 7; i++) {
                System.out.println("Number " + i);
            }
            System.out.print("Your choice: ");
            int choice = sc.nextInt();
            System.out.println();

            switch (choice) {
                case 1: program1(); break;
                case 2: program2(); break;
                case 3: program3(); break;
                case 4: program4(); break;
                case 5: program5(); break;
                case 6: program6(); break;
                case 7: program7(); break;
                default: System.out.println("Invalid choice. Pick 1-7.");
            }

            System.out.print("\nDo you want to continue ? Y/N: ");
            again = sc.next();
        } while (again.equalsIgnoreCase("Y"));
        System.out.println("Goodbye!");
    }

    // ------------------------------------------------------------------
    // PROGRAM 1: 10 real numbers - positive sum/average, negative count, min
    // ------------------------------------------------------------------
    static void program1() {
        double[] nums = new double[10];
        System.out.println("Enter 10 real numbers (negative and positive):");
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextDouble();
        }

        // Loop 1: sum and average of positives
        double sum = 0;
        int positiveCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                sum += nums[i];
                positiveCount++;
            }
        }
        if (positiveCount > 0) {
            System.out.println("Sum of positive numbers: " + sum);
            System.out.println("Average of positive numbers: " + (sum / positiveCount));
        } else {
            System.out.println("There are no positive numbers.");
        }

        // Loop 2: count negatives
        int negativeCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                negativeCount++;
            }
        }
        System.out.println("Count of negative numbers: " + negativeCount);

        // Loop 3: minimum value
        double min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        System.out.println("Minimum value: " + min);
    }

    // ------------------------------------------------------------------
    // PROGRAM 2: 8 integers - remove duplicates, 2nd largest, 2nd smallest
    // ------------------------------------------------------------------
    static void program2() {
        int[] arr = new int[8];
        System.out.println("Enter 8 integers:");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        // Remove duplicates (keeps first occurrence, preserves order)
        int[] unique = new int[arr.length];
        int uniqueCount = 0;
        for (int i = 0; i < arr.length; i++) {
            boolean duplicate = false;
            for (int j = 0; j < uniqueCount; j++) {
                if (arr[i] == unique[j]) {
                    duplicate = true;
                    break;
                }
            }
            if (!duplicate) {
                unique[uniqueCount++] = arr[i];
            }
        }
        System.out.print("Array without duplicates:");
        for (int i = 0; i < uniqueCount; i++) {
            System.out.print(" " + unique[i]);
        }
        System.out.println();

        // Second largest / smallest are taken from the distinct values
        if (uniqueCount < 2) {
            System.out.println("Not enough distinct elements for second largest/smallest.");
            return;
        }

        int largest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE, secondSmallest = Integer.MAX_VALUE;
        for (int i = 0; i < uniqueCount; i++) {
            int v = unique[i];
            if (v > largest) {
                secondLargest = largest;
                largest = v;
            } else if (v > secondLargest) {
                secondLargest = v;
            }
            if (v < smallest) {
                secondSmallest = smallest;
                smallest = v;
            } else if (v < secondSmallest) {
                secondSmallest = v;
            }
        }
        System.out.println("Second largest element: " + secondLargest);
        System.out.println("Second smallest element: " + secondSmallest);
    }

    // ------------------------------------------------------------------
    // PROGRAM 3: delete an element from a specific position
    // ------------------------------------------------------------------
    static void program3() {
        int size = 5;
        int[] arr = new int[size];

        System.out.print("Enter Data in Array: ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Stored Data in Array:");
        for (int i = 0; i < size; i++) {
            System.out.print(" " + arr[i]);
        }
        System.out.println();

        System.out.print("Enter poss. of Element to Delete: ");
        int pos = sc.nextInt();

        // Position is the array index (0-based), matching the sample output
        if (pos < 0 || pos >= size) {
            System.out.println("Invalid position!");
            return;
        }

        for (int i = pos; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;

        System.out.print("New data in Array:");
        for (int i = 0; i < size; i++) {
            System.out.print(" " + arr[i]);
        }
        System.out.println();
    }

    // ------------------------------------------------------------------
    // PROGRAM 4: even and odd elements
    // ------------------------------------------------------------------
    static void program4() {
        System.out.print("Enter Size of Array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter any " + n + " elements in Array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Evens in input order
        System.out.print("Even Elements:");
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0) {
                System.out.print(" " + arr[i]);
            }
        }
        System.out.println();

        // Odds printed from the end, as in the sample output (7 5)
        System.out.print("Odd Elements:");
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] % 2 != 0) {
                System.out.print(" " + arr[i]);
            }
        }
        System.out.println();
    }

    // ------------------------------------------------------------------
    // PROGRAM 5: pattern
    // *
    // *A*
    // *A*A*
    // *A*A*A*
    // ------------------------------------------------------------------
    static void program5() {
        int rows = 4;
        for (int i = 1; i <= rows; i++) {
            System.out.print("*");
            for (int j = 1; j < i; j++) {
                System.out.print("A*");
            }
            System.out.println();
        }
    }

    // ------------------------------------------------------------------
    // PROGRAM 6: Student class (a), constructors (b), usage (c)
    // ------------------------------------------------------------------
    static class Student {
        private String studentNo;
        private String studentName;
        private LocalDate dateOfBirth;
        private int tariffPoints;

        // class variable
        private static int noOfStudents = 0;

        // (b) default constructor
        public Student() {
            this.studentNo = "not known";
            this.studentName = "not known";
            this.dateOfBirth = LocalDate.of(1995, 1, 1);
            this.tariffPoints = 20;
            noOfStudents++;
        }

        // (b) constructor with 4 parameters (uses setters for integrity checks)
        public Student(String studentNo, String studentName,
                       LocalDate dateOfBirth, int tariffPoints) {
            setStudentNo(studentNo);
            setStudentName(studentName);
            setDateOfBirth(dateOfBirth);
            setTariffPoints(tariffPoints);
            noOfStudents++;
        }

        // (a) getters
        public String getStudentNo() { return studentNo; }
        public String getStudentName() { return studentName; }
        public LocalDate getDateOfBirth() { return dateOfBirth; }
        public int getTariffPoints() { return tariffPoints; }
        public static int getNoOfStudents() { return noOfStudents; }

        // (a) setters with integrity checks
        public void setStudentNo(String studentNo) {
            if (studentNo == null || studentNo.trim().isEmpty()) {
                throw new IllegalArgumentException("Student number must not be empty");
            }
            this.studentNo = studentNo;
        }

        public void setStudentName(String studentName) {
            if (studentName == null || studentName.trim().isEmpty()) {
                throw new IllegalArgumentException("Student name must not be empty");
            }
            this.studentName = studentName;
        }

        public void setDateOfBirth(LocalDate dateOfBirth) {
            if (dateOfBirth == null || dateOfBirth.isAfter(LocalDate.now())) {
                throw new IllegalArgumentException("Date of birth must be a valid past date");
            }
            this.dateOfBirth = dateOfBirth;
        }

        public void setTariffPoints(int tariffPoints) {
            if (tariffPoints < 20 || tariffPoints > 280) {
                throw new IllegalArgumentException("Tariff points must be between 20 and 280");
            }
            this.tariffPoints = tariffPoints;
        }

        @Override
        public String toString() {
            return "Student[No=" + studentNo + ", Name=" + studentName
                    + ", DOB=" + dateOfBirth + ", Tariff=" + tariffPoints + "]";
        }
    }

    static void program6() {
        // (c) using the default constructor
        Student s1 = new Student();
        System.out.println(s1);

        // (c) using the 4-parameter constructor
        Student s2 = new Student("S1001", "Alice Smith", LocalDate.of(2003, 5, 14), 180);
        System.out.println(s2);

        // Integrity check demo
        try {
            new Student("S1002", "Bob", LocalDate.of(2002, 3, 2), 500);
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }

        System.out.println("Number of students created: " + Student.getNoOfStudents());
    }

    // ------------------------------------------------------------------
    // PROGRAM 7: tab separated text file -> database (JDBC)
    // ------------------------------------------------------------------
    // Change these to match your database. The matching JDBC driver jar
    // (e.g. MySQL Connector/J) must be on the classpath when you run.
    static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "";

    static void program7() {
        System.out.print("Enter path of the text file (e.g. emp.txt): ");
        String path = sc.next();

        List<String[]> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                // one record per line, tab separated (falls back to comma)
                String[] parts = line.contains("\t") ? line.split("\t") : line.split(",");
                if (parts.length < 3) continue;
                if (parts[0].trim().equalsIgnoreCase("eno")) continue; // skip header
                records.add(parts);
            }
        } catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
            return;
        }

        try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            try (Statement st = con.createStatement()) {
                st.executeUpdate("CREATE TABLE IF NOT EXISTS emp ("
                        + "eno INT PRIMARY KEY, ename VARCHAR(50), mobile VARCHAR(15))");
            }

            String sql = "INSERT INTO emp (eno, ename, mobile) VALUES (?, ?, ?)";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                for (String[] r : records) {
                    ps.setInt(1, Integer.parseInt(r[0].trim()));
                    ps.setString(2, r[1].trim());
                    ps.setString(3, r[2].trim());
                    ps.executeUpdate();
                    System.out.println("Inserted: " + r[0].trim() + " " + r[1].trim() + " " + r[2].trim());
                }
            }
            System.out.println(records.size() + " record(s) inserted.");
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Bad employee number in file: " + e.getMessage());
        }
    }
}