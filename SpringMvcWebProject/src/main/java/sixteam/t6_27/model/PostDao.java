package sixteam.t6_27.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class PostDao {
@Autowired
	private SessionFactory factory;

	// 新增
	public Post add(Post post) {
		Session session = factory.openSession();

		if (post != null) {
			session.save(post);
			session.close();
			return post;
		}
		session.close();
		return null;
	}

	// 刪除
	public boolean delete(Post post) {
		Session session = factory.openSession();

		if (post != null) {
			session.delete(post);
			session.flush();
			session.close();
			return true;
		}
		session.close();
		return false;
	}

	// 修改
	public Post update(Post post) {
		Session session = factory.openSession();

		if (post != null) {
			session.update(post);
			session.flush();
			session.close();
		}
		session.close();
		return null;
	}
	
	// 用ID查詢
	public Post findById(Integer postId) {
		Session session = factory.openSession();
		Post post = session.get(Post.class, postId);		
		session.close();
		return post;
	}
	
	// 全部查詢
	public List<Post> findAll(){
		Session session = factory.openSession();
		Query<Post> query = session.createQuery("from Post", Post.class);
		List<Post> result = query.getResultList();
		session.close();
		return result;
	}
	
	// 模糊查詢
	

}

//	public class PostDaoImpl implements PostDao {
//		private SessionFactory factory;
//
//		public PostDaoImpl() {
//			this.factory = HibernateUtil.getSessionFactory();
//		}
//
//		@Override
//		public List<Post> searchAll() {
//			Session session = factory.getCurrentSession();
//
//			try {
//				session.beginTransaction();
//				Query<Post> query = session.createQuery("from Post", Post.class);
//				List<Post> result = query.getResultList();
//				session.getTransaction().commit();
//
//				return result;
//			} catch (Exception e) {
//				session.getTransaction().rollback();
//			}
//			return null;
//		}
//
//		@Override
//		public int delete(Integer postId) {
//			Session session = factory.getCurrentSession();
//
//			try {
//				session.beginTransaction();
//
//				Post post = session.get(Post.class, postId);
//				session.delete(post);
//
//				session.getTransaction().commit();
//			} catch (Exception e) {
//				session.getTransaction().rollback();
//			}
//			return 0;
//		}
//
//		@Override
//		public int update(Post post) {
//			Session session = factory.getCurrentSession();
//
//			try {
//				session.beginTransaction();
//				Post post1 = session.get(Post.class, post.getPostId());
//				if (post1 != null) {
//					post1.setPostTitle(post.getPostTitle());
//					post1.setPostDate(post.getPostDate());
//					post1.setPostContent(post.getPostContent());
//					post1.setPostImage(post.getPostImage());
//					post1.setPostLike(post.getPostLike());
//					post1.setPostDislike(post.getPostDislike());
//					post1.setPostComment(post.getPostComment());
//				}
//				session.getTransaction().commit();
//			} catch (Exception e) {
//				session.getTransaction().rollback();
//			}
//			return 0;
//		}

//		String hql = "update Post p set p.postTitle=:title, p.postDate=:date, p.postContent=:content, p.postLike=:like, p.postDislike=:dislike, p.postComment=:comment, p.postImage=:image where p.postId=:id";
//		Session session = factory.getCurrentSession();
//
//		try
//		{
//			session.beginTransaction();
//			session.createQuery(hql).setParameter("title", post.getpostTitle()).setParameter("date", post.getpostDate())
//					.setParameter("content", post.getpostContent()).setParameter("like", post.getpostLike())
//					.setParameter("dislike", post.getpostDislike()).setParameter("comment", post.getpostComment())
//					.setParameter("id", post.getpostId()).setParameter("image", post.getpostImage()).executeUpdate();
//			session.getTransaction().commit();
//
//		}catch(
//		Exception e)
//		{
//			session.getTransaction().rollback();
//			e.printStackTrace();
//		}return 0;
//
//	}
//
//		@Override
//		public Post searchById(Integer postId) {
//			String hql = "from Post p where p.postId=:id";
//			Session session = factory.getCurrentSession();
//
//			try {
//				session.beginTransaction();
//
//				Query<Post> query = session.createQuery(hql, Post.class).setParameter("id", postId);
//
//				Post result = query.getSingleResult();
//				session.getTransaction().commit();
//				return result;
//
//			} catch (Exception e) {
//				session.getTransaction().rollback();
//				return null;
//			}
//
//		}
//
//		@Override
//		public int add(Post post) {
//			Session session = factory.getCurrentSession();
//
//			try {
//
//				session.beginTransaction();
//				System.out.println("begin");
//				session.save(post);
//
//				session.getTransaction().commit();
//
//			} catch (Exception e) {
//				session.getTransaction().rollback();
//				e.printStackTrace();
//			}
//			return 0;
//		}
//
//	}
