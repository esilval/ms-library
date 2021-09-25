package com.example.adapter;

import com.example.data.BookDto;
import com.example.entity.Book;
import com.example.mapper.BookMapper;
import com.example.ports.spi.BookPersistencePort;
import com.example.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookJpaAdapter implements BookPersistencePort {

    @Autowired
    private BookRepository repository;

    @Override
    public BookDto addBook(BookDto bookDto) {
        final Book book = BookMapper.INSTANCE.bookDtoToBook(bookDto);
        return BookMapper.INSTANCE.bookToBookDto(repository.save(book));
    }

    @Override
    public void deleteBookById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public BookDto updateBook(BookDto bookDto) {
        return addBook(bookDto);
    }

    @Override
    public List<BookDto> getBooks() {
        return BookMapper.INSTANCE.bookListToBookDtoList(repository.findAll());
    }

    @Override
    public BookDto getBookById(Long id) {
        Book book = repository.findById(id).orElse(null);
        return BookMapper.INSTANCE.bookToBookDto(book);
    }
}
