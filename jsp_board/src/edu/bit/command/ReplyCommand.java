package edu.bit.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.bit.dao.DAO;

public class ReplyCommand implements Bcommand {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		String bId = req.getParameter("bId");
		String bName = req.getParameter("bName");
		String bTitle = req.getParameter("bTitle");
		String bContent = req.getParameter("bContent");
		String bGroup = req.getParameter("bGroup");
		String bStep = req.getParameter("bStep");
		String bIndent = req.getParameter("bIndent");
		
		DAO dao = new DAO();
	
		dao.reply(bId, bName, bTitle, bContent, bGroup, bStep, bIndent);
	}

}
