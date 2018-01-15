/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author AIK
 */
@Entity
@Table(name = "user")
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")})
public class User implements Serializable {
    
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "userid")
    private Long userId;
    
    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 30)
    @Column(name = "email")
    private String email;
    
    @Column(name = "enabled")
    private Integer enabled;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "password")
    private String password;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "username")
    private String userName;
    
    @JsonBackReference
    @OneToMany(mappedBy = "submitter")
    private List<Expense> expenseSubmited;
   
    @JsonBackReference
    @OneToMany(mappedBy = "approver")
    private List<Expense> expenseApproved;

    public User() {
    }

   

    public User(Long userId, String password, String userName) {
        this.userId = userId;
        this.password = password;
        this.userName = userName;
    }
    
    public User(User user) {
        
        this.userId = user.userId;
        this.userName = user.userName;
        this.email = user.email;        
        this.password = user.password;
        this.enabled = user.enabled;        
    
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Expense> getExpenseSubmited() {
        return expenseSubmited;
    }

    public void setExpenseSubmited(List<Expense> expenseSubmited) {
        this.expenseSubmited = expenseSubmited;
    }

    public List<Expense> getExpenseApproved() {
        return expenseApproved;
    }

    public void setExpenseApproved(List<Expense> expenseApproved) {
        this.expenseApproved = expenseApproved;
    }
    
    public String toString() {
	    return "[" + userId + " " + email + "]";
	}
    
 
}
