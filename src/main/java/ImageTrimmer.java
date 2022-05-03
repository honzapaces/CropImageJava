import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ImageTrimmer {


    /**
     * Method loads image and trims picture removing transparent 'edges'
     * @param resourceFileName name of the file in resource folder
     * @return trimmed image
     */
    public BufferedImage cropImage(String resourceFileName) {

        BufferedImage image = loadImageFromFile(resourceFileName);

        Rectangle croppingRectangle = getCroppingRectangle(image);

        return image.getSubimage(croppingRectangle.x, croppingRectangle.y, croppingRectangle.width, croppingRectangle.height);
    }

    /**
     * TODO: Fill in this method
     *
     * @param image image represented by java class {@link BufferedImage}
     * @return {@link Rectangle} object that specifies how the image should be cropped
     */
    private Rectangle getCroppingRectangle(BufferedImage image) {
        return new Rectangle();
    }

    private BufferedImage loadImageFromFile(String path) {
        InputStream is = ImageTrimmer.class.getResourceAsStream(path);

        if (is == null) {
            throw new IllegalArgumentException("File not found");
        }

        try {
            return ImageIO.read(is);
        } catch (IOException e) {
            throw new IllegalArgumentException("File not found!");
        }
    }

    public static void main(String[] args) throws IOException {

        ImageTrimmer imageTrimmer = new ImageTrimmer();
        String[] imageNames = {"image1.png", "image2.png"};

        for (String fileName : imageNames) {
            BufferedImage croppedImage = imageTrimmer.cropImage(fileName);
            File outputFile = new File(fileName + "_cropped.png");
            ImageIO.write(croppedImage, "png", outputFile);
        }

    }
}
