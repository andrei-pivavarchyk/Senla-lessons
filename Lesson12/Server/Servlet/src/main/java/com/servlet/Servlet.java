package com.servlet;

import com.dao.IRoomDAO;
import com.dao.RoomDAO;
import com.dependencyService.DependencyService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Room;
import com.serverQueryService.ClientQueryService.ClientQueryService;
import org.json.JSONException;
import org.json.JSONObject;

public class Servlet extends HttpServlet {
    public class AuthServlet extends HttpServlet {
        }

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {

            StringBuffer sb = new StringBuffer();
            String line = null;

            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null)
                sb.append(line);

            try {

                String query=sb.toString();
                 Object o= ClientQueryService.queryHandler(query);
                response.setContentType("text/plain");
                response.getWriter().write(o.toString());
            } catch (JSONException e) {
                response.getWriter().write(e.toString());
            }

        }

        @Override
        public String getServletInfo() {
            return "Short description";
        }//

    }
