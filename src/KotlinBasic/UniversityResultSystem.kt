package Assignment1
/*
"University Result System:
Every course in university has course name and n number of subjects.
Every subject has names, max marks, minimum passing marks.
Student enrolls for some course.
At the time of enrollment user has to provide his details
such as Name, Mobile Number, Date of Birth, address. After completion of course
student has to appear for exam. Student is considered passed for particular subject
if he/she scores marks greater than minimum passing marks in each subject.
Student has to pass every subject to complete the course.
University inputs details of n students about their course,
marks obtained in each subject and calculates their total marks and percentage.
At the end list of all the students result is displayed in the descending order of their percentage.
Write a program to simulate University Result System.
Provide option to sort result alphabetically by student name,
ascending or descending order of percentage.
Create appropriate classes with appropriate properties/data members, functions"
 */
data class Course(val name: String)
data class Subject(val name: String, val maxMark: Int, val passingMark: Int)
data class Student(val name: String, val mobileNumber: String, val dOF: String, val address: String)
class University(val numberOfNumber: Int) {
    val students = Array<Student?> (numberOfNumber) { null }

}
