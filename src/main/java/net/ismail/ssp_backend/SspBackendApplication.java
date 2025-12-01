package net.ismail.ssp_backend;

import net.ismail.ssp_backend.entities.Gate;
import net.ismail.ssp_backend.entities.PickupRequest;
import net.ismail.ssp_backend.entities.Student;
import net.ismail.ssp_backend.entities.User;
import net.ismail.ssp_backend.enums.Role;
import net.ismail.ssp_backend.enums.Status;
import net.ismail.ssp_backend.repositories.GateRepository;
import net.ismail.ssp_backend.repositories.PickupRequestRepository;
import net.ismail.ssp_backend.repositories.StudentRepository;
import net.ismail.ssp_backend.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class SspBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SspBackendApplication.class, args);
	}


    //@Bean
    CommandLineRunner initDatabase(UserRepository userRepository, GateRepository gateRepository,
            StudentRepository studentRepository, PickupRequestRepository pickupRequestRepository
    ){
         return args -> {

            // -----------------------
            // 1. Create Admin User
            // -----------------------
            User admin = new User();
            admin.setName("Admin System");
            admin.setEmail("admin@ssp.com");
            admin.setPassword("admin123"); // TODO: hash later
            admin.setPhone("0000000000");
            admin.setRole(Role.ADMIN);
            userRepository.save(admin);

            // -----------------------
            // 2. Create Parents
            // -----------------------
            User parent1 = new User();
            parent1.setName("Parent Ahmed");
            parent1.setEmail("ahmed.parent@example.com");
            parent1.setPassword("123456");
            parent1.setPhone("0611223344");
            parent1.setRole(Role.PARENT);
            userRepository.save(parent1);

            User parent2 = new User();
            parent2.setName("Parent Fatima");
            parent2.setEmail("fatima.parent@example.com");
            parent2.setPassword("123456");
            parent2.setPhone("0622334455");
            parent2.setRole(Role.PARENT);
            userRepository.save(parent2);

            // -----------------------
            // 3. Create Gates
            // -----------------------
            Gate gate1 = new Gate();
            gate1.setGateName("Gate A");
            gate1.setLocation("Entrée Primaire");
            gateRepository.save(gate1);

            Gate gate2 = new Gate();
            gate2.setGateName("Gate B");
            gate2.setLocation("Entrée Collège");
            gateRepository.save(gate2);

            // -----------------------
            // 4. Create Students
            // -----------------------
            Student s1 = new Student();
            s1.setFirstName("Yassine");
            s1.setLastName("El Amrani");
            s1.setClassName("CP-A");
            s1.setPhotoUrl("yassine.jpg");
            s1.setParent(parent1);
            s1.setGate(gate1);
            studentRepository.save(s1);

            Student s2 = new Student();
            s2.setFirstName("Sara");
            s2.setLastName("Ben Ali");
            s2.setClassName("CP-A");
            s2.setPhotoUrl("sara.jpg");
            s2.setParent(parent1);
            s2.setGate(gate1);
            studentRepository.save(s2);

            Student s3 = new Student();
            s3.setFirstName("Adam");
            s3.setLastName("Malki");
            s3.setClassName("CE1-B");
            s3.setPhotoUrl("adam.jpg");
            s3.setParent(parent2);
            s3.setGate(gate2);
            studentRepository.save(s3);

            // -----------------------
            // 5. Create Pickup Requests
            // -----------------------
            PickupRequest pr1 = new PickupRequest();
            pr1.setStudent(s1);
            pr1.setParent(parent1);
            pr1.setGate(gate1);
            pr1.setStatus(Status.PENDING);
            pr1.setRequestTime(new Date());
            pickupRequestRepository.save(pr1);

            PickupRequest pr2 = new PickupRequest();
            pr2.setStudent(s3);
            pr2.setParent(parent2);
            pr2.setGate(gate2);
            pr2.setStatus(Status.PENDING);
            pr2.setRequestTime(new Date());
            pickupRequestRepository.save(pr2);

            System.out.println("✔ Base de données initialisée avec succès !");
        };
    }
}
