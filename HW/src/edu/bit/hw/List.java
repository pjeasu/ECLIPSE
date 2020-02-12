package edu.bit.hw;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class List implements Service{

	@Override
	public ArrayList<MemberDto> execute(HttpServletRequest request, HttpServletResponse response) {
			MemberDao dao = MemberDao.getInstance();
			return dao.membersAll();
	}
}

