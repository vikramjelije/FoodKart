package OOPSDesign.Models;

public class Review {
	
	public Review(int id, int score, String comment) {
		super();
		this.id = id;
		this.score = score;
		this.comment = comment;
	}
	
	public Review() {
	}

	int id;
	int score;
	String comment;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
