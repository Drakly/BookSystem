package bg.softuni.bookshopsystem.service;

import bg.softuni.bookshopsystem.data.entities.enums.AgeRestriction;

import java.io.IOException;
import java.util.List;

public interface BookService {

    void seedBooks() throws IOException;

    List<String> findAllBooksAfterYear2000();

    List<String> findAllByAgeRestriction(AgeRestriction ageRestriction);
}
