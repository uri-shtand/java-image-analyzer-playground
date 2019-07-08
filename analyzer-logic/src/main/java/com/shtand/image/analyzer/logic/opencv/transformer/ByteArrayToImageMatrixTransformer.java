package com.shtand.image.analyzer.logic.opencv.transformer;

import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.springframework.stereotype.Component;

@Component
public class ByteArrayToImageMatrixTransformer {

    public Mat loadImageToMatrix(byte[] bytes) {
        Mat mat = Imgcodecs.imdecode(new MatOfByte(bytes), Imgcodecs.CV_LOAD_IMAGE_UNCHANGED);
        return mat;
    }

}
