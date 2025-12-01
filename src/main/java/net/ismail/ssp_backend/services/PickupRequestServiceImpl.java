package net.ismail.ssp_backend.services;

import lombok.RequiredArgsConstructor;
import net.ismail.ssp_backend.entities.Gate;
import net.ismail.ssp_backend.entities.PickupRequest;
import net.ismail.ssp_backend.entities.Student;
import net.ismail.ssp_backend.entities.User;
import net.ismail.ssp_backend.enums.Status;
import net.ismail.ssp_backend.repositories.GateRepository;
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
    private final GateRepository gateRepo;

    @Override
    public PickupRequest createRequest(Long parentId, Long studentId) {

        User parent = userRepo.findById(parentId)
                .orElseThrow(() -> new RuntimeException("Parent not found"));

        Student student = studentRepo.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Gate gate = student.getGate();

        PickupRequest req = new PickupRequest();
        req.setParent(parent);
        req.setStudent(student);
        req.setGate(gate);
        req.setStatus(Status.PENDING);
        req.setRequestTime(new Date());

        return pickupRepo.save(req);
    }

    @Override
    public List<PickupRequest> getRequestsByGate(Long gateId) {
        return pickupRepo.findByGateId(gateId);
    }
}

