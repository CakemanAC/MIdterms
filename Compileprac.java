// ============================================================
//  JAVA PROGRAMS PRACTICE  -  all programs in ONE file
//  File name must be:  compileprac.java   (class name = compileprac)
//
//  Every program from the PDF is its own method. main() runs them
//  one after the other (1 to 57). The programs that ask you to type
//  something (they used Scanner in the PDF) will still ask you.
//
//  Fixes made to the original code are marked with  // FIX:
// ============================================================

import java.util.HashMap;
import java.util.Scanner;

public class compileprac {

    // One shared Scanner for every program that needs typed input.
    // (Never close it - closing it would close the keyboard for the other programs.)
    static Scanner sc = new Scanner(System.in);

    static void title(int no, String name) {
        System.out.println("\n==================================================");
        System.out.println(no + ". " + name);
        System.out.println("==================================================");
    }

    // ============================================================
    //  1 - 5 : Odd numbers, sums, digits
    // ============================================================

    // 1. Display odd numbers between 1 - 100
    static void oddNumbers() {
        System.out.println("The Odd Numbers are:");
        for (int i = 1; i <= 100; i++) {
            if (i % 2 != 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    // 2. Sum of odd numbers between 1 - 100
    static void sumOddNumbers() {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 != 0) {
                sum = sum + i;
            }
        }
        System.out.println("The Sum Of 100 Odd Numbers are:" + sum);
    }

    // 3. Total number of odd numbers between 1 - 100
    static void countOddNumbers() {
        int count = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 != 0) {
                count++;
            }
        }
        System.out.println("The Count Of Odd Numbers are:" + count);
    }

    // 4. Find sum of first n numbers
    static void sumFirstN() {
        int sum = 0;
        int n = 10;
        for (int i = 1; i <= n; i++) {
            sum = sum + i;
        }
        System.out.println("The Sum Of " + n + " Numbers are:" + sum);
    }

    // 5. Find the sum of the digits of a number
    static void sumOfDigits() {
        int num = 251025, rem = 0, sum = 0, temp;
        temp = num;
        while (num > 0) {
            rem = num % 10;
            sum = sum + rem;
            num = num / 10;
        }
        System.out.println("Sum of Digits of " + temp + " is " + sum);
    }

    // ============================================================
    //  6 : Electricity bill
    // ============================================================
    static void electricBill() {
        int units = 123;
        int bill = 0;            // 100 units or less = no charge (same as the original code)

        if (units > 100) {
            if (units >= 200) {
                if (units > 300) {
                    bill = units * 8;
                } else {
                    bill = units * 6;
                }
            } else {
                bill = units * 5;
            }
        }

        System.out.println("CHENNAI ELECTRICITY LTD, CHENNAI");
        System.out.println("Units Consumed : " + units);
        System.out.println("Total Bill : " + bill);
    }

    // ============================================================
    //  7 - 8 : Armstrong numbers
    // ============================================================

    // FIX: the original only worked for 3-digit numbers (it cubed every digit) and had a
    //      pointless outer "for" loop that broke for numbers like 1.
    //      An Armstrong number = sum of each digit raised to the NUMBER OF DIGITS.
    static boolean isArmstrong(int n) {
        int digits = String.valueOf(n).length();
        int temp = n, sum = 0;
        while (temp > 0) {
            int r = temp % 10;
            sum = sum + (int) Math.pow(r, digits);
            temp = temp / 10;
        }
        return sum == n;
    }

    // 7. Java program to find Armstrong number
    static void armstrongCheck() {
        int n = 153;   // input value
        if (isArmstrong(n)) {
            System.out.println("Given number is armstrong number: " + n);
        } else {
            System.out.println("Given number is not armstrong number: " + n);
        }
    }

    // 8. Print Armstrong numbers between 1 to 1000
    static void armstrongRange() {
        int limit = 1000;
        System.out.print("Armstrong numbers from 1 to N:");
        for (int i = 1; i <= limit; i++) {
            if (isArmstrong(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    // ============================================================
    //  9 : Print given number in words
    // ============================================================

    // prints the words for n (0 - 99) followed by a unit word like " crore"
    static void pw(int n, String ch) {
        // FIX: " Fifteen" and " Seventy" were missing their leading space
        String[] one = {"", " One", " Two", " Three", " Four", " Five", " Six", " Seven",
                " Eight", " Nine", " Ten", " Eleven", " Twelve", " Thirteen", " Fourteen",
                " Fifteen", " Sixteen", " Seventeen", " Eighteen", " Nineteen"};
        String[] ten = {"", "", " Twenty", " Thirty", " Forty", " Fifty", " Sixty",
                " Seventy", " Eighty", " Ninety"};

        if (n > 19) {
            System.out.print(ten[n / 10] + one[n % 10]);
        } else {
            System.out.print(one[n]);
        }
        if (n > 0) System.out.print(ch);
    }

    static void numberToWords() {
        int n = 28;
        System.out.print(n + " =");
        if (n <= 0) {
            System.out.println(" Enter numbers greater than 0");
        } else {
            pw((n / 1000000000), " Hundred");
            pw((n / 10000000) % 100, " crore");
            pw(((n / 100000) % 100), " lakh");
            pw(((n / 1000) % 100), " thousand");
            pw(((n / 100) % 10), " hundred");
            pw((n % 100), "");
            System.out.println();
        }
    }

    // ============================================================
    //  10 - 12 : Palindrome numbers, prime numbers
    // ============================================================

    // 10. Check the given number is Palindrome or not
    static void palindromeCheck() {
        int n = 121, pal, r, rev = 0;
        pal = n;
        while (n > 0) {
            r = n % 10;
            rev = rev * 10 + r;
            n = n / 10;
        }
        if (rev == pal) {
            System.out.println("The given no is palindrome " + rev);
        } else {
            System.out.println("The given no is not palindrome " + rev);
        }
    }

    // 11. Print palindrome numbers up to N
    static void palindromeUptoN() {
        int n, b, rev = 0;
        int limit = 50;
        System.out.print("Palindrome numbers from 1 to N:");
        for (int i = 1; i <= limit; i++) {
            n = i;
            while (n > 0) {
                b = n % 10;
                rev = rev * 10 + b;
                n = n / 10;
            }
            if (rev == i) {
                System.out.print(i + " ");
            }
            rev = 0;
        }
        System.out.println();
    }

    // 12. Print prime numbers and find sum and average
    //     FIX: the title says "sum and average" but the original code never calculated them
    static void primeNumbers() {
        int num = 0, i = 0;
        int sum = 0, count = 0;
        System.out.println("Prime numbers from 1 to 100 are :");
        for (i = 1; i <= 100; i++) {
            int counter = 0;
            for (num = i; num >= 1; num--) {
                if (i % num == 0) {
                    counter = counter + 1;
                }
            }
            if (counter == 2) {           // a prime has exactly 2 divisors
                System.out.print(i + " ");
                sum = sum + i;
                count++;
            }
        }
        System.out.println();
        System.out.println("Count   = " + count);
        System.out.println("Sum     = " + sum);
        System.out.println("Average = " + (double) sum / count);
    }

    // ============================================================
    //  13 - 15 : Patterns of stars
    // ============================================================

    // 13.  *
    //      * *
    //      * * *
    //      * * * *
    //  FIX: the original used println("\n") which printed a blank line before every row
    static void pyramidPattern1() {
        int n = 4;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // 14. Centered star pyramid
    static void pyramidPattern2() {
        int i, j, k = 8;
        for (i = 0; i < 5; i++) {
            for (j = 0; j < k; j++) {
                System.out.print(" ");
            }
            k = k - 2;
            for (j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // 15. Butterfly pattern  (FIX: the original forgot  import java.util.Scanner)
    static void butterflyPattern() {
        int n, i, j, k, l, m, p, q;
        System.out.println("Enter the n values");
        n = sc.nextInt();
        p = n;
        q = n;
        for (i = n; i >= 1; i--) {
            for (j = 1; j <= i; j++) {
                System.out.print("*");
            }
            for (k = p * 2; k < n * 2 - 1; k++) {
                System.out.print(" ");
            }
            for (l = i; l != 0; l--) {
                if (l == n) {
                    continue;
                }
                System.out.print("*");
            }
            p--;
            System.out.println();
        }
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= i; j++) {
                System.out.print("*");
            }
            for (k = q * 2 - 2; k > 1; k--) {
                System.out.print(" ");
            }
            for (m = i; m != 0; m--) {
                if (m == n) {
                    continue;
                }
                System.out.print("*");
            }
            System.out.println();
            q--;
        }
    }

    // ============================================================
    //  16 - 22 : Patterns of numbers
    // ============================================================

    // 16. Floyd's triangle
    static void floydsTriangle() {
        System.out.println("Enter the number of rows");
        int rows = sc.nextInt();
        System.out.println("Floyd's Triangle Generated");
        int count = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(count + " ");
                count++;
            }
            System.out.println();
        }
    }

    // 17. Numbers in sequence  (3 4 7 / 7 5 12 / ...)
    static void numberSequence() {
        int a = 3;
        int b = 4;
        int n = 8;
        for (int i = 1; i <= n; i++) {
            int c = a + b;
            System.out.println(a + " " + b + " " + c);
            a = c;
            b = b + 1;
        }
    }

    // 18. 1 / 121 / 12321 / ...
    static void numberPyramidPrevRev() {
        int s = 1;
        int n;
        System.out.println("Enter the N values");
        n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            while (s <= i) {
                System.out.print(s);
                s++;
            }
            s--;
            while (s > 1) {
                System.out.print(--s);
            }
            System.out.println();
        }
    }

    // 19. 1 / 2 3 / 4 5 6 / ...
    static void numberPyramidUptoN() {
        int i, j, n = 1;
        for (i = 0; i < 5; i++) {
            for (j = 0; j <= i; j++) {
                System.out.print(n + " ");
                n++;
            }
            System.out.println();
        }
    }

    // 20. 1 / 1 2 / 1 2 3 / ...
    static void numberPyramid() {
        int i, j, n;
        System.out.println("Enter the Row value n");
        n = sc.nextInt();
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= i; j++)
                System.out.print(" " + j);
            System.out.print("\n");
        }
    }

    // 21. Growing then shrinking (arrow)
    static void numberPyramidArrow() {
        int i, j, n;
        System.out.println("Enter the values ");
        n = sc.nextInt();
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= i; j++)
                System.out.print(" " + j);
            System.out.print("\n");
        }
        for (i = n - 1; i >= 1; i--) {
            for (j = 1; j <= i; j++)
                System.out.print(" " + j);
            System.out.print("\n");
        }
    }

    // 22. 1 / 212 / 32123 / ...
    static void numberPyramidRev() {
        int i, j, k, n, a;
        System.out.println("Enter the n values");
        n = sc.nextInt();
        a = n;
        for (i = 1; i <= n; i++) {
            for (j = a; j > 1; j--) {
                System.out.print(" ");
            }
            for (k = i; k != 0; k--) {
                System.out.print(k);
            }
            a--;
            for (int l = 2; l <= i; l++) {
                System.out.print(l);
            }
            System.out.println();
        }
    }

    // ============================================================
    //  23 - 25 : More star patterns
    // ============================================================

    // 23. *****  /  ****  /  ***  /  **  /  *
    static void star1() {
        int i, j, t;
        System.out.println("How many row you want ");
        t = sc.nextInt();
        for (j = 0; j < t; j++) {
            for (i = t - 1; i >= j; i--) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    // 24. *  *  /  ** **  /  ******
    static void star3() {
        int i, j, k, n = 3;
        for (i = 0; i < n; i++) {
            for (j = 0; j <= i; j++) {
                System.out.print("*");
            }
            for (j = (n - i); j >= 2; j--) {
                System.out.print(" ");
            }
            for (k = i; k >= 0; k--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // 25. Diamond of stars
    static void star10() {
        int i, j, k;
        for (i = 1; i <= 5; i++) {
            for (j = i; j < 5; j++) {
                System.out.print(" ");
            }
            for (k = 1; k < (i * 2); k++) {
                System.out.print("*");
            }
            System.out.println("");
        }
        for (i = 4; i >= 1; i--) {
            for (j = 5; j > i; j--) {
                System.out.print(" ");
            }
            for (k = 1; k < (i * 2); k++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    // ============================================================
    //  26 - 33 : Arrays
    // ============================================================

    // 26. Largest number in an array
    static void largestNumber() {
        int[] a = new int[]{20, 30, 50, 4, 71, 100};
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        System.out.println("The Given Array Element is:");
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        System.out.println("From The Array Element Largest Number is:" + max);
    }

    // 27. Second largest number in an array
    //     FIX: the original started both values at arr[0], so it gave the WRONG answer
    //          when the first element was the biggest (e.g. {90, 10, 20}).
    static void secondLargest() {
        int[] arr = {14, 46, 47, 86, 92, 52, 48, 36, 66, 85};
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        System.out.println("The given array is:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i];
            }
        }
        System.out.println("\nSecond largest number is:" + secondLargest);
    }

    // 28. Largest and smallest number in an array
    static void largestSmallest() {
        int[] a = new int[]{23, 34, 13, 64, 72, 90, 10, 15, 9, 27};
        int min = a[0];   // assume first element as smallest number
        int max = a[0];   // assume first element as largest number
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
            if (a[i] < min) {
                min = a[i];
            }
        }
        System.out.println("Largest Number in a given array is : " + max);
        System.out.println("Smallest Number in a given array is : " + min);
    }

    // 29. Largest and second largest in an array
    //     FIX: starting at 0 fails for negative numbers, and a repeated biggest number
    //          would be counted again as the "second" largest.
    static void largestAndSecondLargest() {
        int[] nums = {5, 34, 78, 2, 45, 1, 99, 23};
        int maxOne = Integer.MIN_VALUE;
        int maxTwo = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (maxOne < nums[i]) {
                maxTwo = maxOne;
                maxOne = nums[i];
            } else if (maxTwo < nums[i] && nums[i] != maxOne) {
                maxTwo = nums[i];
            }
        }
        System.out.println("Largest Number: " + maxOne);
        System.out.println("Second Largest Number: " + maxTwo);
    }

    // 30. Index of the largest number in an array
    static void largestNumberIndex() {
        int[] a = new int[]{12, 44, 23, 56, 23, 78, 13};
        int max = a[0];
        int index = 0;
        for (int i = 0; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
                index = i;
            }
        }
        System.out.println("Index position of Maximum value in an array is : " + index);
    }

    // 31. Index of the smallest number in an array
    static void smallestNumberIndex() {
        int[] a = new int[]{12, 44, 23, 56, 9, 23, 78, 13};
        int min = a[0];
        int index = 0;
        for (int i = 0; i < a.length; i++) {
            if (min > a[i]) {
                min = a[i];
                index = i;
            }
        }
        System.out.println("Index position of Smallest value in a given array is : " + index);
    }

    // 32. Remove duplicate elements in an array
    //     NOTE: this method only works when the array is SORTED (like the sample).
    //     FIX: it now works on a copy, so the "Input Elements" line is not damaged.
    static int[] removeDuplicates(int[] original) {
        int[] input = original.clone();
        int j = 0;
        int i = 1;
        if (input.length < 2) {      // nothing to remove
            return input;
        }
        while (i < input.length) {
            if (input[i] == input[j]) {
                i++;
            } else {
                input[++j] = input[i++];
            }
        }
        int[] output = new int[j + 1];
        for (int k = 0; k < output.length; k++) {
            output[k] = input[k];
        }
        return output;
    }

    static void removeDuplicateElements() {
        int[] input1 = {2, 3, 6, 6, 8, 9, 10, 10, 10, 12, 12};
        int[] output = removeDuplicates(input1);
        System.out.print("Input Elements: \n");
        for (int i : input1) {
            System.out.print(i + " ");
        }
        System.out.print("\nOutput Elements: \n");
        for (int i : output) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // 33. Print odd and even numbers from an array
    static void oddEvenArray() {
        int s, i;
        int[] a = {33, 2, 4, 71, 88, 92, 9, 1};
        for (i = 0; i < a.length; i++) {          // sort the array (small to big)
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    s = a[i];
                    a[i] = a[j];
                    a[j] = s;
                }
            }
        }
        System.out.print("Input numbers :");
        for (i = 0; i < a.length; i++) {
            System.out.print(" " + a[i]);
        }
        System.out.print("\nOdd numbers :");
        for (i = 0; i <= a.length - 1; i++) {
            if (a[i] % 2 != 0) {
                System.out.print(" " + a[i]);
            }
        }
        System.out.print("\nEven numbers :");
        for (i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0) {
                System.out.print(" " + a[i]);
            }
        }
        System.out.println();
    }

    // ============================================================
    //  34 - 36 : Matrices
    // ============================================================

    // 34. Add two matrices
    static void matrixAddition() {
        int[][] a = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] b = new int[][]{{10, 11, 12}, {13, 14, 15}, {16, 17, 18}};
        int[][] c = new int[3][3];
        if (a.length == b.length && a[0].length == b[0].length) {
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[i].length; j++) {
                    c[i][j] = a[i][j] + b[i][j];
                }
            }
        } else {
            System.out.println("'A' and 'B' Matrix are not SAME");
            return;
        }
        System.out.println("The Matrix 'A' Value:");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("The Matrix 'B' Value:");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("The Addition Matrix of 'A' and 'B' Value:");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 35. Check if a matrix is a null matrix (all zeros)
    static void nullMatrix() {
        int[][] a = new int[][]{{0, 0, 0}, {0, 0, 1}, {0, 0, 0}};
        boolean setValue = true;
        abc:
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] != 0) {
                    setValue = false;
                    break abc;
                }
            }
        }
        System.out.println("The Given Matrix Value:");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        if (setValue) {
            System.out.println("The Given Matrix is a Null Matrix");
        } else {
            System.out.println("The Given Matrix is not a Null Matrix");
        }
    }

    // 36. Check if a matrix is a diagonal matrix
    static void diagonalMatrix() {
        int[][] a = new int[][]{{1, 0, 1}, {0, 3, 0}, {0, 0, 3}};
        boolean setValue = true;
        abc:
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (i == j) {
                    if (a[i][j] == 0) {
                        setValue = false;
                        break abc;
                    }
                } else if (a[i][j] != 0) {
                    setValue = false;
                    break abc;
                }
            }
        }
        System.out.println("The Given Matrix Value:");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        if (setValue) {
            System.out.println("The Given Matrix is a Diagonal Matrix");
        } else {
            System.out.println("The Given Matrix is not a Diagonal Matrix");
        }
    }

    // ============================================================
    //  37 - 38 : Searching
    // ============================================================

    // 37. Linear search
    //     FIX: the original called in.close(), which would also close the keyboard
    //          for every program after it. Removed.
    static void linearSearch() {
        int i, num, searchval, array[];
        System.out.println("Enter number of elements");
        num = sc.nextInt();
        array = new int[num];
        System.out.println("Enter " + num + " integers");
        for (i = 0; i < num; i++)
            array[i] = sc.nextInt();
        System.out.println("Enter the search value:");
        searchval = sc.nextInt();
        for (i = 0; i < num; i++) {
            if (array[i] == searchval) {
                System.out.println(searchval + " is present at location " + (i + 1));
                break;
            }
        }
        if (i == num)
            System.out.println(searchval + " is not exist in array.");
    }

    // 38. Binary search  (type the numbers from smallest to biggest!)
    static void binarySearch() {
        int counter, num, item, array[], first, last, middle;
        System.out.println("Enter number of elements:");
        num = sc.nextInt();
        array = new int[num];
        System.out.println("Enter " + num + " integers (smallest to biggest)");
        for (counter = 0; counter < num; counter++)
            array[counter] = sc.nextInt();
        System.out.println("Enter the search value:");
        item = sc.nextInt();
        first = 0;
        last = num - 1;
        middle = (first + last) / 2;
        while (first <= last) {
            if (array[middle] < item)
                first = middle + 1;
            else if (array[middle] == item) {
                System.out.println(item + " found at location " + (middle + 1) + ".");
                break;
            } else {
                last = middle - 1;
            }
            middle = (first + last) / 2;
        }
        if (first > last)
            System.out.println(item + " is not found.\n");
    }

    // ============================================================
    //  39 - 42 : Math programs
    // ============================================================

    // 39. HCF and LCM
    static void hcfLcm() {
        int a, b, x, y, t, hcf, lcm;
        x = 6;
        y = 10;
        a = x;
        b = y;
        while (b != 0) {
            t = b;
            b = a % b;
            a = t;
        }
        hcf = a;
        lcm = (x * y) / hcf;
        System.out.print("HCF and LCM of : " + x + " and " + y + " is :\n");
        System.out.print("HCF = " + hcf);
        System.out.print("\nLCM = " + lcm + "\n");
    }

    // 40. Volume of cube
    static void cubeVolume() {
        int side = 5;
        float volume = side * side * side;
        System.out.println("Volume of Cube :" + volume);
    }

    // 41. Reverse of a given number
    static void reverseNumber() {
        int rev = 0;
        int num = 1234;
        int no = num;
        while (num > 0) {
            int rem = num % 10;
            rev = rem + (rev * 10);
            num = num / 10;
        }
        System.out.println("Number = " + no);
        System.out.println("Reverse = " + rev);
    }

    // 42. Convert integer to Roman letters
    private static int[] bases = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static HashMap<Integer, String> map = new HashMap<Integer, String>();

    private static void romanSetup() {
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
    }

    static String intToRoman(int num) {
        romanSetup();
        String result = new String();
        for (int i : bases) {
            while (num >= i) {
                result += map.get(i);
                num -= i;
            }
        }
        return result;
    }

    static void integerToRoman() {
        System.out.println("Enter the number : ");
        int no = sc.nextInt();
        if (no < 1) {                               // FIX: Roman numerals start at 1
            System.out.println("Please enter a number of 1 or more.");
            return;
        }
        System.out.println(no + " ---> " + intToRoman(no));
    }

    // ============================================================
    //  43 - 57 : Strings
    // ============================================================

    // 43. Count number of words in a given string
    //     FIX: the original always started at 1, so an empty string or a string with
    //          spaces at the start gave a wrong count.
    static void wordCount() {
        String s = "welcome to candid java tutorial";
        String trimmed = s.trim();
        int count = 0;
        if (!trimmed.isEmpty()) {
            count = 1;
            for (int i = 0; i < trimmed.length() - 1; i++) {
                if ((trimmed.charAt(i) == ' ') && (trimmed.charAt(i + 1) != ' ')) {
                    count++;
                }
            }
        }
        System.out.println("Number of words in a string = " + count);
    }

    // 44. Count number of duplicate words in a given string
    //     FIX: the original compared strings with  !=  (which compares memory, not text).
    //          It now uses null to mark words already counted.
    static void duplicateWordCount() {
        String input = "Welcome to Java Session Session Session";
        String[] words = input.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i] == null) continue;       // already counted
            int wrc = 1;
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].equals(words[j])) {
                    wrc = wrc + 1;
                    words[j] = null;
                }
            }
            System.out.println(words[i] + "--" + wrc);
        }
    }

    // 45. Remove duplicate words in a given string
    static void removeDuplicateWords() {
        String input = "Welcome to Java Session Java Session Session Java";
        String[] words = input.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i] != null) {
                for (int j = i + 1; j < words.length; j++) {
                    if (words[i].equals(words[j])) {
                        words[j] = null;
                    }
                }
            }
        }
        for (int k = 0; k < words.length; k++) {
            if (words[k] != null) {
                System.out.println(words[k]);
            }
        }
    }

    // 46. Count each word and total number of words in a given string
    //     FIX: replaced  words[i] != ""  with  !words[i].isEmpty()  (correct way to compare text)
    static void countWords(String st) {
        String[] words = st.split("\\s");
        int[] fr = new int[words.length];
        for (int i = 0; i < fr.length; i++)
            fr[i] = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (words[i].equals(words[j])) {
                    fr[i]++;
                }
            }
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (words[i].equals(words[j])) {
                    if (i != j) {
                        words[i] = "";
                    }
                }
            }
        }
        int total = 0;
        System.out.println("Words and words count:");
        for (int i = 0; i < words.length; i++) {
            if (!words[i].isEmpty()) {
                System.out.println(words[i] + "=" + fr[i]);
                total += fr[i];
            }
        }
        System.out.println("Total words counted: " + total);
    }

    static void countEachWord() {
        countWords("apple banna apple fruit fruit apple hello hi hi hello hi");
    }

    // 47. Reverse the string and check whether it is a palindrome
    static void palindromeString() {
        String inpstr = "AMMA";
        char[] inpArray = inpstr.toCharArray();
        char[] revArray = new char[inpArray.length];
        int j = 0;
        for (int i = inpArray.length - 1; i >= 0; i--) {
            revArray[j] = inpArray[i];
            j++;
        }
        String revstr = String.valueOf(revArray);
        if (inpstr.equals(revstr)) {
            System.out.println("The given string is a Palindrome");
        } else {
            System.out.println("The given string is not a Palindrome");
        }
    }

    // 48. Delete vowels in a given string
    static void removeVowels() {
        String string = "Welcome to Candid Java Programming";
        System.out.println("Input String : " + string);
        string = string.replaceAll("[AaEeIiOoUu]", "");
        System.out.println(string);
    }

    // 49. Capitalize first letter of each word
    //     FIX: two spaces in a row (an empty word) made charAt(0) crash. Empty words are skipped.
    static void capitalizeWords() {
        String str = "welcome to candid java program";
        StringBuilder result = new StringBuilder(str.length());
        String[] words = str.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].isEmpty()) continue;
            result.append(Character.toUpperCase(words[i].charAt(0)))
                  .append(words[i].substring(1))
                  .append(" ");
        }
        System.out.println(result.toString().trim());
    }

    // 50. Split a comma-separated string
    static void commaSeparated() {
        String input = "Welcome,to,Java Session Session Session";
        String[] words = input.split(",");
        for (int k = 0; k < words.length; k++) {
            System.out.println(words[k]);
        }
    }

    // 51. Convert ASCII value to character
    static void asciiToCharacter() {
        char c;
        for (int i = 65; i <= 90; i++) {
            c = (char) i;
            System.out.println(i + " = " + c);
        }
    }

    // 52. Replace vowels with star
    static void vowelsWithStar() {
        String string = "Welcome to Candid Java Programming";   // Input String
        System.out.println("Input String : " + string);
        string = string.replaceAll("[AaEeIiOoUu]", "*");          // Replace vowels with star
        System.out.println(string);
    }

    // 53. Print character position count in a given string
    static void letterPositionCount() {
        String s = "CANDIDJAVA";
        char[] a = s.toCharArray();
        int i = 1;
        for (char output : a) {
            System.out.print(output + " " + i + " ");
            i++;
        }
        System.out.println();
    }

    // 54. Print reversed string by word in a given line
    static void reverseWord() {
        String input = "Welcome to Java Session";
        String[] words = input.split(" ");
        String[] revwords = new String[words.length];
        int j = 0;
        for (int i = words.length - 1; i >= 0; i--) {
            revwords[j] = words[i];
            System.out.print(revwords[j] + " ");
            j++;
        }
        System.out.println();
    }

    // 55. Returning a string as reverse text
    static void stringReverse() {
        String string = "Welcome to Java Programming and Dotnet Programming";
        String[] wordsCount = string.split(" ");
        System.out.println("The Given String is:\n" + string + "\n");
        System.out.println("After Reverse String is:");
        for (int i = wordsCount.length; i > 0; i--) {
            System.out.print(wordsCount[i - 1] + " ");
        }
        System.out.println();
    }

    // 56. Difference of minimum and maximum numbers of an array
    static class MinMaxInArray {
        int getMax(int[] inputArray) {
            int maxValue = inputArray[0];
            for (int i = 1; i < inputArray.length; i++) {
                if (inputArray[i] > maxValue) {
                    maxValue = inputArray[i];
                }
            }
            return maxValue;
        }

        int getMin(int[] inputArray) {
            int minValue = inputArray[0];
            for (int i = 1; i < inputArray.length; i++) {
                if (inputArray[i] < minValue) {
                    minValue = inputArray[i];
                }
            }
            return minValue;
        }
    }

    static void minMaxDifference() {
        int n;
        System.out.print("Enter number of elements you wants to enter :");
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter [" + (i + 1) + "] element :");
            arr[i] = sc.nextInt();
        }
        MinMaxInArray mm = new MinMaxInArray();
        System.out.println("Maximum value is :" + mm.getMax(arr));
        System.out.println("Minimum value is :" + mm.getMin(arr));
        int difference = mm.getMax(arr) - mm.getMin(arr);
        System.out.println("Difference between Minnimum and Maximum in array is : " + difference);
    }

    // 57. Count the occurrences of each character
    //     FIX: the original needed  import java.util.Scanner  and created a Scanner it never used.
    static final int MAX_CHAR = 256;

    static void getOccuringChar(String str) {
        int[] count = new int[MAX_CHAR];
        int len = str.length();
        for (int i = 0; i < len; i++)
            count[str.charAt(i)]++;
        char[] ch = new char[str.length()];
        for (int i = 0; i < len; i++) {
            ch[i] = str.charAt(i);
            int find = 0;
            for (int j = 0; j <= i; j++) {
                if (str.charAt(i) == ch[j])
                    find++;
            }
            if (find == 1)
                System.out.println("Number of Occurrence of " + str.charAt(i)
                        + " is:" + count[str.charAt(i)]);
        }
    }

    static void charOccurrences() {
        getOccuringChar("geeksforgeeks");
    }

    // ============================================================
    //  main: runs every program, one after the other
    // ============================================================
    public static void main(String[] args) {
        System.out.println("JAVA PROGRAMS PRACTICE (1 - 57)");

        title(1,  "Display odd numbers between 1 - 100");                  oddNumbers();
        title(2,  "Sum of odd numbers between 1 - 100");                   sumOddNumbers();
        title(3,  "Total number of odd numbers between 1 - 100");          countOddNumbers();
        title(4,  "Find sum of first n numbers");                          sumFirstN();
        title(5,  "Find the sum of the digits of a number");               sumOfDigits();
        title(6,  "Calculate electricity bill");                           electricBill();
        title(7,  "Find Armstrong number");                                armstrongCheck();
        title(8,  "Print Armstrong numbers between 1 to 1000");            armstrongRange();
        title(9,  "Print given number in words");                          numberToWords();
        title(10, "Check the given number is Palindrome or not");          palindromeCheck();
        title(11, "Print palindrome numbers up to N");                     palindromeUptoN();
        title(12, "Print prime numbers and find sum and average");         primeNumbers();
        title(13, "Star pattern: right triangle");                         pyramidPattern1();
        title(14, "Star pattern: pyramid");                                pyramidPattern2();
        title(15, "Star pattern: butterfly");                              butterflyPattern();
        title(16, "Floyd's triangle");                                     floydsTriangle();
        title(17, "Print numbers in sequence way");                        numberSequence();
        title(18, "Number pattern: 1 / 121 / 12321");                      numberPyramidPrevRev();
        title(19, "Number pattern: 1 / 2 3 / 4 5 6");                      numberPyramidUptoN();
        title(20, "Number pattern: 1 / 1 2 / 1 2 3");                      numberPyramid();
        title(21, "Number pattern: arrow");                                numberPyramidArrow();
        title(22, "Number pattern: 1 / 212 / 32123");                      numberPyramidRev();
        title(23, "Star pattern: inverted triangle");                      star1();
        title(24, "Star pattern: * * / ** ** / ******");                   star3();
        title(25, "Star pattern: diamond");                                star10();
        title(26, "Largest number in an array");                           largestNumber();
        title(27, "Second largest number in an array");                    secondLargest();
        title(28, "Largest and smallest number in an array");              largestSmallest();
        title(29, "Largest and second largest in an array");               largestAndSecondLargest();
        title(30, "Index of the largest number in an array");              largestNumberIndex();
        title(31, "Index of the smallest number in an array");             smallestNumberIndex();
        title(32, "Remove duplicate elements in an array");                removeDuplicateElements();
        title(33, "Print odd and even numbers from an array");             oddEvenArray();
        title(34, "Add two matrices");                                     matrixAddition();
        title(35, "Check if a matrix is a null matrix");                   nullMatrix();
        title(36, "Check if a matrix is a diagonal matrix");               diagonalMatrix();
        title(37, "Linear search");                                        linearSearch();
        title(38, "Binary search");                                        binarySearch();
        title(39, "Calculate HCF and LCM");                                hcfLcm();
        title(40, "Volume of cube");                                       cubeVolume();
        title(41, "Reverse of a given number");                            reverseNumber();
        title(42, "Convert integer to Roman letters");                     integerToRoman();
        title(43, "Count number of words in a string");                    wordCount();
        title(44, "Count number of duplicate words in a string");          duplicateWordCount();
        title(45, "Remove duplicate words in a string");                   removeDuplicateWords();
        title(46, "Count each word and total number of words");            countEachWord();
        title(47, "Reverse the string and check if it is a palindrome");   palindromeString();
        title(48, "Delete vowels in a string");                            removeVowels();
        title(49, "Capitalize first letter of each word");                 capitalizeWords();
        title(50, "Split a comma-separated string");                       commaSeparated();
        title(51, "Convert ASCII value to character");                     asciiToCharacter();
        title(52, "Replace vowels with star");                             vowelsWithStar();
        title(53, "Print character position count in a string");           letterPositionCount();
        title(54, "Print reversed string by word in a line");              reverseWord();
        title(55, "Returning a string as reverse text");                   stringReverse();
        title(56, "Difference of minimum and maximum numbers of an array");minMaxDifference();
        title(57, "Count the occurrences of each character");              charOccurrences();

        System.out.println("\nAll programs finished.");
    }
}