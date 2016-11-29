package com.game.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameFram extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public GameFram() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton btnDown = new JButton("DOWN");
		btnDown.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GameFram.this.setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							StartFrame frame = new StartFrame();
							frame.setVisible(true);
							frame.setTitle("Start Page");
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		contentPane.add(btnDown, BorderLayout.CENTER);
	}

}
