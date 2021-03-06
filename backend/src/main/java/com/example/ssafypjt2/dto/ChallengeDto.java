package com.example.ssafypjt2.dto;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


public class ChallengeDto {
	private int id;
	private int category_id;
	private int user_id;
	private String title;
	private String content;
	private String sum_img;

	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
	//@JsonFormat(Timpattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private LocalDate start_date;

	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private LocalDate end_date;
	private int cert_count;
	private int max_people;
	private String example_img;
	private int join_deposit;
	private int like_cnt;
	private int result;
	private int week; // 몇 주
	private int day;  // 며칠


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSum_img() {
		return sum_img;
	}
	public void setSum_img(String sum_img) {
		this.sum_img = sum_img;
	}
	public LocalDate getStart_date() {
		return start_date;
	}
	public void setStart_date(LocalDate start_date) {
		this.start_date = start_date;
	}
	public LocalDate getEnd_date() {
		return end_date;
	}
	public void setEnd_date(LocalDate end_date) {
		this.end_date = end_date;
	}
	public int getCert_count() {
		return cert_count;
	}
	public void setCert_count(int cert_count) {
		this.cert_count = cert_count;
	}
	public int getMax_people() {
		return max_people;
	}
	public void setMax_people(int max_people) {
		this.max_people = max_people;
	}
	public String getExample_img() {
		return example_img;
	}
	public void setExample_img(String example_img) {
		this.example_img = example_img;
	}
	public int getJoin_deposit() {
		return join_deposit;
	}
	public void setJoin_deposit(int join_deposit) {
		this.join_deposit = join_deposit;
	}
	public int getLike_cnt() {
		return like_cnt;
	}
	public void setLike_cnt(int like_cnt) {
		this.like_cnt = like_cnt;
	}

	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}

	public int getWeek() {
		return week;
	}
	public void setWeek(int week) {
		this.week = week;
	}

	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public ChallengeDto() {
		super();
	}


}
