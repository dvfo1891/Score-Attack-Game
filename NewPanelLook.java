package com.game.main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.omg.CORBA.PUBLIC_MEMBER;

public class NewPanelLook extends JPanel{
	
	protected void paintComponent(Graphics g) {		
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2d.setColor(new Color(255,255,255,150));
		g2d.fillRoundRect(3,3,getWidth()-7,getHeight()-7,20,20);
		
		//Title
		g2d.setClip(0,0,getWidth(),50);
		g2d.setColor(new Color(140,98,56,150));
		g2d.fillRoundRect(2,2,getWidth()-4,50,20,20);
		g2d.setClip(null);
		//team number
		g2d.setClip(getWidth()-80,getHeight()-260,getWidth(),20);
		g2d.setColor(new Color(140,98,56,150));
		g2d.fillRoundRect(getWidth()-80,getHeight()-260,78,20,7,7);
		g2d.setClip(null);
		//button background
		g2d.setClip(3,90,150,getHeight()-80);
		g2d.setColor(new Color(140,98,56,150));
		g2d.fillRoundRect(3,90,150,getHeight()-95,20,20);
		g2d.setClip(null);
		
		g2d.setColor(Color.DARK_GRAY);
		g2d.setStroke(new BasicStroke(2));
		g2d.drawRoundRect(3,3,getWidth()-7,getHeight()-7,20,20);
		
		g2d.setFont(new Font("Arial",Font.BOLD,30));
		g2d.setColor(Color.DARK_GRAY);
		g2d.drawString("Score & Attack",15,45);
		
		
		g2d.setFont(new Font("Arial",Font.BOLD,15));
		g2d.setColor(Color.DARK_GRAY);
		g2d.drawString("Team #10",getWidth()-76,getHeight()-245);
	}
	

}
