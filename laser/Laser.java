package laser;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextPane;

import org.eclipse.osgi.internal.debug.Debug;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Window.Type;
import javax.swing.JFormattedTextField;

import java.io.File;
import java.io.IOException;
import java.net.URI;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
//import java.awt.Panel;
//import javax.swing.Box;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;

//import java.awt.Desktop;
//import java.net.URI;
// clipboard readers
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.util.concurrent.TimeUnit;
import java.awt.Label;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
//import com.sun.jna.Library;
//import com.sun.jna.Native;
//import com.sun.jna.Platform;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinUser;

// import java.net.URISyntaxExaception;

// import Bloomberg API

public class Laser {

	public String strClp;
	public String strBashScriptLocation;
	public JFormattedTextField frmtdtxtfldTest;
	public URI strUrlReports;
	
	
	private JFrame frmLaser;
	private JTextField txtpnCn;

	public static void main(String[] args) {
		String strBashScriptLocation = new String("C:/SRDEV/B_Bash/");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Laser window = new Laser();
					window.frmLaser.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public Laser() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 */
	public void initialize() throws IOException {
		String strclip = new String("");
		frmLaser = new JFrame();
		frmLaser.setType(Type.UTILITY);
			
		frmLaser.setTitle("laser v0.24.5");
		frmLaser.getContentPane().setFont(new Font("Arial", Font.PLAIN, 30));
		frmLaser.setBounds(100, 100, 451, 1087);
		frmLaser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		Label statusLabel = new Label("");
		statusLabel.setBackground(Color.GREEN);
		statusLabel.setForeground(Color.GREEN);
		statusLabel.setBounds(27, 714, 17, 17);
		frmLaser.getContentPane().add(statusLabel);
		
		JTextPane txtPnCommand = new JTextPane();
		txtPnCommand.setText((String) null);
		txtPnCommand.setForeground(Color.LIGHT_GRAY);
		txtPnCommand.setFont(new Font("Arial", Font.PLAIN, 12));
		txtPnCommand.setCaretColor(Color.GREEN);
		txtPnCommand.setBackground(Color.DARK_GRAY);
		txtPnCommand.setBounds(0, 807, 435, 252);
		frmLaser.getContentPane().add(txtPnCommand);
		
		JTextPane txtpnTest2 = new JTextPane();
		txtpnTest2.setFocusAccelerator('1');
		txtpnTest2.setBounds(0, 47, 435, 45);
		txtpnTest2.setText((String) null);
		txtpnTest2.setForeground(Color.LIGHT_GRAY);
		txtpnTest2.setFont(new Font("Arial", Font.PLAIN, 14));
		txtpnTest2.setBackground(Color.DARK_GRAY);
		txtpnTest2.setCaretColor(Color.GREEN);
		frmLaser.getContentPane().add(txtpnTest2);
		
		JTextPane txtpnTest3 = new JTextPane();
		txtpnTest3.setFocusAccelerator('2');
		txtpnTest3.setText((String) null);
		txtpnTest3.setForeground(Color.LIGHT_GRAY);
		txtpnTest3.setFont(new Font("Arial", Font.PLAIN, 14));
		txtpnTest3.setBackground(Color.DARK_GRAY);
		txtpnTest3.setBounds(0, 93, 435, 45);
		txtpnTest3.setCaretColor(Color.GREEN);
		frmLaser.getContentPane().add(txtpnTest3);
		
		JTextPane txtpnTest4 = new JTextPane();
		txtpnTest4.setFocusAccelerator('3');
		txtpnTest4.setText((String) null);
		txtpnTest4.setForeground(Color.LIGHT_GRAY);
		txtpnTest4.setFont(new Font("Arial", Font.PLAIN, 14));
		txtpnTest4.setBackground(Color.DARK_GRAY);
		txtpnTest4.setBounds(0, 140, 435, 45);
		txtpnTest4.setCaretColor(Color.GREEN);
		frmLaser.getContentPane().add(txtpnTest4);		
		
		JTextPane txtpnTest = new JTextPane();
		txtpnTest.setFocusAccelerator('0');
		txtpnTest.setToolTipText("test");
		txtpnTest.setCaretColor(Color.GREEN);
		
		txtpnTest.setBounds(0, 0, 435, 45);
		txtpnTest.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent e) {
				if(e.getKeyCode() == 27)
				{
					
					txtpnTest.setText(null);
				}
				if(e.getKeyCode() == 112)
				{
					txtpnTest2.setText(txtpnTest.getText());
				}
				if(e.getKeyCode() == 113)
				{
					txtpnTest3.setText(txtpnTest.getText());
				}
				if(e.getKeyCode() == 114)
				{
					txtpnTest4.setText(txtpnTest.getText());
				}
				if(e.getKeyCode() == 115)
				{
					txtpnTest.setCaretPosition(0);
					System.out.println("F5");
				}
				if(e.getKeyCode() == 107)
				{
					Integer intCn = Integer.parseInt(txtpnCn.getText());
					txtpnCn.setText(Integer.toString(intCn + 1));
				}	
			}
		});
				
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			// e1.printStackTrace();
		}
		frmLaser.getContentPane().setLayout(null);
		
		txtpnTest.setText(null);
		txtpnTest.setBackground(Color.DARK_GRAY);
		txtpnTest.setForeground(Color.LIGHT_GRAY);
		txtpnTest.setFont(new Font("Arial", Font.PLAIN, 14));
		frmLaser.getContentPane().add(txtpnTest);
		
		JTextPane textPaneBBG2 = new JTextPane();
		textPaneBBG2.setText((String) null);
		textPaneBBG2.setForeground(Color.LIGHT_GRAY);
		textPaneBBG2.setFont(new Font("Arial", Font.PLAIN, 12));
		textPaneBBG2.setBackground(Color.DARK_GRAY);
		textPaneBBG2.setBounds(0, 766, 151, 29);
		textPaneBBG2.setCaretColor(Color.GREEN);
		frmLaser.getContentPane().add(textPaneBBG2);
		
		JTextPane textPaneBBG1 = new JTextPane();
		textPaneBBG1.setText((String) null);
		textPaneBBG1.setForeground(Color.LIGHT_GRAY);
		textPaneBBG1.setFont(new Font("Arial", Font.PLAIN, 12));
		textPaneBBG1.setBackground(Color.DARK_GRAY);
		textPaneBBG1.setBounds(161, 766, 274, 29);
		textPaneBBG1.setCaretColor(Color.GREEN);
		frmLaser.getContentPane().add(textPaneBBG1);
		
		JTextPane textPane = new JTextPane();
		textPane.setFocusAccelerator('4');
		textPane.setText((String) null);
		
		textPane.setForeground(Color.LIGHT_GRAY);
		textPane.setFont(new Font("Arial", Font.PLAIN, 14));
		textPane.setBackground(Color.DARK_GRAY);
		textPane.setBounds(0, 188, 435, 45);
		textPane.setCaretColor(Color.GREEN);
		frmLaser.getContentPane().add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setFocusAccelerator('5');
		textPane_1.setText((String) null);
		textPane_1.setForeground(Color.LIGHT_GRAY);
		textPane_1.setFont(new Font("Arial", Font.PLAIN, 14));
		textPane_1.setBackground(Color.DARK_GRAY);
		textPane_1.setBounds(0, 236, 435, 45);
		textPane_1.setCaretColor(Color.GREEN);
		frmLaser.getContentPane().add(textPane_1);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setFocusAccelerator('6');
		textPane_2.setText((String) null);
		textPane_2.setForeground(Color.LIGHT_GRAY);
		textPane_2.setFont(new Font("Arial", Font.PLAIN, 14));
		textPane_2.setBackground(Color.DARK_GRAY);
		textPane_2.setBounds(0, 284, 435, 45);
		textPane_2.setCaretColor(Color.GREEN);
		frmLaser.getContentPane().add(textPane_2);
		
		JButton btnAip = new JButton("AIP");
		btnAip.setMnemonic('a');
		btnAip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Button AIP Pressed");
				txtPnCommand.setText("AIP initiated");
				statusLabel.setBackground(Color.RED);
				runAIP();
				String[] params = new String [3];
				// params[0] = "C:/SRDEV/B_Bash/get_REPO_PX.bat";
				// "cmd.exe", "/c", "dir"
				params[0] = "cmd.exe";
				params[1] = "/c";
				params[2] = "C:/SRDEV/B_Bash/get_REPO_PX.bat";
				try {
					Runtime.getRuntime().exec(params);
					
					statusLabel.setBackground(Color.GREEN);
					txtPnCommand.setText("AIP retrieval executed");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//RefDataExample.aipp();
				String StrPanel1 = txtpnTest.getText();
				System.out.println(StrPanel1);
			}
		});
		btnAip.setBounds(346, 711, 89, 23);
		frmLaser.getContentPane().add(btnAip);
		
		JButton btnSecDes = new JButton("SEC DES");
		btnSecDes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Button SEC_DES Pressed");
				
				String[] params = new String [3];
				params[0] = "cmd.exe";
				params[1] = "/c";
				params[2] = "C:/SRDEV/B_Bash/get_isin.bat";
				try {
					statusLabel.setBackground(Color.RED);
					Process p1 = Runtime.getRuntime().exec(params);
					p1.waitFor();
					TimeUnit.SECONDS.sleep(0);
					String bbg_des_reply = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
					Debug.println(bbg_des_reply);
					textPaneBBG1.setText(bbg_des_reply);
					statusLabel.setBackground(Color.GREEN);
				} catch (IOException | HeadlessException | UnsupportedFlavorException | InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSecDes.setMnemonic('l');
		btnSecDes.setBounds(247, 711, 89, 23);
		frmLaser.getContentPane().add(btnSecDes);
		
		JButton btnTkt = new JButton("TKT");
		btnTkt.setBounds(148, 711, 89, 23);
		frmLaser.getContentPane().add(btnTkt);
		
		txtpnCn = new JTextField();
		txtpnCn.setForeground(Color.LIGHT_GRAY);
		txtpnCn.setBackground(Color.DARK_GRAY);
		txtpnCn.setBounds(0, 712, 21, 20);
		frmLaser.getContentPane().add(txtpnCn);
		txtpnCn.setColumns(10);
		txtpnCn.setText("0");
		
		JButton btnNexHist = new JButton("NEX HIST");
		btnNexHist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNexHist.setBounds(346, 682, 89, 23);
		frmLaser.getContentPane().add(btnNexHist);
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 27)
					textPane_3.setText(null);
			}
		});
		textPane_3.setText((String) null);
		textPane_3.setForeground(Color.LIGHT_GRAY);
		textPane_3.setFont(new Font("Arial", Font.PLAIN, 14));
		textPane_3.setFocusAccelerator('7');
		textPane_3.setCaretColor(Color.GREEN);
		textPane_3.setBackground(Color.DARK_GRAY);
		textPane_3.setBounds(0, 334, 435, 45);
		frmLaser.getContentPane().add(textPane_3);
		
		JTextPane textPane_4 = new JTextPane();
		textPane_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 27)
				{
					textPane_4.setText(null);
				}
			}
		});
		textPane_4.setText((String) null);
		textPane_4.setForeground(Color.LIGHT_GRAY);
		textPane_4.setFont(new Font("Arial", Font.PLAIN, 14));
		textPane_4.setFocusAccelerator('8');
		textPane_4.setCaretColor(Color.GREEN);
		textPane_4.setBackground(Color.DARK_GRAY);
		textPane_4.setBounds(0, 385, 435, 45);
		frmLaser.getContentPane().add(textPane_4);
		
		JTextPane textPane_5 = new JTextPane();
		textPane_5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 27)
				{
					textPane_5.setText(null);
				}
			}
		});
		textPane_5.setText((String) null);
		textPane_5.setForeground(Color.LIGHT_GRAY);
		textPane_5.setFont(new Font("Arial", Font.PLAIN, 14));
		textPane_5.setFocusAccelerator('9');
		textPane_5.setCaretColor(Color.GREEN);
		textPane_5.setBackground(Color.DARK_GRAY);
		textPane_5.setBounds(0, 435, 435, 45);
		frmLaser.getContentPane().add(textPane_5);
		
		JTextPane textPane_6 = new JTextPane();
		textPane_6.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 27)
				{
					textPane_6.setText(null);
				}
			}
		});
		textPane_6.setText((String) null);
		textPane_6.setForeground(Color.LIGHT_GRAY);
		textPane_6.setFont(new Font("Arial", Font.PLAIN, 14));
		textPane_6.setCaretColor(Color.GREEN);
		textPane_6.setBackground(Color.DARK_GRAY);
		textPane_6.setBounds(0, 485, 435, 45);
		frmLaser.getContentPane().add(textPane_6);
		
		JTextPane textPane_7 = new JTextPane();
		textPane_7.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 27)
				{
					textPane_7.setText(null);
				}
			}
		});
		textPane_7.setText((String) null);
		textPane_7.setForeground(Color.LIGHT_GRAY);
		textPane_7.setFont(new Font("Arial", Font.PLAIN, 14));
		textPane_7.setCaretColor(Color.GREEN);
		textPane_7.setBackground(Color.DARK_GRAY);
		textPane_7.setBounds(0, 535, 435, 45);
		frmLaser.getContentPane().add(textPane_7);
		
		JTextPane textPane_8 = new JTextPane();
		textPane_8.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 27)
				{
					textPane_8.setText(null);
				}
			}
		});
		textPane_8.setText((String) null);
		textPane_8.setForeground(Color.LIGHT_GRAY);
		textPane_8.setFont(new Font("Arial", Font.PLAIN, 14));
		textPane_8.setCaretColor(Color.GREEN);
		textPane_8.setBackground(Color.DARK_GRAY);
		textPane_8.setBounds(0, 585, 435, 45);
		frmLaser.getContentPane().add(textPane_8);
		
		JTextPane textPane_9 = new JTextPane();
		textPane_9.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 27)
					textPane_9.setText(null);
			}
		});
		textPane_9.setText((String) null);
		textPane_9.setForeground(Color.LIGHT_GRAY);
		textPane_9.setFont(new Font("Arial", Font.PLAIN, 14));
		textPane_9.setCaretColor(Color.GREEN);
		textPane_9.setBackground(Color.DARK_GRAY);
		textPane_9.setBounds(0, 636, 435, 45);
		frmLaser.getContentPane().add(textPane_9);
		
		JButton btnSrdev = new JButton("SRDEV");
		btnSrdev.setBackground(Color.GREEN);
		btnSrdev.setMnemonic('s');
		btnSrdev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Desktop.getDesktop().open(new File("C:\\SRDEV"));
				} catch (Exception f){
					System.out.print("error in SRDEV");
				}
				
			}
		});
		btnSrdev.setBounds(247, 682, 89, 23);
		frmLaser.getContentPane().add(btnSrdev);
		
		JLabel lblActive = DefaultComponentFactory.getInstance().createLabel("active");
		lblActive.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblActive.setBounds(10, 686, 40, 14);
		frmLaser.getContentPane().add(lblActive);
		
		JButton btnReporting = new JButton("Reporting");
		btnReporting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Desktop d = Desktop.getDesktop();
				try {
				    d.browse(new URI("https://shp.swissre.com/sites/finace/_layouts/15/start.aspx#/Trading%20Reports/Forms/AllItems.aspx"));
				} catch (Exception f){
					System.out.print("error in SRDEV");
				}
			}
		});
		btnReporting.setMnemonic('r');
		btnReporting.setBackground(Color.GRAY);
		btnReporting.setBounds(53, 711, 89, 23);
		frmLaser.getContentPane().add(btnReporting);
		
		JButton btnNCE = new JButton("NCE");
		btnNCE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Desktop d = Desktop.getDesktop();
				try {
				    d.browse(new URI("https://shp.swissre.com/sites/finace/_layouts/15/start.aspx#/Trading%20Reports/Forms/AllItems.aspx?RootFolder=%2Fsites%2Ffinace%2FTrading%20Reports%2FSecurities%20Lending%20%2D%20Counterparties%27%20Exposures%20plus%20NCE&FolderCTID=0x0120006F85F0A94F7C5C47A62459B6BEA39CA4&View=%7B5508DBB1%2DE856%2D4E47%2DA494%2DAE104B609F2F%7D"));
				} catch (Exception f){
					System.out.print("error in SRDEV");
				}
			}
		});
		btnNCE.setMnemonic('n');
		btnNCE.setBackground(Color.GRAY);
		btnNCE.setBounds(53, 682, 89, 23);
		frmLaser.getContentPane().add(btnNCE);
		
		JButton btnOraise = new JButton("oraise");
		btnOraise.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Desktop d = Desktop.getDesktop();
				try {
				    d.browse(new URI("https://service.oraise.com/Citrix/externWeb/"));
				} catch (Exception f){
					System.out.print("error in SRDEV");
				}			
			}
		});
		
		btnOraise.setMnemonic('o');
		btnOraise.setBackground(Color.GRAY);
		btnOraise.setBounds(148, 682, 89, 23);
		frmLaser.getContentPane().add(btnOraise);
		
		JButton btnAtx = new JButton("ATX");
		btnAtx.setMnemonic('t');
		btnAtx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				statusLabel.setBackground(Color.RED);
				Desktop d = Desktop.getDesktop();
				try {
				    d.browse(new URI("C:/temp/BlackRock/s5mkilch/packagedApps/SWISSRE/ATXL/Bin(x86)/ATX.xll"));
				    statusLabel.setBackground(Color.GREEN);
				    txtPnCommand.setText("ATX loaded");
				} catch (Exception f){
					System.out.print("error in ATX");
					txtPnCommand.setText("Error in loading ATX");
					statusLabel.setBackground(Color.ORANGE);
				}
			}
		});
		btnAtx.setBackground(Color.GRAY);
		btnAtx.setBounds(346, 739, 89, 23);
		frmLaser.getContentPane().add(btnAtx);
		
		JButton btnNewLine = new JButton("new line");
		btnNewLine.setMnemonic('e');
		btnNewLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String txtCommand = txtPnCommand.getText();
				txtPnCommand.setText(txtCommand += "ATX loaded \n");
			}
		});
		btnNewLine.setBackground(Color.GRAY);
		btnNewLine.setBounds(247, 739, 89, 23);
		frmLaser.getContentPane().add(btnNewLine);
		
		JButton btnTiles = new JButton("bash");
		btnTiles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// placeholder today
				try {
					WinDef.HWND hWnd = User32.INSTANCE.FindWindow("ConsoleWindowClass", "C:\\WINDOWS\\system32\\cmd.exe");
					// WinDef.HWND hWnd = User32.INSTANCE.FindWindow("SunAwtFrame", "[PRODUCTION] Firebird - Version 1.5.0.7");
					User32.INSTANCE.ShowWindow(hWnd, WinUser.SW_RESTORE);
					User32.INSTANCE.SetForegroundWindow(hWnd);
					String strCmnd = new String();
					strCmnd = txtPnCommand.getText();
					strCmnd = strCmnd + "\n" + "bash activated";  
					txtPnCommand.setText(strCmnd);							
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnTiles.setMnemonic('b');
		btnTiles.setBackground(Color.GREEN);
		btnTiles.setBounds(148, 739, 89, 23);
		frmLaser.getContentPane().add(btnTiles);
		
		JButton btnBbgDataDump = new JButton("BBG Data");
		btnBbgDataDump.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Button BBG Retrieve Pressed");
				txtPnCommand.setText("BBG Data Dump initiated");
				statusLabel.setBackground(Color.RED);
				try {
			           Runtime.getRuntime().exec(new String[] {"cmd", "/C", "Start", "C:/SRDEV/B_Bash/bbg_bar.bat"}); 
					statusLabel.setBackground(Color.GREEN);
					txtPnCommand.setText("BBG Data Dump executed");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//RefDataExample.aipp();
				String StrPanel1 = txtpnTest.getText();
				System.out.println(StrPanel1);
			}
		});
		btnBbgDataDump.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnBbgDataDump.setMnemonic('b');
		btnBbgDataDump.setBackground(Color.GREEN);
		btnBbgDataDump.setBounds(53, 739, 89, 23);
		frmLaser.getContentPane().add(btnBbgDataDump);
			
		txtpnTest.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent e) {
//				System.out.println(e.getKeyCode());
				if(e.getKeyCode() == 122)
				{
//					System.out.println("Yes");
					System.out.print("on top = true");
					frmLaser.setAlwaysOnTop(true);
				}
				if(e.getKeyCode() == 123)
				{
//					System.out.println("Yes");
					System.out.print("on top = false");
					frmLaser.setAlwaysOnTop(false);
				}		
			}
		});
		
		
		txtpnTest2.addKeyListener(new java.awt.event.KeyAdapter(){
			@Override
			public void keyPressed(java.awt.event.KeyEvent e) {
			if(e.getKeyCode() == 27)
			{
				txtpnTest2.setText(null);
			}
			if(e.getKeyCode() == 107)
			{
				Integer intCn = Integer.parseInt(txtpnCn.getText());
				txtpnCn.setText(Integer.toString(intCn + 1));
			}


			}
		});
		txtpnTest3.addKeyListener(new java.awt.event.KeyAdapter(){
			@Override
			public void keyPressed(java.awt.event.KeyEvent e) {
			if(e.getKeyCode() == 27)
			{
				txtpnTest3.setText(null);
			}
			if(e.getKeyCode() == 107)
			{
				Integer intCn = Integer.parseInt(txtpnCn.getText());
				txtpnCn.setText(Integer.toString(intCn + 1));
			}
			}
		});
		txtpnTest4.addKeyListener(new java.awt.event.KeyAdapter(){
			@Override
			public void keyPressed(java.awt.event.KeyEvent e) {
			if(e.getKeyCode() == 27)
			{
				txtpnTest4.setText(null);
			}
			if(e.getKeyCode() == 107)
			{
				Integer intCn = Integer.parseInt(txtpnCn.getText());
				txtpnCn.setText(Integer.toString(intCn + 1));
			}
			}
		});
		textPane.addKeyListener(new java.awt.event.KeyAdapter(){
			@Override
			public void keyPressed(java.awt.event.KeyEvent e) {
			if(e.getKeyCode() == 27)
			{
				textPane.setText(null);
			}
			if(e.getKeyCode() == 107)
			{
				Integer intCn = Integer.parseInt(txtpnCn.getText());
				txtpnCn.setText(Integer.toString(intCn + 1));
			}		
			}
		});
		textPane_1.addKeyListener(new java.awt.event.KeyAdapter(){
			@Override
			public void keyPressed(java.awt.event.KeyEvent e) {
			if(e.getKeyCode() == 27)
			{
				textPane_1.setText(null);
			}
			if(e.getKeyCode() == 107)
			{
				Integer intCn = Integer.parseInt(txtpnCn.getText());
				txtpnCn.setText(Integer.toString(intCn + 1));
			}			
			}
		});
		
		textPane_2.addKeyListener(new java.awt.event.KeyAdapter(){
			@Override
			public void keyPressed(java.awt.event.KeyEvent e) {
			if(e.getKeyCode() == 27)
			{
				textPane_2.setText(null);
			}
			if(e.getKeyCode() == 107)
			{
				Integer intCn = Integer.parseInt(txtpnCn.getText());
				txtpnCn.setText(Integer.toString(intCn + 1));
			}			
			}
		});
		
	}
	
	public void runAIP()
	{
		System.out.println("methon run");
		try {
			//MK_bloomberg.bloom("IT0004634132");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
