package com.capitalnumbers.entity;

import com.capitalnumbers.Views;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Match {
	private Long id;	
	@JsonView(Views.UpcomingMatchView.class)
	private String start_time;
	@JsonView(Views.UpcomingMatchView.class)
	private String home_team_name;
	@JsonView(Views.UpcomingMatchView.class)
	private String away_team_name;
	private int home_score;
	private int away_score;
	
	public Match(String start_time, String home_team_name, String away_team_name){
		this.start_time = start_time;
		this.home_team_name = home_team_name;
		this.away_team_name = away_team_name;
	}
	
	public Match(String start_time, String home_team_name, String away_team_name, int home_score, int away_score){
		this.start_time = start_time;
		this.home_team_name = home_team_name;
		this.away_team_name = away_team_name;
		this.home_score = home_score;
		this.away_score = away_score;
	}
}
