package pi;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class CalculatePi {
	
	public static void main(String[] args) throws IOException{
		String file;
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter file name");
		file = in.nextLine();
		System.out.println("PI from image '" + file + "': " + new CalculatePi(file).estimateUsingPicture());
		in.close();
	}
	
	private final BufferedImage image;
	  private double blackPixels = 0;
	  private double diameter = 0;

	  public CalculatePi(String file) throws IOException {
	    image = ImageIO.read(new File(file));
	  }

	  public double estimateUsingPicture() {
	    countPixels();

	    return blackPixels / ((diameter / 2d) * (diameter / 2d));
	  }

	  private void countPixels() {
	    int width = image.getWidth();
	    int height = image.getHeight();

	    int minX = Integer.MAX_VALUE;
	    int maxX = Integer.MIN_VALUE;
	    for (int y = 0; y < height; y++) {
	      for (int x = 0; x < width; x++) {
	        int rgb = image.getRGB(x, y);
	        if (rgb != -1) {
	          blackPixels++;
	          if (x < minX) {
	            minX = x;
	          }
	          if (x > maxX) {
	            maxX = x;
	          }
	        }
	      }
	    }
	    diameter = maxX - minX;
	  }
}


