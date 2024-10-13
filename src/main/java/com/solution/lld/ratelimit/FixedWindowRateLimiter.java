package com.solution.lld.ratelimit;

import java.util.HashMap;
import java.util.Map;

public class FixedWindowRateLimiter extends AbstractRateLimiter{
    private Map<String, Integer> requestCounts;
    private Map<String, Long> windowStartTimes;

    public FixedWindowRateLimiter(int maxRequests, long windowSizeInMilliseconds) {
        super(maxRequests, windowSizeInMilliseconds);
        this.requestCounts = new HashMap<>();
        this.windowStartTimes = new HashMap<>();
    }

    @Override
    public boolean isRequestAllowed(String clientId) {
        long currentTimeInMilliseconds = System.currentTimeMillis();
        windowStartTimes.putIfAbsent(clientId, currentTimeInMilliseconds);
        requestCounts.putIfAbsent(clientId, 0);

        long windowStartTime = windowStartTimes.get(clientId);
        if(currentTimeInMilliseconds - windowStartTime >= windowSizeInMilliseconds){
            windowStartTimes.putIfAbsent(clientId, currentTimeInMilliseconds);
            requestCounts.putIfAbsent(clientId, 0);
        }

        int requestCount = requestCounts.get(clientId);
        if(requestCount < maxRequests){
            requestCounts.put(clientId, requestCount+1);
            return true;
        }
        return false;
    }
}
