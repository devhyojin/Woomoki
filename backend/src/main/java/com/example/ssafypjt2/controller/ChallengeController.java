package com.example.ssafypjt2.controller;

import java.util.List;

import com.example.ssafypjt2.dto.UserDto;
import com.example.ssafypjt2.service.FavCategoryService;
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

	@Autowired
	private FavCategoryService favCategoryService;


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
		return result;
	}

	@GetMapping("/allChallenge")
	public List<ChallengeDto> challengeAllList(){
		return challengeService.challengeAllList();

	}

	@GetMapping("/categorySort/{cgId}")
	public List<ChallengeDto> challengeCategorySort(@PathVariable(value = "cgId") int cgId){
		return challengeService.challengeCategorySort(cgId);
	}

	@GetMapping("/challengeUserSelect/{userId}")
	public List<ChallengeDto> challengeUserSelect(@PathVariable(value = "userId") int userId){
		return challengeService.challengeUserSelect(userId);
	}


	//생성한 챌린지 리스트형태로 보여주기
	@PutMapping("/likeUpChallenge/{userId}/{cngId}")
	public int likeUp ( @PathVariable(value = "userId") int userId, @PathVariable(value = "cngId") int cng_id) throws Exception
	{
		System.out.println(userId +"가 " + cng_id +"챌린지에 넣을게 ");
		int result = challengeService.likeUp(userId, cng_id );
		System.out.println(result);
		return  result;
	}

	@PutMapping("/likeDownChallenge/{userId}/{cngId}")
	public int likeDown ( @PathVariable(value = "userId") int userId, @PathVariable(value = "cngId") int cng_id) {
		System.out.println(userId +"가 " + cng_id +"챌린지에 좋아요했던거 안좋아요 하겠3  ");
		int result = challengeService.likeDown(userId, cng_id );
		System.out.println(result);
		return  result;
	}


	/*
	* 	//내가 좋아요 한 챌린지의 id와 좋아요 수
	@CrossOrigin(origins = "*")
	@GetMapping("LikeAndChallenge/{userid}")
	public List<ChallengeDto> user_LikeAndChallengeList(@PathVariable(value = "userid") int user_id ) throws Exception {
		System.out.println(user_id+"가 좋아요 한 챌린지들과 좋아요의 수를 보여줄게");
		List<ChallengeDto> result = challengeService.user_LikeAndChallengeList(user_id);
		System.out.println(result);
		return result;
	}

	*
	* */

	//내가 좋아요 한 챌린지의 id와 좋아요 수
	@CrossOrigin(origins = "*")
	@GetMapping("LikeAndChallenge/{cngId}")
	public List<UserDto> user_LikeAndChallengeList( @PathVariable(value = "cngId") int cng_id) throws Exception {
		System.out.println(cng_id+"가 좋아요 한 챌린지들과 좋아요의 수를 보여줄게");
		List<UserDto> result = challengeService.user_LikeAndChallengeList(cng_id);
		System.out.println(result);
		return result;
	}



	@GetMapping("/userPage/createcng/{userid}")
	public List<ChallengeDto> userPageCreatecng(@PathVariable(value = "userid") int user_id ) throws Exception {
		System.out.println(user_id+"생성한 챌린지 리스트형태로 보여주기");
		List<ChallengeDto> result = challengeService.userPageCreatecng(user_id);
		return result;
	}

	// 메인 페이지 보여주기
	@PostMapping("/")
	public List<ChallengeDto> favCategory(@RequestBody UserDto userDto) {
		System.out.println(userDto.getId()+"가 가장 관심이 있어하는 카테고리 리스트 보여주기");
		List<ChallengeDto> result = favCategoryService.main_favCategory(userDto.getId());
		System.out.println(result);
		return result;
	}

	@GetMapping("/searchWordChallenge/{keyword}")
	public  List<ChallengeDto> searchWordChallenge(@PathVariable(value = "keyword") String keyword){
		System.out.println("챌린지 중에서 "+ keyword +"로 검색해볼게요!");
		return challengeService.searchWordChallenge(keyword);
	}

	@GetMapping("/challenge")
	public  List<String> challenge(){
		System.out.println("챌린지의 title을 리턴하기 ");
		List<String> list = challengeService.Challenge();
		return list;
	}

	@GetMapping("/challengeResultSort/{userId}/{resultNum}")
	public List<ChallengeDto> challengeListResultSort(@PathVariable(value = "userId") int userId, @PathVariable(value = "resultNum") int resultNum){
		return challengeService.challengeListResultSort(userId,resultNum);
	}


	 //챌린지id를 보내면 그 챌린지에 좋아요한 숫자를 갖고오는 기능
	 @GetMapping("/likecount/{cngId}")
	 public int challengeLikeCount(@PathVariable(value = "cngId") int cngId){
		 return challengeService.challengeLikeCount(cngId);
	 }








}
