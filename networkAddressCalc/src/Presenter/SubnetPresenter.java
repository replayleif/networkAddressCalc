package Presenter;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import GUI.AddSubnetDialog;
import GUI.HostDialog;
import GUI.SubnetDialog;
import Model.Network;
import Model.Subnet;

public class SubnetPresenter {

	private SubnetDialog dialog;
	private Network network;

	public SubnetPresenter(Network network) {
		this.network = network;
	}
	
	public void setDialog(SubnetDialog dialog) {
		this.dialog = dialog;
	}

	public void verifyOK() {
		dialog.dispose();
	}
	
	public void verifyAdd() {
		AddSubnetPresenter addSubnetPresenter = new AddSubnetPresenter(network);
		AddSubnetDialog addSubnetDialog = new AddSubnetDialog(this, addSubnetPresenter);
		addSubnetPresenter.setDialog(addSubnetDialog);
		addSubnetDialog.setModal(true);
		addSubnetDialog.setVisible(true);
	}
	
	public void verifyDelete() {
		String selectedItem = dialog.getSelectedItem();
		if (selectedItem != null) {
			int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure?", "delete", JOptionPane.YES_NO_OPTION);
			if (dialogResult == JOptionPane.YES_OPTION) {
				network.DeleteSubnet(network.getSubnetByName(selectedItem));
				updateUI();
			}
		}
	}
	
	public void verifyHosts() {
		String selectedItem = dialog.getSelectedItem();
		if (selectedItem != null) {
			Subnet subnet = network.getSubnetByName(selectedItem);
			HostPresenter hostPresenter = new HostPresenter(subnet);
			HostDialog hostDialog = new HostDialog(hostPresenter);
			hostPresenter.setDialog(hostDialog);
			hostPresenter.updateUI();
			hostDialog.setModal(true);
			hostDialog.setVisible(true);
		}
	}
	
	public void updateUI(){
		TableModel model = dialog.getTable().getModel();
		DefaultTableModel mod = (DefaultTableModel)model;
		mod.setRowCount(0);
		dialog.getTable().revalidate();
		for (Subnet subnet : network.getSubnets()) {
			String ipString = "IPv4: " + subnet.getIpv4SubnetID().toDecimal();
			String hostCount = String.valueOf( subnet.getHosts().size() ) + " of " + subnet.getMaxHostCount();
			if( subnet.getIpv6SubnetID() != null ){
				ipString += "; IPv6: " + subnet.getIpv6SubnetID().toString();
			}
			mod.addRow( new Object[]{ ipString, subnet.getDepartment(), hostCount });
		}
	}
}
