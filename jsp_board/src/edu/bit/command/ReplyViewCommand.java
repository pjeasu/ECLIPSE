package edu.bit.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.bit.dao.DAO;
import edu.bit.dto.DTO;

public class ReplyViewCommand implements Bcommand {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		String bId = req.getParameter("bId");
		DAO dao = new DAO();
		DTO dto = dao.reply_view(bId);
		
		req.setAttribute("reply_view", dto);

	}

}
