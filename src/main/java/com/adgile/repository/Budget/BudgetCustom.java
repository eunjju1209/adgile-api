package com.adgile.repository.Budget;

import com.adgile.domain.Budget;
import com.adgile.domain.conditional.BudgetConditional;

import java.util.Optional;

public interface BudgetCustom {

	Optional<Budget> findBudget(BudgetConditional where);
}
