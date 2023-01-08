package sixteam.t6_27;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PostService {
	
	@Autowired
	private PostDao pDao;
	
	public Post add(Post post) {
		return pDao.add(post);
	}
	
	public boolean delete(Post post) {
		return pDao.delete(post);
	}
	
	public Post update(Post post) {
		return pDao.update(post);
	}
	
	public Post findById(Integer postId) {
		return pDao.findById(postId);
	}
	
	public List<Post> findAll(){
		return pDao.findAll();
	}

}
