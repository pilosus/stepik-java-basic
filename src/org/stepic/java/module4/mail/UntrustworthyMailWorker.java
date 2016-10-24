package org.stepic.java.module4.mail;

/**
 * Created by vitaly on 29/09/16.
 */

public class UntrustworthyMailWorker implements MailService {
    private MailService[] thirdParties;
    private RealMailService realMailService = new RealMailService();

    public UntrustworthyMailWorker(MailService[] thirdParties) {
        this.thirdParties = thirdParties;
    }

    public MailService getRealMailService() {
        return realMailService;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        for (MailService thirdParty: thirdParties){
            mail = thirdParty.processMail(mail);
        }
        return realMailService.processMail(mail);
    }
}

/*
public class UntrustworthyMailWorker implements MailService {

    private MailService[] thirdParties;
    private RealMailService realMailService;

    public UntrustworthyMailWorker(MailService[] thirdParties) {
        this.thirdParties = thirdParties;
        realMailService = new RealMailService();
    }

    public MailService getRealMailService() {
        return realMailService;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        for (MailService thirdParty: thirdParties){
            mail = thirdParty.processMail(mail);
        }
        return realMailService.processMail(mail);
    }
}
*/



