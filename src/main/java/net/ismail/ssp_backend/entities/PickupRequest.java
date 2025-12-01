package net.ismail.ssp_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.ismail.ssp_backend.enums.Status;
import java.util.Date;


@Entity
@Table(name = "pickup_requests")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PickupRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date requestTime;

    @Enumerated(EnumType.STRING)
    private Status status; // PENDING, DONE, CANCELLED

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "gate_id")
    private Gate gate;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private User parent;


}

