package hannotte_td_graphql.controler;

import java.util.List;

import graphql.kickstart.tools.GraphQLQueryResolver;
import hannotte_td_graphql.dao.*;
import hannotte_td_graphql.domain.*;

public class BlogQuery implements GraphQLQueryResolver {

	
	private PostDao postDao;

    public BlogQuery(PostDao postDao) {
        this.postDao = postDao;
    }

    public List<Post> getRecentPosts(int count, int offset) {
        return postDao.getRecentPosts(count, offset);
    }
}
