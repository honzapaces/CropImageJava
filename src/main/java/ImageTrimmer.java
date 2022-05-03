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

        int[][] pixelArray = image2PixelArray(image);
        Rectangle croppingRectangle = getCroppingRectangle(pixelArray);

        return image.getSubimage(croppingRectangle.x, croppingRectangle.y, croppingRectangle.width, croppingRectangle.height);
    }

    /**
     * TODO: Fill in this method
     *
     * @param pixelArray two-dimensional array representation of the image [x][y] - each pixel is represented as a integer
     * @return {@link Rectangle} object that specifies how the image should be cropped
     */
    private Rectangle getCroppingRectangle(int[][] pixelArray) {
        return new Rectangle();
    }

    private int[][] image2PixelArray(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();

        int[][] pixelArray = new int[width][height];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rgb = image.getRGB(x, y);
                Color color = new Color(rgb);
                pixelArray[x][y] = rgb;
            }
        }

        return pixelArray;
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
