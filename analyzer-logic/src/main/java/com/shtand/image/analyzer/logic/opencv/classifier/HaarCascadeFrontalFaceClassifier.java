package com.shtand.image.analyzer.logic.opencv.classifier;

import org.opencv.objdetect.Objdetect;
import org.springframework.stereotype.Component;

@Component
public class HaarCascadeFrontalFaceClassifier extends AbstractCascadeClassifier {

    private static final String haarCascade = "/classifiers/haarcascade_frontalface_alt.xml";
    private static final double SCALE_FACTOR = 1.1;
    private static final int MIN_NEIGHBORS = 2;
    private static final int FLAGS = 0 | Objdetect.CASCADE_SCALE_IMAGE;

    public HaarCascadeFrontalFaceClassifier() {
        super(haarCascade, SCALE_FACTOR, MIN_NEIGHBORS, FLAGS);
    }

}
