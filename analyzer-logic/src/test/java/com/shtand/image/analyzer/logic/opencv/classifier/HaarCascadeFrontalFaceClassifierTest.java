package com.shtand.image.analyzer.logic.opencv.classifier;

import com.shtand.image.analyzer.logic.OpenCvStarter;
import com.shtand.image.analyzer.logic.opencv.utils.TestUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opencv.core.Mat;
import org.opencv.core.Rect;

import java.util.List;

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
        double minSize = image.size().width / 10;
        double maxSize = image.size().width / 1.5;
        List<Rect> faces = haarCascadeFrontalFaceClassifier.detectWithCascade(image, minSize, maxSize);
        Assertions.assertThat(faces).isEmpty();
    }
}