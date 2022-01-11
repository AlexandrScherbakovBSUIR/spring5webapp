package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapDataForPublisher implements CommandLineRunner {

    private final PublisherRepository publisherRepository;

    public BootStrapDataForPublisher(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher pablo = new Publisher("Pablo","IZ kabaro","Columbia","New Stanford","New Orlean","220123");

        System.out.println("Started in "+BootStrapDataForPublisher.class.getName());
        System.out.println(pablo.toString());
    }
}
