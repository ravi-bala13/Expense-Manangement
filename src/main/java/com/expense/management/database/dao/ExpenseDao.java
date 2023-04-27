package com.expense.management.database.dao;

import com.expense.management.database.entity.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseDao extends MongoRepository<Expense, String> {
}
