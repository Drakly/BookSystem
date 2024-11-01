package bg.softuni.bookshopsystem;

import bg.softuni.bookshopsystem.data.entities.enums.AgeRestriction;
import bg.softuni.bookshopsystem.data.repositories.BookInfo;
import bg.softuni.bookshopsystem.service.AuthorService;
import bg.softuni.bookshopsystem.service.BookService;
import bg.softuni.bookshopsystem.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final AuthorService authorService;

    private final CategoryService categoryService;

    private final BookService bookService;

    public CommandLineRunnerImpl(AuthorService authorService, CategoryService categoryService, BookService bookService) {
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.bookService = bookService;
    }


    @Override
    public void run(String... args) throws Exception {
        SeedData();


//        printBooksByAgeRestriction();

//        printBooksNotIssuedAt();

//        printTotalBookCopiesForAuthor();

//        printBookProjection();

        updateBookCopiesById();
    }

    private void updateBookCopiesById() {
        bookService.sellCopies(1, 1200);
    }

    private void printBookProjection() {
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();

        BookInfo info = bookService.findInfoByTitle(title);

        System.out.println(info);
    }

    private void printTotalBookCopiesForAuthor() {
        Scanner scanner = new Scanner(System.in);
        String[] authorName = scanner.nextLine().split(" ");

        int count = authorService.getTotalCopiesCountFor(authorName[0], authorName[1]);

        System.out.printf("%s %s %d", authorName[0], authorName[1], count);
    }

    private void printBooksNotIssuedAt() {
        List<String> titles = bookService.findTitlesForBooksNotPublishedIn(2000);

        titles.forEach(System.out::println);
    }

    private void SeedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }

    private void printBooksByAgeRestriction(){
        Scanner scanner = new Scanner(System.in);

        String restriction = scanner.nextLine();

        try {
            AgeRestriction ageRestriction = AgeRestriction.valueOf(restriction.toUpperCase());
            List<String> titles = bookService.findAllByAgeRestriction(ageRestriction);

            titles.forEach(t -> System.out.println(t));

        }catch (IllegalArgumentException ex) {
            System.out.println("Wrong age category");
            return;
        }


    }


}
