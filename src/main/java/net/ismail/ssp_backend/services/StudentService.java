package net.ismail.ssp_backend.services;

import net.ismail.ssp_backend.entities.Student;

import java.util.List;

public interface StudentService {

    Student createStudent(Student student);
    Student updateStudent(Long id, Student student);

    void deleteStudent(Long id);

    Student getStudentById(Long id);
    List<Student> getAllStudents();
    List<Student> getStudentsByParent(Long parentId);




}
