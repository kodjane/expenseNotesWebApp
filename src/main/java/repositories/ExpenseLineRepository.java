/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.io.Serializable;
import java.util.List;
import model.ExpenseLine;
import model.ExpenseType;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author AIK
 */
public interface ExpenseLineRepository extends CrudRepository<ExpenseLine, Serializable>{
    List<ExpenseLine> findByExpenseType(ExpenseType expenseType);
}
