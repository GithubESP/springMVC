package sixteam.t6_27;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="post")
public class Post  implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="postId")
	private Integer postId;
	
	@Column(name="postTitle")
	private String postTitle;
	
	@Column(name="postDate")
	private String postDate;
	
	@Column(name="postContent")
	private String postContent;	
	
	@Column(name="postLike")
	private String postLike;	
	
	@Column(name="postDislike")
	private String postDislike;	
	
	@Column(name="postComment")
	private String postComment;
	
	@Column(name = "FILENAME")
	private String filename;
	
	@Column(name = "PICTURE")
	private byte[] picture;
	
	public Post() {
	}

	public Post(Integer postId, String postTitle, String postDate, String postContent, String postLike,
			String postDislike, String postComment, String filename, byte[] picture) {
		super();
		this.postId = postId;
		this.postTitle = postTitle;
		this.postDate = postDate;
		this.postContent = postContent;
		this.postLike = postLike;
		this.postDislike = postDislike;
		this.postComment = postComment;
		this.filename = filename;
		this.picture = picture;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostDate() {
		return postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public String getPostLike() {
		return postLike;
	}

	public void setPostLike(String postLike) {
		this.postLike = postLike;
	}

	public String getPostDislike() {
		return postDislike;
	}

	public void setPostDislike(String postDislike) {
		this.postDislike = postDislike;
	}

	public String getPostComment() {
		return postComment;
	}

	public void setPostComment(String postComment) {
		this.postComment = postComment;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	
	
}