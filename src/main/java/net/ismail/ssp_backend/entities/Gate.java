package net.ismail.ssp_backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "gates")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Gate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String gateName;

    private String location;

    @JsonIgnore
    @OneToMany(mappedBy = "gate")
    private List<Student> students;

    @JsonIgnore
    @OneToMany(mappedBy = "gate")
    private List<PickupRequest> pickupRequests;

}
