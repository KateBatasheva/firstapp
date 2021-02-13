package com.geekbrains.firstapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "FirstServlet", urlPatterns = "/shop")
public class FirstServlet extends HttpServlet {

    private static Logger log = LoggerFactory.getLogger(FirstServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("get");
        resp.getWriter().printf("<html><body><h1>Shop</h1></body></html>");
        String [] fruits = {"Apple", "Peach", "Orange", "Kiwi", "Pear", "Strawberry", "Blueberry", "Lemon", "Melon", "Cherry"};
        Random random = new Random();
        Product[] products = new Product[10];
        for (int i = 0; i <products.length ; i++) {
            products[i] = new Product(fruits[i], i+1, random.nextDouble()*10);
            resp.getWriter().printf("<html><body><br> %d - %s - %f </br></body></html>", products[i].getId(), products[i].getTitle(), products[i].getCost());
        }

    }

    @Override
    public void destroy() {
        log.debug("destroy");
    }

    @Override
    public void init() throws ServletException {
        log.debug("init");
    }
}
