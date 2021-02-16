package com.example.ssafypjt2.dao;

import java.util.List;

import com.example.ssafypjt2.dto.CertificationDto;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.example.ssafypjt2.dto.ChallengeDto;



@Mapper
public interface ChallengeDao {
	//다시 test
	@Select(" SELECT category_id, user_id, title, content, "
			+ "sum_img, start_date, end_date, cert_count, "
			+ "max_people, example_img , join_deposit, like_cnt, result, week, day"
			+ " FROM challenge WHERE id = #{cngId} ")
	public ChallengeDto challengeDetail(@Param("cngId")int cngId);


	@Insert("Insert INTO challenge ( category_id, user_id, title, content, sum_img, start_date, end_date, cert_count, max_people, example_img, join_deposit, result, week , day)"
			+ " VALUES ( "
			+ "#{challengeDto.category_id}, #{challengeDto.user_id}, "
			+ "#{challengeDto.title}, #{challengeDto.content}, #{challengeDto.sum_img}, "
			+ "#{challengeDto.start_date}, #{challengeDto.end_date}, #{challengeDto.cert_count}, \n"
			+ "#{challengeDto.max_people}, #{challengeDto.example_img}, #{challengeDto.join_deposit}, #{challengeDto.result} , #{challengeDto.week} ,#{challengeDto.day} )")
	@Options(useGeneratedKeys = true)
	public int challengeInsert(@Param("challengeDto")ChallengeDto challengeDto);

	@Update("Update challenge SET "
			+ "category_id = #{challengeDto.category_id},"
			+ "user_id =  #{challengeDto.user_id}, "
			+ "title = #{challengeDto.title},"
			+ "content = #{challengeDto.content},"
			+ "sum_img = #{challengeDto.sum_img},"
			+ "max_people = #{challengeDto.max_people},"
			+ "example_img = #{challengeDto.example_img},"
			+ "join_deposit = #{challengeDto.join_deposit}, "
			+ " result =  #{challengeDto.result} ," +
			" week = #{challengeDto.week} , " +
			" day = #{challengeDto.day} "
			+ "WHERE id = #{challengeDto.id}" )
	public int challengeUpdate(@Param("challengeDto")ChallengeDto challengeDto);

	@Delete("DELETE FROM challenge "
			+ "WHERE id=#{cngId}")
	public int challengeDelete(@Param("cngId")int cngId);


	@Select("SELECT * FROM challenge")
	public List<ChallengeDto> ChallengeAllList();

	@Select(" SELECT id, category_id, user_id, title, content, "
			+ "sum_img, start_date, end_date, cert_count, "
			+ "max_people, example_img , join_deposit, like_cnt, result, week, day "
			+ " FROM challenge WHERE category_id = #{cgId} ")
	public List<ChallengeDto> challengeCategorySort(@Param("cgId")int cgId);

	@Select(" SELECT id, category_id, user_id, title, content, "
			+ "sum_img, start_date, end_date, cert_count, "
			+ "max_people, example_img , join_deposit, like_cnt, result, week ,day "
			+ " FROM challenge WHERE user_id = #{userId} ")
	public List<ChallengeDto> challengeUserSelect(@Param("userId")int userId);



	@Update("Update challenge SET "
			+"like_cnt = like_cnt+1 "
			+ "WHERE id = #{cngId}")
	public int one_likeUp(@Param("cngId")int cngId);

	@Insert("INSERT INTO like_challenge ( user_id, cng_id  ) VALUES (#{userId}  , #{cngId} )")
	public int likeUp(@Param("userId")int userId, @Param("cngId")int cngId);

	@Update("Update challenge SET "
			+"like_cnt = like_cnt-1 "
			+ "WHERE id = #{cngId}")
	public int one_likeDown(@Param("cngId")int cngId);

	@Delete("DELETE FROM like_challenge WHERE user_id = #{userId} AND cng_id = #{cngId}")
	public int likeDown(@Param("userId")int userId, @Param("cngId")int cngId);

	@Select("SELECT * FROM challenge  WHERE content like CONCAT('%', #{keyword}, '%') OR  title like CONCAT('%', #{keyword}, '%')")
	public List<ChallengeDto> searchWordChallenge(@Param("keyword") String keyword);

	@Select("SELECT * FROM challenge WHERE user_id = #{user_id} ")
    public List<ChallengeDto> userPageCreatecng(@Param("user_id")int user_id);

	@Select("SELECT title FROM challenge ")
     public   List<String> challenge();

	@Select("SELECT c.category_id, c.user_id, c.title, c.content," +
			"c.sum_img, c.start_date, c.end_date, c.cert_count," +
			"c.max_people, c.example_img , c.join_deposit, c.like_cnt, c.result, c.week, c.day " +
			"FROM challenge AS c INNER JOIN joined_challenge  AS jc " +
			"WHERE jc.user_id = #{user_id} AND jc.cng_id = c.id AND jc.result =#{result_num}")
	public List<ChallengeDto> challengeListResultSort(@Param("user_id")int user_id ,@Param("result_num")int result_num );

	@Select("SELECT like_cnt FROM challenge WHERE id = #{cngId}")
	public int challengeLikeCount(@Param("cngId")int cngId);

    @Select("SELECT cha.id , cha.category_id, cha.user_id, cha.title, cha.title, cha.content, cha.sum_img, cha.start_date, cha.end_date, cha.cert_count, cha.max_people, cha.example_img, cha.join_deposit, cha.like_cnt  " +
			" FROM like_challenge AS joy JOIN challenge AS cha ON joy.user_id = #{user_id} AND joy.cng_id = cha.id")
	public List<ChallengeDto> main_LikeChallegeList(@Param("user_id")int user_id);
}

/*
   @Select("SELECT * FROM challenge  WHERE content like '%' ||  #{keyword} || '%' AND title like '%' ||  #{keyword} || '%'")
	public List<ChallengeDto> searchWordChallenge(@Param("keyword") String keyword);


	@Select("SELECT * FROM challenge  WHERE content like CONCAT('%', #{keyword}, '%')")

    @Select("SELECT * FROM challenge  WHERE content like  '%' ||  #{keyword} || '%' ")  -> 이건 됨
	public List<ChallengeDto> searchWordChallenge(@Param("keyword") String keyword);


 */