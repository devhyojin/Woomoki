package com.example.ssafypjt2.dao;

import com.example.ssafypjt2.dto.ChallengeDto;
import com.example.ssafypjt2.dto.FavChallengeDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FavChallengeDao {
    @Insert("INSERT INTO fav_challenge ( user_id, cng_id  ) VALUES ( #{user_id} , #{cng_id} ) ")
    @Options(useGeneratedKeys = true) // myBatis 에서 자동생성키를 true를 했을 때
    public int user_InsertfavChallenge(@Param("user_id") int user_id, @Param("cng_id") int cng_id);

    @Insert("DELETE FROM fav_challenge WHERE user_id = #{user_id} AND cng_id = #{cng_id} ")
    @Options(useGeneratedKeys = true) // myBatis 에서 자동생성키를 true를 했을 때
    public int user_DeletefavChallenge(@Param("user_id") int user_id, @Param("cng_id") int cng_id);

    @Select("SELECT cng_id FROM fav_challenge WHERE user_id = #{user_id}")
    public List<FavChallengeDto> main_favChallege1(@Param("user_id") int user_id);

    @Select("SELECT * FROM  challenge WHERE id = #{cng_id} ")
    public List<ChallengeDto> main_favChallege2(@Param("cng_id") int cng_id);

    @Select("SELECT cha.id , cha.category_id, cha.user_id, cha.title, cha.title, cha.content, cha.sum_img, cha.start_date, cha.end_date, cha.cert_count, cha.max_people, cha.example_img, cha.join_deposit, cha.like_cnt , cha.week , cha.day  FROM fav_challenge AS joy JOIN challenge AS cha ON joy.user_id = #{user_id} AND joy.cng_id = cha.id ")
    public List<ChallengeDto> main_LikefavChallege(@Param("user_id") int user_id);

}
