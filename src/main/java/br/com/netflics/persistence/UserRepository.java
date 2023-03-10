/* generated by JSetup v0.95 :  at 1 de fev de 2023 23:43:20 */
package br.com.netflics.persistence;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import br.com.netflics.model.User;

public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {
	Optional<User> findByUsername(String username);
}