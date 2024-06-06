package com.servlet;

import com.model.Medicine;
import com.model.User;
import com.service.MedicineService;
import com.service.UserService;
import com.service.impl.MedicineServiceImpl;
import com.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getMedicineServlet")
public class GetMedicineServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMedicineServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        this.doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String id = request.getParameter("id");
        //System.out.println("id="+id);
        /*
         * 1.����service���������ظ�id��Ӧ��¼��������Ϣ��user
         * 2.��user�����װ��request�������,reuqest.setAttrubute("user",user);
         * 3.������ת���ķ�ʽ����ת���༭ҳ�������ʾ
         */
        MedicineService userv = new MedicineServiceImpl();
        Medicine medicine = userv.findMedicineById(id);
        request.setAttribute("medicine", medicine);
        System.out.println("medicine:"+medicine);
        request.getRequestDispatcher("/medicine/editMedicine.jsp").forward(request, response);
    }

}
