package hannotte_td_graphql.controler;
import graphql.kickstart.tools.GraphQLMutationResolver;
import hannotte_td_graphql.dao.*;
import hannotte_td_graphql.domain.*;

public class BlogMutationPlayer implements GraphQLMutationResolver {

	private PlayerRepository playerRepository;

    public BlogMutationPlayer(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player writePlayer(String id, String name, String firstname, String team,String position) {
    	
    	Player player = new Player();
    	player.setId(id);
    	player.setName(name);
    	player.setFirstName(firstname);
    	player.setTeam(team);
    	player.setPosition(position);
 
    	
        return playerRepository.savePlayer(player);
    }
	
	
}
