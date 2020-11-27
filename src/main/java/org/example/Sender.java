package org.example;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.util.concurrent.TimeoutException;


public class Sender implements ISender {

    private static final Logger logger = LoggerFactory.getLogger(Sender.class);
    private final static String QUEUE_NAME = "hello";
    private static final String HOST = "localhost";
    private static ConnectionFactory factory = new ConnectionFactory();
    private static Channel channel;
    private Connection connection;

    public Sender() throws IOException, TimeoutException {
        init();
    }

    private void init() throws IOException, TimeoutException {
        factory.setHost(HOST);
        connection = factory.newConnection();
        channel = connection.createChannel();
    }

    public void send(String message) throws IOException {
        byte[] messageBytes = message.getBytes();
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        logger.info("sent:'" + message + "' to queue: " + QUEUE_NAME);
    }
}