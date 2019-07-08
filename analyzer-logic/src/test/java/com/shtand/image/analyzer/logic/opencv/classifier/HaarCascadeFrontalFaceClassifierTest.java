package com.shtand.image.analyzer.logic.opencv.classifier;

import com.shtand.image.analyzer.logic.OpenCvStarter;
import com.shtand.image.analyzer.logic.opencv.utils.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opencv.core.Mat;

class HaarCascadeFrontalFaceClassifierTest {

    HaarCascadeFrontalFaceClassifier haarCascadeFrontalFaceClassifier;

    @BeforeEach
    void setUp() {
        OpenCvStarter.init();
        haarCascadeFrontalFaceClassifier = new HaarCascadeFrontalFaceClassifier();
    }

    @Test
    void detectWithCascade_noFace() {
        Mat image = TestUtils.readImageFromResource("/images_nohead/1.jpg");
        haarCascadeFrontalFaceClassifier.detectWithCascade(image);
    }
}