package com.cqs.demo.jetty;

import com.cqs.demo.models.douban.service.impl.MovieServiceHessian;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HessianTest {
    static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:spring/*.xml");

    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        ServletContextHandler context = new ServletContextHandler(
                ServletContextHandler.SESSIONS);
        server.setHandler(context);
        ServletHolder servletHolder = new ServletHolder(new BasicService());
        MovieServiceHessian movieService = applicationContext.getBean(MovieServiceHessian.class);
        System.out.println(movieService);
        ServletHolder servletHolder2 = new ServletHolder(movieService);
        context.addServlet(servletHolder, "/test");
        context.addServlet(servletHolder2, "/movie");
        server.start();
        server.join();
    }

}




