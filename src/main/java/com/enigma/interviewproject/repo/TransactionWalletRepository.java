package com.enigma.interviewproject.repo;

import com.enigma.interviewproject.entity.TransactionWallet;
import com.enigma.interviewproject.util.TransactionType;
import com.enigma.interviewproject.util.WalletCategory;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TransactionWalletRepository extends CrudRepository<TransactionWallet, String> {
    @Query(value = "SELECT * FROM tx_wallet_transaction", nativeQuery = true)
    public List<TransactionWallet> getAllTransactionWallet();

    @Query(value = "SELECT * FROM tx_wallet_transaction WHERE id=?", nativeQuery = true)
    public TransactionWallet getById(String id);

    @Modifying
    @Query(value = "INSERT INTO tx_wallet_transaction(id, transaction_date, type, wallet_category, wallet_id) values (:id, :transaction_date, :type, :wallet_category, :wallet_id)", nativeQuery = true)
    public void createWalletTransactions(@Param("id") String id, @Param("transaction_date") Date transaction_date, @Param("type") String type, @Param("wallet_category") String wallet_category, @Param("wallet_id") String wallet_id);

//    @Modifying
//    @Query(value = "DELETE FROM tx_wallet_transaction WHERE id=?", nativeQuery = true)
//    public void deleteWalletTransactionById(String id);
//
//    @Modifying
//    @Query(value = "UPDATE tx_wallet_transaction SET transaction_date, type, wallet_category, wallet_id WHERE id=?", nativeQuery = true)
//    public void updateWalletTransaction(String id, Date transaction_date, String type, String wallet_category, String wallet_id);
}
