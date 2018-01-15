/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.io.Serializable;
import model.ExpenseType;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author AIK
 */
public interface ExpenseTypeRepository extends CrudRepository<ExpenseType, Serializable>{
}
