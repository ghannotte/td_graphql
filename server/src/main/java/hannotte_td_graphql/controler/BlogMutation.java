package hannotte_td_graphql.controler;
import graphql.kickstart.tools.GraphQLMutationResolver;
import hannotte_td_graphql.dao.*;
import hannotte_td_graphql.domain.*;
public class BlogMutation implements GraphQLMutationResolver{
	
	private PostDao postDao;

    public BlogMutation(PostDao postDao) {
        this.postDao = postDao;
    }

    public Post writePost(String id, String title, String category, String text) {
    	
    	Post post = new Post();
    	post.setId(id);
    	post.setTitle(title);
    	post.setCategory(category);
    	post.setText(text);
    	
        return postDao.savePost(post);
    }
	

}
