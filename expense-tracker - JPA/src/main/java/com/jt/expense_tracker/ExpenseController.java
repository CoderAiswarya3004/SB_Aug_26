package com.jt.expense_tracker;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor

public class ExpenseController {
    
    private final ExpenseService expenseService;     
   
    @GetMapping("/expenses")
    public List<Expense> getExpenses(){
        // String sql ="Select * from %s".formatted(Expense_TABLE);
        // List<Expense> expenses = new ArrayList<>();
        // jdbcTemplate.query(sql,(resultSet)->{
        

        //     var id = resultSet.getInt("id");
        //     var title = resultSet.getString("title");
        //     var category = resultSet.getString("category");
        //     var price = resultSet.getDouble("price");
        //     var date = resultSet.getDate("date").toLocalDate(); 
        //     var desc = resultSet.getString("description") ;

        //     var expense = new Expense(id, title, category, price, date,desc);
        //     // expenses.add(expense);
        // });

        // return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Expense>(Expense.class));

        // var savedExpenses = expenseRepository.findAll();
        // return savedExpenses;

        return expenseService.getExpenses();
    }

         @GetMapping("/expenses/{id}")
        public Expense getExpensesByID(@PathVariable int id){
            // System.out.println("ID is "+ id);
            // var sql = "SELECT * FROM %s Where id =?".formatted(Expense_TABLE);
            // Expense expense = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Expense.class),id);
            // return expense;

            // Optional<Expense> optExp = expenseRepository.findById(id);

            // if(optExp.isPresent()){
            //     Expense expense = optExp.get();
            // }

            // Expense expense = optExp.orElseThrow();
            //  Expense expense = optExp.orElseThrow(() ->
            //     new RuntimeException("Unable to find Expense with id:-" + id)
            // );
            // return expense;

        //     return expenseRepository.findById(id).orElseThrow(()->
        //  new RuntimeException("Unable to find Expense with id:-" + id)
        // );

        return expenseService.getExpenseById(id);
        }

        @PostMapping("/expenses")
        @ResponseStatus(code=HttpStatus.CREATED)
        public Expense createExpense(@RequestBody Expense expense){
            // var sql = "INSERT INTO %s (title , category, price , date ) VALUES (?,?,?,?)".formatted(Expense_TABLE);
            // jdbcTemplate.update(sql,expense.getTitle(),expense.getCategory(),expense.getPrice(), expense.getDate());
            // return expense;

           return expenseService.addExpense(expense);
        }

        @DeleteMapping("/expenses/{id}")
        @ResponseStatus(value = HttpStatus.NO_CONTENT)
        public void deleteExpense(@PathVariable int id){
                // var sql = "DELETE FROM %s where id = ?".formatted(Expense_TABLE);
                // jdbcTemplate.update(sql, id);

                // Expense toBeDeletedExpense = getExpensesByID(id);
                // expenseRepository.delete(toBeDeletedExpense);

                // getExpensesByID(id);
                // expenseRepository.deleteById(id);

                expenseService.deleteExpenseById(id);
        }

        @PutMapping("/expenses")
        @ResponseStatus(HttpStatus.ACCEPTED)
        public Expense updateExpense(@RequestBody Expense expense)
        {
            // var sql = "UPDATE %s SET title=?, category = ? , price= ?, date = ? WHERE id = ? " .formatted(Expense_TABLE);
            // jdbcTemplate.update(sql,expense.getTitle(),expense.getCategory(),expense.getPrice(), expense.getDate(),expense.getId()) ;
            // Expense updatedExpense  =  getExpensesByID(expense.getId());
            // return updatedExpense;

            // getExpensesByID(expense.getId());
            // return expenseRepository.save(expense);

            return expenseService.updateExpense(expense);
        }
    }

