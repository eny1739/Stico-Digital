package com.enigma.interviewproject.repo;

import com.enigma.interviewproject.entity.Wallet;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WalletRepository extends CrudRepository<Wallet, String> {

    @Query(value = "SELECT * FROM mst_wallet", nativeQuery = true)
    public List<Wallet> getAllWallet();

    @Modifying
    @Query(value = "INSERT INTO mst_wallet(id, name, balance, user_id) values (:id, :name, :balance, :user_id)", nativeQuery = true)
    public void createWallet(@Param("id") String id, @Param("name") String name, @Param("balance") Integer balance, @Param("user_id") String user_id);

    @Query(value = "SELECT * FROM mst_wallet WHERE id=?", nativeQuery = true)
    public Wallet getById(String id);

    @Modifying
    @Query(value = "UPDATE mst_wallet SET name=?, balance=?, user_id=? WHERE id=?", nativeQuery = true)
    public void updateWallet( String name, Integer balance, String user_id, String id);

    @Modifying
    @Query(value = "DELETE FROM mst_wallet WHERE id=?", nativeQuery = true)
    public void deleteById(String id);

}
