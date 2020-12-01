package org.example;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.util.concurrent.TimeoutException;


public class RabbitMQSender {

    private static final Logger logger = LoggerFactory.getLogger(RabbitMQSender.class);
    private RabbitMQConfiguration server;
    private static ConnectionFactory factory = new ConnectionFactory();
    private static Channel channel;
    private Connection connection;

    public RabbitMQSender() throws IOException, TimeoutException {
        init();
    }

    private void init() throws IOException, TimeoutException {
        server = new RabbitMQConfiguration();
        connection = factory.newConnection();
        channel = connection.createChannel();
    }

    public void send(String message) throws IOException {
        byte[] messageBytes = message.getBytes();
        channel.basicPublish("", server.getQueue(), null, messageBytes);
    }
}