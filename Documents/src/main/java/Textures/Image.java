package Textures;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import javax.imageio.ImageIO;

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
		// Check if texture is already created
		if (textures.get(path) != null) {
			// Get texture from list of already downloaded
			this.texture = this.textures.get("" + path);
		} else {
			try {
				// Get current thread and find file path
				ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
				File file = new File(classLoader.getResource("" + path).toURI());
				
				// Read the file
				BufferedImage texture = ImageIO.read(file);
				// Add the texture to list of all textures
				this.textures.put(path, texture);

				// Set texture to downloaded texture
				this.texture = texture;

			} catch (Exception e) { e.printStackTrace(); }
		}
	}
	
	public BufferedImage getTexture() {
		return this.texture;
		
	}
	
}
