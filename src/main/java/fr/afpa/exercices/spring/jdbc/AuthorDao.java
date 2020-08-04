package fr.afpa.exercices.spring.jdbc;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fr.afpa.exercices.spring.jdbc.table.Authors;
import fr.afpa.exercices.spring.jdbc.table.Books;
import lombok.Data;

@Repository

public class AuthorDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	


public  List<Authors>  getAllAuthors() {
	String query = "Select * from authors ";
	return jdbcTemplate.query(query, new authorsMapper());
}

private static final class authorsMapper implements RowMapper<Authors> {
	public Authors mapRow(ResultSet rs, int rowNum) throws SQLException {
		Authors msg = new Authors();
		msg.setName(rs.getString("name"));
		msg.setId(rs.getInt("id"));
		
		
		
		return msg;
	}
}
public void setauthors() {
	String query = "INSERT INTO authors (ID,NAME) values (?, ?)";
	jdbcTemplate.update(query, "6","Sabri Louatah");



}

}
