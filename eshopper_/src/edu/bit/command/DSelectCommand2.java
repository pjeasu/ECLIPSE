package edu.bit.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.bit.dto.Dto2;
import edu.bit.dao.Dao2;


public class DSelectCommand2 implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {


		Dao2 dao2 = new Dao2();
		ArrayList<Dto2> dtos2 = dao2.list2();
		req.setAttribute("list2", dtos2);

	}

}
