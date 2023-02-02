/* generated by JSetup v0.95 :  at 1 de fev de 2023 23:43:21 */
package br.com.netflics.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.persistence.UniqueConstraint;		

import java.time.LocalDate;
import java.time.LocalDateTime;
	
import java.util.ArrayList;
import java.util.List;

import br.com.netflics.core.model.AbstractEntity;

@Entity
@Table(name = "ACCESS_GROUP", uniqueConstraints = {
		@UniqueConstraint(name = "ACCESS_GROUP_NAME", columnNames = { "NAME" }), 
})
public class Group extends AbstractEntity{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Integer id;
	
	@Column(name = "NAME" )
	private String name;		
	
	@Column(name = "DESCRIPTION" )
	private String description;		
	
    @ManyToMany
    @JoinTable(name="GROUP_ROLE", joinColumns = @JoinColumn(name = "ID_GROUP", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_ROLE", referencedColumnName = "ID") )
    private List<Role> roles;
    
    @ManyToMany
    @JoinTable(name="GROUP_PERMISSION", joinColumns = @JoinColumn(name = "ID_GROUP", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_PERMISSION", referencedColumnName = "ID") )
    private List<Permission> permissions;
    
		
	public  Group() {
		
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public void setRoles(List<Role> roles){
		this.roles = roles;
	}
	
	public List<Role>  getRoles() {
		if(this.roles == null){
			setRoles(new ArrayList<Role>());
		}
		return this.roles; 
	}
		
	public boolean addRoles(Role role){	
		return getRoles().add(role);
	}
	
	public boolean removeRoles(Role role){	
		return getRoles().remove(role);
	}
	public void setPermissions(List<Permission> permissions){
		this.permissions = permissions;
	}
	
	public List<Permission>  getPermissions() {
		if(this.permissions == null){
			setPermissions(new ArrayList<Permission>());
		}
		return this.permissions; 
	}
		
	public boolean addPermissions(Permission permission){	
		return getPermissions().add(permission);
	}
	
	public boolean removePermissions(Permission permission){	
		return getPermissions().remove(permission);
	}
	
}
//generated by JSetup v0.95 :  at 1 de fev de 2023 23:43:21