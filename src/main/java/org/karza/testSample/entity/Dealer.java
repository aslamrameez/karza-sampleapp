package org.karza.testSample.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Dealer {
	
	@Id
	private String tinNo;
	
	private Long name;
	
	private String location;
	
	
	

}
