package com.service;

import java.util.List;
import java.util.Map;

import com.model.Medicine;
import com.model.PageBean;
import com.model.User;

public interface MedicineService {
    /**
     * ����û�
     * @param medicine
     * @return
     */
    public boolean addMedicine(Medicine medicine);
    /**
     * ɾ���û�
     * @param id
     * @return
     */
    public boolean delMedicineById(String id);
    /**
     * ɾ��ѡ���û���Ϣ
     * @param ids
     * @return
     */
    public boolean delChoseMedicineByIds(String[] ids);
    /**
     * �����û�
     * @param Medicine
     * @return
     */
    public boolean updateMedicine(Medicine medicine);
    /**
     * ����id��ȡָ���û�����Ϣ
     * @param id
     * @return
     */
    public Medicine findMedicineById(String id);
    /**
     *
     * @param page
     * @param limit
     * @return
     */
    public PageBean getNowPageMedicine(String page, String limit);
    /**
     * ���������ѯ�����ĵ�ǰҳ��¼�ļ���
     * @param pagebean
     * @param conditions
     * @return
     */
    public PageBean<Medicine> getNowPageMedicineByCondition(Map<String, String[]> conditions);
    /**
     * �������м�¼�ļ���
     * @return
     */
    public List<Medicine> findAllMedicine();
}
