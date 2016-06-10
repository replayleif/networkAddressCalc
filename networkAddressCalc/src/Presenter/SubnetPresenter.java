package Presenter;

import javax.swing.JOptionPane;

import GUI.SubnetDialog;
import Model.Network;

public class SubnetPresenter {

	private SubnetDialog dialog;
	private Network network;

	public SubnetPresenter(Network network) {
		this.network = network;
	}
	
	public void setDialog(SubnetDialog dialog) {
		this.dialog = dialog;
	}

	public void verifyAdd() {
//		AddSubnetPresenter addSubnetPresenter = new AddSubnetPresenter(network);
//		AddSubnetDialog addSubnetDialog = new AddSubnetDialog(addSubnetPresenter);
//		addSubnetPresenter.setDialog(addSubnetDialog);
//		addSubnetDialog.setVisible(true);
	}
	
	public void verifyDelete() {
		String selectedItem = dialog.getSelectedItem();
		if (selectedItem != null) {
			int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure?", "delete", JOptionPane.YES_NO_OPTION);
			if (dialogResult == JOptionPane.YES_OPTION) {
				network.DeleteSubnet(network.getSubnetByName(selectedItem));
			}
		}
	}
	
	public void verifyHosts() {
//		Subnet subnet = new Subnet();
//		HostPresenter hostPresenter = new HostPresenter(subnet);
//		HostDialog hostDialog = new HostDialog(hostPresenter);
//		hostPresenter.setDialog(hostDialog);
//		hostDialog.setVisible(true);
	}
}