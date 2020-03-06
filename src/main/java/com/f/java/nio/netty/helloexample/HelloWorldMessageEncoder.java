package com.f.java.nio.netty.helloexample;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.handler.codec.string.LineEncoder;
import io.netty.handler.codec.string.LineSeparator;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorldMessageEncoder extends MessageToByteEncoder<String> {
    private Logger logger = LoggerFactory.getLogger(HelloWorldMessageEncoder.class);

    @Override
    protected void encode(ChannelHandlerContext ctx, String msg, ByteBuf out) throws Exception {
        logger.info("class name: {}, 对 msg: {} 进行 encode", HelloWorldMessageEncoder.class.getSimpleName(), msg);
        new LineEncoder(LineSeparator.DEFAULT);
        out.writeCharSequence(msg, CharsetUtil.UTF_8);
    }
}
