package com.f.java.base.util.enums;

import java.util.Iterator;

public class Mail {
    public enum GeneralDelivery {
        Yes, No1, No2, No3, No4
    }

    public enum Scannability {
        Unscannable, Yes1, Yes2, Yes3, Yes4
    }

    public enum Readability {
        Illegible, Yes1, Yes2, Yes3, Yes4
    }

    public enum Address {
        Incorrect, Ok1, Ok2, Ok3, Ok4, Ok5, Ok6
    }

    public enum ReturnAdress {
        Missing, Ok1, Ok2, Ok3, Ok4, Ok5
    }

    public GeneralDelivery generalDelivery;
    public Scannability scannability;
    public Readability readability;
    public Address address;
    public ReturnAdress returnAdress;
    public static long counter = 0;
    public long id = counter++;

    public static Mail randomMail() {
        Mail mail = new Mail();
        mail.generalDelivery = Enums.random(GeneralDelivery.values());
        mail.scannability = Enums.random(Scannability.values());
        mail.readability = Enums.random(Readability.values());
        mail.address = Enums.random(Address.values());
        mail.returnAdress = Enums.random(ReturnAdress.values());
        return mail;
    }

    public static Iterable<Mail> generator(final int count) {
        return new Iterable<Mail>() {
            int n = count;

            @Override
            public Iterator<Mail> iterator() {

                return new Iterator<Mail>() {
                    @Override
                    public boolean hasNext() {
                        return n-- > 0;
                    }

                    @Override
                    public Mail next() {
                        return randomMail();
                    }
                };
            }
        };
    }
}
