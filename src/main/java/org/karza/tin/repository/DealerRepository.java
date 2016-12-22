package org.karza.tin.repository;

import java.util.List;

import org.karza.tin.entity.Dealer;
import org.springframework.data.jpa.repository.JpaRepository;
/*
 * Repository for Dealer
 * 
 * @author aslam
 */
public interface DealerRepository extends JpaRepository<Dealer,Long>{
	
	List<Dealer> findByTinNo(String tinNo);

}
