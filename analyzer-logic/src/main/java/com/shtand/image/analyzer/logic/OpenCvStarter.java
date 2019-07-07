package com.shtand.image.analyzer.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class OpenCvStarter {

    private static final Logger log = LoggerFactory.getLogger(OpenCvStarter.class);
    private static boolean loaded;
    private static Object mutex = new Object();

    public static void init() {

        synchronized (mutex) {
            if (loaded) {
                log.info("openCV playground loaded already");
                return;
            }
            log.warn("Init openCV playground");
            nu.pattern.OpenCV.loadShared();
            System.loadLibrary(org.opencv.core.Core.NATIVE_LIBRARY_NAME);
            log.warn("openCV playground loaded");
            loaded = true;
        }
    }
}
