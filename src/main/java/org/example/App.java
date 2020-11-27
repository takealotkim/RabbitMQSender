package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * read name from console
 * and send a message to rabbitMQ
 *
 */
public class App 
{
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main( String[] args ) throws Exception {

        System.out.println("To exit press Ctl + C");
        System.out.println("Enter a name:");
        ISender sender = new Sender();
        while(true) {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            String name = buffer.readLine();
            // Read an input string
            //System.console().readLine();
            String message = "Hello my name is, ";
            message = "Hello my name is, " + name;
            logger.info("sending message: " + message);
            // write the message to rabbit MQ
            try {
                sender.send(message);
            } catch (Exception E) {
                logger.error("Error sending message to server " + E.toString());
            }
        }
    }
}
