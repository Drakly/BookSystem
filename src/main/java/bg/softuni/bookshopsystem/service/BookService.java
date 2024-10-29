package bg.softuni.bookshopsystem.service;

import java.io.IOException;
import java.util.List;

public interface BookService {

    void seedBooks() throws IOException;

    List<String> findAllBooksAfterYear2000();
}
