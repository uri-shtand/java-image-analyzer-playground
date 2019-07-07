package com.shtand.image.analyzer.logic.opencv;

import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.objdetect.CascadeClassifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class OpenCvPlayground {

    private static final Logger log = LoggerFactory.getLogger(OpenCvPlayground.class);
    private static final String haarCascade = "/classifiers/haarcascade_frontalface_alt.xml";

    private CascadeClassifier faceCascade;

    public OpenCvPlayground() {
        log.warn("Init openCV playground");
        nu.pattern.OpenCV.loadShared();
        System.loadLibrary(org.opencv.core.Core.NATIVE_LIBRARY_NAME);
        log.warn("openCV playground loaded");
        faceCascade = loadHaarcascade();
    }

    private CascadeClassifier loadHaarcascade() {
        CascadeClassifier cascadeClassifier = new CascadeClassifier();
        String file = OpenCvPlayground.class.getResource(haarCascade).getFile();
        cascadeClassifier.load(file);
        log.warn("haarCascade loaded");
        return cascadeClassifier;
    }

    public Mat loadImageToMatrix(byte[] bytes) {
        Mat mat = Imgcodecs.imdecode(new MatOfByte(bytes), Imgcodecs.CV_LOAD_IMAGE_UNCHANGED);
        return mat;
    }
}
