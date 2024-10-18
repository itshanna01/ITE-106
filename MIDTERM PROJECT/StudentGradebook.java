# 1. Array Storage
names = []
grades = []

# 2. Input
num_students = int(input("Enter the number of students: "))

for i in range(num_students):
    name = input(f"Enter the name of student {i + 1}: ")
    names.append(name)
    
    # Input grades for multiple assignments
    num_assignments = int(input(f"Enter the number of assignments for {name}: "))
    student_grades = []
    for j in range(num_assignments):
        grade = float(input(f"Enter grade for assignment {j + 1}: "))
        student_grades.append(grade)
    
    grades.append(student_grades)

# 3. Calculation
averages = []
letter_grades = []

for student_grades in grades:
    average = sum(student_grades) / len(student_grades)
    averages.append(average)

    # Assign letter grades
    if average >= 90:
        letter_grades.append('A')
    elif average >= 80:
        letter_grades.append('B')
    elif average >= 70:
        letter_grades.append('C')
    elif average >= 60:
        letter_grades.append('D')
    else:
        letter_grades.append('F')

# 4. Output
print(f"{'Student Name':<20}{'Grades':<30}{'Average':<10}{'Letter Grade':<15}")
print('-' * 75)

for i in range(num_students):
    grades_str = ', '.join(map(str, grades[i]))
    print(f"{names[i]:<20}{grades_str:<30}{averages[i]:<10.2f}{letter_grades[i]:<15}")

# 5. Array Manipulation
# Find highest and lowest average scores
highest_avg = max(averages)
lowest_avg = min(averages)

# Sorting students by average score (Bubble Sort)
for i in range(num_students):
    for j in range(0, num_students - i - 1):
        if averages[j] < averages[j + 1]:  # Sort in descending order
            # Swap averages
            averages[j], averages[j + 1] = averages[j + 1], averages[j]
            # Swap names
            names[j], names[j + 1] = names[j + 1], names[j]
            # Swap grades
            grades[j], grades[j + 1] = grades[j + 1], grades[j]

# Display highest and lowest averages
print(f"\nHighest average: {highest_avg:.2f}")
print(f"Lowest average: {lowest_avg:.2f}")

# Display sorted results
print("\nSorted Results by Average Score:")
print(f"{'Student Name':<20}{'Average':<10}{'Letter Grade':<15}")
for i in range(num_students):
    print(f"{names[i]:<20}{averages[i]:<10.2f}{letter_grades[i]:<15}")
