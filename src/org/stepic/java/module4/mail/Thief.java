package org.stepic.java.module4.mail;

/**
 * Created by vitaly on 29/09/16.
 */
public class Thief implements MailService {

    private int minValue;
    private int totalValue;

    public Thief(int minValue) {
        this.minValue = minValue;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        String to, from, content;
        int price;
        Package pkg;

        if (mail instanceof MailPackage){
            MailPackage mailPackage = (MailPackage) mail;
            to = mailPackage.getTo();
            from = mailPackage.getFrom();
            pkg = mailPackage.getContent();
            content = pkg.getContent();
            price = pkg.getPrice();

            if (price >= minValue) {
                totalValue += price;
                String newContent = "stones instead of " + content;
                Package newPkg = new Package(newContent, 0);
                MailPackage newMailPackage = new MailPackage(from, to, newPkg);
                return newMailPackage;
            }
        }
        return mail;
    }

    public int getStolenValue() { return totalValue; }


}
