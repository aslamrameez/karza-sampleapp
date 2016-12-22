package org.karza.testSample.controller;

import javax.servlet.http.HttpServletRequest;

import org.karza.testSample.entity.Dealer;
import org.karza.testSample.repository.DealerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

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
	 * Redirects to the actual {@code index.html}.
	 * 
	 * @return
	 */

	@RequestMapping(value = "/search", headers = "Accept=*/*", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity search(String tin) {
		Dealer findOne = repo.findOne(tin);
		if (findOne != null)
			return ResponseEntity.status(HttpStatus.OK).body(findOne);

		return ResponseEntity.status(HttpStatus.OK).body("NO Data");
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public View create(Dealer dealer) {
		repo.save(dealer);
		return new RedirectView("index");
	}

}
