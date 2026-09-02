package com.jt.expense_tracker;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Expense {
    private int id;
    private String title;
    private String Category;
    private double price;
    private LocalDate date;
    
    // public Expense() {
    // }

    // public Expense(int id, String title, String category, double price, LocalDate date) {
    //     this.id = id;
    //     this.title = title;
    //     Category = category;
    //     this.price = price;
    //     this.date = date;
    // }


    // public int getId() {
    //     return id;
    // }
    // public void setId(int id) {
    //     this.id = id;
    // }
    // public String getTitle() {
    //     return title;
    // }
    // public void setTitle(String title) {
    //     this.title = title;
    // }
    // public String getCategory() {
    //     return Category;
    // }
    // public void setCategory(String category) {
    //     Category = category;
    // }
    // public double getPrice() {
    //     return price;
    // }
    // public void setPrice(double price) {
    //     this.price = price;
    // }
    // public LocalDate getDate() {
    //     return date;
    // }
    // public void setDate(LocalDate date) {
    //     this.date = date;
    // }    
}
