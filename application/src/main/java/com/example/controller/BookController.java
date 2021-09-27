package com.example.controller;

import com.example.data.BookDto;
import com.example.ports.api.BookServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BookController implements IBookController {

    private final BookServicePort bookServicePort;

    public ResponseEntity<BookDto> addBook(final BookDto bookDto) {
        return ResponseEntity.ok(bookServicePort.addBook(bookDto));
    }

    public ResponseEntity<BookDto> updateBook(final BookDto bookDto) {
        return ResponseEntity.ok(bookServicePort.updateBook(bookDto));
    }

    public ResponseEntity<BookDto> getBookById(final Long id) {
        return ResponseEntity.ok(bookServicePort.getBookById(id));
    }

    public ResponseEntity<List<BookDto>> getAllBooks() {
        return ResponseEntity.ok(bookServicePort.getBooks());
    }

    public ResponseEntity<Void> deleteBookById(final Long id) {
        bookServicePort.deleteBookById(id);
        return ResponseEntity.ok().build();
    }

}
