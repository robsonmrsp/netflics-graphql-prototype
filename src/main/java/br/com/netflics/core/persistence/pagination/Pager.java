package br.com.netflics.core.persistence.pagination;

import java.util.List;

/* generated by JSetup v0.95 :  at 17/09/2020 23:37:34 */
public class Pager<Entity> {
	private final List<Entity> items;
	private final Integer actualPage;
	private final Long totalRecords;

	private final Integer pageSize;
	private final String orderBy;
	private final String order;

	public Pager() {
		this(null, 0, 10, null, null, 10L);
	}

	public Pager(List<Entity> items, Integer actualPage, Integer pageSize, String orderBy, String order, Long totalRecords) {
		super();
		this.items = items;
		this.actualPage = actualPage;
		this.pageSize = pageSize;
		this.order = order;
		this.orderBy = orderBy;
		this.totalRecords = totalRecords;
	}

	public List<Entity> getItems() {
		return items;
	}

	public Integer getActualPage() {
		return actualPage;
	}

	public Long getTotalRecords() {
		return totalRecords;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public String getOrder() {
		return order;
	}

}
