package com.jt.expense_tracker;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor

public class ExpenseController {
    
    private final JdbcTemplate jdbcTemplate; 
    private static final String Expense_TABLE = "expenses";
    
   
    @GetMapping("/expenses")
    public List<Expense> getExpenses(){
        String sql ="Select * from %s".formatted(Expense_TABLE);
        List<Expense> expenses = new ArrayList<>();
        jdbcTemplate.query(sql,(resultSet)->{
        

            var id = resultSet.getInt("id");
            var title = resultSet.getString("title");
            var category = resultSet.getString("category");
            var price = resultSet.getDouble("price");
            var date = resultSet.getDate("date").toLocalDate(); 
            var desc = resultSet.getString("description") ;

            var expense = new Expense(id, title, category, price, date,desc);
            // expenses.add(expense);
        });

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Expense>(Expense.class));
    }

         @GetMapping("/expenses/{id}")
        public Expense getExpensesByID(@PathVariable int id){
            // System.out.println("ID is "+ id);
            var sql = "SELECT * FROM %s Where id =?".formatted(Expense_TABLE);
            Expense expense = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Expense.class),id);
            return expense;
        }

        @PostMapping("/expenses")
        public Expense createExpense(@RequestBody Expense expense){
            var sql = "INSERT INTO %s (title , category, price , date ) VALUES (?,?,?,?)".formatted(Expense_TABLE);
            jdbcTemplate.update(sql,expense.getTitle(),expense.getCategory(),expense.getPrice(), expense.getDate());
            return expense;
        }

        @DeleteMapping("/expenses/{id}")
        public void deleteExpense(@PathVariable int id){
                var sql = "DELETE FROM %s where id = ?".formatted(Expense_TABLE);
                jdbcTemplate.update(sql, id);
        }

        @PutMapping("/expenses")
        public Expense updateExpense(@RequestBody Expense expense)
        {
            var sql = "UPDATE %s SET title=?, category = ? , price= ?, date = ? WHERE id = ? " .formatted(Expense_TABLE);
            jdbcTemplate.update(sql,expense.getTitle(),expense.getCategory(),expense.getPrice(), expense.getDate(),expense.getId()) ;
            Expense updatedExpense  =  getExpensesByID(expense.getId());
            return updatedExpense;
        }
    }

