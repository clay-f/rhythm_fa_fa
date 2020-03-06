package com.f.java.nio.netty.protobufexample;

import com.google.common.collect.Lists;

public class MockData {
    public static final AddressBookProtos.AddressBook ADDRESS_BOOK = AddressBookProtos.AddressBook.newBuilder()
            .addPerson(AddressBookProtos.Person.newBuilder()
                    .setId(1234)
                    .setName("John Doe")
                    .setEmail("jdoe@example.com")
                    .addAllPhone(Lists.newArrayList(
                            AddressBookProtos.Person.PhoneNumber.newBuilder()
                                    .setNumber("555-4321")
                                    .setType(AddressBookProtos.Person.PhoneType.HOME).build(),
                            AddressBookProtos.Person.PhoneNumber.newBuilder().setNumber("555-4311")
                                    .setType(AddressBookProtos.Person.PhoneType.WORK).build()))
                    .build())
            .build();

    public static void main(String[] args) {
        System.out.println(ADDRESS_BOOK);
    }

}
