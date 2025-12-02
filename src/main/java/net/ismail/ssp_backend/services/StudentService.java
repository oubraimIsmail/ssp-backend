package net.ismail.ssp_backend.services;

import net.ismail.ssp_backend.dtos.ParentDTO;
import net.ismail.ssp_backend.dtos.StudentDTO;
import java.util.List;

public interface StudentService {

    StudentDTO createStudent(StudentDTO dto);

    StudentDTO updateStudent(StudentDTO dto);

    void deleteStudent(Long id);

    StudentDTO getStudentById(Long id);

    List<StudentDTO> getAllStudents();

    ParentDTO getStudentsByParent(Long parentId);
}
