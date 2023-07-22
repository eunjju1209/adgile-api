package com.adgile.repository;

import com.adgile.domain.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BudgetRepository extends JpaRepository<Budget, Long>, BudgetCustom {
}
