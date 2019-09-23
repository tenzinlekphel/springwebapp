package guru.springframework.springwebapp.bootstrap;

import guru.springframework.springwebapp.model.Author;
import guru.springframework.springwebapp.model.Book;
import guru.springframework.springwebapp.model.Publisher;
import guru.springframework.springwebapp.repositories.AuthorRepository;
import guru.springframework.springwebapp.repositories.BookRepository;
import guru.springframework.springwebapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepsitory;


    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepsitory) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepsitory = publisherRepsitory;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        Publisher publisher = new Publisher();
        publisher.setName("FOO");
        publisher.setAddress("12th Street, LA");

        publisherRepsitory.save(publisher);

        Author tenzin = new Author("Tenzin", "Events");
        Book dd = new Book("Domain driven design", "1234", publisher);
        tenzin.getBooks().add(dd);
        dd.getAuthors().add(tenzin);

        authorRepository.save(tenzin);
        bookRepository.save(dd);



        Author rod = new Author("Rod", "Jonson");
        Book redJJ = new Book("JE22 Developmment without EJS5", "2323", publisher);
        rod.getBooks().add(redJJ);

        authorRepository.save(rod);
        bookRepository.save(redJJ);


    }
}
