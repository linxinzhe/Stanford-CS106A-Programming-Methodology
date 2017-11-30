import acm.graphics.GImage;
import acm.program.GraphicsProgram;

public class ImageFlip extends GraphicsProgram {
	public void run() {
		GImage image = new GImage("./milkmaid.jpg");
		GImage flipImage = flipImage(image);

		add(image, 0, 50);
		add(flipImage, 380, 50);
	}

	private GImage flipImage(GImage image) {
		int[][] array = image.getPixelArray();
		
		
		
		return new GImage(array);
	}
}
