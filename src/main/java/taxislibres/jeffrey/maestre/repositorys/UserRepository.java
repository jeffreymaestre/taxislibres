package taxislibres.jeffrey.maestre.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import taxislibres.jeffrey.maestre.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
