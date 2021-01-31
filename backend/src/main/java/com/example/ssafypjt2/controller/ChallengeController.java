package com.example.ssafypjt2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ssafypjt2.dto.ChallengeDto;
import com.example.ssafypjt2.service.ChallengeService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ChallengeController {

	@Autowired
	private ChallengeService challengeService;
	
	@PostMapping("/insertChallenge")
	public int challengeInsert ( @RequestBody ChallengeDto challengeDto) {
		int result = challengeService.challengeInsert(challengeDto);
		
		System.out.println(result);
		return result;
	}
	
	@PutMapping("/updateChallenge")
	public int challengeUpdate ( @RequestBody ChallengeDto challengeDto) {
		int result = challengeService.challengeUpdate(challengeDto);
		System.out.println(result);
		return result;
	}
	
	@DeleteMapping("/deleteChallenge/{cngId}")
	public int challengeUpdate (@PathVariable(value = "cngId") int id) {
		int result = challengeService.challengeDelete(id);
		System.out.println(result);
		return result;
	}
	
	@GetMapping("/detailChallenge/{cngId}")
	public ChallengeDto challengeDetail (@PathVariable(value = "cngId") int id) {
		
		ChallengeDto result = challengeService.challengeDetail(id);
		System.out.println(result+"detail한거 여기~ ");
		return result;
	}
}
