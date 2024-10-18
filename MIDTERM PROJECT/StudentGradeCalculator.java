def get_valid_score(prompt):
    while True:
        try:
            score = float(input(prompt))
            if 0 <= score <= 100:
                return score
            else:
                print("Please enter a score between 0 and 100.")
        except ValueError:
            print("Invalid input. Please enter a numeric value.")

def calculate_letter_grade(average):
    if average >= 90:
        return 'A'
    elif average >= 80:
        return 'B'
    elif average >= 70:
        return 'C'
    elif average >= 60:
        return 'D'
    else:
        return 'F'

def main():
    num_students = int(input("Enter the number of students in the class: "))
    students = []
    total_average = 0
    highest_score = float('-inf')
    lowest_score = float('inf')

    for _ in range(num_students):
        name = input("\nEnter the student's name: ")
        num_assignments = int(input("Enter the number of assignments: "))
        
        scores = []
        for i in range(num_assignments):
            score = get_valid_score(f"Enter score for assignment {i + 1}: ")
            scores.append(score)

        average_score = sum(scores) / num_assignments
        letter_grade = calculate_letter_grade(average_score)
        
        students.append((name, average_score, letter_grade))
        
        total_average += average_score
        highest_score = max(highest_score, average_score)
        lowest_score = min(lowest_score, average_score)

    print("\nStudent Report:")
    for student in students:
        print(f"Name: {student[0]}, Average Score: {student[1]:.2f}, Letter Grade: {student[2]}")

    class_average = total_average / num_students if num_students > 0 else 0
    print(f"\nClass Average Score: {class_average:.2f}")
    print(f"Highest Average Score: {highest_score:.2f}")
    print(f"Lowest Average Score: {lowest_score:.2f}")

if __name__ == "__main__":
    main()
