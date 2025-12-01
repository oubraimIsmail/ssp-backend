package net.ismail.ssp_backend.services;

import lombok.RequiredArgsConstructor;
import net.ismail.ssp_backend.entities.Student;
import net.ismail.ssp_backend.repositories.GateRepository;
import net.ismail.ssp_backend.repositories.StudentRepository;
import net.ismail.ssp_backend.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final UserRepository userRepository;
    private final GateRepository gateRepository;

    @Override
    public Student createStudent(Student student) {
        // Validate parent
        if (student.getParent() != null) {
            userRepository.findById(student.getParent().getId())
                    .orElseThrow(() -> new RuntimeException("Parent not found"));
        }

        // Validate gate
        if (student.getGate() != null) {
            gateRepository.findById(student.getGate().getId())
                    .orElseThrow(() -> new RuntimeException("Gate not found"));
        }

        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Long id, Student newStudent) {
        Student existing = getStudentById(id);

        existing.setFirstName(newStudent.getFirstName());
        existing.setLastName(newStudent.getLastName());
        existing.setPhotoUrl(newStudent.getPhotoUrl());
        existing.setClassName(newStudent.getClassName());
        existing.setParent(newStudent.getParent());
        existing.setGate(newStudent.getGate());

        return studentRepository.save(existing);
    }

    @Override
    public void deleteStudent(Long id) {
        if (getStudentById(id) == null)
            throw new RuntimeException("Student not found");

        studentRepository.deleteById(id);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> getStudentsByParent(Long parentId) {
        return studentRepository.findByParentId(parentId);
    }

}

