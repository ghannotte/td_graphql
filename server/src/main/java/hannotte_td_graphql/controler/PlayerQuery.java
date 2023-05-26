package hannotte_td_graphql.controler;

import java.util.List;

import graphql.kickstart.tools.GraphQLQueryResolver;
import hannotte_td_graphql.dao.PlayerRepository;
import hannotte_td_graphql.domain.Player;

public class PlayerQuery implements GraphQLQueryResolver{

	private PlayerRepository PlayerRepository;

    public PlayerQuery(PlayerRepository PlayerRepository) {
        this.PlayerRepository = PlayerRepository;
    }

    public List<Player> getAllPlayers() {
        return this.PlayerRepository.getAllPlayers();
    }	
	
}
