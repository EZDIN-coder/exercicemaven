package fr.afpa.exercices.spring.jdbc;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;



import fr.afpa.exercices.spring.jdbc.table.Books;
import lombok.Data;


@Repository

public class BooksDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Books> getAllbooks() {
		String query = "Select * from books ";
		return jdbcTemplate.query(query, new booksMapper());
	}

	private static final class booksMapper implements RowMapper<Books> {
		public Books mapRow(ResultSet rs, int rowNum) throws SQLException {
			Books msg = new Books();
			msg.setId(rs.getInt("id"));
			msg.setAuthorId(rs.getInt("authorId"));
			msg.setTitle(rs.getString("title"));
			
			
			return msg;
		}
	}

	/**
	 * nombre commentairs
	 * 
	 * @return
	 */
	public int getNbbooks() {
		String query = "Select count(*) from books ";
		return jdbcTemplate.queryForObject(query, Integer.class);
	}
	public int getbooks() {
		String query = "Select (*) from books where id =  ";
		return jdbcTemplate.queryForObject(query, Integer.class);
	}
	
	public List<Books> getbookTrum() {
		String query = "Select * from books where authorId = 5  ";
		return jdbcTemplate.query(query,new booksMapper());
		
	}
	
	
	public void setbooks(int Id,int AuthorId,String Title ) {
		String query = "INSERT INTO books (Id,authorId,TITLE) values (?, ?, ?)";
		jdbcTemplate.update(query, Id, AuthorId,Title);
		
		

	}

	
	
	public void delebookByauthorId(int AuthorId) {
		 String query= "delete from books where authorId = ?";
		 jdbcTemplate.update(query, AuthorId);
	}
	
	




}
