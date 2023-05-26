package hannotte_td_graphql.controler;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hannotte_td_graphql.dao.*;
import hannotte_td_graphql.domain.*;

@Configuration
public class GraphqlConfiguration {

	
	@Bean
    public PostDao postDao() {
        List<Post> posts = new ArrayList<>();
        for (int postId = 0; postId < 10; ++postId) {
            Post post = new Post();
            post.setId("" + postId);
            post.setTitle("Title " + postId);
            post.setText("Text " + postId);
            post.setCategory("Category " + (postId % 2 == 0 ? "1" : "2"));
            posts.add(post);
        }
        return new PostDao(posts);
    }	

	
	@Bean
	public TeamRepository teamDao() {
		
		List<Team> teams = new ArrayList<>();
		
		Team team1 = new Team();
		team1.setId("1");
		team1.setName("PSG");
		team1.setCity("Paris");

		teams.add(team1);
		
		Team team2 = new Team();
		team2.setId("2");
		team2.setName("OM");
		team2.setCity("Marseille");
		teams.add(team2);
		
		return new TeamRepository(teams);
	}	
	@Bean
	public PlayerRepository playerDao() {
		
		List<Player> players = new ArrayList<>();
		
		Player player1 = new Player();
		player1.setId("1");
		player1.setName("Mbappe");
		player1.setFirstName("Kylian");
		player1.setTeam("PSG");
		player1.setPosition("Attaquant");
		players.add(player1);
		
		Player player2 = new Player();
		player2.setId("2");
		player2.setName("Benzema");
		player2.setFirstName("Karim");
		player2.setTeam("RM");
		player2.setPosition("Attaquant");

		players.add(player2);
		
		return new PlayerRepository(players);
	}	
	
	@Bean
    public BlogQuery blogQuery(PostDao postDao) {
        return new BlogQuery(postDao);
    }
	
	@Bean
    public TeamsQuery teamsQuery(TeamRepository teamDao) {
        return new TeamsQuery(teamDao);
    }
	@Bean
    public PlayerQuery playerQuery(PlayerRepository playerDao) {
        return new PlayerQuery(playerDao);
    }	
	
	@Bean
    public BlogMutation mutation(PostDao postDao) {
        return new BlogMutation(postDao);
    }	
	@Bean
    public BlogMutationPlayer mutationPlayer(PlayerRepository playerDao) {
        return new BlogMutationPlayer(playerDao);
    }
	@Bean
    public BlogMutationTeam mutationTeam(TeamRepository teamDao) {
        return new BlogMutationTeam(teamDao);
    }	
}
