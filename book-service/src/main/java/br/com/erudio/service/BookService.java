package br.com.erudio.service;

import br.com.erudio.model.Book;
import br.com.erudio.proxy.CambioProxy;
import br.com.erudio.repository.BookRepository;
import br.com.erudio.service.exception.ObjectNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookService {

    private BookRepository bookRepository;
    private Environment environment;
    private CambioProxy cambioProxy;

    public Book findById(Long id, String currency) {
        System.out.println(currency);
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Nao existe livro com esses dados"));


        var cambio = cambioProxy.findCambio(book.getPrice(), "USD", currency);
        book.setPrice(cambio.getBody().getConvertionValue());

        book.setEnvironment(environment.getProperty("local.server.port"));
        book.setEnvironment( "Porta book: "+environment.getProperty("local.server.port")
        + " Porta cambio" + cambio.getBody().getEnvironment());
        return book;

    }
}
