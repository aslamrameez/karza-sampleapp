package org.karza.testSample.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.karza.testSample.Status;

import lombok.Data;

@Data
@Entity
public class Transaction {
	
	@GeneratedValue
	@Id
	private Long id;

	private Long tin;
	
	private Long srlNo;
	
	private Long oldRc;
	
	private Long dealerno;
	
	private Status status;
	
	
}
