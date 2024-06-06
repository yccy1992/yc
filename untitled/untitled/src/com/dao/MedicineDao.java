package com.dao;

import com.model.Medicine;
import com.model.PageBean;
import com.model.User;

import java.util.List;
import java.util.Map;

public interface MedicineDao {
    /**
     * ����û���Ϣ
     * @param user
     * @return
     */
    public boolean addMedicine(Medicine user);
    /**
     * ����idɾ���û�
     * @param id
     * @return
     */
    public boolean delMedicineById(int id);
    /**
     * ɾ��ָ��ids�ļ�¼��Ϣ
     * @param ids
     * @return
     */
    public boolean delChoseMedicineByIds(int[] ids);
    /**
     * �����û�
     * @param user
     * @return
     */
    public boolean updateMedicine(Medicine user);
    /**
     * ����id�����û���Ϣ
     * @param id
     * @return
     */
    public Medicine getMedicineById(int id);

    /**
     * ��ѯ���е��û���Ϣ
     * @return
     */
    public List<Medicine> getAllMedicine();
    /**
     * ��ȡ�����û�����Ŀ
     * @return
     */
    public int countAllMedicine();
    /**
     * ���ص�ǰҳ��¼�ļ���
     * @param pagebean
     * @return
     */
    public List<Medicine> findNowPageMedicine(PageBean pagebean);
    /**
     * ���������ѯ�����ļ�¼�ĸ���
     * @param conditions
     * @return
     */
    public int countAllMedicineByCondition(Map<String, String[]> conditions);
    /**
     * �������������ĵ�ǰҳ�ļ�¼�ļ���
     * @param pagebean
     * @param conditions
     * @return
     */
    public List<Medicine> findNowPageMedicineByCondition(PageBean pagebean,Map<String, String[]> conditions);
}
