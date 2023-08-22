package day0822;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EmpInfoViewEvt extends WindowAdapter {
	private EmpInfoView eiv;
	
	public EmpInfoViewEvt() {
		this.eiv=eiv;
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		eiv.dispose();
	}
	
	
	public void setEmpData(EmpVO evo) {
		eiv.getJtfEmpno().setText(evo.getEmpno());
	}

}
