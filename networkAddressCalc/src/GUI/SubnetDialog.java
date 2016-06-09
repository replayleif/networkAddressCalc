package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SubnetDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SubnetDialog dialog = new SubnetDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SubnetDialog() {
		setTitle("Subnet");
		setBounds(100, 100, 1175, 719);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JButton add = new JButton("Add");
		
		JButton delete = new JButton("Delete");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton openHosts = new JButton("Hosts...");
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(5)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 1135, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(464)
					.addComponent(add, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(delete, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(openHosts, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(6)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE)
					.addGap(23)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(add, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(delete, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(openHosts, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Subnet", "Department", "Host Count"
			}
		));
		scrollPane.setViewportView(table);
		contentPanel.setLayout(gl_contentPanel);
	}
}