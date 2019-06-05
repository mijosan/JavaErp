package erp_F;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class CalendarDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	Vector<CalendarBean> vc ;
	
	MemberMgr mgr;	
	
	public CalendarDialog(CalendarPanel calendarPanel, ModalityType modalityType, final String sqlDay) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
		setTitle(sqlDay);
		vc = new Vector<CalendarBean>();
		mgr = new MemberMgr();
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBounds(0, 0, 434, 228);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel label = new JLabel("\uC77C  \uC815");
			label.setBounds(46, 10, 32, 17);
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 12));
			contentPanel.add(label);
		
		
			JLabel label1 = new JLabel("*");
			label1.setBounds(28, 12, 11, 17);
			label1.setHorizontalAlignment(SwingConstants.CENTER);
			label1.setForeground(Color.RED);
			label1.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 12));
			contentPanel.add(label1);
		
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setBounds(0, 228, 434, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			
				JButton okButton = new JButton("\uD655\uC778");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setBackground(Color.WHITE);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				
				
				final DefaultListModel<String> model = new DefaultListModel<String>();
				 vc = mgr.getCalendar(sqlDay); 
				 
				for(int i = 0; i<vc.size();i++) {
				    	CalendarBean bean = new CalendarBean();
				    	bean = vc.get(i);
				    	model.addElement(bean.getTitle());
				}
				
				final JList list = new JList(model);
				list.setFont(new Font("µ∏øÚ", Font.PLAIN, 12));
				list.setBorder(new EmptyBorder(0, 0, 0, 0));
			   list.setSelectedIndex(0);
			   list.setVisibleRowCount(vc.size()); 
			   JScrollPane pane = new JScrollPane(list);
			   Border emptyBorder = BorderFactory.createEmptyBorder();
			   pane.setBorder(emptyBorder);
			  pane.setBounds(100, 10, 252, 50);
			  contentPanel.add(pane);
			 
			   //pane.setViewportView(list);
			   //list.setBounds(126,11, 75,75);  
			  // contentPanel.add(pane);
		    
			  
		    
		    JLabel label_1 = new JLabel("\uB0B4  \uC6A9");
		    label_1.setHorizontalAlignment(SwingConstants.CENTER);
		    label_1.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 12));
		    label_1.setBounds(46, 95, 32, 17);
		    contentPanel.add(label_1);
		    
		    final JTextArea textArea = new JTextArea();
		    textArea.setBounds(103, 98, 254, 104);
		    contentPanel.add(textArea);
		    textArea.setBackground(Color.WHITE);
		    textArea.setRows(5);
		    CalendarBean bean = new CalendarBean();
		    bean = vc.get(0);
		    textArea.setText(bean.getContent());
		    
		    JButton btnNewButton = new JButton("ªË¡¶");
		    btnNewButton.setBackground(Color.WHITE);
		    btnNewButton.setBounds(354, 70, 68, 23);
		    contentPanel.add(btnNewButton);
		    btnNewButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						if(model.getSize()>0) {
						int idx2 = list.getSelectedIndex();
						String date = sqlDay;
						String title = String.valueOf(list.getSelectedValue());					
						model.removeElementAt(idx2);
						textArea.setText("");
						mgr.deleteCalendar(date, title);						
						}
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null,"ªË¡¶«“ µ•¿Ã≈Õ∞° æ¯Ω¿¥œ¥Ÿ.");
						e2.printStackTrace();
						//dispose();
					}				
				}
			});
		    list.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					int idx = list.getSelectedIndex();
					CalendarBean bean = new CalendarBean();
					bean = vc.get(idx);
					textArea.setText(bean.getContent());
					
				}
			});
		   /* list.addListSelectionListener(new ListSelectionListener() {
		    	
				@Override
				public void valueChanged(ListSelectionEvent e) {
					String s="";
					int idx=0;
					String str = String.valueOf(list.getSelectedValue());
					
					idx = list.getSelectedIndex();
					
					System.out.println(idx);
					
					CalendarBean bean = new CalendarBean();
					bean = vc.get(idx);
					textArea.setText(bean.getContent());
					//s = mgr.getCContent(str);
					//System.out.println(mgr.getCContent(str));
					//textArea.setText(s);
				}
			});*/
	}
}
