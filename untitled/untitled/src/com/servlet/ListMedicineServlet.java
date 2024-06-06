package com.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.model.PageBean;
import com.service.MedicineService;
import com.service.UserService;
import com.service.impl.MedicineServiceImpl;
import com.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet("/ListMedicineServlet")
public class ListMedicineServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListMedicineServlet() {
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
        //����service���ؼ�¼���
        response.setContentType("text/html;charset=utf-8");
        Map<String, String[]> map = request.getParameterMap();

        //���Ի�ȡ����ܴ����ķ�ҳ��Ϣ page limit
        MedicineService medicine = new MedicineServiceImpl();

        PageBean pagebean = medicine.getNowPageMedicineByCondition(map);

        JSONObject jobject = new JSONObject();
        jobject.put("code", 0);//0����ɹ�
        jobject.put("msg", "");
        jobject.put("count", pagebean.getTotalCount());//�ܼ�¼��
        jobject.put("data", pagebean.getList());//��ǰҳ�����ݼ�¼
        System.out.println(JSON.toJSONString(jobject));
        response.getWriter().println(JSON.toJSONString(jobject));
    }
}
