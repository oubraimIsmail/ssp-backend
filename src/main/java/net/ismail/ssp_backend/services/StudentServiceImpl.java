package net.ismail.ssp_backend.services;

import lombok.RequiredArgsConstructor;
import net.ismail.ssp_backend.dtos.ParentDTO;
import net.ismail.ssp_backend.dtos.StudentDTO;
import net.ismail.ssp_backend.entities.Gate;
import net.ismail.ssp_backend.entities.Student;
import net.ismail.ssp_backend.entities.User;
import net.ismail.ssp_backend.mappers.StudentMapper;
import net.ismail.ssp_backend.repositories.GateRepository;
import net.ismail.ssp_backend.repositories.StudentRepository;
import net.ismail.ssp_backend.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final UserRepository userRepository;
    private final GateRepository gateRepository;
    private final StudentMapper studentMapper;
    private final UserService userService;

    @Override
    public StudentDTO createStudent(StudentDTO dto) {

        Student student = studentMapper.toEntity(dto);

        // Validate Parent
        if (dto.getParentId() != null) {
            User parent = userRepository.findById(dto.getParentId())
                    .orElseThrow(() -> new RuntimeException("Parent not found"));
            student.setParent(parent);
        }

        // Validate Gate
        if (dto.getGateId() != null) {
            Gate gate = gateRepository.findById(dto.getGateId())
                    .orElseThrow(() -> new RuntimeException("Gate not found"));
            student.setGate(gate);
        }

        Student saved = studentRepository.save(student);

        return studentMapper.toDTO(saved);
    }

    @Override
    public StudentDTO updateStudent(StudentDTO dto) {

        Student student = studentRepository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        student.setPhotoUrl(dto.getPhotoUrl());
        student.setClassName(dto.getClassName());

        // Update Parent
        if (dto.getParentId() != null) {
            User parent = userRepository.findById(dto.getParentId())
                    .orElseThrow(() -> new RuntimeException("Parent not found"));
            student.setParent(parent);
        } else {
            student.setParent(null);
        }

        // Update Gate
        if (dto.getGateId() != null) {
            Gate gate = gateRepository.findById(dto.getGateId())
                    .orElseThrow(() -> new RuntimeException("Gate not found"));
            student.setGate(gate);
        } else {
            student.setGate(null);
        }

        Student updated = studentRepository.save(student);

        return studentMapper.toDTO(updated);
    }

    @Override
    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new RuntimeException("Student not found");
        }
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDTO getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        return studentMapper.toDTO(student);
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ParentDTO getStudentsByParent(Long parentId) {
        List<StudentDTO> studentDTOList = studentRepository.findByParentId(parentId)
                .stream()
                .map(studentMapper::toDTO)
                .collect(Collectors.toList());
        ParentDTO parentDTO = new ParentDTO() ;
        parentDTO.setId(parentId);
        parentDTO.setName(userService.getUserById(parentId).getName());
        parentDTO.setStudentDTOList(studentDTOList);
        return parentDTO;
    }
}
