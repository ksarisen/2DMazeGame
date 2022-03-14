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

	private static HashMap <String, BufferedImage> textures = new HashMap<>();
	private BufferedImage texture;
	
	/**
	 * @author Reece Landry
	 * @param path
	 * creates new object of Image from given path
	 */
	public Image (String path) {
		//check if texture is already created
		if (this.textures.get(path) == null) {
			try {
				//get current thread and find file path
				ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
				File file = new File(classLoader.getResource("" + path).toURI());
				
				//read the file
				BufferedImage texture = ImageIO.read(file);
				//add the texture to list of all textures
				this.textures.put(path, texture);
				
				//set texture to downloaded texture
				this.texture = texture;
				
			} catch (Exception e) { System.out.println(e); }
		} else {
			//get texture from list of already downloaded
			this.texture = this.textures.get(path);
		}
	}
	
	public BufferedImage getTexture() {
		return this.texture;
	}
	
}
