package com.example.ssafypjt2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ssafypjt2.dto.JoinedchallengeDto;
import com.example.ssafypjt2.dto.NotificationDto;
import com.example.ssafypjt2.dto.RelationDto;
import com.example.ssafypjt2.service.NotificationService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class NotificationController {

	@Autowired
	private NotificationService notificationService;

	// 개설자가 챌린지 참가를 수락/거절 하기
//	@PostMapping("/challengeJoinResult/{cngid}")
//	public List<NotificationDto> challengeJoinResult(@RequestBody NotificationDto notificationDto, @RequestBody JoinedchallengeDto joinedChallengeDto) {
//		List<NotificationDto> list;
//		return list;
//	}
//
//	// 친구신청 알림
//	@PostMapping("/followResult/{userid}")
//	public List<NotificationDto> followResult(@RequestBody RelationDto relationDto) {
//		List<NotificationDto> list;
//		return list;
//	}
}
