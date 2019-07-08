package com.shtand.image.analyzer.logic.opencv.transformer;

import com.shtand.image.analyzer.logic.OpenCvStarter;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opencv.core.Mat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

class ByteArrayToImageMatrixTransformerTest {
    private static final Logger log = LoggerFactory.getLogger(ByteArrayToImageMatrixTransformerTest.class);

    private ByteArrayToImageMatrixTransformer byteArrayToImageMatrixTransformer;

    @BeforeEach
    void setUp() {
        OpenCvStarter.init();
        byteArrayToImageMatrixTransformer = new ByteArrayToImageMatrixTransformer();
    }

    @Test
    public void testLoadImage() throws IOException {
        InputStream resourceAsStream = ByteArrayToImageMatrixTransformerTest.class.getResourceAsStream("/images_nohead/1.jpg");
        Mat mat = byteArrayToImageMatrixTransformer.loadImageToMatrix(IOUtils.toByteArray(resourceAsStream));
        log.info("Mat has {} height {} width and {} depth", mat.height(), mat.width(), mat.depth());
        log.info("Mat has {} total {} channels and {} dims", mat.total(), mat.channels(), mat.dims());
    }

}