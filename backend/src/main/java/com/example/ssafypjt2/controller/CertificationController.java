package com.example.ssafypjt2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ssafypjt2.dto.CertificationDto;
import com.example.ssafypjt2.dto.ChallengeDto;
import com.example.ssafypjt2.service.CertificationService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class CertificationController {

	@Autowired
	private CertificationService certificationService;
	
	@GetMapping("/detailcertification/{certId}")
	public CertificationDto certificationDetail (@PathVariable(value = "certId") int id) {		
		CertificationDto result = certificationService.certificationDetail(id);	
		return result;
	}
	
	
	@PostMapping("/insertCertification")
	public int certificationInsert ( @RequestBody CertificationDto certificationDto) {
		int result = certificationService.certificationInsert(certificationDto);
		return result;
	}
	
	@PutMapping("/updateCertification")
	public int challengeUpdate ( @RequestBody CertificationDto certificationDto) {
		int result = certificationService.certificationUpdate(certificationDto);
		return result;
	}
}
