/* generated by JSetup v0.95 :  at 1 de fev de 2023 23:43:21 */
package br.com.netflics.core.model;

import java.io.Serializable;

import javax.persistence.EntityListeners;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import br.com.netflics.core.persistence.DataCreateUpdateListener;
import java.time.LocalDateTime;

@EntityListeners(DataCreateUpdateListener.class)
@MappedSuperclass
public abstract class AbstractMultitenantEntity extends AbstractEntity {

	private static final long serialVersionUID = -7964355524118760783L;
	@ManyToOne
	@JoinColumn(name = "ID_TENANT", nullable = true, updatable = true)
	private Tenant tenant;

	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}
}