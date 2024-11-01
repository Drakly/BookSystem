package bg.softuni.bookshopsystem.data.repositories;

import bg.softuni.bookshopsystem.data.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Set;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    Set<Author> findAllByBooksReleaseDateBefore(LocalDate releaseDate);
@Query("SELECT SUM (b.copies) " +
        "FROM Author a " +
        "JOIN Book b ON b.author = a " +
        "WHERE a.firstName = :firstName AND a.lastName = :lastName")
    int countBookCopiesByAuthorName(String firstName, String lastName);
}
