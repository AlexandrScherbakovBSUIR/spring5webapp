package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrap implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

       Author peter = new Author("Peter","Betterhofvn");
       Book  dsp = new Book("Double Simple person","si soleto si italis");
       Author sviter = new Author("Sviter","Fon Shnobel");
       Book dvp = new Book("Development versus programer","just a pain");

       peter.getBooks().add(dsp);
       dsp.getAuthors().add(peter);
       sviter.getBooks().add(dvp);
       dvp.getAuthors().add(sviter);


       authorRepository.save(peter);
       authorRepository.save(sviter);
       bookRepository.save(dvp);
       bookRepository.save(dsp);

       System.out.println("Started in Bootstrap");
       System.out.println("Number of books: " + bookRepository.count());

    }
}
