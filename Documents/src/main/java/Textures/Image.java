package Textures;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;


/**
 * Creates Images for everything the user sees on the map
 *
 * @author Reece Landry
 */

public class Image {

    private final static HashMap<String, BufferedImage> textures = new HashMap<>();
    private BufferedImage texture;

    /**
     * Creates new object of Image from given path
     *
     * @param path
     * @author Reece Landry
     */
    public Image(String path) {
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

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public BufferedImage getTexture() {
        return this.texture;
    }

    public void setTexture(BufferedImage texture) {
        this.texture = texture;
    }
}
