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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SecondServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("Hello from SecondServlet INIT");
        super.init(config);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Hello from SecondServlet SERVICE");
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Hello from SecondServlet DOGET");

        PrintWriter writer = resp.getWriter();
        writer.println("Hello from SecondServlet");
    }

    @Override
    public void destroy() {
        System.out.println("Hello from SecondServlet DESTROY");
        super.destroy();
    }
}