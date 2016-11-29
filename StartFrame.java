package com.game.main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.game.gameCode.*;


//import com.qi.snake.mainDriver.Game;

import java.awt.event.MouseMotionAdapter;

public class StartFrame extends JFrame {

	int oldX, oldY, newX, newY;
	private NewPanelLook contentPane;
	NewButtonUI buttonUI;
	String username;
	//String passward;
	UserData data;
	int score;
	boolean flag = true;
	/**
	 * Create the frame.
	 */
	public StartFrame() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 553, 337);
		setBackground(new Color(0,0,0,0));
		contentPane = new NewPanelLook();
		buttonUI = new NewButtonUI();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				oldX = e.getXOnScreen();
				oldY = e.getYOnScreen();
				newX = getX();
				newY = getY();
			}
		});
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				setLocation(newX+(e.getXOnScreen()-oldX),newY+(e.getYOnScreen()-oldY));
			}
		});
		
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBounds(10, 96, 119, 214);
		panel.setOpaque(false);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setUI(buttonUI);
		btnExit.setBounds(451, 266, 71, 23);
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		
		JLabel lblNewLabel = new JLabel(" ");
		lblNewLabel.setBounds(383, 107, 139, 148);
		ImageIcon img = new ImageIcon("./src/images/yang.png");
		lblNewLabel.setIcon(img);
		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.setUI(buttonUI);
		btnNewGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StartFrame.this.setVisible(false);
//				EventQueue.invokeLater(new Runnable() {
//					public void run() {
//						try {
//							GameFram frame = new GameFram();
//							frame.setTitle("Have Fun!!!");
//							frame.setVisible(true);
//						} catch (Exception e) {
//							e.printStackTrace();
//						}
//					}
//				});
				
				GameFrame.createGame(username,score);
//				int newscore = GameFrame.finalscore();
				
			}
		});
		
		JButton btnNewButton = new JButton("How To Play");
		btnNewButton.setUI(buttonUI);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String str = "Use direction keys to move up, down, left, and right.\n Eat all the beans.\n Avoid the monsters.";
				JOptionPane.showMessageDialog(StartFrame.this,str,"Rules",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		JButton btnSetting = new JButton("Setting");
		btnSetting.setUI(buttonUI);
		btnSetting.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String [] options = {"ON","OFF"};
				int value = JOptionPane.showOptionDialog(StartFrame.this,"music","setting",JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE,null,options,"ON");
				if(value == 0){
					
				}else if(value == 1){
					
				}
			}
		});
		
		JButton btnAboutUs = new JButton("About Us");
		btnAboutUs.setUI(buttonUI);
		btnAboutUs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(StartFrame.this,"Team member:\n D��Vreaux Fontaine\n Donyao Wang\n Qi Pei",
						"About Us",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.setUI(buttonUI);
		btnLogIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				username = JOptionPane.showInputDialog(StartFrame.this,"username plase","username",JOptionPane.INFORMATION_MESSAGE);
				
				if(username != null){
					
					try {
						SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
						Session session = sessionFactory.openSession();
						session.beginTransaction();
						UserData data1 = (UserData)session.load(UserData.class, username);
						session.getTransaction().commit();
						
						score = data1.getScore();
					} catch (HibernateException e1) {
						data = new UserData(username, 0);
						
						addData(data);
					}
					JOptionPane.showMessageDialog(StartFrame.this,"Hi your score is" + score,"Info",JOptionPane.INFORMATION_MESSAGE);
				}
			
				
				
			}
		});
		contentPane.setLayout(null);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnLogIn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnAboutUs, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnSetting, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewGame, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewGame)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnSetting)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnAboutUs)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnLogIn)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.add(panel);
		//contentPane.add(lblNewLabel);
		contentPane.add(btnExit);
		
		JLabel lblNewLabel_1 = new JLabel(" ");
		lblNewLabel_1.setBounds(174, 107, 337, 136);
		ImageIcon img2 = new ImageIcon("./src/images/dashi.png");
		lblNewLabel_1.setIcon(img2);
		contentPane.add(lblNewLabel_1);
	}
	
	public void addData(UserData data){
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(data);
		session.getTransaction().commit();
	}
	
}
