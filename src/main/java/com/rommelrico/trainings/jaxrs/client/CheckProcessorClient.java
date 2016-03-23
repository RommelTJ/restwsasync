package com.rommelrico.trainings.jaxrs.client;

import com.rommelrico.trainings.jaxrs.Check;
import com.rommelrico.trainings.jaxrs.ChecksList;
import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by rommelrico on 3/22/16.
 */
public class CheckProcessorClient {

    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/services/checkservice/checks");


        AsyncInvoker asyncInvoker = target.request().async();
        /* Do this if you don't care the order it comes back */
        ChecksList checksList = new ChecksList();
        ArrayList<Check> checks = new ArrayList<Check>();
        checks.add(new Check());
        checksList.setChecks(checks);
        Future<Boolean> future = asyncInvoker.post(Entity.entity(checksList, MediaType.APPLICATION_ATOM_XML),
                new ChecksResponseCallbackHandler());
        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        /* Do this is you care about the order you want */
//        Future<Boolean> future = asyncInvoker.post(Entity.entity(new ChecksList(), MediaType.APPLICATION_ATOM_XML), Boolean.class);
//        try {
//            System.out.println(future.get());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            if (e.getCause() instanceof BadRequestException) {
//                BadRequestException badRequestException = (BadRequestException) e.getCause();
//                System.out.println("Checks should be provided");
//            }
//            e.printStackTrace();
//        }
    }
}
