package org.stepic.java.module4.mail;

/**
 * Created by vitaly on 29/09/16.
 * Should be static
 */

/*
Интерфейс, который задает класс, который может каким-либо образом обработать почтовый объект.
*/
public interface MailService {
    Sendable processMail(Sendable mail);
}