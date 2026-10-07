import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    static final Scanner sc = new Scanner(System.in);

    // ------------------------------------------------------------------
    // INPUT HELPERS - re-prompt instead of crashing on bad input
    // ------------------------------------------------------------------
    static int readInt() {
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input, enter a whole number: ");
            sc.next();
        }
        return sc.nextInt();
    }

    static double readDouble() {
        while (!sc.hasNextDouble()) {
            System.out.print("Invalid input, enter a number: ");
            sc.next();
        }
        return sc.nextDouble();
    }

    // ------------------------------------------------------------------
    // MENU
    // ------------------------------------------------------------------
    public static void main(String[] args) {
        sc.useLocale(Locale.US); // so "3.5" parses the same on every machine

        String[] titles = {
            "Positive sum/average, negative count, minimum",
            "Remove duplicates, 2nd largest/smallest",
            "Delete an element from an array",
            "Even and odd elements",
            "Print the * A * pattern",
            "Student class demo",
            "Text file formatting"
        };

        String again;
        do {
            System.out.println("\nChoose the program you want to run:");
            for (int i = 0; i < titles.length; i++) {
                System.out.println("  " + (i + 1) + ". " + titles[i]);
            }
            System.out.print("Your choice: ");
            int choice = readInt();
            System.out.println();

            switch (choice) {
                case 1: program1(); break;
                case 2: program2(); break;
                case 3: program3(); break;
                case 4: program4(); break;
                case 5: program5(); break;
                case 6: program6(); break;
                case 7: runProgram7(); break;
                default: System.out.println("Invalid choice. Pick 1-7.");
            }

            do {
                System.out.print("\nDo you want to continue? Y/N: ");
                again = sc.next();
            } while (!again.equalsIgnoreCase("Y") && !again.equalsIgnoreCase("N"));
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
            nums[i] = readDouble();
        }

        // Loop 1: sum and average of positives
        double sum = 0;
        int positiveCount = 0;
        for (double n : nums) {
            if (n > 0) {
                sum += n;
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
        for (double n : nums) {
            if (n < 0) negativeCount++;
        }
        System.out.println("Count of negative numbers: " + negativeCount);

        // Loop 3: minimum value
        double min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) min = nums[i];
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
            arr[i] = readInt();
        }

        // Remove duplicates (keeps first occurrence, preserves order)
        int[] unique = new int[arr.length];
        int uniqueCount = 0;
        for (int value : arr) {
            boolean duplicate = false;
            for (int j = 0; j < uniqueCount; j++) {
                if (value == unique[j]) {
                    duplicate = true;
                    break;
                }
            }
            if (!duplicate) unique[uniqueCount++] = value;
        }
        System.out.print("Array without duplicates:");
        for (int i = 0; i < uniqueCount; i++) {
            System.out.print(" " + unique[i]);
        }
        System.out.println();

        if (uniqueCount < 2) {
            System.out.println("Not enough distinct elements for second largest/smallest.");
            return;
        }

        // Use long so Integer.MIN_VALUE / MAX_VALUE inputs can't clash with the sentinels
        long largest = Long.MIN_VALUE, secondLargest = Long.MIN_VALUE;
        long smallest = Long.MAX_VALUE, secondSmallest = Long.MAX_VALUE;
        for (int i = 0; i < uniqueCount; i++) {
            long v = unique[i];
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

        System.out.print("Enter " + size + " values for the array: ");
        for (int i = 0; i < size; i++) {
            arr[i] = readInt();
        }

        System.out.print("Stored data in array:");
        for (int i = 0; i < size; i++) {
            System.out.print(" " + arr[i]);
        }
        System.out.println();

        System.out.print("Enter position (index 0-" + (size - 1) + ") of element to delete: ");
        int pos = readInt();

        if (pos < 0 || pos >= size) {
            System.out.println("Invalid position!");
            return;
        }

        for (int i = pos; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;

        System.out.print("New data in array:");
        for (int i = 0; i < size; i++) {
            System.out.print(" " + arr[i]);
        }
        System.out.println();
    }

    // ------------------------------------------------------------------
    // PROGRAM 4: even and odd elements
    // ------------------------------------------------------------------
    static void program4() {
        System.out.print("Enter size of array: ");
        int n = readInt();
        if (n <= 0) {
            System.out.println("Size must be at least 1.");
            return;
        }
        int[] arr = new int[n];

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = readInt();
        }

        // Evens in input order
        System.out.print("Even elements:");
        for (int v : arr) {
            if (v % 2 == 0) System.out.print(" " + v);
        }
        System.out.println();

        // Odds printed from the end, matching the sample output (7 5)
        System.out.print("Odd elements:");
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] % 2 != 0) System.out.print(" " + arr[i]);
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

        private static int noOfStudents = 0;

        // default constructor
        public Student() {
            this.studentNo = "not known";
            this.studentName = "not known";
            this.dateOfBirth = LocalDate.of(1995, 1, 1);
            this.tariffPoints = 20;
            noOfStudents++;
        }

        // 4-parameter constructor; setters validate, and the counter only
        // increases if every check passes
        public Student(String studentNo, String studentName,
                       LocalDate dateOfBirth, int tariffPoints) {
            setStudentNo(studentNo);
            setStudentName(studentName);
            setDateOfBirth(dateOfBirth);
            setTariffPoints(tariffPoints);
            noOfStudents++;
        }

        public String getStudentNo() { return studentNo; }
        public String getStudentName() { return studentName; }
        public LocalDate getDateOfBirth() { return dateOfBirth; }
        public int getTariffPoints() { return tariffPoints; }
        public static int getNoOfStudents() { return noOfStudents; }

        public void setStudentNo(String studentNo) {
            if (studentNo == null || studentNo.trim().isEmpty()) {
                throw new IllegalArgumentException("Student number must not be empty");
            }
            this.studentNo = studentNo.trim();
        }

        public void setStudentName(String studentName) {
            if (studentName == null || studentName.trim().isEmpty()) {
                throw new IllegalArgumentException("Student name must not be empty");
            }
            this.studentName = studentName.trim();
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
        // Default constructor: used exactly once
        Student first = new Student();
        System.out.println("Default student: " + first);

        // Every following student comes from user input (4-parameter constructor)
        String more;
        do {
            sc.nextLine(); // discard leftover end-of-line
            try {
                System.out.print("\nEnter student number: ");
                String no = sc.nextLine();
                System.out.print("Enter student name: ");
                String name = sc.nextLine();
                System.out.print("Enter date of birth (yyyy-MM-dd): ");
                LocalDate dob = LocalDate.parse(sc.nextLine().trim());
                System.out.print("Enter tariff points (20-280): ");
                int points = readInt();

                Student s = new Student(no, name, dob, points);
                System.out.println("Created: " + s);
            } catch (IllegalArgumentException | DateTimeParseException e) {
                System.out.println("Rejected: " + e.getMessage());
            }

            do {
                System.out.print("Add another student? Y/N: ");
                more = sc.next();
            } while (!more.equalsIgnoreCase("Y") && !more.equalsIgnoreCase("N"));
        } while (more.equalsIgnoreCase("Y"));

        System.out.println("\nNumber of students created: " + Student.getNoOfStudents());
    }

    // ------------------------------------------------------------------
    // PROGRAM 7: Text File Formatting
    // ------------------------------------------------------------------
    public static void runProgram7() {
        String fileName = "emp.txt";
        System.out.println("Reading and formatting data from: " + fileName + "\n");
        try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",|\t");
                if (data.length >= 3) {
                    // FIX 2: Changed data.trim() to data[2].trim()
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

