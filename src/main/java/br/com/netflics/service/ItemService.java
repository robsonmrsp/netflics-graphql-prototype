/* generated by JSetup v0.95 :  at 1 de fev de 2023 23:43:21 */
package br.com.netflics.service;
import java.util.Optional;

import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;
import br.com.netflics.core.model.Tenant;
import br.com.netflics.model.Item;
import br.com.netflics.model.filter.FilterItem;

import br.com.netflics.core.persistence.pagination.Pager;
import br.com.netflics.core.persistence.pagination.SearchParameters;

public interface ItemService {

	
	public Optional<Item> get(Integer id) ;

	public Pager<Item> get(SearchParameters<FilterItem> searchParams) ;
	
	public Boolean delete(Integer id);

	public Item save(Item entity) ;

	public Item update(Item entity) ;

}
//generated by JSetup v0.95 :  at 1 de fev de 2023 23:43:21