package com.f.net.netty.protobufexample.server;

import com.f.net.netty.protobufexample.AddressBookProtos;
import com.f.net.netty.protobufexample.MockData;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddressBookServerHandler extends ChannelInboundHandlerAdapter {
    private Logger logger = LoggerFactory.getLogger(AddressBookServerHandler.class);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        logger.info("server 读取客户发起的请求...");
        AddressBookProtos.AddressBook req = (AddressBookProtos.AddressBook) msg;
        try {
            logger.info("address book: {}", req);
            ChannelFuture channelFuture = ctx.writeAndFlush(MockData.ADDRESS_BOOK);
            channelFuture.addListener(ChannelFutureListener.CLOSE);
            logger.info("向 client 写入 address book 成功...");
        } finally {
            ReferenceCountUtil.release(req);
        }
    }
}
