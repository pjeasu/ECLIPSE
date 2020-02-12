package edu.bit.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.bit.dao.DAO;
import edu.bit.dto.DTO;

public class ListCommand implements Bcommand {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
	
		DAO dao = new DAO();
		ArrayList<DTO> dtos = dao.list();
		req.setAttribute("list", dtos);
		
		
	}

}
