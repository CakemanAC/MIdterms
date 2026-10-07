import sys

def read_int(prompt=""):
    while True:
        try:
            return int(input(prompt))
        except ValueError:
            print("Invalid input, enter a whole number: ", end="")

def read_double(prompt=""):
    while True:
        try:
            return float(input(prompt))
        except ValueError:
            print("Invalid input, enter a number: ", end="")

# ------------------------------------------------------------------
# PROGRAMS
# ------------------------------------------------------------------

def program1():
    """10 real numbers - positive sum/average, negative count, min"""
    print("Enter 10 real numbers (negative and positive):")
    nums = []
    for i in range(10):
        nums.append(read_double(f"Number {i+1}: "))

    # Loop 1: sum and average of positives
    sum_pos = 0
    positive_count = 0
    for n in nums:
        if n > 0:
            sum_pos += n
            positive_count += 1

    if positive_count > 0:
        print(f"Sum of positive numbers: {sum_pos}")
        print(f"Average of positive numbers: {sum_pos / positive_count}")
    else:
        print("There are no positive numbers.")

    # Loop 2: count negatives
    negative_count = sum(1 for n in nums if n < 0)
    print(f"Count of negative numbers: {negative_count}")

    # Loop 3: minimum value
    minimum = nums[0]
    for n in nums[1:]:
        if n < minimum:
            minimum = n
    print(f"Minimum value: {minimum}")


def program2():
    """8 integers - remove duplicates, 2nd largest, 2nd smallest"""
    print("Enter 8 integers:")
    arr = []
    for i in range(8):
        arr.append(read_int(f"Integer {i+1}: "))

    # Remove duplicates (keeps first occurrence, preserves order)
    unique = []
    for value in arr:
        if value not in unique:
            unique.append(value)
            
    print("Array without duplicates:", " ".join(map(str, unique)))

    if len(unique) < 2:
        print("Not enough distinct elements for second largest/smallest.")
        return

    # Sort to find 2nd largest and 2nd smallest easily
    sorted_unique = sorted(unique)
    print(f"Second largest element: {sorted_unique[-2]}")
    print(f"Second smallest element: {sorted_unique[1]}")


def program3():
    """Delete an element from a specific position"""
    arr = [0] * 5
    print("Enter 5 values for the array:")
    for i in range(5):
        arr[i] = read_int(f"Value {i+1}: ")

    print("Stored data in array:", " ".join(map(str, arr)))
    pos = read_int("Enter position (index 0-4) of element to delete: ")

    if pos < 0 or pos >= len(arr):
        print("Invalid position!")
        return

    arr.pop(pos)
    print("New data in array:", " ".join(map(str, arr)))


def program4():
    """Even and odd elements"""
    n = read_int("Enter size of array: ")
    if n <= 0:
        print("Size must be at least 1.")
        return
        
    print(f"Enter {n} elements:")
    arr = []
    for i in range(n):
        arr.append(read_int(f"Element {i+1}: "))

    # Evens in input order
    evens = [str(v) for v in arr if v % 2 == 0]
    print("Even elements:", " ".join(evens))

    # Odds printed from the end (reversed)
    odds = [str(arr[i]) for i in range(n - 1, -1, -1) if arr[i] % 2 != 0]
    print("Odd elements:", " ".join(odds))


def program5():
    """Print the * A * pattern"""
    rows = 4
    for i in range(1, rows + 1):
        row_str = "*" + "A*" * (i - 1)
        print(row_str)


def program6():
    """Evaluate the net salary of an employee given constraints from the photo"""
    print("--- Employee Net Salary Evaluation ---")
    
    # Given Constraints
    basic_salary = 12000.0
    da = 0.12 * basic_salary
    hra = 150.0
    ta = 120.0
    others = 450.0
    
    # Tax cuts
    pf = 0.14 * basic_salary
    it = 0.15 * basic_salary
    
    # Net Salary formula
    net_salary = (basic_salary + da + hra + ta + others) - (pf + it)
    
    # Display calculation breakdown
    print(f"Basic Salary : ${basic_salary:,.2f}")
    print(f"DA (12%)     : ${da:,.2f}")
    print(f"HRA          : ${hra:,.2f}")
    print(f"TA           : ${ta:,.2f}")
    print(f"Others       : ${others:,.2f}")
    print(f"PF Cut (14%) : ${pf:,.2f}")
    print(f"IT Cut (15%) : ${it:,.2f}")
    print("-" * 38)
    print(f"Net Salary   : ${net_salary:,.2f}")


# ------------------------------------------------------------------
# MAIN MENU LOOP
# ------------------------------------------------------------------
def main():
    titles = [
        "Positive sum/average, negative count, minimum",
        "Remove duplicates, 2nd largest/smallest",
        "Delete an element from an array",
        "Even and odd elements",
        "Print the * A * pattern",
        "Employee Net Salary Evaluation"
    ]

    while True:
        print("\nChoose the program you want to run:")
        for i, title in enumerate(titles):
            print(f"  {i + 1}. {title}")
        
        choice = read_int("Your choice: ")
        print()

        if choice == 1:
            program1()
        elif choice == 2:
            program2()
        elif choice == 3:
            program3()
        elif choice == 4:
            program4()
        elif choice == 5:
            program5()
        elif choice == 6:
            program6()
        else:
            print("Invalid choice. Pick 1-6.")

        while True:
            again = input("\nDo you want to continue? Y/N: ").strip().upper()
            if again in ("Y", "N"):
                break
        
        if again == "N":
            print("Goodbye!")
            break

if __name__ == "__main__":
    main()
