import random
import math
import datetime

# --- Program 1: How to print "Hello World" on Python? ---
print("--- Program 1 ---")
print("Hello World")


# --- Program 2: How to print "Hello + Username" with the user's name on Python? ---
print("\n--- Program 2 ---")
usertext = input("What is your name? ")
print("Hello", usertext)


# --- Program 3: How to add 2 numbers entered on Python? ---
print("\n--- Program 3 ---")
num1 = input('Enter first number: ')
num2 = input('Enter second number: ')
sum_result = float(num1) + float(num2)
print('The sum of {0} and {1} is {2}'.format(num1, num2, sum_result))


# --- Program 4: How to find the Average of 2 Entered Numbers on Python? ---
# Correction: Added missing division by 2 to calculate the actual average
print("\n--- Program 4 ---")
num1 = input('Enter first number: ')
num2 = input('Enter second number: ')
average = (int(num1) + int(num2)) / 2
print('average: {0}'.format(average))


# --- Program 5: How to calculate the Entered Visa and Final Grade Average on Python? ---
print("\n--- Program 5 ---")
visagrade = input('enter your visa grade : ')
finalgrade = input('enter your final grade : ')
average = (float(visagrade) * 0.3) + (float(finalgrade) * 0.7)
print("average :{0} ".format(average))


# --- Program 6: How to find the Average of 3 Written Grades entered on Python? ---
print("\n--- Program 6 ---")
firstexam = input('your first exam : ')
secondexam = input('your second exam : ')
thirdexam = input('your third exam : ')
average = (float(firstexam) + float(secondexam) + float(thirdexam)) / 3
print("average :{0} ".format(average))


# --- Program 7: How to show the Class Pass Status (PASSED — FAILED) ---
print("\n--- Program 7 ---")
average = input('enter average : ')
if int(average) >= 50:
    print("Passed")
else:
    print("Failed")


# --- Program 8: How to find out if the entered number is odd or even on Python? ---
print("\n--- Program 8 ---")
num = int(input("Enter a number: "))
if (num % 2) == 0:
    print("{0} is Even".format(num))
else:
    print("{0} is Odd".format(num))


# --- Program 9: How to find out if the entered number is Positive, Negative, or 0? ---
print("\n--- Program 9 ---")
num = float(input("Enter a number: "))
if num > 0:
    print("Positive number")
elif num == 0:
    print("Zero")
else:
    print("Negative number")


# --- Program 10: How to calculate body mass index on Python? ---
# Correction: Changed non-standard Turkish char 'BMİ' to standard 'BMI'
print("\n--- Program 10 ---")
print("body mass index calculation program")
height = float(input("enter height (m):"))
weight = int(input("enter weight (kg):"))
index = weight / (height * height)
if index <= 18:
    print("\n underweight BMI:{}".format(index))
elif 18 < index <= 25:
    print("\n normal weight BMI:{}".format(index))
elif 25 < index <= 30:
    print("\n obese BMI:{}".format(index))
elif index > 30:
    print("\n severely obese BMI:{}".format(index))


# --- Program 11: How to show if the person whose age is entered can get a driver's license? ---
print("\n--- Program 11 ---")
age = input('enter age : ')
if int(age) < 18:
    print("Your Age Is Not Eligible To Get A Driver's License")
else:
    print("Your Age Is Eligible To Get Your License")


# --- Program 12: How to List Numbers 1–100 on the Screen on Python? ---
print("\n--- Program 12 ---")
for i in range(1, 101):
    print(i, end=" ")
print()


# --- Program 13: How to List Even Numbers 1–100 on Python? ---
print("\n--- Program 13 ---")
for i in range(1, 101):
    if i % 2 == 0:
        print(i, end=" ")
print()


# --- Program 14: How to List Odd Numbers from 1–100 on Python? ---
print("\n--- Program 14 ---")
for i in range(1, 101):
    if i % 2 != 0:
        print(i, end=" ")
print()


# --- Program 15: How to find numbers between 1 and 100 that are divided by 3 and 5 on Python? ---
# Correction: Changed 'or' to 'and' to fit the prompt requirement "divided by 3 AND 5"
print("\n--- Program 15 ---")
for i in range(1, 101):
    if i % 3 == 0 and i % 5 == 0:
        print(i, end=" ")
print()


# --- Program 16: How to list Numbers from 1 to User-Entered Number on Python? ---
print("\n--- Program 16 ---")
num = input('enter number : ')
for i in range(1, int(num) + 1):
    print(i, end=" ")
print()


# --- Program 17: How to find the Area and Perimeter of a Rectangle With Its Sides? ---
# Correction: Resolved undefined variables 'alan' and 'cevre' to English mappings
print("\n--- Program 17 ---")
short = input('Enter short side : ')
tall = input('Enter tall side : ')
area = int(short) * int(tall)
perimeter = 2 * (int(short) + int(tall))
print("area: {0}".format(area))
print("perimeter: {0}".format(perimeter))


# --- Program 18: How to print the letters of the entered text one under the other? ---
print("\n--- Program 18 ---")
word = 'mrhuseyin'
for char in word:
    print(char)


# --- Program 19: How to show the sum of numbers between two numbers the user has entered? ---
# Correction: Patched broken variables 'sayi1' and 'sayi2' to use correct names 'num1' and 'num2'
print("\n--- Program 19 ---")
sumofnumbers = 0
num1 = input('first number: ')
num2 = input('second number: ')
for i in range(int(num1) + 1, int(num2)):
    sumofnumbers += i
print("Sum of numbers between {0} and {1} : {2}".format(num1, num2, sumofnumbers))


# --- Program 20: Cinema/Theater pricing logic with student discount ---
print("\n--- Program 20 ---")
selection = input("Press (1) for Cinema, (2) for Theater : ")
student = input("Are you student(Y/N) : ")
price = 0
if selection == '1':
    price = 10 
elif selection == '2':
    price = 5 
if student == 'Y' or student == 'y':
    price = price / 2 
print(" The fee you have to pay :{}".format(price))


# --- Program 21: How to find out if the entered number is Prime or Not on Python? ---
print("\n--- Program 21 ---")
num = int(input("Enter a number: "))
if num > 1:
    for i in range(2, num):
        if (num % i) == 0:
            print(num, "is not a prime number")
            print(i, "times", num // i, "is", num)
            break
    else:
        print(num, "is a prime number")
else:
    print(num, "is not a prime number")


# --- Program 22: How to separately find the sum of odd and even numbers up to input? ---
print("\n--- Program 22 ---")
NumList = []
Even_Sum = 0
Odd_Sum = 0
Number = int(input("Please enter the Total Number of List Elements: "))
for i in range(1, Number + 1):
    value = int(input("Please enter the Value of %d Element : " % i))
    NumList.append(value)
for j in range(Number):
    if NumList[j] % 2 == 0:
        Even_Sum = Even_Sum + NumList[j]
    else:
        Odd_Sum = Odd_Sum + NumList[j]
print("\nThe Sum of Even Numbers in this List = ", Even_Sum)
print("The Sum of Odd Numbers in this List = ", Odd_Sum)


# --- Program 23: How to calculate the increased salary of the worker? ---
# Correction: Renamed keyword 'raise' to 'raise_rate' to prevent fatal SyntaxError
print("\n--- Program 23 ---")
newsalary = 0
salary = input("enter new salary : ")
raise_rate = input("salary raise rate(%) : ")
newsalary = int(salary) + (int(salary) * int(raise_rate) / 100)
print("increased salary :", newsalary)


# --- Program 24: How to calculate circle dimensions using math functions? ---
print("\n--- Program 24 ---")
def find_Diameter(radius):
    return 2 * radius
def find_Circumference(radius):
    return 2 * math.pi * radius
def find_Area(radius):
    return math.pi * radius * radius

r = float(input(' Please Enter the radius of a circle: '))
diameter = find_Diameter(r)
circumference = find_Circumference(r)
area = find_Area(r)
print("\n Diameter Of a Circle = %.2f" % diameter)
print(" Circumference Of a Circle = %.2f" % circumference)
print(" Area Of a Circle = %.2f" % area)


# --- Program 25: How to calculate the area of the rectangle using function? ---
print("\n--- Program 25 ---")
def areaRectangle(a, b):
    return a * b
def perimeterRectangle(a, b):
    return 2 * (a + b)

a = 5
b = 6
print("Area = ", areaRectangle(a, b))
print("Perimeter = ", perimeterRectangle(a, b))


# --- Program 26: Making a Number Guessing Game with Python ---
print("\n--- Program 26 ---")
lower = int(input("Enter Lower bound:- "))
upper = int(input("Enter Upper bound:- "))
x = random.randint(lower, upper)
chances = round(math.log(upper - lower + 1, 2))
print("\n\tYou've only ", chances, " chances to guess the integer!\n")
count = 0
while count < chances:
    count += 1
    guess = int(input("Guess a number:- "))
    if x == guess:
        print("Congratulations you did it in ", count, " try")
        break
    elif x > guess:
        print("You guessed too small!")
    elif x < guess:
        print("You Guessed too high!")
if count >= chances and x != guess:
    print("\nThe number is %d" % x)
    print("\tBetter Luck Next time!")


# --- Program 27: How to find out what day of the year a given date is on Python? ---
print("\n--- Program 27 ---")
date = str(input('Enter the date(for example:09 02 2019):'))
day_name = ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday']
day = datetime.datetime.strptime(date, '%d %m %Y').weekday()
print(day_name[day])


# --- Program 28: How to find missing numbers in a sorted list range on Python? ---
print("\n--- Program 28 ---")
def find_missing(lst):
    return [x for x in range(lst[0], lst[-1] + 1) if x not in lst]

lst = [1, 2, 4, 6, 7, 9, 10]
print("Missing numbers:", find_missing(lst))


# --- Program 29: How to check if there is a specified character in a string? ---
print("\n--- Program 29 ---")
char_list = ["a", "b", "c"]
string = "abcd"
matched_list = [characters in char_list for characters in string]
print("Matches:", matched_list)
string_contains_chars = all(matched_list)

# --- Program 30 ---
total = 0
evenSums = 0
evenCount = 0
oddSums = 0
oddCount = 0
done = False

while not done:
    user_in = input("Give me an integer or type 'done' to be done: ")
    if user_in.lower() == "done":
        done = True
    else:
        # Cast input string to int immediately to prevent TypeErrors
        num = int(user_in)
        total += num
        if num % 2 == 0:
            evenSums += num
            evenCount += 1
        else:
            oddSums += num
            oddCount += 1

# Safe guard with conditional statements to avoid fatal ZeroDivisionErrors
evenAverage = evenSums / evenCount if evenCount > 0 else 0
oddAverage = oddSums / oddCount if oddCount > 0 else 0

print("Total sum:", total)
print("Even Average: " + str(evenAverage))
print("Odd Average: " + str(oddAverage))
