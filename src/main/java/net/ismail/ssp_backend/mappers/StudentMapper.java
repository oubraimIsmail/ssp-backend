package net.ismail.ssp_backend.mappers;

import net.ismail.ssp_backend.dtos.StudentDTO;
import net.ismail.ssp_backend.entities.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

    public StudentDTO toDTO(Student s) {
        if (s == null) return null;

        StudentDTO dto = new StudentDTO();
        dto.setId(s.getId());
        dto.setFirstName(s.getFirstName());
        dto.setLastName(s.getLastName());
        dto.setPhotoUrl(s.getPhotoUrl());
        dto.setClassName(s.getClassName());

        dto.setParentId(s.getParent() != null ? s.getParent().getId() : null);
        dto.setGateId(s.getGate() != null ? s.getGate().getId() : null);

        return dto;
    }

    public Student toEntity(StudentDTO dto) {
        if (dto == null) return null;

        Student s = new Student();
        s.setId(dto.getId());
        s.setFirstName(dto.getFirstName());
        s.setLastName(dto.getLastName());
        s.setPhotoUrl(dto.getPhotoUrl());
        s.setClassName(dto.getClassName());

        return s;
    }
}

