package iniko.Voda.Repos;

import iniko.Voda.DTO.Payments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentsRepo extends JpaRepository<Payments,Integer> {
}
