package in.psg.spring5webapp.bootstrap;

import in.psg.spring5webapp.domain.Author;
import in.psg.spring5webapp.domain.Book;
import in.psg.spring5webapp.domain.Publisher;
import in.psg.spring5webapp.repositories.AuthorRepository;
import in.psg.spring5webapp.repositories.BookRepository;
import in.psg.spring5webapp.repositories.PublisherRepository;
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

      System.out.println("Started in Bootstrap.............");

      Publisher publisherOne = new Publisher();
      publisherOne.setName("PSG Publication");
      publisherOne.setCity("Bangalore");
      publisherOne.setState("Karnataka");
      publisherOne.setAddressLine1("Railway Colony");

      Publisher publisherTwo = new Publisher();
      publisherTwo.setName("TBW Publication");
      publisherTwo.setCity("Bhubaneswar");
      publisherTwo.setState("Odisha");
      publisherTwo.setAddressLine1("VSS Nagar");

      publisherRepository.save(publisherOne);
      publisherRepository.save(publisherTwo);


      Author eric = new Author("Eric","Evans");
      Book ddd = new Book("Domain Driven Design","123123");
      eric.getBooks().add(ddd);
      ddd.getAuthors().add(eric);
      ddd.setPublisher(publisherOne);
      publisherOne.getBooks().add(ddd);

      authorRepository.save(eric);
      bookRepository.save(ddd);
      publisherRepository.save(publisherOne);


      Author rod = new Author("Rod","Johnson");
      Book noEJB = new Book("J2EE Development without EJB","1234556");
      rod.getBooks().add(noEJB);
      noEJB.getAuthors().add(rod);
      noEJB.setPublisher(publisherTwo);
      publisherTwo.getBooks().add(noEJB);

      authorRepository.save(rod);
      bookRepository.save(noEJB);
      publisherRepository.save(publisherTwo);


      System.out.println("Number of books: "+bookRepository.count());
      System.out.println("Number of publisher: "+publisherRepository.count());




   }
}
