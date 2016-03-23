package com.rommelrico.trainings.jaxrs;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;

/**
 * Created by rommelrico on 3/22/16.
 */
public class CheckProcessorImpl {

    @POST
    @Path("/checks")
    public void processChecks(@Suspended final AsyncResponse response, final ChecksList checks) {
        new Thread() {
            public void run() {
                if (checks.getChecks() == null || checks.getChecks().size() == 0) {
                    response.resume(new BadRequestException());
                }
                response.resume(true);
            }
        }.start();
    }

}
