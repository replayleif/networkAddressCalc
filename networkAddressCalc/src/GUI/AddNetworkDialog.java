 package GUI;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Presenter.AddNetworkPresenter;
import Presenter.NetworkPresenter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JCheckBox;

public class AddNetworkDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txt_IPv4;
	private JTextField txt_IPv4_prefix;
	private JTextField txt_IPv6;
	private JTextField txt_IPv6_prefix;
	private NetworkPresenter parent;
	JCheckBox chk_IPv6 = new JCheckBox("use IPv6");
	
	private AddNetworkPresenter addnetworkpresenter;
	
		public AddNetworkDialog( NetworkPresenter parent, AddNetworkPresenter addnetworkpresenter )
		{
			this.setNetworkPresenter(parent);
			this.addnetworkpresenter = addnetworkpresenter;
			init();
		}

	public void init() {
		setTitle("Add Network");
		setBounds(100, 100, 430, 208);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 414, 137);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		
		JLabel lbl_IPv4 = new JLabel("IPv4");
		lbl_IPv4.setBounds(15, 19, 32, 14);
		
		JLabel lbl_IPv6 = new JLabel("IPv6");
		lbl_IPv6.setBounds(15, 60, 32, 14);
		
		txt_IPv4 = new JTextField();
		txt_IPv4.setBounds(57, 16, 297, 20);
		txt_IPv4.setColumns(10);
		
		JLabel lbl_IPv4_Slash = new JLabel("/");
		lbl_IPv4_Slash.setBounds(358, 19, 4, 14);
		
		txt_IPv4_prefix = new JTextField();
		txt_IPv4_prefix.setBounds(366, 16, 38, 20);
		txt_IPv4_prefix.setColumns(10);
		
		txt_IPv6 = new JTextField();
		txt_IPv6.setBounds(57, 54, 297, 20);
		txt_IPv6.setColumns(10);
		
		JLabel lbl_IPv6_Slash = new JLabel("/");
		lbl_IPv6_Slash.setBounds(358, 57, 4, 14);
		
		txt_IPv6_prefix = new JTextField();
		txt_IPv6_prefix.setBounds(366, 54, 38, 20);
		txt_IPv6_prefix.setColumns(10);
		contentPanel.setLayout(null);
		contentPanel.add(lbl_IPv4);
		contentPanel.add(lbl_IPv6);
		contentPanel.add(txt_IPv4);
		contentPanel.add(lbl_IPv4_Slash);
		contentPanel.add(txt_IPv4_prefix);
		contentPanel.add(txt_IPv6);
		contentPanel.add(lbl_IPv6_Slash);
		contentPanel.add(txt_IPv6_prefix);
		

		chk_IPv6.setBounds(10, 93, 97, 23);
		contentPanel.add(chk_IPv6);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 137, 414, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton save = new JButton("Save");
				save.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						addnetworkpresenter.verifySave();
					}
				});
				save.setActionCommand("OK");
				buttonPane.add(save);
				getRootPane().setDefaultButton(save);
			}
			{
				JButton cancel = new JButton("Cancel");
				cancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						addnetworkpresenter.verifyCancel();
					}
				});
				cancel.setActionCommand("Cancel");
				buttonPane.add(cancel);
			}
		}
	}
	public String ipv4FromComponent(){
		return txt_IPv4.getText();
	}
	public String ipv6FromComponent(){
		return txt_IPv6.getText();
	}
	public String ipv4PraefixFromComponent(){
		return txt_IPv4_prefix.getText();
	}
	public String ipv6PraefixFromComponent(){
		return txt_IPv6_prefix.getText();
	}
	public boolean isCheckboxChecked(){
		return chk_IPv6.isSelected();
	}

	public NetworkPresenter getNetworkPresenter() {
		return parent;
	}

	public void setNetworkPresenter(NetworkPresenter parent) {
		this.parent = parent;
	}
}
