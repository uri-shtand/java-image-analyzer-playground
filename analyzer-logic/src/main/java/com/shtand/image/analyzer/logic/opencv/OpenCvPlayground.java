package com.shtand.image.analyzer.logic.opencv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class OpenCvPlayground {

    private static final Logger log = LoggerFactory.getLogger(OpenCvPlayground.class);

    public OpenCvPlayground() {
        log.warn("Init openCV playground");
        nu.pattern.OpenCV.loadShared();
        System.loadLibrary(org.opencv.core.Core.NATIVE_LIBRARY_NAME);
        log.warn("openCV playground loaded");
    }

}
