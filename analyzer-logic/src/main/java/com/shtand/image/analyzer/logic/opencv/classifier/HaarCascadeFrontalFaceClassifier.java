package com.shtand.image.analyzer.logic.opencv.classifier;

import org.springframework.stereotype.Component;

@Component
public class HaarCascadeFrontalFaceClassifier extends AbstractCascadeClassifier {
    private static final String haarCascade = "/classifiers/haarcascade_frontalface_alt.xml";

    public HaarCascadeFrontalFaceClassifier() {
        super(haarCascade);
    }

}
