package guru.springframework.springwebapp.repositories;

import guru.springframework.springwebapp.model.Author;
import guru.springframework.springwebapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
