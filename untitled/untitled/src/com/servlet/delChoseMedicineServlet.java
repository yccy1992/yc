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

@WebServlet("/delChoseMedicineServlet")
public class delChoseMedicineServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public delChoseMedicineServlet() {
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
        String ids = request.getParameter("ids");
        //System.out.println("ids:"+ids);
        /*
         * 1.����service����󣬴���ids
         * 2.service����dao��ɾ����ɾ��
         * 3.����service����õķ��ؽ�������سɹ��������������
         */
        boolean flag = false;
        String[] _ids = ids.split(",");
        MedicineService medicine = new MedicineServiceImpl();
        flag = medicine.delChoseMedicineByIds(_ids);
        JSONObject jobject = new JSONObject();
        if(flag) {
            jobject.put("code", 0);//0����ɹ�
            jobject.put("msg", "ɾ���ɹ�!");
        }else {
            jobject.put("code", 1);//1����ʧ��
            jobject.put("msg", "ɾ��ʧ��!");
        }
        System.out.println(JSON.toJSONString(jobject));
        response.getWriter().println(JSON.toJSONString(jobject));


    }
}
