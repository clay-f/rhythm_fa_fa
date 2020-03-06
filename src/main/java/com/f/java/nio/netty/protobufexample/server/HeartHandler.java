package com.f.java.nio.netty.protobufexample.server;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HeartHandler extends ChannelInboundHandlerAdapter {
    private Logger logger = LoggerFactory.getLogger(HeartHandler.class);

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        logger.info("get heart handler: {}", evt);
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent idleStateEvent = (IdleStateEvent) evt;
            if (idleStateEvent.state() == IdleState.WRITER_IDLE || idleStateEvent.state() == IdleState.ALL_IDLE) {
                ctx.writeAndFlush(Unpooled.copiedBuffer("server heart beat message\n".getBytes()));
            }
        } else {
            super.userEventTriggered(ctx, evt);
        }
    }
}
