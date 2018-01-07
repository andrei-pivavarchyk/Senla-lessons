package com.servlet;

import com.dao.IRoomDAO;
import com.dao.RoomDAO;
import com.dependencyService.DependencyService;

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
import org.json.JSONException;
import org.json.JSONObject;

public class Servlet extends HttpServlet {
    public class AuthServlet extends HttpServlet {
     /*   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException, JSONException {
            response.setContentType("application/json");//Отправляем от сервера данные в JSON -формате
            response.setCharacterEncoding("utf-8");//Кодировка отправляемых данных
            try (PrintWriter out = response.getWriter()) {
                JSONObject jsonEnt = new JSONObject();
                if (request.getParameter("login").equals("myLogin") && request.getParameter("password").equals("myPassword")) {
                    jsonEnt.put("backgroundColor", "#99CC66");
                    jsonEnt.put("serverInfo", "Вы вошли!");
                } else {
                    jsonEnt.put("backgroundColor", "#CC6666");
                    jsonEnt.put("serverInfo", "Введен неправильный логин или пароль!");
                }
                out.print(jsonEnt.toString());
            }*/
        }

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
          /*  try {
                processRequest(request, response);
            } catch (JSONException ex) {
                Logger.getLogger(HttpServlet.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {

        Room room=new Room(3,4,5,69999,7);
            RoomDAO roomDAO=new RoomDAO();
            roomDAO.addEntity(room);
             /*  try {
                processRequest(request, response);
            } catch (JSONException ex) {
                Logger.getLogger(HttpServlet.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        }

        @Override
        public String getServletInfo() {
            return "Short description";
        }//

    }
