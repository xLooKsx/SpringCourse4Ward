package br.com.fiveward.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xLooKsx
 *
 */
@RestController
@RequestMapping("/merchant")
public class MicroserviceController {

	@PostMapping()
	public ResponseEntity<?> create(){
		return ResponseEntity.created(null).build();
	}
	
	@GetMapping()
	public ResponseEntity<?> getById(){
		return ResponseEntity.ok().build();
	}
}
