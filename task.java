package com.example.demo;

import java.time.LocalDate;

public class task {
    private String descripcion;
    private boolean done;
    private LocalDate dueDate;

    //constructor
    public task(String desc, boolean done, LocalDate dueDate){
        this.descripcion = desc;
        this.done = done;
        this.dueDate = dueDate;
    }

    public String getDescripcion(){
        return this.descripcion;
    }

    public void setDescripcion(String descp){
        this.descripcion = descp;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
