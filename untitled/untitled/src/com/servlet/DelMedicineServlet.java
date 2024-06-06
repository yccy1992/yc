package com.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.service.MedicineService;
import com.service.UserService;
import com.service.impl.MedicineServiceImpl;
import com.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/delMedicineServlet")
public class DelMedicineServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String parameter;
    public DelMedicineServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // TODO Auto-generated method stub
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String id = request.getParameter("id");
        MedicineService medicine = new MedicineServiceImpl();
        boolean flag = medicine.delMedicineById(id);
        JSONObject jobject = new JSONObject();
        if(flag) {
            jobject.put("code", 0);//0�ɹ�
            jobject.put("msg", "ɾ���ɹ�");
        }else {
            jobject.put("code", 1);
            jobject.put("msg", "ɾ��ʧ��");
        }
        System.out.println(JSON.toJSONString(jobject));
        response.getWriter().println(JSON.toJSONString(jobject));
    }
}
