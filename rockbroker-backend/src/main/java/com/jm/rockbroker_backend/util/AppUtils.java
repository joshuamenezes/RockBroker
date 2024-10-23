package com.jm.rockbroker_backend.util;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class AppUtils {

    // Static method to check if the app is running in debug mode
    public static boolean isDebugMode(Environment environment) {
        String[] activeProfiles = environment.getActiveProfiles();
        for (String profile : activeProfiles) {
            if ("dev".equals(profile) || "debug".equals(profile)) {
                return true;
            }
        }
        return false;
    }
}
