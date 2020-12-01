package org.example;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class RabbitMQConfigurationTest {

    private RabbitMQConfiguration configuration;

    @Test
    public void constructorTest(){
        configuration = new RabbitMQConfiguration("localhost", "hello");
        assertTrue("hello".equals(configuration.getQueue()));
        assertTrue("localhost".equals(configuration.getHost()));
    }



}
