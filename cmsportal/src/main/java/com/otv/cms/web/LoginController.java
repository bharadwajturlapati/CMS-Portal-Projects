package com.otv.cms.web;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ResponseEntity<String> getCheckLogin(@RequestParam(value="logincreds") String credsAsHashCode) {
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
