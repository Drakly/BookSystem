package bg.softuni.bookshopsystem.data.repositories;

import bg.softuni.bookshopsystem.data.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Set;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    Set<Author> findAllByBooksReleaseDateBefore(LocalDate releaseDate);
}