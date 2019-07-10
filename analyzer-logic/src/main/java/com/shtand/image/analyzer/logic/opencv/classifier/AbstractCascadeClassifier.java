package com.shtand.image.analyzer.logic.opencv.classifier;

import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;
import org.opencv.core.Size;
import org.opencv.objdetect.CascadeClassifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class AbstractCascadeClassifier {
    private static final Logger log = LoggerFactory.getLogger(AbstractCascadeClassifier.class);
    private final CascadeClassifier cascadeClassifier;
    private final double scaleFactor;
    private final int minNeighbors;
    private final int cascadeFlags;

    public AbstractCascadeClassifier(String resource, double scaleFactor, int minNeighbors, int cascadeFlags) {
        cascadeClassifier = loadCascadeClassifier(resource);
        this.scaleFactor = scaleFactor;
        this.minNeighbors = minNeighbors;
        this.cascadeFlags = cascadeFlags;
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

    public List<Rect> detectWithCascade(Mat image, double minSize, double maxSize) {
        return detectWithCascade(image, minSize, minSize, maxSize, maxSize);
    }

    public List<Rect> detectWithCascade(Mat image, double minWidth, double minHeight, double maxWidth, double maxHeight) {
        log.debug("Detect with cascade image {}", image.total());
        MatOfRect faces = new MatOfRect();
        Size minSize = new Size(minWidth, minHeight);
        Size maxSize = new Size(maxWidth, maxHeight);
        getCascadeClassifier().detectMultiScale(image, faces, scaleFactor, minNeighbors, cascadeFlags, minSize, maxSize);
        return faces.toList();
    }


}
