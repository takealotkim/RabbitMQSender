package org.example;

import com.rabbitmq.client.Channel;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitMQSenderTest {

    private Channel channel = Mockito.mock(Channel.class);
    private RabbitMQSender sender;

    public RabbitMQSenderTest() throws IOException, TimeoutException {
        sender = new RabbitMQSender(channel);
    }
    @Test
    public void testSendErrors() {
        Exception exception=null;
        try {
            sender = new RabbitMQSender(channel);
            sender.send("Hello");
        }catch(Exception ex){
            exception=ex;
        }
        assertTrue(exception == null);
    }

}
