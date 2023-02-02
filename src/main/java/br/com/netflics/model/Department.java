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

import java.time.LocalDate;
import java.time.LocalDateTime;
	
import java.util.ArrayList;
import java.util.List;

import br.com.netflics.core.model.AbstractMultitenantEntity;

@Entity
@Table(name = "DEPARTMENT")
public class Department extends AbstractMultitenantEntity{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Integer id;
	
	@Column(name = "DEPARTMENT_NAME" )
	private String departmentName;		
	
		
	public  Department() {
		
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
}
//generated by JSetup v0.95 :  at 1 de fev de 2023 23:43:21