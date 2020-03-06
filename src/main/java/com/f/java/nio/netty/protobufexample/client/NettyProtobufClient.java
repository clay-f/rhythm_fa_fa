package com.f.java.nio.netty.protobufexample.client;

import com.f.java.nio.netty.protobufexample.AddressBookProtos;
import com.f.java.nio.netty.protobufexample.MockData;
import com.f.java.nio.netty.protobufexample.server.HeartHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleStateHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class NettyProtobufClient {
    public static void main(String[] args) throws InterruptedException {
        Logger logger = LoggerFactory.getLogger(NettyProtobufClient.class);
        NioEventLoopGroup worker = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        NioSocketChannel nioSocketChannel = null;
        try {
            ChannelFuture channelFuture = bootstrap.group(worker)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.SO_KEEPALIVE, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(
                                    new ProtobufVarint32FrameDecoder(), new ProtobufDecoder(AddressBookProtos.AddressBook.getDefaultInstance()),
                                    new AddressBookClientHandler(),
                                    new ProtobufVarint32LengthFieldPrepender(), new ProtobufEncoder(),
                                    new IdleStateHandler(0l, 0l, 10l, TimeUnit.SECONDS),
                                    new HeartHandler(),
                                    new LoggingHandler(LogLevel.INFO));
                        }
                    }).connect("127.0.0.1", 49157).sync();
            nioSocketChannel = (NioSocketChannel) channelFuture.channel();
            nioSocketChannel.writeAndFlush(MockData.ADDRESS_BOOK);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            worker.shutdownGracefully();
        }
    }
}
