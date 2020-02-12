package edu.bit.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.bit.dao.DAO;

public class DeleteCommand implements Bcommand {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		String bId = req.getParameter("bId");
		DAO dao = new DAO();
		dao.delete(bId);

	}

}
