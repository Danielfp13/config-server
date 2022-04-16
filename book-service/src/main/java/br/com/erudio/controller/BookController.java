package br.com.erudio.controller;

import br.com.erudio.model.Book;
import br.com.erudio.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book-service")
@AllArgsConstructor
@Tag(name = "Book endpoint")
public class BookController {

    private BookService bookService;

    @Operation(summary = "Busca um livro especifico por ID")
    @GetMapping("/{id}/{currency}")
    public ResponseEntity<Book> findById(@PathVariable Long id, @PathVariable String currency){
       return ResponseEntity.ok().body(bookService.findById(id, currency));

    }
}
