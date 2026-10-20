// ============================================================
//  OOPR Midterm Lab Activities 1 - 31  (all in ONE program)
//  Language: Java
//  File name must be:  MidtermActivities.java
//  The program simply runs Activity 1, then 2, then 3 ... up to 31.
//  Where the activity asks for several solutions (if/else, switch,
//  for, while, do-while), every solution is shown one after another.
// ============================================================

import java.util.Scanner;

public class MidtermActivities {

    // One Scanner shared by every activity (this is what reads your typing)
    static Scanner sc = new Scanner(System.in);

    // ------------------------------------------------------------
    //  Small helper methods (used by many activities)
    // ------------------------------------------------------------

    // Prints a big heading for each activity
    static void heading(String title) {
        System.out.println("\n==================================================");
        System.out.println(title);
        System.out.println("==================================================");
    }

    // Prints a small heading for each solution
    static void solution(String title) {
        System.out.println("--- " + title + " ---");
    }

    // Asks for a whole number and keeps asking until it is valid
    static int readInt(String prompt, int minValue, int maxValue) {
        System.out.print(prompt);
        while (true) {
            if (!sc.hasNext()) System.exit(0);       // input ended, stop the program
            if (sc.hasNextInt()) {
                int n = sc.nextInt();
                if (n >= minValue && n <= maxValue) return n;
            } else {
                sc.next();                           // throw away the bad input
            }
            System.out.print("Invalid. Try again: ");
        }
    }

    // Asks for a number with decimals
    static double readDouble(String prompt) {
        System.out.print(prompt);
        while (true) {
            if (!sc.hasNext()) System.exit(0);
            if (sc.hasNextDouble()) return sc.nextDouble();
            sc.next();
            System.out.print("Invalid. Try again: ");
        }
    }

    // Turns 21000 into "21,000.00"
    static String money(double value) {
        return String.format("%,.2f", value);
    }

    // ------------------------------------------------------------
    //  Activity 1 : Vowel or Consonant
    // ------------------------------------------------------------
    static void activity1() {
        heading("Activity 1: Vowel or Consonant");
        System.out.print("Enter a letter: ");
        char ch = sc.next().charAt(0);
        if (!Character.isLetter(ch)) {
            System.out.println("That is not a letter.");
            return;
        }
        char up = Character.toUpperCase(ch);   // handles capital AND small letters

        solution("1st Solution: if / else if / else");
        if (up == 'A')      System.out.println(ch + " is a VOWEL");
        else if (up == 'E') System.out.println(ch + " is a VOWEL");
        else if (up == 'I') System.out.println(ch + " is a VOWEL");
        else if (up == 'O') System.out.println(ch + " is a VOWEL");
        else if (up == 'U') System.out.println(ch + " is a VOWEL");
        else                System.out.println(ch + " is a CONSONANT");

        solution("2nd Solution: switch / case");
        switch (up) {
            case 'A': case 'E': case 'I': case 'O': case 'U':
                System.out.println(ch + " is a VOWEL");
                break;
            default:
                System.out.println(ch + " is a CONSONANT");
        }
    }

    // ------------------------------------------------------------
    //  Activity 2 : Numeric date -> complete date
    // ------------------------------------------------------------
    static void activity2() {
        heading("Activity 2: Date in Words");
        int month = readInt("Enter month day year (example: 2 26 1986)\nMonth: ", 1, 12);
        int day   = readInt("Day: ", 1, 31);
        int year  = readInt("Year: ", 1, 9999);

        solution("1st Solution: if / else if / else");
        String name;
        if (month == 1)       name = "January";
        else if (month == 2)  name = "February";
        else if (month == 3)  name = "March";
        else if (month == 4)  name = "April";
        else if (month == 5)  name = "May";
        else if (month == 6)  name = "June";
        else if (month == 7)  name = "July";
        else if (month == 8)  name = "August";
        else if (month == 9)  name = "September";
        else if (month == 10) name = "October";
        else if (month == 11) name = "November";
        else                  name = "December";
        System.out.println(name + " " + day + ", " + year);

        solution("2nd Solution: switch / case");
        switch (month) {
            case 1:  name = "January";   break;
            case 2:  name = "February";  break;
            case 3:  name = "March";     break;
            case 4:  name = "April";     break;
            case 5:  name = "May";       break;
            case 6:  name = "June";      break;
            case 7:  name = "July";      break;
            case 8:  name = "August";    break;
            case 9:  name = "September"; break;
            case 10: name = "October";   break;
            case 11: name = "November";  break;
            default: name = "December";  break;
        }
        System.out.println(name + " " + day + ", " + year);
    }

    // ------------------------------------------------------------
    //  Activity 3 : Temperature message
    // ------------------------------------------------------------
    static void activity3() {
        heading("Activity 3: Temperature");
        double temp = readDouble("Enter temp: ");
        if (temp < 0)           System.out.println("ICE");
        else if (temp <= 100)   System.out.println("WATER");   // between 0 and 100
        else                    System.out.println("STEAM");   // exceeds 100
    }

    // ------------------------------------------------------------
    //  Activity 4 : Military or civilian aircraft
    // ------------------------------------------------------------
    static void activity4() {
        heading("Activity 4: Aircraft Label");
        double speed  = readDouble("Enter observed speed (km/h): ");
        double length = readDouble("Enter estimated length (meters): ");

        if (speed > 1100 && length > 52)
            System.out.println("Civilian aircraft");
        else if (speed >= 500)              // fast, but not big enough to be civilian
            System.out.println("Military aircraft");
        else                                // slower speeds
            System.out.println("It's a bird");
    }

    // ------------------------------------------------------------
    //  Activity 5 : Ship class
    // ------------------------------------------------------------
    static void activity5() {
        heading("Activity 5: Ship Class");
        System.out.print("Enter class ID (B, C, D or F): ");
        char id = sc.next().charAt(0);

        solution("1st Solution: if / else if / else");
        if (id == 'B' || id == 'b')      System.out.println("Battleship");
        else if (id == 'C' || id == 'c') System.out.println("Cruiser");
        else if (id == 'D' || id == 'd') System.out.println("Destroyer");
        else if (id == 'F' || id == 'f') System.out.println("Frigate");
        else                             System.out.println("Unknown class ID");

        solution("2nd Solution: switch / case");
        switch (id) {
            case 'B': case 'b': System.out.println("Battleship"); break;
            case 'C': case 'c': System.out.println("Cruiser");    break;
            case 'D': case 'd': System.out.println("Destroyer");  break;
            case 'F': case 'f': System.out.println("Frigate");    break;
            default:            System.out.println("Unknown class ID");
        }
    }

    // ------------------------------------------------------------
    //  Activity 6 : Earthquake damage (Richter scale)
    // ------------------------------------------------------------
    static void activity6() {
        heading("Activity 6: Richter Scale");
        double n = readDouble("Enter Richter scale value: ");
        if (n < 5.0)       System.out.println("Little or no damage");
        else if (n < 5.5)  System.out.println("Some damage");
        else if (n < 6.5)  System.out.println("Serious damage");
        else if (n < 7.5)  System.out.println("Disaster");
        else               System.out.println("Catastrophe");
    }

    // ------------------------------------------------------------
    //  Activity 7 : Number in words (max 3000)
    // ------------------------------------------------------------
    static void activity7() {
        heading("Activity 7: Number to Words");
        int n = readInt("Enter a number (0 - 3000): ", 0, 3000);

        String[] ones = {"zero", "one", "two", "three", "four", "five", "six",
                         "seven", "eight", "nine", "ten", "eleven", "twelve",
                         "thirteen", "fourteen", "fifteen", "sixteen",
                         "seventeen", "eighteen", "nineteen"};
        String[] tens = {"", "", "twenty", "thirty", "forty", "fifty",
                         "sixty", "seventy", "eighty", "ninety"};

        if (n == 0) {
            System.out.println("zero");
            return;
        }

        String words = "";
        if (n >= 1000) {
            words += ones[n / 1000] + " thousand";
            n %= 1000;
        }
        if (n >= 100) {
            if (!words.isEmpty()) words += " ";
            words += ones[n / 100] + " hundred";
            n %= 100;
        }
        if (n > 0) {
            if (!words.isEmpty()) words += " ";
            if (n < 20) {
                words += ones[n];
            } else {
                words += tens[n / 10];
                if (n % 10 != 0) words += " " + ones[n % 10];
            }
        }
        System.out.println(words);
    }

    // ------------------------------------------------------------
    //  Activity 8 : Roman numerals (max 3000)
    // ------------------------------------------------------------
    static void activity8() {
        heading("Activity 8: Roman Numerals");
        int n = readInt("Enter a number (1 - 3000): ", 1, 3000);

        int[] values      = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols  = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        String roman = "";
        for (int i = 0; i < values.length; i++) {
            while (n >= values[i]) {      // use the biggest symbol that still fits
                roman += symbols[i];
                n -= values[i];
            }
        }
        System.out.println(roman);
    }

    // ------------------------------------------------------------
    //  Activity 9 : Tuition fee
    // ------------------------------------------------------------
    static void activity9() {
        heading("Activity 9: Tuition Fee");
        double fee = 0;
        boolean valid = false;
        System.out.print("Enter tuition fee: ");
        while (!valid) {
            if (!sc.hasNext()) System.exit(0);
            String text = sc.next().replace(",", "");     // allow "20,000"
            try {
                fee = Double.parseDouble(text);
                valid = true;
            } catch (NumberFormatException e) {
                System.out.print("Invalid. Try again: ");
            }
        }

        System.out.println("(Press 1 for Cash, 2 for Two-Installment, 3 for Three-Installment)");
        int mode = readInt("Enter mode of payment: ", 1, 3);

        double total;
        if (mode == 1)      total = fee - fee * 0.10;   // 10% discount
        else if (mode == 2) total = fee - fee * 0.05;   // 5% discount
        else                total = fee + fee * 0.10;   // 10% interest

        System.out.println("Your total tuition fee is: " + money(total));
    }

    // ------------------------------------------------------------
    //  Activity 10 : Percentile -> grade
    // ------------------------------------------------------------
    static void activity10() {
        heading("Activity 10: Grade Equivalent");
        int g = readInt("Enter percentile grade: ", Integer.MIN_VALUE, Integer.MAX_VALUE);

        if (g >= 98 && g <= 100)      System.out.println("1.00");
        else if (g >= 95 && g <= 97)  System.out.println("1.25");
        else if (g >= 92 && g <= 94)  System.out.println("1.50");
        else if (g >= 89 && g <= 91)  System.out.println("1.75");
        else if (g >= 85 && g <= 88)  System.out.println("2.00");
        else if (g >= 82 && g <= 84)  System.out.println("2.25");
        else if (g >= 80 && g <= 81)  System.out.println("2.50");
        else if (g >= 77 && g <= 79)  System.out.println("2.75");
        else if (g >= 75 && g <= 76)  System.out.println("3.00");
        else                          System.out.println("\"Out-of-Range\"");
    }

    // ------------------------------------------------------------
    //  Activity 11 : Sequence numbers and their squares
    // ------------------------------------------------------------
    static void activity11() {
        heading("Activity 11: Numbers and Squares");
        int n = readInt("How many numbers? (example: 5): ", 1, 1000);
        int i;

        solution("1st Solution: for loop");
        System.out.println("Sequence nos.\tSquared");
        for (i = 1; i <= n; i++)
            System.out.println(i + "\t\t" + i * i);

        solution("2nd Solution: while loop");
        System.out.println("Sequence nos.\tSquared");
        i = 1;
        while (i <= n) {
            System.out.println(i + "\t\t" + i * i);
            i++;
        }

        solution("3rd Solution: do-while loop");
        System.out.println("Sequence nos.\tSquared");
        i = 1;
        do {
            System.out.println(i + "\t\t" + i * i);
            i++;
        } while (i <= n);
    }

    // ------------------------------------------------------------
    //  Activity 12 : 1, 5, 2, 4, 3, 3, 4, 2, 5, 1,
    // ------------------------------------------------------------
    static void activity12() {
        heading("Activity 12: Alternate Sequence");
        final int N = 5;
        int i;

        solution("1st Solution: for loop");
        for (i = 1; i <= N; i++)
            System.out.print(i + ", " + (N + 1 - i) + ", ");
        System.out.println();

        solution("2nd Solution: while loop");
        i = 1;
        while (i <= N) {
            System.out.print(i + ", " + (N + 1 - i) + ", ");
            i++;
        }
        System.out.println();

        solution("3rd Solution: do-while loop");
        i = 1;
        do {
            System.out.print(i + ", " + (N + 1 - i) + ", ");
            i++;
        } while (i <= N);
        System.out.println();
    }

    // ------------------------------------------------------------
    //  Activity 13 : 5, 1, 4, 2, 3, 3, 2, 4, 1, 5,
    // ------------------------------------------------------------
    static void activity13() {
        heading("Activity 13: Alternate Sequence (Reverse)");
        final int N = 5;
        int i;

        solution("1st Solution: for loop");
        for (i = 1; i <= N; i++)
            System.out.print((N + 1 - i) + ", " + i + ", ");
        System.out.println();

        solution("2nd Solution: while loop");
        i = 1;
        while (i <= N) {
            System.out.print((N + 1 - i) + ", " + i + ", ");
            i++;
        }
        System.out.println();

        solution("3rd Solution: do-while loop");
        i = 1;
        do {
            System.out.print((N + 1 - i) + ", " + i + ", ");
            i++;
        } while (i <= N);
        System.out.println();
    }

    // ------------------------------------------------------------
    //  Activity 14 : Factorial (counting UP with i++)
    // ------------------------------------------------------------
    static void activity14() {
        heading("Activity 14: Factorial");
        int n = readInt("Enter a no. (1 - 20): ", 1, 20);
        long f;
        int i;

        solution("1st Solution: for loop");
        f = 1;
        System.out.print("The computation is: ");
        for (i = 1; i <= n; i++) {
            f *= i;
            System.out.print(i + (i < n ? "*" : ""));
        }
        System.out.println(" = " + f);

        solution("2nd Solution: while loop");
        f = 1; i = 1;
        System.out.print("The computation is: ");
        while (i <= n) {
            f *= i;
            System.out.print(i + (i < n ? "*" : ""));
            i++;
        }
        System.out.println(" = " + f);

        solution("3rd Solution: do-while loop");
        f = 1; i = 1;
        System.out.print("The computation is: ");
        do {
            f *= i;
            System.out.print(i + (i < n ? "*" : ""));
            i++;
        } while (i <= n);
        System.out.println(" = " + f);
    }

    // ------------------------------------------------------------
    //  Activity 15 : Fibonacci series
    // ------------------------------------------------------------
    static void activity15() {
        heading("Activity 15: Fibonacci Series");
        int n = readInt("Enter a no. (1 - 90): ", 1, 90);
        long a, b, next;
        int i;

        solution("1st Solution: for loop");
        a = 1; b = 1;
        System.out.print("Fibonacci series: ");
        for (i = 1; i <= n; i++) {
            System.out.print(a + " ");
            next = a + b;
            a = b;
            b = next;
        }
        System.out.println();

        solution("2nd Solution: while loop");
        a = 1; b = 1; i = 1;
        System.out.print("Fibonacci series: ");
        while (i <= n) {
            System.out.print(a + " ");
            next = a + b;
            a = b;
            b = next;
            i++;
        }
        System.out.println();

        solution("3rd Solution: do-while loop");
        a = 1; b = 1; i = 1;
        System.out.print("Fibonacci series: ");
        do {
            System.out.print(a + " ");
            next = a + b;
            a = b;
            b = next;
            i++;
        } while (i <= n);
        System.out.println();
    }

    // ------------------------------------------------------------
    //  Activity 16 : Power (base ^ exponent) using loops
    // ------------------------------------------------------------
    static void activity16() {
        heading("Activity 16: Power Value");
        int base = readInt("Enter base no.: ", -1000, 1000);
        int exp  = readInt("Enter exponent no. (1 or more): ", 1, 20);
        long result;
        int i;

        solution("1st Solution: for loop");
        result = 1;
        for (i = 1; i <= exp; i++) result *= base;
        System.out.println("Power value: " + result);

        solution("2nd Solution: while loop");
        result = 1; i = 1;
        while (i <= exp) {
            result *= base;
            i++;
        }
        System.out.println("Power value: " + result);

        solution("3rd Solution: do-while loop");
        result = 1; i = 1;
        do {
            result *= base;
            i++;
        } while (i <= exp);
        System.out.println("Power value: " + result);
    }

    // ------------------------------------------------------------
    //  Activity 17 : Sum of squares 1 to n
    // ------------------------------------------------------------
    static void activity17() {
        heading("Activity 17: Sum of Squares");
        int n = readInt("Enter a number: ", 1, 100000);
        long sum;
        int i;

        solution("1st Solution: for loop");
        sum = 0;
        for (i = 1; i <= n; i++) sum += (long) i * i;
        System.out.println("Sum of squares: " + sum);

        solution("2nd Solution: while loop");
        sum = 0; i = 1;
        while (i <= n) {
            sum += (long) i * i;
            i++;
        }
        System.out.println("Sum of squares: " + sum);

        solution("3rd Solution: do-while loop");
        sum = 0; i = 1;
        do {
            sum += (long) i * i;
            i++;
        } while (i <= n);
        System.out.println("Sum of squares: " + sum);
    }

    // ------------------------------------------------------------
    //  Activity 18 : Sum of 1 to n
    // ------------------------------------------------------------
    static void activity18() {
        heading("Activity 18: Sum of Sequence");
        int n = readInt("Enter a number: ", 1, 1000000);
        long sum;
        int i;

        solution("1st Solution: for loop");
        sum = 0;
        for (i = 1; i <= n; i++) sum += i;
        System.out.println("Sum: " + sum);

        solution("2nd Solution: while loop");
        sum = 0; i = 1;
        while (i <= n) {
            sum += i;
            i++;
        }
        System.out.println("Sum: " + sum);

        solution("3rd Solution: do-while loop");
        sum = 0; i = 1;
        do {
            sum += i;
            i++;
        } while (i <= n);
        System.out.println("Sum: " + sum);
    }

    // ------------------------------------------------------------
    //  Activity 19 : Reverse a number
    //  Idea: take the last digit with  % 10,  then chop it off with  / 10
    //        rev = rev * 10 + lastDigit
    // ------------------------------------------------------------
    static void activity19() {
        heading("Activity 19: Reverse Number");
        int n = readInt("Enter a number: ", 0, Integer.MAX_VALUE);
        long rev;
        int temp;

        solution("1st Solution: for loop");
        for (rev = 0, temp = n; temp > 0; temp /= 10)
            rev = rev * 10 + temp % 10;
        System.out.println("Reverse number: " + rev);

        solution("2nd Solution: while loop");
        rev = 0; temp = n;
        while (temp > 0) {
            rev = rev * 10 + temp % 10;
            temp /= 10;
        }
        System.out.println("Reverse number: " + rev);

        solution("3rd Solution: do-while loop");
        rev = 0; temp = n;
        do {
            rev = rev * 10 + temp % 10;
            temp /= 10;
        } while (temp > 0);
        System.out.println("Reverse number: " + rev);
    }

    // ------------------------------------------------------------
    //  Activity 20 : Sum of powers  1^1 + 2^2 + 3^3 + ... + n^n
    // ------------------------------------------------------------

    // helper: base raised to exponent (uses a loop)
    static long powerOf(int base, int exp) {
        long result = 1;
        for (int k = 1; k <= exp; k++) result *= base;
        return result;
    }

    static void activity20() {
        heading("Activity 20: Sum of Powers");
        int n = readInt("Enter a number (1 - 15): ", 1, 15);   // bigger numbers get too large
        long sum;
        int i;

        solution("1st Solution: for loop");
        sum = 0;
        for (i = 1; i <= n; i++) sum += powerOf(i, i);
        System.out.println("Sum of powers: " + sum);

        solution("2nd Solution: while loop");
        sum = 0; i = 1;
        while (i <= n) {
            sum += powerOf(i, i);
            i++;
        }
        System.out.println("Sum of powers: " + sum);

        solution("3rd Solution: do-while loop");
        sum = 0; i = 1;
        do {
            sum += powerOf(i, i);
            i++;
        } while (i <= n);
        System.out.println("Sum of powers: " + sum);
    }

    // ------------------------------------------------------------
    //  PATTERN ACTIVITIES 21 - 31
    //  Rows go down (outer loop i), items go across (inner loop j)
    // ------------------------------------------------------------

    // 21: right-angle triangle of asterisks
    static void activity21() {
        heading("Activity 21: Right-Angle Triangle (*)");
        int n = readInt("Number of rows: ", 1, 50);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) System.out.print("* ");
            System.out.println();
        }
    }

    // 22: Floyd's triangle (1 and 0 alternating)
    static void activity22() {
        heading("Activity 22: Floyd's Triangle");
        int n = readInt("Number of rows: ", 1, 50);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++)
                System.out.print(((i + j) % 2 == 0 ? 1 : 0) + " ");
            System.out.println();
        }
    }

    // 23: pyramid, odd number of asterisks per row (1, 3, 5, 7...)
    static void activity23() {
        heading("Activity 23: Pyramid (odd number of *)");
        int n = readInt("Number of rows: ", 1, 30);
        for (int i = 1; i <= n; i++) {
            for (int s = 1; s <= 2 * (n - i); s++) System.out.print(" ");   // leading spaces
            for (int j = 1; j <= 2 * i - 1; j++) System.out.print("* ");
            System.out.println();
        }
    }

    // 24: pyramid where each row repeats its row number
    static void activity24() {
        heading("Activity 24: Pyramid of Repeated Numbers");
        int n = readInt("Number of rows: ", 1, 30);
        for (int i = 1; i <= n; i++) {
            for (int s = 1; s <= n - i; s++) System.out.print(" ");
            for (int j = 1; j <= i; j++) System.out.print(i + " ");
            System.out.println();
        }
    }

    // 25: pyramid of asterisks
    static void activity25() {
        heading("Activity 25: Pyramid (*)");
        int n = readInt("Number of rows: ", 1, 30);
        for (int i = 1; i <= n; i++) {
            for (int s = 1; s <= n - i; s++) System.out.print(" ");
            for (int j = 1; j <= i; j++) System.out.print("* ");
            System.out.println();
        }
    }

    // 26: pyramid with numbers increasing by 1
    static void activity26() {
        heading("Activity 26: Pyramid (numbers increasing by 1)");
        int n = readInt("Number of rows: ", 1, 30);
        int num = 1;
        for (int i = 1; i <= n; i++) {
            for (int s = 1; s <= n - i; s++) System.out.print(" ");
            for (int j = 1; j <= i; j++) {
                System.out.print(num + " ");
                num++;
            }
            System.out.println();
        }
    }

    // 27: right-angle triangle with numbers increasing by 1
    static void activity27() {
        heading("Activity 27: Right-Angle Triangle (numbers increasing by 1)");
        int n = readInt("Number of rows: ", 1, 30);
        int num = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(num + " ");
                num++;
            }
            System.out.println();
        }
    }

    // 28: right-angle triangle where each row repeats its row number
    static void activity28() {
        heading("Activity 28: Right-Angle Triangle (repeated number)");
        int n = readInt("Number of rows: ", 1, 30);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) System.out.print(i + " ");
            System.out.println();
        }
    }

    // 29: right-angle triangle 1, 1 2, 1 2 3 ...
    static void activity29() {
        heading("Activity 29: Right-Angle Triangle (1 2 3 ...)");
        int n = readInt("Number of rows: ", 1, 30);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) System.out.print(j + " ");
            System.out.println();
        }
    }

    // 30: diamond of asterisks (n rows for the top half)
    static void activity30() {
        heading("Activity 30: Diamond");
        int n = readInt("Number of rows (top half of the diamond): ", 1, 30);

        // top half (growing)
        for (int i = 1; i <= n; i++) {
            for (int s = 1; s <= 2 * (n - i); s++) System.out.print(" ");
            for (int j = 1; j <= 2 * i - 1; j++) System.out.print("* ");
            System.out.println();
        }
        // bottom half (shrinking)
        for (int i = n - 1; i >= 1; i--) {
            for (int s = 1; s <= 2 * (n - i); s++) System.out.print(" ");
            for (int j = 1; j <= 2 * i - 1; j++) System.out.print("* ");
            System.out.println();
        }
    }

    // 31: number pyramid 1 / 1 2 1 / 1 2 3 2 1 ...
    static void activity31() {
        heading("Activity 31: Number Pyramid (1 2 3 2 1)");
        int n = readInt("Number of rows: ", 1, 9);
        for (int i = 1; i <= n; i++) {
            for (int s = 1; s <= 2 * (n - i); s++) System.out.print(" ");
            for (int j = 1; j <= i; j++) System.out.print(j + " ");        // going up
            for (int j = i - 1; j >= 1; j--) System.out.print(j + " ");    // coming back down
            System.out.println();
        }
    }

    // ------------------------------------------------------------
    //  main: runs every activity, one after the other
    // ------------------------------------------------------------
    public static void main(String[] args) {
        System.out.println("OOPR MIDTERM LAB ACTIVITIES (1 - 31)");

        activity1();   activity2();   activity3();   activity4();   activity5();
        activity6();   activity7();   activity8();   activity9();   activity10();
        activity11();  activity12();  activity13();  activity14();  activity15();
        activity16();  activity17();  activity18();  activity19();  activity20();
        activity21();  activity22();  activity23();  activity24();  activity25();
        activity26();  activity27();  activity28();  activity29();  activity30();
        activity31();

        System.out.println("\nAll activities finished.");
    }
}