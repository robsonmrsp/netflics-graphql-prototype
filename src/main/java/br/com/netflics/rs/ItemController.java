/*  generated by JSetup v0.95 :  at 1 de fev de 2023 23:43:21 */
package br.com.netflics.rs;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.MediaType.*;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import br.com.netflics.core.json.JsonError;
import br.com.netflics.core.json.JsonPaginator;
import br.com.netflics.json.JsonItem;

import br.com.netflics.model.Item;

import br.com.netflics.service.ItemService;
import br.com.netflics.model.filter.FilterItem;
import br.com.netflics.core.persistence.pagination.Pager;
import br.com.netflics.core.persistence.pagination.SearchParameters;
import br.com.netflics.core.rs.exception.ValidationException;
import br.com.netflics.core.security.SpringSecurityUserContext;

import br.com.netflics.utils.Parser;
@RestController
@RequestMapping("/rs/crud/items")
@SuppressWarnings({ "unchecked", "rawtypes" })
public class ItemController {
	@Autowired
	ItemService itemService;
	public static final Logger LOGGER = LoggerFactory.getLogger(ItemController.class);

	@RequestMapping(method = GET, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity get(@RequestParam MultiValueMap<String, String> mapParams) {
		ResponseEntity response = null;

		Pager<Item> items = null;
		try {
			SearchParameters<FilterItem> paginationParams = new SearchParameters<FilterItem>(mapParams, FilterItem.class);

			items = itemService.get(paginationParams);
			
			JsonPaginator<JsonItem> paginator = JsonPaginator.of(Parser.toListJsonItems(items.getItems()),
				 items.getActualPage(), items.getPageSize(), items.getOrder(), items.getOrderBy(),items.getTotalRecords());

			response = ResponseEntity.ok(paginator);

		} catch (Exception e) {
			String message = String.format("Não foi possivel carregar items para os parametros %s [%s]", mapParams.toString(), e.getMessage());
			LOGGER.error(message, e);
			response = ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new JsonError(e, message, null));
		}
		return response;
	}
	
	@RequestMapping(value = "{id:\\d+}", method = GET, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity get(@PathVariable("id") int id) {
		try {
			Optional<Item> optional = itemService.get(id);
			
			if (optional.isPresent()) {
				return ResponseEntity.ok(Parser.toJson(optional.get()));
			}

			return ResponseEntity.notFound().build();

		} catch (Exception e) {
			String message = String.format("Não foi possivel carregar o registro. [ %s ] parametros [ %d ]", e.getMessage(), id);
			LOGGER.error(message, e);
			return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new JsonError(e, message, null));
		}
	}

	@RequestMapping(method = POST, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity save(@RequestBody JsonItem jsonItem) {
		try {
			Item item = Parser.toEntity(jsonItem);

			item = itemService.save(item);

			return ResponseEntity.status(CREATED).body(Parser.toJson(item));

		} catch (ValidationException e) {
			String message = String.format("Não foi possivel salvar  o registro [ %s ] parametros [ %s ]", e.getOrigem().getMessage(), jsonItem.toString());
			LOGGER.error(message, e.getOrigem());
			return ResponseEntity.status(BAD_REQUEST).body(new JsonError(e, message, jsonItem, e.getLegalMessage()));
		} catch (Exception e) {
			String message = String.format("Não foi possivel salvar  item [ %s ] parametros [ %s ]", e.getMessage(), jsonItem.toString());
			LOGGER.error(message, e);
			return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new JsonError(e, message, jsonItem));

		}
	}

	@RequestMapping(value = "{id:\\d+}", method = PUT, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity update(@PathVariable("id") Integer id, @RequestBody JsonItem jsonItem) {
		try {
			Item item = Parser.toEntity(jsonItem);

			item = itemService.update(item);

			return ResponseEntity.ok(Parser.toJson(item));
		} catch (ValidationException e) {
			String message = String.format("Não foi possivel salvar  o registro [ %s ] parametros [ %s ]", e.getOrigem().getMessage(), jsonItem.toString());
			LOGGER.error(message, e.getOrigem());
			return ResponseEntity.status(BAD_REQUEST).body(new JsonError(e, message, jsonItem, e.getLegalMessage()));
		} catch (Exception e) {
			String message = String.format("Não foi possivel salvar o registro [ %s ] parametros [ %s ]", e.getMessage(), jsonItem.toString());
			LOGGER.error(message, e);
			return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new JsonError(e, message, jsonItem));
		}
	}
	
	@RequestMapping(value = "{id:\\d+}", method = DELETE)
	public ResponseEntity delete(@PathVariable("id") Integer id) {
		try {
			itemService.delete(id);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			String message = String.format("Não foi possivel remover o registro [ %s ] parametros [ %s ]", e.getMessage(), id);
			LOGGER.error(message, e);
			return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new JsonError(e, message, id));
		}
	}

}
//generated by JSetup v0.95 :  at 1 de fev de 2023 23:43:21
