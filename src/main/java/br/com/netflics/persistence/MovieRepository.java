/* generated by JSetup v0.95 :  at 1 de fev de 2023 23:43:21 */
package br.com.netflics.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import br.com.netflics.model.Movie;
	
public interface MovieRepository extends JpaRepository<Movie, Integer> ,JpaSpecificationExecutor<Movie>{

}

//generated by JSetup v0.95 :  at 1 de fev de 2023 23:43:21