package com.example.tareas.repository;

import com.example.tareas.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public class TransactionRepository extends JpaRepository<Transaction, Long> {
}
