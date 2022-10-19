package org.bhavya.practice;

/**
 * ===================Question===================
 * In a college, A student can be identified uniquely with combination of student's first and last name
 * and in a given stream a student can enroll to one or many subjects. Finally, during evaluations students are scored for each subjects
 *
 * E.g. In Physics Subject(See code below) Rahul, Sidd, Monica has scored 40, 50, 30 marks each.
 *
 *
 * We need to print the students in the descending order of their average marks across subjects.
 *
 * Expected output for students in code snippet should be as below:
 *
 * Student{firstName='Sidd', lastName='Bhatia', age=30, stream='Science', avgScore=50.0}
 * Student{firstName='Neha', lastName='Jain', age=33, stream='Science', avgScore=48.0}
 * Student{firstName='Vishal', lastName='Garg', age=24, stream='Commerce', avgScore=44.0}
 * Student{firstName='Abhishek', lastName='Kakkar', age=22, stream='Commerce', avgScore=43.0}
 * Student{firstName='Rahul', lastName='Garg', age=25, stream='Science', avgScore=43.0}
 * Student{firstName='Monica', lastName='Mishra', age=26, stream='Science', avgScore=41.333333333333336}
 *
 * Also, please note Evaluator will give some different input to the program and code should produce expected output for the same.
 *  ===========================Code snippet=================================
 */


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Data;

public class AvgMaxGrade {
  static Map<String, List<Student>> subjectToStudentsMap = new HashMap<>();

  static {
    subjectToStudentsMap.put("Physics", Arrays.asList(
        new Student("Rahul", "Garg", 25,"Science", 40),
        new Student("Sidd", "Bhatia", 30,"Science", 50),
        new Student("Monica", "Mishra", 26, "Science", 30)
    ));
    subjectToStudentsMap.put("Chemistry", Arrays.asList(
        new Student("Rahul", "Garg", 25,"Science", 46),
        new Student("Neha", "Jain", 33,"Science", 48),
        new Student("Monica", "Mishra", 26,"Science", 46)
    ));

    subjectToStudentsMap.put("Maths", Arrays.asList(
        new Student("Vishal", "Garg", 24,"Commerce", 44),
        new Student("Abhishek", "Kakkar",22, "Commerce", 43),
        new Student("Monica", "Mishra", 26,"Science", 48)
    ));
  }

  public static void main(String[] args) {
    //We need to print the students in the descending order of their average marks across subjects.
    Map<String, Student> stdMarks = new HashMap<>();
    subjectToStudentsMap.values()
        .forEach(students1 -> students1.forEach(student -> {
          stdMarks.computeIfPresent(student.getName(), (s, student1) -> {
            student1.setScore(student.getScore() + student1.score);
            student1.setSubjects(++student1.subjects);
            return student1;
          });
          stdMarks.putIfAbsent(student.getName(), student);
        }));

    stdMarks.values().stream().sorted((o1, o2) -> Double.compare(o2.getScore() / o2.subjects,
        o1.getScore() / o1.subjects)).forEach(System.out::println);
  }
}

@Data
class Student {
  String firstName;
  String lastName;
  double score;
  String stream;
  int subjects = 1;
  int age;

  public Student(String firstName, String lastName, int age, String stream, double score) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.score = score;
    this.age = age;
    this.stream = stream;
  }

  public String getName(){
    return this.firstName + this.lastName;
  }

  @Override
  public String toString() {
    var avg = this.score/this.subjects;
//    System.out.println(subjects);
    return "Student{firstName=" + this.firstName+
        " lastName=" + this.lastName+
        ", age=" +this.age +
        ", stream= "+this.stream +
        ", avgScore=" + avg+"}";
  }
}

