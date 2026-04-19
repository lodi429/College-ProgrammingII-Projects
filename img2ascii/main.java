import javax.imageio.ImageIO;
import java.io.*;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics2D;

public class main{
    public static void main(String[] args) {
        try {
            File imageFile = new File(args[0]);
            BufferedImage image = ImageIO.read(imageFile);
            int newWidth = 200;
            if(image.getWidth() >= newWidth){
                double aspectRatio = (double) newWidth / image.getWidth();
                int newHeight = (int) Math.round( image.getHeight() * aspectRatio );
                image = resizeImage(image, newWidth, newHeight);
            }
            Color[][] pixels = getPixels(image);
            createAscii(image);
        } catch (IOException e) {
            System.out.println("File not found.");
        }
    }

    public static Color[][] getPixels(BufferedImage image){
        int width = image.getWidth();
        int height = image.getHeight();
    
        Color[][] pixels = new Color[height][width];
        
        // iterating through every pixel and getting RGB 
        // and writing that to the pixels 2D color array
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                pixels[i][j] = new Color(image.getRGB(j, i));
            }
        }

        return pixels;
    }
    public static double getBrightness(Color color){
        // using the formula for relative luminance
        int red = color.getRed();
        int green = color.getGreen();
        int blue = color.getBlue();

        double brightness = 0.2126 * red + 0.7152 * green + 0.0722 * blue;
        return brightness;
    }
    public static char asciiFromBrightness(double brightness){
        // takes the pixel brightness and divides by the divisor,
        // and then floors the result to get the ascii character. the divisor
        // number was obtained by dividing 255 by 65 and using that number
        // 65 is how many ascii characters there are in the string, so 
        // since 255 is the brightest and $ is the brightest ascii character,
        // going by that logic, whatever number we get from dividing the brightness
        // by the divisor will give us its equivalent ascii character.
        // if that makes sense
        String ascii = "`^\",:;Il!i~+_-?][}{1)(|\\/tfjrxnuvczXYUJCLQ0OZmwqpdbkhao*#MW&8%B@$";
        double divisor = 3.92307692308;
        int asciiChar = (int) Math.floor(brightness / divisor);
        return ascii.charAt(asciiChar);
    }
    public static void createAscii(BufferedImage image){
        Color[][] pixels = getPixels(image);
        // the combined effort of the last 2 methods for this.
        for(int i = 0; i < image.getHeight(); i++){
            for(int j = 0; j < image.getWidth(); j++){
                System.out.print(asciiFromBrightness( getBrightness( pixels[i][j] ) ));
            }
            System.out.println();
        }
    }
    public static BufferedImage resizeImage(BufferedImage img, int newWidth, int newHeight){
        // my knowledge with bufferedimage is not very good
        // had to look up how to resize image with java, this is not my own code
        // its not ai either though so im happy
        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(img, 0, 0, newWidth, newHeight, null);
        g2d.dispose();
        return resizedImage;
    }
}
