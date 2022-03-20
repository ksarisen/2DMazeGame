package Textures;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import javax.imageio.ImageIO;
import java.awt.*;


/**
 * 
 * @author Reece Landry
 *
 */

public class Image {

	private final static HashMap <String, BufferedImage> textures = new HashMap<>();
	private BufferedImage texture;
	
	/**
	 * @author Reece Landry
	 * @param path
	 * creates new object of Image from given path
	 */
	public Image (String path) {
		// Checks if texture is already created
		if (textures.get(path) != null) {
			// Gets texture from list of already downloaded
			this.texture = this.textures.get("" + path);
		} else {
			try {
				// Gets current thread and find file path
				ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
				File file = new File(classLoader.getResource("" + path).toURI());
				
				// Reads the file
				BufferedImage texture = ImageIO.read(file);
				// Adds the texture to list of all textures
				this.textures.put(path, texture);

				// Sets texture to downloaded texture
				this.texture = texture;

			} catch (Exception e) { e.printStackTrace(); }
		}
	}

		public static BufferedImage rotateImage(Image imageToRotate) {
			int widthOfImage = imageToRotate.texture.getWidth();
			int heightOfImage = imageToRotate.texture.getHeight();
			int typeOfImage = imageToRotate.texture.getType();

			BufferedImage newImageFromBuffer = new BufferedImage(widthOfImage, heightOfImage, typeOfImage);

			Graphics2D graphics2D = newImageFromBuffer.createGraphics();

			graphics2D.rotate(Math.toRadians(90), widthOfImage / 2, heightOfImage / 2);
			graphics2D.drawImage(imageToRotate.texture, null, 0, 0);

			return newImageFromBuffer;
		}
	
	public BufferedImage getTexture() {
		return this.texture;
		
	}

	public void setTexture(BufferedImage texture) {
		this.texture = texture;
	}
}
