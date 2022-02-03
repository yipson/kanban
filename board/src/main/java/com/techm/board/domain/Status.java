package com.techm.board.domain;

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
