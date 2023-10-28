package taxislibres.jeffrey.maestre.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import taxislibres.jeffrey.maestre.models.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
}
