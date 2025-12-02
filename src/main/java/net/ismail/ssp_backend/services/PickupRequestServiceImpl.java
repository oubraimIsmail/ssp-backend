package net.ismail.ssp_backend.services;

import lombok.RequiredArgsConstructor;
import net.ismail.ssp_backend.dtos.PickupRequestDTO;
import net.ismail.ssp_backend.entities.Gate;
import net.ismail.ssp_backend.entities.PickupRequest;
import net.ismail.ssp_backend.entities.Student;
import net.ismail.ssp_backend.entities.User;
import net.ismail.ssp_backend.enums.Status;
import net.ismail.ssp_backend.mappers.PickupRequestMapper;
import net.ismail.ssp_backend.repositories.PickupRequestRepository;
import net.ismail.ssp_backend.repositories.StudentRepository;
import net.ismail.ssp_backend.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PickupRequestServiceImpl implements PickupRequestService {

    private final PickupRequestRepository pickupRepo;
    private final UserRepository userRepo;
    private final StudentRepository studentRepo;
    private final PickupRequestMapper pickupRequestMapper;

    @Override
    public PickupRequestDTO createRequest(Long parentId, Long studentId) {

        User parent = userRepo.findById(parentId)
                .orElseThrow(() -> new RuntimeException("Parent not found"));

        Student student = studentRepo.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Gate gate = student.getGate();
        if (gate == null) {
            throw new RuntimeException("This student has no gate assigned");
        }

        PickupRequest req = new PickupRequest();
        req.setParent(parent);
        req.setStudent(student);
        req.setGate(gate);
        req.setStatus(Status.PENDING);
        req.setRequestTime(new Date());

        PickupRequest saved = pickupRepo.save(req);

        return pickupRequestMapper.toDTO(saved);
    }

    @Override
    public List<PickupRequestDTO> getRequestsByGate(Long gateId) {
        return pickupRepo.findByGateId(gateId)
                .stream()
                .map(pickupRequestMapper::toDTO)
                .toList();
    }
}
