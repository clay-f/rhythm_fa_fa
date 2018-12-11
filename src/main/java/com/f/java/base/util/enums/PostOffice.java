package com.f.java.base.util.enums;

import com.sun.tools.javac.Main;

public abstract class PostOffice {
    enum MailHanler {
        General_delivery {
            @Override
            boolean handler(Mail mail) {
                switch (mail.generalDelivery) {
                    case Yes:
                        System.out.println("using general delivery for " + mail);
                        return true;
                    default:
                        return false;
                }
            }
        },
        Machine_scan {
            @Override
            boolean handler(Mail mail) {
                switch (mail.scannability) {
                    case Unscannable:
                        return false;
                    default:
                        System.out.println("delivering " + mail + " automatically");
                        return true;
                }
            }
        },
        Visual_inspection {
            @Override
            boolean handler(Mail mail) {
                switch (mail.readability) {
                    case Illegible:
                        return false;
                    default:
                        System.out.println("delivering " + mail + " normally");
                        return true;
                }
            }
        },
        Return_to_sender {
            @Override
            boolean handler(Mail mail) {
                switch (mail.returnAdress) {
                    case Missing:
                        return false;
                    default:
                        System.out.println("returning " + mail + " to sender");
                        return true;
                }
            }
        };

        abstract boolean handler(Mail mail);
    }

    static void handler(Mail mail) {
        for (MailHanler hanler : MailHanler.values()) {
            if (hanler.handler(mail))
                return;
        }
        System.out.println(mail + "is a dead letter");
    }

    public static void main(String[] args) {
        for (Mail mail : Mail.generator(10)) {
            System.out.println(mail);
            handler(mail);
            System.out.println("*************************");
        }
    }

}
