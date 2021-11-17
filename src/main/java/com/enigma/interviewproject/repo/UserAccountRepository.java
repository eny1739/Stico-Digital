package com.enigma.interviewproject.repo;

import com.enigma.interviewproject.entity.UserAccount;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserAccountRepository extends CrudRepository<UserAccount, String> {

    @Query(value = "SELECT * FROM mst_user", nativeQuery = true)
    public List<UserAccount> getAllUser();

    @Query(value = "SELECT * FROM mst_user WHERE id=?", nativeQuery = true)
    public UserAccount getById(String id);

    @Modifying
    @Query(value = "INSERT INTO mst_user(id, name, email, phone_number, address, mother_name, account_number, username, password) values (:id, :name, :email, :phone_number, :address, :mother_name, :account_number, :username, :password)", nativeQuery = true)
    public void createUser(@Param("id") String id, @Param("name") String name, @Param("email") String email, @Param("phone_number") String phone_number, @Param("address") String address, @Param("mother_name") String mother_name, @Param("account_number") String account_number, @Param("username") String username, @Param("password") String password);

    @Modifying
    @Query(value = "UPDATE mst_user SET name=?, email=?, phone_number=?, address=?, mother_name=?, account_number=?, username=?, password=? WHERE id=?", nativeQuery = true)
    public void updateBook(String id,String name, String email, String phone_number, String address, String mother_name, String account_number, String username, String password);

    @Modifying
    @Query(value = "DELETE FROM mst_user WHERE id=?", nativeQuery = true)
    public void deleteById(String id);

    @Query(value = "SELECT * FROM mst_user WHERE username=?", nativeQuery = true)
    public Optional<UserAccount> getUsernameUser(String username);

    @Modifying
    @Query(value = "INSERT INTO mst_user(id, username, password) values(:id, :username, :password)", nativeQuery = true)
    public void registerAccount(@Param("id") String id, @Param("username") String name, @Param("password") String password);

}
