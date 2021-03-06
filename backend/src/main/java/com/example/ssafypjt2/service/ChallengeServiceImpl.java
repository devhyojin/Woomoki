package com.example.ssafypjt2.service;

import java.util.List;

import com.example.ssafypjt2.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ssafypjt2.dao.ChallengeDao;
import com.example.ssafypjt2.dto.ChallengeDto;

@Service
public class ChallengeServiceImpl implements ChallengeService {
	@Autowired
	private ChallengeDao dao;

	@Override
	public int challengeUpdate(ChallengeDto challengeDto) {
		int get = dao.challengeUpdate(challengeDto);
		return get;
	}

	@Override
	public ChallengeDto challengeJoin(ChallengeDto challengeDto) {
		return null;
	}


	@Override
	public int challengeDelete(int id) {
		int get = dao.challengeDelete(id);
		return get;
	}

	@Override
	public int challengeInsert(ChallengeDto challengeDto) {
		int get = dao.challengeInsert(challengeDto);

		return get;
	}

	@Override
	public ChallengeDto challengeDetail(int id) {
		return dao.challengeDetail(id);
	}

	@Override
	public List<ChallengeDto> challengeAllList() {
		return dao.ChallengeAllList();
	}

	@Override
	public List<ChallengeDto> challengeCategorySort(int cgId) {
		return dao.challengeCategorySort(cgId);
	}

	@Override
	public List<ChallengeDto> challengeUserSelect(int userId) {
		return dao.challengeUserSelect(userId);
	}


	@Override
	public int likeUp(int userId, int cng_id) {
		int COUNT = dao.one_likeUp(cng_id);
		return dao.likeUp( userId , cng_id);
	}


	@Override
	public int likeDown(int userId, int cng_id)
	{
		int COUNT = dao.one_likeDown(cng_id);
		return dao.likeDown( userId , cng_id);
	}

	@Override
	public List<ChallengeDto> searchWordChallenge(String keyword) {
		System.out.println("키워드로 챌린지 찾기 "+keyword);
		List<ChallengeDto> result =  dao.searchWordChallenge(keyword);
		System.out.println(result);
		return result;
	}

	@Override
	public List<ChallengeDto> userPageCreatecng(int user_id) {
		System.out.println(user_id+"가 생성한 챌린지들의 정보를 보여주기 ");
		List<ChallengeDto> result =  dao.userPageCreatecng(user_id);
		return result;
	}

	@Override
	public List<String> Challenge() {
		System.out.println("모든 챌린지 title 리턴해줄 service에 도착 ~ ");
		List<String> result =  dao.challenge();
		System.out.println(result);
		return result;
	}

	@Override
	public List<ChallengeDto> challengeListResultSort(int user_id, int result_num) {
		return dao.challengeListResultSort(user_id,result_num);
	}

	@Override
	public int challengeLikeCount(int cngId) {
		return dao.challengeLikeCount(cngId);
	}

	@Override
	public List<UserDto> user_LikeAndChallengeList(int cngId) {
		List<UserDto> list = dao.main_LikeChallegeList(cngId);
		return list;
	}

/*
@Override
	public List<ChallengeDto> user_LikeAndChallengeList(int user_id) {
		List<ChallengeDto> list = dao.main_LikeChallegeList(user_id);
		return list;
	}
 */

}
