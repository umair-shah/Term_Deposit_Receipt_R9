package TermDeposit;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainMenu {
//	public MainMenu() {
//		
//	}
	private JTextField brnCdField;
	private JTextField brnDtField;
	private BranchService br = new BranchService();
	public MainMenu()
	{
		createWindow();
	}
	
	public void createWindow(){
		final JFrame frame = new JFrame("Bank Al Habib");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,615);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		
		final JButton termDepositButton = new JButton("Term Deposit");
		termDepositButton.setForeground(new Color(255, 255, 255));
		termDepositButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		termDepositButton.setBackground(new Color(0, 128, 0));
		termDepositButton.setBounds(285, 255, 213, 50);
		panel.add(termDepositButton);
		
		JPopupMenu termDepositPopup = new JPopupMenu();
		addPopup(termDepositButton, termDepositPopup);
		termDepositPopup.setForeground(new Color(255, 255, 255));
		termDepositPopup.setBackground(new Color(0, 128, 0));
		
		
		JButton newApplicationButton = new JButton("New Application");
		newApplicationButton.setVisible(false);
		newApplicationButton.setMaximumSize(new Dimension(200, 23));
		newApplicationButton.setPreferredSize(new Dimension(200, 23));
		newApplicationButton.setMinimumSize(new Dimension(200, 23));
		newApplicationButton.setForeground(new Color(255, 255, 255));
		newApplicationButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		newApplicationButton.setBackground(new Color(0, 128, 0));
		newApplicationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SearchAccount sa = new SearchAccount();
			}
		});
		termDepositPopup.add(newApplicationButton);
		
		JButton modifyApplicationButton = new JButton("Modify Application");
		modifyApplicationButton.setVisible(false);
		modifyApplicationButton.setMaximumSize(new Dimension(200, 23));
		modifyApplicationButton.setPreferredSize(new Dimension(200, 23));
		modifyApplicationButton.setMinimumSize(new Dimension(200, 23));
		modifyApplicationButton.setForeground(new Color(255, 255, 255));
		modifyApplicationButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		modifyApplicationButton.setBackground(new Color(0, 128, 0));
		modifyApplicationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TermDepositSearch tds = new TermDepositSearch();
				try {
					tds.CreateTDRApplicationWindow(1);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		termDepositPopup.add(modifyApplicationButton);
		
		JButton tdrOpenning = new JButton("TDR Opening");
		tdrOpenning.setVisible(false);
		tdrOpenning.setMaximumSize(new Dimension(200, 23));
		tdrOpenning.setPreferredSize(new Dimension(200, 23));
		tdrOpenning.setMinimumSize(new Dimension(200, 23));
		tdrOpenning.setForeground(new Color(255, 255, 255));
		tdrOpenning.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tdrOpenning.setBackground(new Color(0, 128, 0));
		tdrOpenning.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TermDepositSearch tds = new TermDepositSearch();
				try {
					tds.CreateTDRApplicationWindow(2);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		termDepositPopup.add(tdrOpenning);

		JButton tdrPreMatureEncashment = new JButton("TDR Pre-mature encashment");
		tdrPreMatureEncashment.setVisible(false);
		tdrPreMatureEncashment.setMaximumSize(new Dimension(200, 23));
		tdrPreMatureEncashment.setPreferredSize(new Dimension(200, 23));
		tdrPreMatureEncashment.setMinimumSize(new Dimension(200, 23));
		tdrPreMatureEncashment.setForeground(new Color(255, 255, 255));
		tdrPreMatureEncashment.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tdrPreMatureEncashment.setBackground(new Color(0, 128, 0));
		tdrPreMatureEncashment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					TermDepositSearch tds = new TermDepositSearch();
					tds.SearchDeal();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		termDepositPopup.add(tdrPreMatureEncashment);
		JButton authorizeApplicationButton = new JButton("Authorize Application");
		authorizeApplicationButton.setVisible(false);
		authorizeApplicationButton.setMaximumSize(new Dimension(200, 23));
		authorizeApplicationButton.setPreferredSize(new Dimension(200, 23));
		authorizeApplicationButton.setMinimumSize(new Dimension(200, 23));
		authorizeApplicationButton.setForeground(Color.WHITE);
		authorizeApplicationButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		authorizeApplicationButton.setBackground(new Color(0, 128, 0));
		authorizeApplicationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					TermDepositSearch tds = new TermDepositSearch();
					tds.CreateTDRApplicationWindow(0);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	});
		termDepositPopup.add(authorizeApplicationButton);
		JButton setDateButton = new JButton("Set Date");
	      setDateButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
	      setDateButton.setForeground(new Color(255, 255, 255));
	      setDateButton.setBackground(new Color(0, 128, 0));
	      setDateButton.setBounds(590, 457, 133, 34);

	      panel.add(setDateButton);

	      setDateButton.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) {
	          	SpinnerDateModel model = new SpinnerDateModel();
	              JSpinner spinner = new JSpinner(model);
	              JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "dd/MM/yyyy");
	              spinner.setEditor(editor);

	              int option = JOptionPane.showOptionDialog(null, spinner, "Select Date",
	                      JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

	              if (option == JOptionPane.OK_OPTION) {
	                  Date date = model.getDate();
	                  // Handle the selected date
	                  System.out.println("Date selected: " + date);
	                  // Create a new SimpleDateFormat object with the desired date format
	                  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	                  // Use the format method of the SimpleDateFormat object to convert the java.util.Date variable to the desired format
	                  String formattedDate = dateFormat.format(date);

	                  // Print the formatted date
	                  System.out.println(formattedDate);
	                  try {
						br.SetDate(formattedDate);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	              }
	          }
	      });

		
	      JButton tdrPreMatureAuthorizationButton = new JButton("TDR Premature Authorization");
			tdrPreMatureAuthorizationButton.setVisible(false);
			tdrPreMatureAuthorizationButton.setMaximumSize(new Dimension(200, 23));
			tdrPreMatureAuthorizationButton.setPreferredSize(new Dimension(200, 23));
			tdrPreMatureAuthorizationButton.setMinimumSize(new Dimension(200, 23));
			tdrPreMatureAuthorizationButton.setForeground(new Color(255, 255, 255));
			tdrPreMatureAuthorizationButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
			tdrPreMatureAuthorizationButton.setBackground(new Color(0, 128, 0));
			tdrPreMatureAuthorizationButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					TermDepositSearch tds = new TermDepositSearch();
					try {
						tds.AuthorizePreMatureWindow();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			});
			termDepositPopup.add(tdrPreMatureAuthorizationButton);
	      
	    JButton signoutButton = new JButton("Sign Out");
		signoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Session.clearSession();
				frame.dispose();
				LoginUser lu = new LoginUser();
			}
		});
		signoutButton.setForeground(new Color(255, 255, 255));
		signoutButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		signoutButton.setBackground(new Color(0, 128, 0));
		signoutButton.setBounds(590, 502, 133, 34);
		panel.add(signoutButton);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(0, 547, 794, 39);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		brnDtField = new JTextField();
		brnDtField.setBorder(null);
		brnDtField.setBounds(634, 11, 86, 20);
		panel_1.add(brnDtField);
		brnDtField.setBackground(new Color(192, 192, 192));
		brnDtField.setText(Session.GetBranchDate());
		brnDtField.setEditable(false);
		brnDtField.setColumns(10);
		
		JLabel lblBranchDate = new JLabel("Branch Date:");
		lblBranchDate.setBounds(531, 14, 74, 14);
		panel_1.add(lblBranchDate);
		
		brnCdField = new JTextField();
		brnCdField.setBorder(null);
		brnCdField.setBounds(158, 11, 46, 20);
		panel_1.add(brnCdField);
		brnCdField.setBackground(new Color(192, 192, 192));
		brnCdField.setText(Session.GetBranchCode());
		brnCdField.setEditable(false);
		brnCdField.setColumns(10);
		
		JLabel lblBranchCode = new JLabel("Branch Code:");
		lblBranchCode.setBounds(41, 14, 91, 14);
		panel_1.add(lblBranchCode);
		if(Session.getUserRoleId() == 1)
		{
			newApplicationButton.setVisible(true);
			modifyApplicationButton.setVisible(true);
			tdrOpenning.setVisible(true);
			tdrPreMatureEncashment.setVisible(true);
		}
		if(Session.getUserRoleId() == 2)
		{
			authorizeApplicationButton.setVisible(true);
			tdrPreMatureAuthorizationButton.setVisible(true);
		}
		
		panel.repaint();
		
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainMenu td = new MainMenu();
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
//			public void mousePressed(MouseEvent e) {
//				if (e.isPopupTrigger()) {
//					showMenu(e);
//				}
//			}
//			public void mouseReleased(MouseEvent e) {
//				if (e.isPopupTrigger()) {
//					showMenu(e);
//				}
//			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				if(MouseEvent.BUTTON1 == arg0.getButton())
				{
					showMenu(arg0);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
