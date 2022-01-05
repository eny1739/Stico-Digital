package com.heroku.repo;

import com.heroku.entity.TransactionBook;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TransactionBookRepository extends CrudRepository<TransactionBook, String> {

    @Query(value = "SELECT * FROM tx_user_buy_books WHERE id=?", nativeQuery = true)
    public TransactionBook getTransactionBookById(String id);

    @Query(value = "SELECT * FROM tx_user_buy_books", nativeQuery = true)
    public List<TransactionBook> getAllTransactionBook();

    @Modifying
    @Query(value = "DELETE FROM tx_user_buy_books WHERE id=?", nativeQuery = true)
    public void deleteBookTransactionById(String id);

    @Modifying
    @Query(value = "UPDATE tx_user_buy_books SET count, sub_total, transaction_date, book_id, user_id WHERE id=?", nativeQuery = true)
    public void updateBookTransaction(String id, Integer count, Integer sub_total, Date transaction_date, String book_id, String user_id);

    @Modifying
    @Query(value = "INSERT INTO tx_user_buy_books(id, count, sub_total, transaction_date, book_id, user_id) values (:id, :count, :sub_total, :transaction_date, :book_id, :user_id)", nativeQuery = true)
    public void createBookTransactions(@Param("id") String id, @Param("count") Integer count, @Param("sub_total") Integer sub_total, @Param("transaction_date") Date transaction_date, @Param("book_id") String book_id, @Param("user_id") String user_id);
}
