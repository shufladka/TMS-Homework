/*
Написать два сервлета и один фильтр.
Фильтр должен перехватывать все запросы которые идут только на второй сервлет.
Задача:
	1) фильтр должен блокировать все запросы, идущие на сервлет, кроме тех, в которых есть определенные данные;
	2) первый сервлет (без фильтра) должен эти данные предоставлять.
*/

package org.tms.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class FirstServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("Hello from FirstServlet INIT");
        super.init(config);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Hello from FirstServlet SERVICE");
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Hello from FirstServlet DOGET");

        PrintWriter writer = resp.getWriter();
        writer.println("Hello from FirstServlet");

        resp.addCookie(new Cookie("cookieKey", "cookieValue"));
    }

    @Override
    public void destroy() {
        System.out.println("Hello from FirstServlet DESTROY");
        super.destroy();
    }
}