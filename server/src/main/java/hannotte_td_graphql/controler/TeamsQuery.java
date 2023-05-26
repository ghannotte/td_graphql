package hannotte_td_graphql.controler;
import java.util.List;
import hannotte_td_graphql.dao.*;
import hannotte_td_graphql.domain.*;

import graphql.kickstart.tools.GraphQLQueryResolver;

public class TeamsQuery implements GraphQLQueryResolver {

	private TeamRepository TeamRepository;

    public TeamsQuery(TeamRepository TeamRepository) {
        this.TeamRepository = TeamRepository;
    }
    
    public List<Team> getAllTeams() {
        return this.TeamRepository.getAllTeams();
    }
	
}
