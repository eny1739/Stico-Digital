package com.enigma.interviewproject.repo;

import com.enigma.interviewproject.entity.TransactionBook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionBookRepository extends CrudRepository<TransactionBook, String> {

}
