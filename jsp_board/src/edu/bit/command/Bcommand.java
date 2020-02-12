package edu.bit.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Bcommand {
	void execute(HttpServletRequest req, HttpServletResponse res);

}
