package com.palmyralabs.workflow.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "action_type")
public class ActionTypeEntity {
	
	@Id
    @Column(name = "id")
	private String id;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "created_by")
	private String createdBy;
	
	@Column(name = "created_on")
	private LocalDateTime createdOn;
	
	@Column(name = "last_upd_by")
	private String lastUpdBy;
	
	@Column(name = "last_upd_on")
	private LocalDateTime lastUpdOn;
 
}
