package bg.softuni.bookshopsystem.data.repositories;

import bg.softuni.bookshopsystem.data.entities.Book;
import bg.softuni.bookshopsystem.data.entities.enums.AgeRestriction;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    Set<Book> findAllByReleaseDateAfter(LocalDate date);


    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findAllByReleaseDateLessThanOrReleaseDateGreaterThan(LocalDate start, LocalDate end);

    BookInfo findByTitle(String title);
    @Query("UPDATE Book b " +
            "SET b.copies = b.copies + :additionalCopies " +
            "WHERE b.id = :id")
    @Modifying
    @Transactional
    int updateBookCopiesById(int id, int additionalCopies);
}
