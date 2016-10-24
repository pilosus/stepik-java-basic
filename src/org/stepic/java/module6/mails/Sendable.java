package org.stepic.java.module6.mails;

/**
 * Created by vitaly on 09/10/16.
 */
public interface Sendable<T> {
    String getFrom();
    String getTo();
    T getContent();
}
