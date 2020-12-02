package com.cybergame.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.cybergame.main.Game;
import com.cybergame.world.Camera;
import com.cybergame.world.World;

public class Enemy extends Entity {

		private double speed = 1;
		
		private int maskx = 8, masky = 8, maskw = 10, maskh = 10;
	
	public Enemy(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);

	}
	public void tick() {
		/*if(Game.rand.nextInt(100) < 50) {*/
		if((int)x < Game.player.getX() && World.isFree((int)(x+speed), this.getY())
				&& !isColidding((int)(x+speed), this.getY())) {
			x+=speed;
		}else if((int)x > Game.player.getX() && World.isFree((int)(x-speed), this.getY())
				&& !isColidding ((int)(x-speed), this.getY())){
			x-=speed;
		}
		if((int)y < Game.player.getY()&& World.isFree(this.getX(),(int)(y+speed))
				&& !isColidding (this.getX(),(int)(y+speed))) {
			y+=speed;
		}else if((int)y > Game.player.getY() && World.isFree(this.getX(),(int)(y-speed))
				&& !isColidding (this.getX(),(int)(y-speed))){
			y-=speed;
		}
	//}
	}
	
	public boolean isColidding(int xnext, int ynext) {
		Rectangle enemyCurrent = new Rectangle(xnext + maskx,ynext + masky,maskw,maskh);
		for (int i = 0; i < Game.enemies.size(); i++){
		Enemy e = Game.enemies.get(i);
		if(e == this) 
			continue;
		Rectangle targetEnemy = new Rectangle(e.getX()+maskw,e.getY()+masky,maskw,maskh);
		if(enemyCurrent.intersects(targetEnemy)) {
			return true;
		}
		
		
		}
		
		return false;
		}
	
	public void render(Graphics g) {
		super.render(g);
		g.setColor(Color.blue);
		g.fillRect(this.getX() + maskx - Camera.x, this.getY() + masky - Camera.y, maskw, maskh);
	}
		

}
