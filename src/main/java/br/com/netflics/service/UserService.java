/* generated by JSetup v0.95 :  at 1 de fev de 2023 23:43:21 */
package br.com.netflics.service;
import java.util.Optional;

import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;
import br.com.netflics.core.model.Tenant;
import br.com.netflics.model.User;
import br.com.netflics.model.filter.FilterUser;

import br.com.netflics.core.persistence.pagination.Pager;
import br.com.netflics.core.persistence.pagination.SearchParameters;

public interface UserService {

	
	public Optional<User> get(Integer id, Tenant tenant) ;

	public Pager<User> get(SearchParameters<FilterUser> searchParams, Tenant tenant) ;
	
	public Boolean delete(Integer id, Tenant tenant);

	public User save(User entity) ;

	public User update(User entity) ;

}
//generated by JSetup v0.95 :  at 1 de fev de 2023 23:43:21