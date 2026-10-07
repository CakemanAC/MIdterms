import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class OOPMidtermLab {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        char continueChoice;

        do {
            System.out.println("Choose the program you want to run");
            System.out.println("Number 1");
            System.out.println("Number 2");
            System.out.println("Number 3");
            System.out.println("Number 4");
            System.out.println("Number 5");
            System.out.println("Number 6");
            System.out.println("Number 7");

            System.out.print("Enter your choice (1-7): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    runProgram1();
                    break;
                case 2:
                    runProgram2();
                    break;
                case 3:
                    runProgram3();
                    break;
                case 4:
                    runProgram4();
                    break;
                case 5:
                    runProgram5();
                    break;
                case 6:
                    runProgram6();
                    break;
                case 7:
                    runProgram7();
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

            System.out.print("Do you want to continue ? Y/N: ");
            continueChoice = scanner.next().toUpperCase().charAt(0);
            System.out.println();

        } while (continueChoice == 'Y');

        System.out.println("Program terminated. Goodbye!");
        scanner.close();
    }

    // ==========================================
    // PROGRAM 1: Array of 10 Real Numbers
    // ==========================================
    public static void runProgram1() {
        double[] arr = new double[10];
        System.out.println("Enter 10 real numbers (positive and negative):");
        for (int i = 0; i < 10; i++) {
            arr[i] = scanner.nextDouble();
        }

        // Loop 1: Find sum and average of positive numbers
        double sumPos = 0;
        int countPos = 0;
        for (int i = 0; i < 10; i++) {
            if (arr[i] > 0) {
                sumPos += arr[i];
                countPos++;
            }
        }
        double avgPos = (countPos > 0) ? (sumPos / countPos) : 0;
        System.out.println("Sum of positive numbers: " + sumPos);
        System.out.println("Average of positive numbers: " + avgPos);

        // Loop 2: Count negative numbers
        int countNeg = 0;
        for (int i = 0; i < 10; i++) {
            if (arr[i] < 0) {
                countNeg++;
            }
        }
        System.out.println("Count of negative numbers: " + countNeg);

        double minVal = arr[0];
        for (int i = 1; i < 10; i++) {
            if (arr[i] < minVal) {
                minVal = arr[i];
            }
        }
        System.out.println("Minimum value of the array: " + minVal);
    }

    public static void runProgram2() {
        int[] arr = new int[8];
        System.out.println("Enter 8 integer numbers:");
        for (int i = 0; i < 8; i++) {
            arr[i] = scanner.nextInt();
        }

        Set<Integer> uniqueSet = new LinkedHashSet<>();
        for (int num : arr) {
            uniqueSet.add(num);
        }
        System.out.println("Array after removing duplicates: " + uniqueSet);

        List<Integer> sortedList = new ArrayList<>(uniqueSet);
        Collections.sort(sortedList);

        if (sortedList.size() < 2) {
            System.out.println("Not enough unique elements to find 2nd largest/smallest.");
        } else {
            System.out.println("Second smallest element: " + sortedList.get(1));
            System.out.println("Second largest element: " + sortedList.get(sortedList.size() - 2));
        }
    }

    public static void runProgram3() {
        scanner.nextLine(); 
        System.out.print("Enter Data in Array: ");
        String line = scanner.nextLine();
        String[] tokens = line.split("\\s+");
        int[] arr = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            arr[i] = Integer.parseInt(tokens[i]);
        }

        System.out.print("Stored Data in Array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i == arr.length - 1 ? "" : " "));
        }
        System.out.println();

        System.out.print("Enter poss. of Element to Delete: ");
        int pos = scanner.nextInt();

        if (pos < 1 || pos > arr.length) {
            System.out.println("Invalid position!");
            return;
        }

        System.out.print("New data in Array: ");
        boolean first = true;
        for (int i = 0; i < arr.length; i++) {
            if (i == pos - 1) {
                continue;
            }
            if (!first) {
                System.out.print(" ");
            }
            System.out.print(arr[i]);
            first = false;
        }
        System.out.println();
    }

    // ==========================================
    // PROGRAM 4: Even and Odd Elements
    // ==========================================
    public static void runProgram4() {
        System.out.print("Enter Size of Array : ");
        int size = scanner.nextInt();
        int[] arr = new int[size];

        System.out.println("Enter any " + size + " elements in Array:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.print("Even Elements: ");
        boolean firstEven = true;
        for (int num : arr) {
            if (num % 2 == 0) {
                if (!firstEven) System.out.print(" ");
                System.out.print(num);
                firstEven = false;
            }
        }
        System.out.println();

        System.out.print("Odd Elements: ");
        boolean firstOdd = true;
        for (int num : arr) {
            if (num % 2 != 0) {
                if (!firstOdd) System.out.print(" ");
                System.out.print(num);
                firstOdd = false;
            }
        }
        System.out.println();
    }

    // ==========================================
    // PROGRAM 5: Structural Pattern Printer
    // ==========================================
    public static void runProgram5() {
        int rows = 4;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
                if (j < i) {
                    System.out.print("A");
                }
            }
            System.out.println();
        }
    }

    // ==========================================
    // PROGRAM 6: Student Management System
    // ==========================================
    public static void runProgram6() {
        System.out.println("Creating student1 using Default Constructor...");
        Student s1 = new Student();
        s1.displayStudentInfo();

        System.out.println("\nCreating student2 using Parameterized Constructor...");
        System.out.print("Enter Student Number: ");
        String studentNo = scanner.nextLine(); 
        System.out.print("Enter Student Name: ");
        String studentName = scanner.nextLine();
        System.out.print("Enter Date of Birth (dd/MM/yyyy): ");
        String dobString = scanner.nextLine();
        System.out.print("Enter Tariff Points: ");
        int tariffPoints = scanner.nextInt();
        scanner.nextLine(); 

        Student s2 = new Student(studentNo, studentName, dobString, tariffPoints);
        System.out.println("\n--- Displaying Student 2 Info ---");
        s2.displayStudentInfo();
        System.out.println("\nTotal Student Instances Registered: " + Student.getNoOfStudents());
    }

    static class Student {
        private String studentNo;
        private String studentName;
        private java.util.Date dateOfBirth;
        private Integer tariffPoints;
        private static int noOfStudents = 0;
        private static final java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");

        public Student() {
            this.studentNo = "not known";
            this.studentName = "not known";
            try {
                this.dateOfBirth = sdf.parse("01/01/1995");
            } catch (java.text.ParseException e) {
                this.dateOfBirth = new java.util.Date();
            }
            this.tariffPoints = 20;
            noOfStudents++;
        }

        public Student(String studentNo, String studentName, String dobString, Integer tariffPoints) {
            this.studentNo = studentNo;
            this.studentName = studentName;
            try {
                this.dateOfBirth = sdf.parse(dobString);
            } catch (java.text.ParseException e) {
                try {
                    this.dateOfBirth = sdf.parse("01/01/1995");
                } catch (java.text.ParseException ex) {
                    this.dateOfBirth = new java.util.Date();
                }
            }
            setTariffPoints(tariffPoints);
            noOfStudents++;
        }

        public String getStudentNo() { return studentNo; }
            public void setStudentNo(String studentNo) { this.studentNo = studentNo; }
        public String getStudentName() { return studentName; }
        public void setStudentName(String studentName) { this.studentName = studentName; }
        public java.util.Date getDateOfBirth() { return dateOfBirth; }
        public void setDateOfBirth(java.util.Date dateOfBirth) { this.dateOfBirth = dateOfBirth; }
        public Integer getTariffPoints() { return tariffPoints; }
        public void setTariffPoints(Integer tariffPoints) {
        if (tariffPoints >= 20 && tariffPoints <= 280) {
        this.tariffPoints = tariffPoints;
        } else {
        System.out.println("Warning: Tariff points must be between 20 and 280.");
        if (this.tariffPoints == null) this.tariffPoints = 20;
        }
        }
        public void displayStudentInfo() {
        System.out.println("Student No: " + studentNo);
        System.out.println("Student Name: " + studentName);
        System.out.println("Date of Birth: " + sdf.format(dateOfBirth));
        System.out.println("Tariff Points: " + tariffPoints);
        }
        public static int getNoOfStudents() { return noOfStudents; }
        }
        public static void runProgram7() {
        String fileName = "emp.txt";
        System.out.println("Reading and formatting data from: " + fileName + "\n");
        try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(fileName))) {
        String line;
        while ((line = br.readLine()) != null) {
        String[] data = line.split(",|\t");
        if (data.length >= 3) {
        System.out.printf("%-12s %-20s %-15s%n", data[0].trim(), data[1].trim(), data[2].trim());
        }
        }
        } catch (java.io.FileNotFoundException e) {
        System.out.println("Error: The file '" + fileName + "' was not found.");
        System.out.println("Please create 'emp.txt' inside your project root folder.");
        } catch (java.io.IOException e) {
        System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
     }
}   
