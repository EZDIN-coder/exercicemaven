/**
 * 
 */
package fr.afpa.exercices.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.afpa.exercices.spring.jdbc.AuthorDao;
import fr.afpa.exercices.spring.jdbc.BooksDao;
import fr.afpa.exercices.spring.jdbc.table.Books;
import fr.exercices.spring.config.AppConfiguration;
import lombok.extern.log4j.Log4j;



/**
 * @author 77011-53-02
 *
 */
@Log4j
public class AppExerciceMain {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Creating a Context Application object by reading
				// the configuration of the 'AppConfiguration' class.
				ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfiguration.class);
				
				
			log.info("list des commentaires");
				
				BooksDao booksDao = (BooksDao) ctx.getBean("booksDao");
				AuthorDao authorDao = (AuthorDao) ctx.getBean("authorDao");
				
				List<Books> books = booksDao.getAllbooks();
				for (Books books1 : books) {
					System.out.println(books1);
				}
				
				log.info("nombres des Books");
				System.out.println(booksDao.getNbbooks());
				
				log.info("Afficher les livres de Truman Capote");
				System.out.println(booksDao.getbookTrum());
				
				log.info("afficher les livres de Truman");				
				System.out.println(booksDao.getbookTrum());
				
//				log.info("insert author");
//				authorDao.setauthors();
//				
				
//				log.info("insert books");
//				booksDao.setbooks(10,5,"404");
//				
				
//			log.info("delete books ");
//				booksDao.delebookByauthorId(2);
				
				
				
				

	}

}
