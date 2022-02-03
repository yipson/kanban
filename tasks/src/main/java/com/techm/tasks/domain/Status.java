package com.techm.tasks.domain;

public enum Status {
    TO_DO("To do"),
    IN_PROGRESS("In progress"),
    DONE("Done");

    private final String toString;

    private Status(String toString){
        this.toString = toString;
    }

    public String toString(){
        return toString;
    }
}
