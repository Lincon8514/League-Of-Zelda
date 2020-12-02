package com.cybergame.graficos;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Spritesheet {

	private BufferedImage spritesheet;
		
	public Spritesheet (String patch) {
		try {
			spritesheet = ImageIO.read(getClass().getResource(patch));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public BufferedImage getSprite(int x, int y, int width, int height){
		return spritesheet.getSubimage(x, y, width, height);
	}
}
