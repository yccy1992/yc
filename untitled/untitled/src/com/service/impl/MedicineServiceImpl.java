package com.service.impl;

import com.dao.MedicineDao;
import com.dao.UserDao;
import com.dao.impl.MedicineDaoImpl;
import com.dao.impl.UserDaoImpl;
import com.model.Medicine;
import com.model.PageBean;
import com.model.User;
import com.service.MedicineService;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MedicineServiceImpl implements MedicineService {

    private MedicineDao dao = new MedicineDaoImpl();
    /**
     * ����û�
     *
     * @param medicine
     * @return
     */
    @Override
    public boolean addMedicine(Medicine medicine) {

        return dao.addMedicine(medicine);
    }

    /**
     * ɾ���û�
     *
     * @param id
     * @return
     */
    @Override
    public boolean delMedicineById(String id) {

        int id_int = 0;
        if(id!=null || id!="") {
            id_int =Integer.parseInt(id);
        }
        return dao.delMedicineById(id_int);
    }

    /**
     * ɾ��ѡ���û���Ϣ
     *
     * @param ids
     * @return
     */
    @Override
    public boolean delChoseMedicineByIds(String[] ids) {
        // TODO Auto-generated method stub
        int[] _ids = Arrays.asList(ids).stream().mapToInt(Integer::parseInt).toArray();
        return dao.delChoseMedicineByIds(_ids);
    }

    /**
     * �����û�
     *
     * @param medicine@return
     */
    @Override
    public boolean updateMedicine(Medicine medicine) {
        return false;
    }

    /**
     * ����id��ȡָ���û�����Ϣ
     *
     * @param id
     * @return
     */
    @Override
    public Medicine findMedicineById(String id) {

        int _id = 0;
        if(id!=null && !"".equals(id)) {
            _id = Integer.parseInt(id);
        }
        return dao.getMedicineById(_id);
    }

    /**
     * @param page
     * @param limit
     * @return
     */
    @Override
    public PageBean getNowPageMedicine(String page, String limit) {
        return null;
    }

    /**
     * ���������ѯ�����ĵ�ǰҳ��¼�ļ���
     *
     * @param conditions
     * @return
     */
    @Override
    public PageBean<Medicine> getNowPageMedicineByCondition(Map<String, String[]> conditions) {
        // TODO Auto-generated method stub
        /**
         * 1.��������ѯ�������ܼ�¼��
         * 2.��õ�ǰҳ��Ϣ
         * 3.���ÿҳ��ʾ�ļ�¼����Ϣ
         */
        int totalCount = dao.countAllMedicineByCondition(conditions);//where
        String page = conditions.get("page")[0];
        String limit = conditions.get("limit")[0];
        int _page = 0;//��ǰҳ
        int _limit = 0;//ÿҳ��ʾ�ļ�¼��
        if(page!=null && !"".equals(page)) {
            _page = Integer.parseInt(page);
        }
        if(limit!=null && !"".equals(limit)) {
            _limit = Integer.parseInt(limit);
        }
        PageBean<Medicine> pagebean = new PageBean<Medicine>(totalCount,_page,_limit);
        List<Medicine> list = dao.findNowPageMedicineByCondition(pagebean, conditions);
        pagebean.setList(list);
        return pagebean;
    }

    /**
     * �������м�¼�ļ���
     *
     * @return
     */
    @Override
    public List<Medicine> findAllMedicine() {
        return dao.getAllMedicine();
    }
}
