package org.stepic.java.module6.mails;

/**
 * Created by vitaly on 09/10/16.
 */
public class Salary implements Sendable<Integer> {
    private String from;
    private String to;
    private Integer salary;

    public Salary(String from, String to, Integer salary) {
        this.from = from;
        this.to = to;
        this.salary = salary;
    }

    @Override
    public String getFrom() {
        return from;
    }

    @Override
    public String  getTo() {
        return to;
    }

    @Override
    public Integer getContent() {
        return salary;
    }

}
