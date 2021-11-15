package com.enigma.interviewproject.repo;

import com.enigma.interviewproject.entity.Book;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<Book, String> {

        @Query(value = "SELECT * FROM mst_book", nativeQuery = true)
        public List<Book> findAllBook();

        @Query(value = "SELECT * FROM mst_book WHERE id=?", nativeQuery = true)
        public Optional<Book> findById(String id);

        @Modifying
        @Query(value = "INSERT INTO mst_book(id, title, publisher, year, price, category, count) values (:id, :title, :publisher, :year, :price, :category, :count)", nativeQuery = true)
        public void createBook(@Param("id") String id,@Param("title") String title, @Param("publisher") String publisher, @Param("year") Date year, @Param("price") Integer price, @Param("category") String category, @Param("count") Integer count);

        @Modifying
        @Query(value = "UPDATE mst_book SET title=?, publisher=?, year=?, price=?, category=?, count=? WHERE id=?", nativeQuery = true)
        public void updateBook(String title, String publisher, Date year, Integer price, String category, Integer count, String id);

        @Modifying
        @Query(value = "DELETE FROM mst_book WHERE id=?", nativeQuery = true)
        public void deleteById(String id);


}
