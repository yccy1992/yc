package com.servlet;

import com.model.Medicine;
import com.model.User;
import com.service.MedicineService;
import com.service.UserService;
import com.service.impl.MedicineServiceImpl;
import com.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/addMedicineServlet")
public class AddMedicineServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMedicineServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        Medicine medicine = new Medicine();
        PrintWriter out = response.getWriter();
        try {
            BeanUtils.populate(medicine, parameterMap);
            //System.out.println(user);
            MedicineService us = new MedicineServiceImpl();
            boolean flag = us.addMedicine(medicine);
            if(flag) {
                //out.println("<script>alert('添加成功')</script>");
                response.setHeader("refresh", "1");
            }else {
                //out.println("<script>alert('添加成功')</script>");
                response.setHeader("refresh", "1");
            }
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
