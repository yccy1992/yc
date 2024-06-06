package com.dao.impl;

import com.dao.MedicineDao;
import com.db.DBUtils;
import com.model.Medicine;
import com.model.PageBean;
import com.model.User;
import com.service.MedicineService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class MedicineDaoImpl  implements MedicineDao {
    private Connection con;
    private PreparedStatement psmt;
    private ResultSet rs;
    private String sql = "";
    private int row = 0;
    /**
     * ����û���Ϣ
     *
     * @param user
     * @return
     */
    @Override
    public boolean addMedicine(Medicine medicine) {

        // TODO Auto-generated method stub
        con = DBUtils.getConnection();
        sql = "insert into medicine_info(medicinename,type,dosage,address,adverse_reactions,component)values(?,?,?,?,?,?)";
        try {
            psmt = con.prepareStatement(sql);
            psmt.setString(1, medicine.getMedicinename());
            psmt.setString(2, medicine.getType());
            psmt.setInt(3, medicine.getDosage());
            psmt.setString(4, medicine.getAddress());
            psmt.setString(5, medicine.getAdverse_reactions());
            psmt.setString(6, medicine.getComponent());
            row = psmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            DBUtils.close(rs, psmt, con);
        }
        return row>0?true:false;
    }

    /**
     * ����idɾ���û�
     *
     * @param id
     * @return
     */
    @Override
    public boolean delMedicineById(int id) {

        // TODO Auto-generated method stub
        sql = "delete from medicine_info where id=?";
        con = DBUtils.getConnection();
        try {
            psmt = con.prepareStatement(sql);
            psmt.setInt(1, id);
            row = psmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            DBUtils.close(rs, psmt, con);
        }
        return row>0?true:false;
    }

    /**
     * ɾ��ָ��ids�ļ�¼��Ϣ
     *
     * @param ids
     * @return
     */
    @Override
    public boolean delChoseMedicineByIds(int[] ids) {

        // TODO Auto-generated method stub
        //delete from user_info where 1=1 and (id=?)
        //delete from user_info where 1=1 and (id=? or id=? or ...or id=?)
        boolean flag = false; //��ʶ���ݿ�����Ƿ�ɹ�
        sql = "delete from medicine_info where 1=1 and ( ";
        StringBuffer buff = new StringBuffer(sql);
        if(ids.length==1) {
            buff.append(" id = ? ) ");
        }else {
            for(int i=0;i<ids.length;i++) {
                if(i==ids.length-1) {
                    buff.append(" id = ? ) ");
                }else {
                    buff.append(" id = ? or ");
                }

            }
        }
        con = DBUtils.getConnection();
        try {
            con.setAutoCommit(false);
            psmt = con.prepareStatement(buff.toString());
            for(int i=0;i<ids.length;i++) {
                psmt.setInt(i+1, ids[i]);
            }
            row = psmt.executeUpdate();
            if(row == ids.length) {
                con.commit();
                flag = true;
            }else {
                con.rollback();
                flag = false;
            }
            con.setAutoCommit(true);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            DBUtils.close(rs, psmt, con);
        }
        return flag;


}

    /**
     * �����û�
     *
     * @param user
     * @return
     */
    @Override
    public boolean updateMedicine(Medicine user) {
        return false;
    }

    /**
     * ����id�����û���Ϣ
     *
     * @param id
     * @return
     */
    @Override
    public Medicine getMedicineById(int id) {

        // TODO Auto-generated method stub
        Medicine medicine = new Medicine();
        sql = "select * from medicine_info where id = ?";
        con = DBUtils.getConnection();
        try {
            psmt = con.prepareStatement(sql);
            psmt.setInt(1, id);
            rs = psmt.executeQuery();
            if(rs.next()) {
                medicine.setId(rs.getInt("id"));
                medicine.setMedicinename(rs.getString("medicinename"));
                medicine.setType(rs.getString("type"));
                medicine.setDosage(rs.getInt("dosage"));
                medicine.setAddress(rs.getString("address"));
                medicine.setAdverse_reactions(rs.getString("adverse_reactions"));
                medicine.setComponent(rs.getString("component"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            DBUtils.close(rs, psmt, con);
        }
        return medicine;
    }

    /**
     * ��ѯ���е��û���Ϣ
     *
     * @return
     */
    @Override
    public List<Medicine> getAllMedicine() {
        // TODO Auto-generated method stub
        con = DBUtils.getConnection();
        List<Medicine> list = new ArrayList<Medicine>();
        sql = "select * from medicine_info";
        try {
            psmt = con.prepareStatement(sql);
            rs = psmt.executeQuery();
            while(rs.next()) {
                Medicine medicine = new Medicine();
                medicine.setId(rs.getInt("id"));
                medicine.setMedicinename(rs.getString("medicinename"));
                medicine.setType(rs.getString("type"));
                medicine.setDosage(rs.getInt("dosage"));
                medicine.setAddress(rs.getString("address"));
                medicine.setAdverse_reactions(rs.getString("adverse_reactions"));
                medicine.setComponent(rs.getString("component"));
                list.add(medicine);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            DBUtils.close(rs, psmt, con);
        }
        return list;
    }

    /**
     * ��ȡ�����û�����Ŀ
     *
     * @return
     */
    @Override
    public int countAllMedicine() {
        return 0;
    }

    /**
     * ���ص�ǰҳ��¼�ļ���
     *
     * @param pagebean
     * @return
     */
    @Override
    public List<Medicine> findNowPageMedicine(PageBean pagebean) {
        return null;
    }

    /**
     * ���������ѯ�����ļ�¼�ĸ���
     *
     * @param conditions
     * @return
     */
    @Override
    public int countAllMedicineByCondition(Map<String, String[]> conditions) {
        // TODO Auto-generated method stub
        //condition:page,limit,name,address,email
        //sql = "select * from user_info where 1=1  "
        //sql = "select * from user_info where 1=1 and name like ? and address like ?"
        int count = 0;
        List<String> params = new ArrayList<String>();
        con = DBUtils.getConnection();
        sql = "select count(*) from medicine_info where 1=1 ";
        StringBuffer buff = new StringBuffer(sql);
        Set<String> set = conditions.keySet();
        Iterator<String> it = set.iterator();
        while(it.hasNext()) {
            String key = it.next();
            if("page".equals(key) || "limit".equals(key)) {
                continue;
            }else {
                String value = conditions.get(key)[0];
                if(value!=null && !"".equals(value)) {
                    buff.append(" and "+ key + " like ? ");
                    params.add("%"+value+"%");
                    // and name like "%��%";"%��%"
                }

            }
        }
        //sql = "select * from user_info where 1=1 and name = ? and address = ? and email = ?"
        try {
            psmt = con.prepareStatement(buff.toString());
            for(int i = 0;i<params.size();i++) {
                psmt.setString(i+1, params.get(i));
            }
            //System.out.println("psmt:"+psmt);
            rs = psmt.executeQuery();
            if(rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            DBUtils.close(rs, psmt, con);
        }
        return count;
    }

    /**
     * �������������ĵ�ǰҳ�ļ�¼�ļ���
     *
     * @param pagebean
     * @param conditions
     * @return
     */
    @Override
    public List<Medicine> findNowPageMedicineByCondition(PageBean pagebean, Map<String, String[]> conditions) {
        // TODO Auto-generated method stub
        con = DBUtils.getConnection();
        List<Medicine> list_medicine = new ArrayList<Medicine>();
        List<String> params = new ArrayList<String>();
        //sql = "select * from user_info where 1=1 and name like ? and address like ? limit ?,?"
        sql = "select * from medicine_info where 1=1 ";
        StringBuffer buff = new StringBuffer(sql);
        Set<String> set = conditions.keySet();
        Iterator<String> it = set.iterator();
        while(it.hasNext()) {
            String key = it.next();
            if("page".equals(key) || "limit".equals(key)) {
                continue;
            }else {
                String value = conditions.get(key)[0];
                if(value!=null && !"".equals(value)) {
                    buff.append(" and "+ key + " like ? ");
                    params.add("%"+value+"%");
                    // and name like "%��%";"%��%"
                }

            }
        }
        //sql = "select * from user_info where 1=1 and name like ? and address like ? and email like ?"
        buff.append(" limit ?,? ");
        //sql = "select * from user_info where 1=1 and name like ? and address like ? and email like ? limit ?,?"
        try {
            psmt = con.prepareStatement(buff.toString());
            for(int i = 0;i<params.size();i++) {
                psmt.setString(i+1, params.get(i));
            }
            psmt.setInt(params.size()+1, pagebean.getStart());
            psmt.setInt(params.size()+2, pagebean.getLimitPage());
            //System.out.println("psmt:"+psmt);
            rs = psmt.executeQuery();
            while(rs.next()) {
                Medicine medicine = new Medicine();
                medicine.setId(rs.getInt("id"));
                medicine.setMedicinename(rs.getString("medicinename"));
                medicine.setType(rs.getString("type"));
                medicine.setDosage(rs.getInt("dosage"));
                medicine.setAddress(rs.getString("address"));
                medicine.setAdverse_reactions(rs.getString("adverse_reactions"));
                medicine.setComponent(rs.getString("component"));
                list_medicine.add(medicine);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list_medicine;
    }
}
