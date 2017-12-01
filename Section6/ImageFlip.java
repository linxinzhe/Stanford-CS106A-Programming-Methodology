import acm.graphics.GImage;
import acm.program.GraphicsProgram;

public class ImageFlip extends GraphicsProgram {
	public void run() {
		GImage image = new GImage("./milkmaid.jpg");
		GImage flipImage = flipImage(image);

		add(image, 0, 0);
		add(flipImage, image.getPixelArray()[0].length, 0);
	}

	private GImage flipImage(GImage image) {
		int[][] array = image.getPixelArray();
		int height = array.length;    // number of rows in grid
		int width = array[0].length;  // number of columns in a row
		println("height:"+height+" "+"width:"+width);
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width/2; j++) {
				int temp=array[i][j];
				array[i][j]=array[i][width-1-j];
				array[i][width-1-j]=temp;
			}
		}
		
		return new GImage(array);
	}
}
