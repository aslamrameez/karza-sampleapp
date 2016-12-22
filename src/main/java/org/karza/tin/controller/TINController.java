package org.karza.tin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.karza.tin.entity.Dealer;
import org.karza.tin.repository.DealerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * 
 * 
 * @author aslam
 */
@Controller
public class TINController {

	@Autowired
	private DealerRepository repo;

	private static String INDEX = "/index";

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
		return INDEX;
	}

	/**
	 *  Retrieve Dealer 
	 * 
	 * @return
	 */

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Dealer>> search(String tin) {
		List<Dealer> findOne = repo.findByTinNo(tin);
		return ResponseEntity.status(HttpStatus.OK).body(findOne);
	}
	
	/**
	 * Save Dealer
	 * 
	 * @return
	 */

	@RequestMapping(value = "/create", method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Dealer create(@RequestBody Dealer dealer) {
		Dealer save = repo.save(dealer);
		return save;
	}

}
