package com.shtand.image.analyzer.logic.opencv;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opencv.core.Mat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

class OpenCvPlaygroundTest {

    private OpenCvPlayground openCvPlayground;
    private static final Logger log = LoggerFactory.getLogger(OpenCvPlaygroundTest.class);
    @BeforeEach
    void setUp() {
        openCvPlayground = new OpenCvPlayground();
    }

    @Test
    public void testLoadImage() throws IOException {
        InputStream resourceAsStream = OpenCvPlaygroundTest.class.getResourceAsStream("/images_nohead/1.jpg");
        Mat mat = openCvPlayground.loadImageToMatrix(IOUtils.toByteArray(resourceAsStream));
        log.info("Mat has {} height {} width and {} depth", mat.height(), mat.width(), mat.depth());
        log.info("Mat has {} total {} channels and {} dims", mat.total(), mat.channels(), mat.dims());
    }
}