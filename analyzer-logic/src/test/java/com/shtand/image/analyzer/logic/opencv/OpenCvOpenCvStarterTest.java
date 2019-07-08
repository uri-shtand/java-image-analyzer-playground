package com.shtand.image.analyzer.logic.opencv;

import com.shtand.image.analyzer.logic.OpenCvStarter;
import com.shtand.image.analyzer.logic.opencv.utils.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opencv.core.Mat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

class OpenCvOpenCvStarterTest {
    private static final Logger log = LoggerFactory.getLogger(OpenCvOpenCvStarterTest.class);

    private OpenCvPlayground openCvPlayground;

    @BeforeEach
    void setUp() {
        OpenCvStarter.init();
        openCvPlayground = new OpenCvPlayground();
    }

    @Test
    void convertToGrayscale() throws IOException {
        Mat image = TestUtils.readImageFromResource("/images_nohead/1.jpg");
        Mat mat = openCvPlayground.convertToGrayscale(image);
        log.info("Mat has {} height {} width and {} depth", mat.height(), mat.width(), mat.depth());
        log.info("Mat has {} total {} channels and {} dims", mat.total(), mat.channels(), mat.dims());

    }

}