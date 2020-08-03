package fr.afpa.exercices.spring.bean.jdbc.table;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fr.afpa.exercices.spring.jdbc.table.books;

/**
 * @author bilonjea
 *
 */
@Repository
public class BooksDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Books> getAllBooks() {
		String query = "Select * from Comments ";
		return jdbcTemplate.query(query, new CommentsMapper());
	}

	private static final class CommentsMapper implements RowMapper<Comments> {
		public Comments mapRow(ResultSet rs, int rowNum) throws SQLException {
			Comments msg = new Comments();
			msg.setComments(rs.getString("books"));
			msg.setDatum(rs.getDate("datum"));
			msg.setEmail(rs.getString("email"));
			msg.setMyuser(rs.getString("myuser"));
			msg.setWebPage(rs.getString("webPage"));
			msg.setId(rs.getInt("id"));
			return msg;
		}
	}

	/**
	 * nombre commentairs
	 * 
	 * @return
	 */
	public int getNbComments() {
		String query = "Select count(*) from Comments ";
		return jdbcTemplate.queryForObject(query, Integer.class);
	}

	public void setComments() {
		String query = "INSERT INTO Comments (MYUSER, EMAIL, WEBPAGE, DATUM, SUMMARY, COMMENTS) values (?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(query, "timi", "timi@yahoo.fr", "https://www.timi.com/", "2009-09-14 10:33:11","timi Summary", "timi first comment");

	}

	public void setComments(String user, String email, String url, String date, String summary, String Comments) {
		String query = "INSERT INTO Comments (MYUSER, EMAIL, WEBPAGE, DATUM, SUMMARY, COMMENTS) values (?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(query, user, email, url, date, summary, Comments);

	}

	public void setComments(String user, String email, String url, Date date, String summary, String Comments) {
		String query = "INSERT INTO Comments (MYUSER, EMAIL, WEBPAGE, DATUM, SUMMARY, COMMENTS) values (?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(query, user, email, url, date, summary, Comments);

	}
	
	public void deleCommentById(int id) {
		 String query= "delete from Comments where id = ?";
		 jdbcTemplate.update(query, id);
	}
	
	public void deleCommentByEmail(String email) {
		 String query= "delete from Comments where email = ?";
		 jdbcTemplate.update(query, email);
	}
	
	public void deleCommentByUserId(String myuser) {
		 String query= "delete from Comments where myuser = ?";
		 jdbcTemplate.update(query, myuser);
	}


}
