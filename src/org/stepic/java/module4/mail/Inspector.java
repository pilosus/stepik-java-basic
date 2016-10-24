package org.stepic.java.module4.mail;

import static org.stepic.java.module4.mail.Constants.BANNED_SUBSTANCE;
import static org.stepic.java.module4.mail.Constants.WEAPONS;

/**
 * Created by vitaly on 30/09/16.
 */
public class Inspector implements MailService {

    @Override
    public Sendable processMail(Sendable mail) {
        String content;
        Package pkg;

        if (mail instanceof MailPackage) {
            MailPackage mailPackage = (MailPackage) mail;
            pkg = mailPackage.getContent();
            content = pkg.getContent();
            if (content.contains(WEAPONS) || content.contains(BANNED_SUBSTANCE)) {
                throw new IllegalPackageException();
            }
            if (content.contains("stones")) {
                throw new StolenPackageException();
            }
        }

        return mail;
    }
}
