package erp_F;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Sell2_Panel extends JPanel {
	ProductPieChart pcd ;
	EmployeepieChart epc;
	CustomerPieChart cpc;
	
	JPanel panel;
	JButton button;
	JButton btnNewButton;
	JButton button_1;
	
	public Sell2_Panel() {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		pcd = new ProductPieChart("상품별 판매조회");		
		epc = new EmployeepieChart("직원별 판매조회");
		cpc = new CustomerPieChart("고객별 판매조회");
		pcd.setBackground(Color.WHITE);		;
		epc.setBackground(Color.WHITE);
		cpc.setBackground(Color.WHITE);
		add(pcd);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		button = new JButton("상품별 판매조회");
		button.setBackground(Color.WHITE);
		
		button.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				button.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
			}
		});
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				removeAll();
				add(panel,BorderLayout.WEST);				
				add(pcd);
				repaint();
				validate();
			}
		});
		panel.add(button);
		
		btnNewButton = new JButton("직원별 판매건수");
		
		btnNewButton.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				btnNewButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
			}
		});
		btnNewButton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				removeAll();
				add(panel,BorderLayout.WEST);				
				add(epc);
				repaint();
				validate();
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		panel.add(btnNewButton);
		
		button_1 = new JButton("\uACE0\uAC1D\uBCC4 \uD310\uB9E4\uC870\uD68C");
		button_1.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				button_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
			}
		});
		button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				removeAll();
				add(panel,BorderLayout.WEST);
				add(cpc);
				repaint();
				validate();
			}
		});
		button_1.setBackground(Color.WHITE);
		panel.add(button_1);
		//pcd.setBounds(200, 500, 700, 700);		

	}

}
