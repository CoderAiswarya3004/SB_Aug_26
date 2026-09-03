package com.jt.expense_tracker;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
// @NoArgsConstructor
public class ExpenseController {
    
    private final JdbcTemplate jdbcTemplate; // create constructor with only final and instance variable
    private static final String Expense_TABLE = "expenses";
    
    // public ExpenseController(JdbcTemplate jdbcTemplate) {
    //     this.jdbcTemplate = jdbcTemplate;
    // }

    @RequestMapping(value="/expenses",method = RequestMethod.GET)
    public List<Expense> getExpenses(){
        String sql ="Select * from %s".formatted(Expense_TABLE);
        List<Expense> expenses = new ArrayList<>();
        jdbcTemplate.query(sql,(resultSet)->{
        //     // System.out.println("id is "+resultSet.getInt("id"));
        //     // System.out.println("title is "+resultSet.getString("title"));
        //     // System.out.println("category is "+resultSet.getString("category"));

        //     // Expense expense = new Expense();
        //     // expense.setId(resultSet.getInt("id"));

            var id = resultSet.getInt("id");
            var title = resultSet.getString("title");
            var category = resultSet.getString("category");
            var price = resultSet.getDouble("price");
            var date = resultSet.getDate("date").toLocalDate(); //typecast ?? 

            var expense = new Expense(id, title, category, price, date);
            // var expense = new Expense(id, title, category, price, date);
            expenses.add(expense);
        });

        // List<Expense> expenses = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Expense>(Expense.class));
        // expenses.add(expenses);

        // return expense;
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Expense>(Expense.class));
    }

    @RequestMapping(value="/expenses/{id}",method = RequestMethod.GET) //Dynamic Routing
        public Expense getExpensesByID(@PathVariable int id){
            // System.out.println("ID is "+ id);
            var sql = "SELECT * FROM %s Where id =?".formatted(Expense_TABLE);
            Expense expense = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Expense.class),id);
            return expense;
        }

        @RequestMapping(value="/expenses", method= RequestMethod.POST)
        public Expense createExpense(@RequestBody Expense expense){
            var sql = "INSERT INTO %s (title , category, price , date ) VALUES (?,?,?,?)".formatted(Expense_TABLE);
            jdbcTemplate.update(sql,expense.getTitle(),expense.getCategory(),expense.getPrice(), expense.getDate());
            return expense;
        }
    }

