package com.example.ssafypjt2.controller;


import com.example.ssafypjt2.dto.JoinedChallengeDto;
import com.example.ssafypjt2.service.JoinedChallengeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class JoinedChallengeController {

    @Autowired
    JoinedChallengeService service;

    @GetMapping("/joinChallengeUserList/{cngId}")
    public List<JoinedChallengeDto> joinChallengeUserList(@PathVariable(value = "cngId") int cngId){
        return service.joinChallengeUserList(cngId);
    }

    @PutMapping("/joinResultUpdate/{userId}/{cngId}/{result}")
    public int joinResultUpdate(@PathVariable("userId")int userId, @PathVariable("cngId")int cngId, @PathVariable("result")int result){
        return service.joinResultUpdate(userId,cngId,result);
    }
}
