package com.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.LookAndFeel;
import javax.swing.plaf.basic.BasicButtonUI;

public class NewButtonUI extends BasicButtonUI{

	@Override
	public void paint(Graphics g, JComponent c) {
		// TODO Auto-generated method stub
		g.setColor(new Color(196,56,17,150));
		g.fillRect(0,0,c.getWidth(),c.getHeight());
		super.paint(g, c);
	}

	@Override
	protected void paintIcon(Graphics g, JComponent c, Rectangle iconRect) {
		// TODO Auto-generated method stub
		super.paintIcon(g, c, iconRect);
	}

	@Override
	protected void paintButtonPressed(Graphics g, AbstractButton b) {
		// TODO Auto-generated method stub
		g.setColor(new Color(130,55,30,150));
		g.fillRect(1,1,b.getWidth()-1,b.getHeight()-1);
	}
	
}
