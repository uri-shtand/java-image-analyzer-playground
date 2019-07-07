package com.shtand.image.analyzer.logic.opencv;

import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.imgproc.Imgproc;
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
        faceCascade = loadHaarcascade();
    }

    private CascadeClassifier loadHaarcascade() {
        CascadeClassifier cascadeClassifier = new CascadeClassifier();
        String file = OpenCvPlayground.class.getResource(haarCascade).getFile();
        cascadeClassifier.load(file);
        log.warn("haarCascade loaded");
        return cascadeClassifier;
    }

    public Mat convertToGrayscale(Mat image) {
        Mat grayImage = new Mat();
        Imgproc.cvtColor(image, grayImage, Imgproc.COLOR_BGR2GRAY);
        return grayImage;
    }

    public void detectFaceWithCascade(Mat image) {
        MatOfRect faces = new MatOfRect();
        this.faceCascade.detectMultiScale(image, faces);
    }
}
