package hannotte_td_graphql.dao;
import java.util.List;

import hannotte_td_graphql.domain.Player;
import hannotte_td_graphql.domain.Post;
public class PlayerRepository {

	private List<Player> players;
	
	public PlayerRepository(List<Player> players) {

		this.players = players;
	}

	public List<Player> getAllPlayers() {
		
		return this.players;
	}		
	public Player savePlayer(Player player) {
		
		this.players.add(player);
		
		return player;
	}	
}
