package edu.bit.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.bit.dao.DAO;
import edu.bit.dto.DTO;

public class ContentCommand implements Bcommand {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		String bId = req.getParameter("bId");
		
		DAO dao = new DAO();
		DTO dto = dao.contentView(bId);
		
		req.setAttribute("content_view", dto);

	}

}
