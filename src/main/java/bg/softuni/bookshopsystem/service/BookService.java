package bg.softuni.bookshopsystem.service;

import bg.softuni.bookshopsystem.data.entities.enums.AgeRestriction;
import bg.softuni.bookshopsystem.data.repositories.BookInfo;

import java.io.IOException;
import java.util.List;

public interface BookService {

    void seedBooks() throws IOException;

    List<String> findAllBooksAfterYear2000();

    List<String> findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<String> findTitlesForBooksNotPublishedIn(int i);

    BookInfo findInfoByTitle(String title);

    void sellCopies(int bookId, int copiesSold);
}
