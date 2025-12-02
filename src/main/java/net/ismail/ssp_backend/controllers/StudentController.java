package net.ismail.ssp_backend.controllers;

import lombok.RequiredArgsConstructor;
import net.ismail.ssp_backend.dtos.ParentDTO;
import net.ismail.ssp_backend.dtos.StudentDTO;
import net.ismail.ssp_backend.services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public StudentDTO createStudent(@RequestBody StudentDTO dto) {
        return studentService.createStudent(dto);
    }

    @PutMapping("/{id}")
    public StudentDTO updateStudent(@PathVariable Long id, @RequestBody StudentDTO dto) {
        dto.setId(id);
        return studentService.updateStudent(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    @GetMapping("/{id}")
    public StudentDTO getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @GetMapping
    public List<StudentDTO> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/parent/{parentId}")
    public ParentDTO getStudentsByParent(@PathVariable Long parentId) {
        return studentService.getStudentsByParent(parentId);
    }


}
