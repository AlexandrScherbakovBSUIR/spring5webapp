package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

       System.out.println("Started in Bootstrap");

       Author peter = new Author("Peter","Betterhofvn");
       Book  dsp = new Book("Double Simple person","si soleto si italis");
       Author sviter = new Author("Sviter","Fon Shnobel");
       Book dvp = new Book("Development versus programer","just a pain");
       Publisher pablo = new Publisher("Pablo","IZ kabaro","Columbia","New Stanford","New Orlean","220123");

       publisherRepository.save(pablo);

       dsp.setPublisher(pablo);
       pablo.getBooks().add(dsp);
       peter.getBooks().add(dsp);
       dsp.getAuthors().add(peter);

       authorRepository.save(peter);
       bookRepository.save(dsp);
       publisherRepository.save(pablo);

       pablo.getBooks().add(dvp);
       dvp.setPublisher(pablo);
       sviter.getBooks().add(dvp);
       dvp.getAuthors().add(sviter);

       authorRepository.save(sviter);
       bookRepository.save(dvp);
       publisherRepository.save(pablo);

       System.out.println("Number of books: " + bookRepository.count());
       System.out.println("pablo info: " + pablo.getBooks().size());

    }
}
