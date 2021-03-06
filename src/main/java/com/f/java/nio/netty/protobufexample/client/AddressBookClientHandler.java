package com.f.java.nio.netty.protobufexample.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddressBookClientHandler extends ChannelInboundHandlerAdapter {
    private Logger logger = LoggerFactory.getLogger(AddressBookClientHandler.class);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        logger.info("client received server response....");
        try {
            logger.info("msg:\n {}", msg);
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }
}
