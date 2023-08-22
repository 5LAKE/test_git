package day0822;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;


public class EmpViewEvt extends MouseAdapter {
	private EmpView ev;
	
	public EmpViewEvt(EmpView ev) {
		this.ev = ev;
		
		setEmpno();
	}
	
	public void setEmpno() {
		EmpDAO eDAO = EmpDAO.getInstance();
		
		try {
			List<String> listEmpno = eDAO.selecEmpno(); 
			for(String setEmpno : listEmpno) {
				ev.getDlmJlEmpno().addElement(setEmpno);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void mouseClicked(MouseEvent me) {
		if(me.getSource() == ev.getJlEmpno()) {
			selectEmpno();
		}
	}

	
	public void selectEmpno() {
		EmpDAO eDAO = EmpDAO.getInstance();
		
		String empno = ev.getJlEmpno().getSelectedValue();
			
		EmpVO eVO = new EmpVO();

		try {
			EmpInfoView eiv = new EmpInfoView(ev,eVO);
				eVO = eDAO.selectOneEmpInfo(empno);
				eiv.getJtfEmpno().setText(eVO.getEmpno());
				eiv.getJtfEname().setText(eVO.getEname());
				eiv.getJtfHiredate().setText(eVO.getHiredate());
				eiv.getJtfJob().setText(eVO.getJob());
				eiv.getJtfSal().setText(eVO.getSal());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
	}
	
}
