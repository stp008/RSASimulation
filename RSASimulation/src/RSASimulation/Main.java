package RSASimulation;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


@SuppressWarnings("serial")
public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField pTextField;
	private JTextField qTextField;
	private JTextField eTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public Main() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		System.out.println(HelperRSA.euclid(1035, 759));
		System.out.println(0 % 1035);
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		setTitle("\u0410\u043B\u0433\u043E\u0440\u0438\u0442\u043C\u044B");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 568);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("RSA", null, panel, null);
		panel.setLayout(null);
		
		JLabel qLabel = new JLabel("\u041F\u0440\u043E\u0441\u0442\u043E\u0435 \u0447\u0438\u0441\u043B\u043E q:");
		qLabel.setBounds(49, 77, 100, 20);
		panel.add(qLabel);
		
		JLabel pLabel = new JLabel("\u041F\u0440\u043E\u0441\u0442\u043E\u0435 \u0447\u0438\u0441\u043B\u043E p:");
		pLabel.setBounds(49, 35, 100, 20);
		panel.add(pLabel);
		
		pTextField = new JTextField();
		pTextField.setBounds(149, 37, 86, 20);
		panel.add(pTextField);
		pTextField.setColumns(10);
		
		qTextField = new JTextField();
		qTextField.setBounds(149, 79, 86, 20);
		panel.add(qTextField);
		qTextField.setColumns(10);
		
		JLabel NLabel = new JLabel("N = pq = ...");
		NLabel.setBounds(350, 29, 92, 32);
		panel.add(NLabel);
		
		JLabel eLabel = new JLabel("\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u0447\u0438\u0441\u043B\u043E \u0435, \u0432\u0437\u0430\u0438\u043C\u043D\u043E \u043F\u0440\u043E\u0441\u0442\u043E\u0435 \u0441 (p-1)(q-1):");
		eLabel.setBounds(49, 123, 249, 20);
		panel.add(eLabel);
		
		eTextField = new JTextField();
		eTextField.setBounds(308, 123, 86, 20);
		panel.add(eTextField);
		eTextField.setColumns(10);
		
		JLabel privateKeyLabel = new JLabel("\u0417\u0430\u043A\u0440\u044B\u0442\u044B\u0439 \u043A\u043B\u044E\u0447 (\u0447\u0438\u0441\u043B\u043E d, \u043E\u0431\u0440\u0430\u0442\u043D\u043E\u0435 \u043A \u0435 \u043F\u043E \u043C\u043E\u0434\u0443\u043B\u044E (p-1)(q-1)):");
		privateKeyLabel.setBounds(49, 189, 334, 20);
		panel.add(privateKeyLabel);
		
		JLabel privateKeyValue = new JLabel("privateKey");
		privateKeyValue.setBounds(374, 191, 86, 17);
		panel.add(privateKeyValue);
		
		JLabel publicKeyLabel = new JLabel("\u041E\u0442\u043A\u0440\u044B\u0442\u044B\u0439 \u043A\u043B\u044E\u0447 (\u043F\u0430\u0440\u0430 (N,e), \u0433\u0434\u0435 N = pq):");
		publicKeyLabel.setBounds(49, 232, 316, 20);
		panel.add(publicKeyLabel);
		
		JLabel publicKeyValue = new JLabel("publicKey");
		publicKeyValue.setBounds(376, 235, 46, 14);
		panel.add(publicKeyValue);
		
		JLabel msgLabel = new JLabel("\u0421\u043E\u043E\u0431\u0449\u0435\u043D\u0438\u0435:");
		msgLabel.setBounds(49, 291, 70, 14);
		panel.add(msgLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(149, 292, 200, 50);
		panel.add(textArea);
		
		JLabel encodedMsgLabel = new JLabel("\u0417\u0430\u0448\u0438\u0444\u0440\u043E\u0432\u0430\u043D\u043D\u043E\u0435 \u0441\u043E\u043E\u0431\u0449\u0435\u043D\u0438\u0435:");
		encodedMsgLabel.setBounds(374, 291, 155, 14);
		panel.add(encodedMsgLabel);
		
		JLabel encodedMsg = new JLabel("");
		encodedMsg.setBounds(374, 327, 164, 95);
		panel.add(encodedMsg);
		
		JLabel decodedMsg = new JLabel("");
		decodedMsg.setBounds(557, 327, 164, 95);
		panel.add(decodedMsg);
		
		JLabel decodedMsgLabel = new JLabel("\u0420\u0430\u0441\u0448\u0438\u0444\u0440\u043E\u0432\u0430\u043D\u043D\u043E\u0435 \u0441\u043E\u043E\u0431\u0449\u0435\u043D\u0438\u0435:");
		decodedMsgLabel.setBounds(557, 291, 155, 14);
		panel.add(decodedMsgLabel);
		
		JButton encode = new JButton("\u0417\u0430\u0448\u0438\u0444\u0440\u043E\u0432\u0430\u0442\u044C");
		encode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		encode.setBounds(84, 449, 115, 32);
		panel.add(encode);
		
		JButton decode = new JButton("\u0420\u0430\u0441\u0448\u0438\u0444\u0440\u043E\u0432\u0430\u0442\u044C");
		decode.setBounds(209, 449, 115, 32);
		panel.add(decode);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("AES", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_2, null);
	}	
	
}
