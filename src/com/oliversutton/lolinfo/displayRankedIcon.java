package com.oliversutton.lolinfo;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class displayRankedIcon {

	public static void drawImages(String tier, String rank, JLabel lblIconImage) {

		String iconName = "";
		
		if(tier.toUpperCase().equals("MASTER")) {
			iconName = "master.png";
		} else if(tier.toUpperCase().equals("CHALLENGER")) {
			iconName = "challenger.png";
		
		} else if(tier.toUpperCase().equals("PROVISIONAL")) {
			iconName = "provisional.png";
		} else {
			iconName = tier.toLowerCase() + "_" + rank.toLowerCase() + ".png";
		}

		String filePath = System.getProperty("user.dir") + "\\tier-icons\\" + iconName;
		BufferedImage img = null;
		
		try {
			img = ImageIO.read(new File(filePath));
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		lblIconImage.setIcon(new ImageIcon(resizeImage(img)));
		
	}
	
	private static Image resizeImage(BufferedImage image) {
		
		Image scaledImage = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		
		return scaledImage;
	}
	
}
