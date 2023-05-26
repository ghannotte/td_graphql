package hannotte_td_graphql.dao;
import java.util.List;

import hannotte_td_graphql.domain.Player;
import hannotte_td_graphql.domain.Team;
public class TeamRepository {

	private List<Team> teams;
	
	public TeamRepository(List<Team> teams) {

		this.teams = teams;
	}

	public List<Team> getAllTeams() {
		
		return this.teams;
	}	

	public Team saveTeam(Team team) {
		
		this.teams.add(team);
		
		return team;
	}
	
}
