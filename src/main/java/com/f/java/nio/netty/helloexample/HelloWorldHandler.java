package com.f.java.nio.netty.helloexample;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorldHandler extends ChannelInboundHandlerAdapter {
    private Logger logger = LoggerFactory.getLogger(HelloWorldHandler.class);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf in = (ByteBuf) msg;
        try {
            if (in.isReadable()) logger.info("read value: {}", in.toString(CharsetUtil.UTF_8));
            ChannelFuture future = ctx.writeAndFlush(Unpooled.copiedBuffer("server hello", CharsetUtil.UTF_8));
//            future.addListener(ChannelFutureListener.CLOSE);
        } finally {
            ReferenceCountUtil.release(in);
        }
    }
}
