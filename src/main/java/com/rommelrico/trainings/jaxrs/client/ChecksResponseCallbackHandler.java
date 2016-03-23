package com.rommelrico.trainings.jaxrs.client;

import javax.ws.rs.client.InvocationCallback;

/**
 * Created by rommelrico on 3/22/16.
 */
public class ChecksResponseCallbackHandler implements InvocationCallback<Boolean> {
    @Override
    public void completed(Boolean response) {
        System.out.println("Success: "+response);
    }

    @Override
    public void failed(Throwable e) {
        e.printStackTrace();
    }
}
