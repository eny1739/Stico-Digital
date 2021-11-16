package com.enigma.interviewproject.repo;

import com.enigma.interviewproject.entity.TransactionBook;
import com.enigma.interviewproject.entity.TransactionWallet;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface TransactionBookRepository extends CrudRepository<TransactionBook, String> {

    @Query(value = "SELECT * FROM tx_user_buy_books WHERE id=?", nativeQuery = true)
    public TransactionBook getById(String id);

    @Modifying
    @Query(value = "INSERT INTO tx_user_buy_books(id, count, sub_total, transaction_date, book_id, user_id) values (:id, :count, :sub_total, :transaction_date, :book_id, :user_id)", nativeQuery = true)
    public void createBookTransactions(@Param("id") String id, @Param("count") Integer count, @Param("sub_total") Integer sub_total, @Param("transaction_date") Date transaction_date, @Param("book_id") String book_id, @Param("user_id") String user_id);
}
