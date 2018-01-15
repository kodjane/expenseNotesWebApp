/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.io.Serializable;
import java.util.List;
import model.Expense;
import model.User;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author AIK
 */
public interface ExpenseRepository extends CrudRepository<Expense, Serializable>{
    List<Expense> findBySubmitter(User user);
    List<Expense> findByApprovalStatusAndSubmitter(String status, User user);
    List<Expense> findByApprovalStatus(String status);
}
