package org.stepic.java.module4.mail;

/**
 * Created by vitaly on 29/09/16.
 * Interface should be <em>static</em>.
 */

/*
Интерфейс: сущность, которую можно отправить по почте.
У такой сущности можно получить от кого и кому направляется письмо.
*/
public interface Sendable {
    String getFrom();
    String getTo();
}
