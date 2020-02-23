package com.f.net.netty.protobufexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class AddressBookHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        AddressBookProtos.Person req = (AddressBookProtos.Person) msg;

        ctx.writeAndFlush(AddressBookProtos.AddressBook.newBuilder().
                addPerson(AddressBookProtos.Person.newBuilder()
                        .setId(req.getId())
                        .setName(req.getName())
                        .setEmail("tianshouzhi@126.com")
                        .build()));
    }
}
