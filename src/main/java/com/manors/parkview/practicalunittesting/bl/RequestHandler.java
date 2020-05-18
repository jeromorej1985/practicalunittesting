package com.manors.parkview.practicalunittesting.bl;

import com.manors.parkview.practicalunittesting.exception.InvalidRequestException;

public class RequestHandler {
    private final RequestProcessor requestProcessor;

    public RequestHandler(RequestProcessor requestProcessor){
        this.requestProcessor = requestProcessor;
    }

    public void handle(Request request)  throws InvalidRequestException {
        if(invalidRequest(request)){
            throw new InvalidRequestException(null, null);
        }
        requestProcessor.process(request);
    }

    private boolean invalidRequest(Request request) {
        if(null == request){
            return true;
        }
        return false;
    }
}