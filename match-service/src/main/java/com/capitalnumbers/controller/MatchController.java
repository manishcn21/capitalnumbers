package com.capitalnumbers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capitalnumbers.CustomException;
import com.capitalnumbers.Views;
import com.capitalnumbers.entity.Match;
import com.capitalnumbers.entity.Team;
import com.capitalnumbers.service.MatchService;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping("/matches")
public class MatchController {

	@Autowired
	private MatchService matchService;
	
	@GetMapping("/teams")
	public List<Team> getAllTeams() {
		return matchService.getAllTeams();
	}
	
	@GetMapping("/upcomingMatchesByTeam/{team_id}")
	public List<Match> getUpcomingMatches(@PathVariable("team_id") Integer team_id) {
		return matchService.getAllUpcomingMatchesByTeam(team_id);
	}
	
	@GetMapping("/allMatchesByTeam/{team_id}")
	public List<Match> getAllMatchesByTeam(@PathVariable("team_id") Integer team_id) {
		return matchService.getAllMatchesByTeam(team_id);
	}
	
	@GetMapping("/winners")
	public List<String> getAllWinners() {
		return matchService.getAllWinners();
	}
	
	@PostMapping("/updateMatchTime")
	public ResponseEntity<Integer> updateMatch(@RequestBody Match match) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		int updated = 0;
		try
		{
			updated = matchService.updateMatchTime(match);
			if(updated > 0) {
				status = HttpStatus.OK;
			}
		}
		catch(Exception e) {
			status = HttpStatus.NOT_FOUND;
		}
		
		return new ResponseEntity<>(updated, status);
	}
	
	@PostMapping("/updateTeamName")
	public ResponseEntity<Integer> updateTeamName(@RequestBody Team team) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		int updated = 0;
		try
		{
			updated = matchService.updateTeamName(team);
			if(updated > 0) {
				status = HttpStatus.OK;
			}
		}
		catch(Exception e) {
			status = HttpStatus.NOT_FOUND;
		}
		
		return new ResponseEntity<>(updated, status);
	}
	
	@DeleteMapping("/deleteUpcomingMatch/{match_id}")
	public ResponseEntity<Integer> deleteUpcomingMatch(@PathVariable("match_id") Integer match_id) {
		HttpStatus status = HttpStatus.NO_CONTENT;
		int updated = 0;
		try
		{
			updated = matchService.deleteUpcomingMatch(match_id);
			if(updated > 0) {
				status = HttpStatus.OK;
			}
		}
		catch(Exception e) {
			status = HttpStatus.NO_CONTENT;
		}
		
		return new ResponseEntity<>(updated, status);
	}
	
	@PostMapping("/addUpcomingMatch")
	public ResponseEntity<Integer> createUpcomingMatch(@RequestBody Match match) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		int added = 0;
		try
		{
			added = matchService.createUpcomingMatch(match);
			if(added > 0) {
				status = HttpStatus.CREATED;
			}
		}
		catch(Exception e) {
			status = HttpStatus.BAD_REQUEST;
		}
		
		return new ResponseEntity<>(added, status);
	}
}
