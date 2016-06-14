package Presenter;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import GUI.ChangeDescriptionDialog;
import GUI.HostDialog;
import Model.Host;
import Model.Subnet;

public class HostPresenter {
	
	private HostDialog dialog;
	private Subnet subnet;
	
	public HostPresenter(Subnet subnet) {
		this.subnet = subnet;
	}
	
	public void setDialog(HostDialog dialog) {
		this.dialog = dialog;
	}
	
	public void verifyOK() {
		dialog.dispose();
	}
	
	public void verifyChange() {
		if( dialog.getSelectedItem() != null ){
			ChangeDescriptionPresenter presenter = new ChangeDescriptionPresenter();
			ChangeDescriptionDialog dia = new ChangeDescriptionDialog(this, presenter);
			presenter.setDialog(dia);
			presenter.setHost(subnet.getHostByIPString(dialog.getSelectedItem()));
			dia.setModal(true);
			dia.setVisible(true);
		}
	}
	
	public void updateUI(){
		TableModel model = dialog.getTable().getModel();
		DefaultTableModel mod = (DefaultTableModel)model;
		mod.setRowCount(0);
		dialog.getTable().revalidate();
		for (Host host : subnet.getHosts() ) {
			mod.addRow( new Object[]{host.getName(), host.getIpv4Address().toDecimal(), host.getIpv4Address().toBinary()});
		}
	}
}
