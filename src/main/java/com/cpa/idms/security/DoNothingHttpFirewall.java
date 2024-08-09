package com.cpa.idms.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.web.firewall.*;
import org.springframework.stereotype.Component;

@Component
public class DoNothingHttpFirewall implements HttpFirewall {

    public FirewalledRequest getFirewalledRequest(HttpServletRequest request) throws RequestRejectedException {
        return new MyFirewalledRequest(request);
    }

    public HttpServletResponse getFirewalledResponse(HttpServletResponse response) {
        return response;
    }

    private static class MyFirewalledRequest extends FirewalledRequest {
         MyFirewalledRequest(HttpServletRequest r) {
             super(r);
         }
         public void reset() {}
    }
}
