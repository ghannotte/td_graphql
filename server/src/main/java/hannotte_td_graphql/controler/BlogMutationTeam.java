package hannotte_td_graphql.controler;
import graphql.kickstart.tools.GraphQLMutationResolver;
import hannotte_td_graphql.dao.*;
import hannotte_td_graphql.domain.*;
public class BlogMutationTeam implements GraphQLMutationResolver{
	private TeamRepository teamRepository;

    public BlogMutationTeam(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Team writeTeam(String id, String name, String city) {
    	
    	Team team = new Team();
    	team.setId(id);
    	team.setName(name);
    	team.setCity(city);
 
    	
        return teamRepository.saveTeam(team);
    }
	

}
