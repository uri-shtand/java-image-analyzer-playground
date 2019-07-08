package com.shtand.image.analyzer.logic.opencv;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class OpenCvPlayground {

    private static final Logger log = LoggerFactory.getLogger(OpenCvPlayground.class);

    public Mat convertToGrayscale(Mat image) {
        log.info("Converting image with {} total and {} channels  to grayscale", image.total(), image.channels());
        Mat grayImage = new Mat();
        Imgproc.cvtColor(image, grayImage, Imgproc.COLOR_BGR2GRAY);
        return grayImage;
    }

}
