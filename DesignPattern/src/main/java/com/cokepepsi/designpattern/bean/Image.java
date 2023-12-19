package com.cokepepsi.designpattern.bean;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author user
 */
public class Image {
    private String path;
    private BufferedImage bufferedImage;

    public Image(String path) {
        this.path = path;
        loadImage();
    }

    public Image() {
    }

    private void loadImage() {
        try {
            this.bufferedImage = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public void setImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }
}
