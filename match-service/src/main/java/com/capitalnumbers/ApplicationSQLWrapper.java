package com.capitalnumbers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApplicationSQLWrapper{ 
    
	@Value("${selectAllTeams}")
	public String selectAllTeams;
	
	@Value("${upcomingMatchesByTeam}")
	public String upcomingMatchesByTeam;
	
	@Value("${allMatchesByTeam}")
	public String allMatchesByTeam;
	
	@Value("${allWinners}")
	public String allWinners;
	
	@Value("${updateMatchTime}")
	public String updateMatchTime;
	
	@Value("${updateTeamName}")
	public String updateTeamName;
	
	@Value("${deleteUpcomingMatch}")
	public String deleteUpcomingMatch;
	 
	@Value("${createUpcomingMatch}")
	public String createUpcomingMatch;
	
	@Value("${createTeam}")
	public String createTeam;
}