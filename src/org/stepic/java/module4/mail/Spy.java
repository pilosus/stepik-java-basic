package org.stepic.java.module4.mail;
import java.util.logging.*;

// comment this line when submitting on stepic.org
import static org.stepic.java.module4.mail.Constants.AUSTIN_POWERS;

/**
 * Created by vitaly on 29/09/16.
 */
public class Spy implements MailService {
    private final Logger logger;

    public Spy(Logger logger) {
        this.logger = logger;
        //logger.getLogger(MailMessage.class.getName());
    }

    @Override
    public Sendable processMail(Sendable mail) {
        String from;
        String to;
        String message;

        if (mail instanceof MailMessage){
            MailMessage mailMessage = (MailMessage) mail;
            to = mailMessage.getTo();
            from = mailMessage.getFrom();

            if (AUSTIN_POWERS.equals(to) || AUSTIN_POWERS.equals(from)){
                message = mailMessage.getMessage();
                logger.log(Level.WARNING,
                        "Detected target mail correspondence: from {0} to {1} \"{2}\"",
                        new Object[]{from, to, message});

            }
            else { logger.log(Level.INFO,
                    "Usual correspondence: from {0} to {1}",
                    new Object[]{from, to});
            }
        }
        return mail;
    }
}
