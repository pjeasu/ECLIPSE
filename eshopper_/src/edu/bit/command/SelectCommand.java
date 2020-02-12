package edu.bit.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.bit.dao.Dao;
import edu.bit.dto.Dto;



public class SelectCommand implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {

		Dao dao = new Dao();
		ArrayList<Dto> dtos = dao.list();
		req.setAttribute("list", dtos);
	

	}

}
