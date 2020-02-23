package com.f.net.netty.helloexample;

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
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ChannelFuture future = ctx.writeAndFlush("server socket™£¢∞§¶¶π∏©√Ínetty🤪😘");
        future.addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf in = (ByteBuf) msg;
        try {
            if (in.isReadable()) logger.info("read value: {}", in.toString(CharsetUtil.UTF_8));
            ChannelFuture future = ctx.writeAndFlush(Unpooled.copiedBuffer("server socket™£¢∞§¶¶π∏©√Ínetty🤪😘", CharsetUtil.UTF_8));
            future.addListener(ChannelFutureListener.CLOSE);
        } finally {
            ReferenceCountUtil.release(in);
        }

    }
}
