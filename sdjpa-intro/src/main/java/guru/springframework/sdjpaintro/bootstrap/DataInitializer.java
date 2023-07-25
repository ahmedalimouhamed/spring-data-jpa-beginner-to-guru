package guru.springframework.sdjpaintro.bootstrap;

import guru.springframework.sdjpaintro.domain.Book;
import guru.springframework.sdjpaintro.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Book book1 = new Book("Domain Driven design", "123",  "RandomHouse");
        Book book2 = new Book("Spring in action", "321",  "testohouse");

        Book savedBook1 = bookRepository.save(book1);
        System.out.println("id : "+savedBook1.getId());
        Book savedBook2 = bookRepository.save(book2);
        System.out.println("id : "+savedBook2.getId());

        bookRepository.findAll().forEach(book -> {
            System.out.println("Book Id : "+book.getId());
            System.out.println("Book title : "+book.getTitle());
        });
    }
}
