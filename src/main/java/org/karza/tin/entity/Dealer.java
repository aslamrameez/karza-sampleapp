package org.karza.tin.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
/*
 * 
 * 
 * @author aslam
 */
@Data
@Entity
public class Dealer {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String tinNo;
	
	private String name;
	
	private String location;
	
	
	

}
