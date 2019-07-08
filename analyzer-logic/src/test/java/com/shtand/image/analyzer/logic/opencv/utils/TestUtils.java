package com.shtand.image.analyzer.logic.opencv.utils;

import org.apache.commons.io.IOUtils;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;

public class TestUtils {
    private static final Logger log = LoggerFactory.getLogger(TestUtils.class);

    public static Mat readImageFromResource(String resourceName) {
        try {
            URL resource = TestUtils.class.getResource(resourceName);
            log.info("Loading image from {}", resource.getFile());
            byte[] bytes = IOUtils.toByteArray(resource);
            return Imgcodecs.imdecode(new MatOfByte(bytes), Imgcodecs.CV_LOAD_IMAGE_UNCHANGED);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read image from resource", e);
        }
    }

}
