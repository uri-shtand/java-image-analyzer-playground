package com.shtand.image.analyzer.logic.opencv.classifier;

import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.objdetect.CascadeClassifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class AbstractCascadeClassifier {
    private static final Logger log = LoggerFactory.getLogger(AbstractCascadeClassifier.class);
    private final CascadeClassifier cascadeClassifier;

    public AbstractCascadeClassifier(String resource) {
        cascadeClassifier = loadCascadeClassifier(resource);
    }

    public CascadeClassifier getCascadeClassifier() {
        return cascadeClassifier;
    }

    private CascadeClassifier loadCascadeClassifier(String resource) {
        CascadeClassifier cascadeClassifier = new CascadeClassifier();
        try {
            Path tempFile = Files.createTempFile("java-", "-temp");
            Files.copy(getClass().getResourceAsStream(resource), tempFile, StandardCopyOption.REPLACE_EXISTING);
            log.warn("loading classifier {} from {}", resource, tempFile.toString());
            cascadeClassifier.load(tempFile.toString());
            log.warn("classifier {} loaded", resource);
        } catch (IOException e) {
            throw new RuntimeException("Failed to copy to tempFile", e);
        }
        return cascadeClassifier;
    }

    public void detectWithCascade(Mat image) {
        log.debug("Detect with cascade image {}", image.total());
        MatOfRect faces = new MatOfRect();
        getCascadeClassifier().detectMultiScale(image, faces);
    }

}
