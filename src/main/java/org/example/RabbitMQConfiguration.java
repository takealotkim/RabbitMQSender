package org.example;

public class RabbitMQConfiguration{
    private String host = "localhost";
    private String queue = "messages";

    public RabbitMQConfiguration(){
    }

    public RabbitMQConfiguration(String host, String queue){
        this.host = host;
        this.queue = queue;
    }

    public String getHost(){
        return this.host;
    }
    public String getQueue(){
        return this.queue;
    }
}
