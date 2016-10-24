package org.stepic.java.module4.mail;

/**
 * Created by vitaly on 29/09/16.
 * Should be static
 */

/*
Класс, в котором скрыта логика настоящей почты
*/
public class RealMailService implements MailService {

    @Override
    public Sendable processMail(Sendable mail) {
        // Здесь описан код настоящей системы отправки почты.
        return mail;
    }
}