package com.example.project.Student;
import java.util.ArrayList;
import java.util.Arrays;

public class Utility {

    public static ArrayList<Student> sortStudents(ArrayList<Student> list) {
        for (int i = 0; i < list.size(); i++) {
            Student currentStudent = list.get(i);
            for (int j = 0; j < i; j++) {
                Student checkStudent = list.get(j);
                int lastNameCompare = currentStudent.getLastName().compareTo(checkStudent.getLastName());
                int firstNameCompare = currentStudent.getFirstName().compareTo(checkStudent.getFirstName());
                boolean higherGPA = currentStudent.getGpa() > checkStudent.getGpa();
                boolean move = false;
                if (lastNameCompare < 0) {
                    // Last name is before
                    move = true;
                } else if (lastNameCompare == 0 && firstNameCompare < 0) {
                    // Last name is same but first name is before
                    move = true;
                } else if (lastNameCompare == 0 && firstNameCompare == 0 && higherGPA) {
                    // Same full name but higher GPA
                    move = true;
                }
                if (move) {
                    list.remove(i);
                    list.add(j, currentStudent);
                    break;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Student s1 = new Student("Abby", "Smith", 96.7);
        Student s2 = new Student("Michelle", "Jones", 98.1);
        Student s3 = new Student("Chase", "Bean", 95.2);
        Student s4 = new Student("Jack", "Clancy", 97.3);
        Student s5 = new Student("Brittany", "Jones", 95.5);
        Student s6 = new Student("Lisa", "Frank", 92.4);
        Student s7 = new Student("Marie", "Angelina", 96.5);
        Student s8 = new Student("Peter", "Frank", 97.9);
        Student s9 = new Student("Lisa", "Frank", 99.5);
        Student s10 = new Student("Dean", "Jones", 93.2);

        ArrayList<Student> students = new ArrayList<Student>(Arrays.asList(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10));

        System.out.println(sortStudents(students));
    }
}
