package GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Presenter.SubnetPresenter;
import javax.swing.LayoutStyle.ComponentPlacement;

public class SubnetDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	public JTable getTable() {
		return table;
	}
	private SubnetPresenter subnetpresenter;

	public SubnetDialog( SubnetPresenter subnetpresenter )
	{
		this.subnetpresenter = subnetpresenter;
		init();
	}
	
	public void init() {
		setTitle("Subnet");
		setBounds(100, 100, 1175, 719);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JButton add = new JButton("Add");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subnetpresenter.verifyAdd();
			}
		});
		
		JButton delete = new JButton("Delete");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subnetpresenter.verifyDelete();
			}
		});
		
		JButton openHosts = new JButton("Hosts...");
		openHosts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subnetpresenter.verifyHosts();
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton ok = new JButton("OK");
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subnetpresenter.verifyOK();
			}
		});
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(5)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 1135, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(add, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(delete, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(openHosts, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(ok, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(9))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(6)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE)
					.addGap(23)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(ok, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(openHosts, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(delete, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(add, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {
				"Subnet", "Department", "Host Count"
			}
		));
		scrollPane.setViewportView(table);
		contentPanel.setLayout(gl_contentPanel);
	}
	public String getSelectedItem(){
		try{
			return (String) table.getModel().getValueAt(table.getSelectedRow(),1);
		}
		catch(Exception e){
			return null;
		}
	}
}
