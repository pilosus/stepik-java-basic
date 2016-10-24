package org.stepic.java.module6.mails;

/**
 * Created by vitaly on 09/10/16.
 */
public class MailMessage implements Sendable<String> {

    private String from;
    private String to;
    private String content;

    public MailMessage(String from, String to, String content) {
        this.from = from;
        this.to = to;
        this.content = content;
    }

    @Override
    public String getFrom() { return from; }

    @Override
    public String getTo() { return to; }

    @Override
    public String getContent() { return content; }
}
