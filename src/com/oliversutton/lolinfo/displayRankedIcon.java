package com.oliversutton.lolinfo;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class displayRankedIcon {

	public static void drawImages(String rank, String tier, JLabel lblIconImage) {

		String iconName = rank.toLowerCase() + "_" + tier.toLowerCase() + ".png";
		String filePath = "D:\\Java\\LoLInfo\\tier-icons\\" + iconName;

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
