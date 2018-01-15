/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.util.List;
import model.User;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Kodjane Aime Dieudonne
 */
public interface UserRepository  extends CrudRepository<User, Long> {
  public User findByUserName(String username);
  User findByUserId(Long id);
}
