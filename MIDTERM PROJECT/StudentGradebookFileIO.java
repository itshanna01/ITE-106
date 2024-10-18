import os

def read_student_data(filename):
    """Reads student data from a file and returns a list of parsed student records."""
    students = []
    try:
        with open(filename, 'r') as file:
            for line in file:
                # Strip whitespace and split the line by commas
                line = line.strip()
                if line:  # Ensure line is not empty
                    parts = line.split(',')
                    if len(parts) < 6:  # Check if there are enough parts
                        print(f"Skipping invalid line: {line}")
                        continue
                    # Trim spaces and store in a tuple
                    name = parts[0].strip()
                    scores = [float(score.strip()) for score in parts[1:]]
                    students.append((name, scores))
    except FileNotFoundError:
        print(f"File {filename} not found.")
    except Exception as e:
        print(f"An error occurred: {e}")
    return students

def calculate_average_and_grade(students):
    """Calculates average scores and assigns grades for each student."""
    results = []
    for name, scores in students:
        if len(scores) == 5:  # Ensure there are 5 scores
            average = sum(scores) / len(scores)
            grade = assign_grade(average)
            results.append((name, scores, average, grade))
        else:
            print(f"Invalid scores for {name}. Expected 5 scores but got {len(scores)}.")
    return results

def assign_grade(average):
    """Assigns a letter grade based on the average score."""
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

def format_name(name):
    """Formats the name from 'First Last' to 'Last, First'."""
    parts = name.split()
    if len(parts) >= 2:
        return f"{parts[-1]}, {' '.join(parts[:-1])}"
    return name  # Return as is if format is unexpected

def write_results_to_file(results, output_filename):
    """Writes the processed student results to an output file."""
    with open(output_filename, 'w') as file:
        file.write(f"{'Name':<20} {'Quiz 1':<10} {'Quiz 2':<10} {'Homework':<10} {'Midterm':<10} {'Final':<10} {'Average':<10} {'Grade':<5}\n")
        file.write('-' * 80 + '\n')
        for name, scores, average, grade in results:
            formatted_name = format_name(name)
            file.write(f"{formatted_name:<20} {scores[0]:<10} {scores[1]:<10} {scores[2]:<10} {scores[3]:<10} {scores[4]:<10} {average:<10.2f} {grade:<5}\n")

def main():
    input_filename = 'student_data.txt'
    output_filename = 'student_grades.txt'
    
    students = read_student_data(input_filename)
    results = calculate_average_and_grade(students)
    write_results_to_file(results, output_filename)
    print(f"Processed data has been written to {output_filename}")

if _name_ == "_main_":
    main()
