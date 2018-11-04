package dao.impl;

import dao.ContactDao;
import enity.Model;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import util.JdbcUtil;
import util.JdbcUtil2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactDaoMySQLImpl implements ContactDao{
    @Override
    public void insertContact(Model model) {
        Connection conn=null;
        PreparedStatement pstmt=null;
        try {
            //conn= JdbcUtil.getConnection();
            QueryRunner queryRunner=new QueryRunner(JdbcUtil2.getDataSources());
            String insertSql="insert into contact_infor(name,Gender,age,phone,email,qq) VALUE (?,?,?,?,?,?)";
            queryRunner.update(insertSql,new Object[]{model.getName(),model.getGender(),model.getAge(),
                    model.getPhone(),model.getEmail(),model.getQQ()});
           /*
           pstmt=conn.prepareStatement(insertSql);
            pstmt.setString(1,model.getName());
            pstmt.setString(2,model.getGender());
            pstmt.setInt(3,model.getAge());
            pstmt.setLong(4,model.getPhone());
            pstmt.setString(5,model.getEmail());
            pstmt.setInt(6,model.getQQ());
            pstmt.executeUpdate();
            */
        } catch (SQLException e) {
            e.printStackTrace();
            throw  new RuntimeException(e);
        }
    }

    @Override
    public void updateContact(Model model) {
        Connection conn=null;
        PreparedStatement pstmt=null;
        try {
            //conn= JdbcUtil.getConnection();
            QueryRunner queryRunner=new QueryRunner(JdbcUtil2.getDataSources());
            String updateSql="Update contact_infor SET name=?,gender=?,age=?,phone=?,email=?,QQ=? WHERE ID=?";
            queryRunner.update(updateSql,new Object[]{model.getName(),model.getGender(),model.getAge(),
                    model.getPhone(),model.getEmail(),model.getQQ(),model.getId()});
            /*pstmt=conn.prepareStatement(updateSql);
            pstmt.setString(1,model.getName());
            pstmt.setString(2,model.getGender());
            pstmt.setInt(3,model.getAge());
            pstmt.setLong(4,model.getPhone());
            pstmt.setString(5,model.getEmail());
            pstmt.setInt(6,model.getQQ());
            pstmt.setInt(7,model.getId());
            pstmt.executeUpdate();*/
        } catch (SQLException e) {
            e.printStackTrace();
            throw  new RuntimeException(e);
        } finally {
            //JdbcUtil.close(pstmt,conn);
        }
    }

    @Override
    public void deleteContact(int id) {
        Connection conn=null;
        PreparedStatement pstmt=null;
        try {
            //conn= JdbcUtil.getConnection();
            QueryRunner queryRunner=new QueryRunner(JdbcUtil2.getDataSources());
            String deleteSql="DELETE from contact_infor WHERE id=?";
            queryRunner.update(deleteSql,new Object[]{id});
            /*pstmt=conn.prepareStatement(deleteSql);
            pstmt.setInt(1,id);
            pstmt.executeUpdate();*/
        } catch (SQLException e) {
            e.printStackTrace();
            throw  new RuntimeException(e);
        } finally {
            //JdbcUtil.close(pstmt,conn);
        }
    }

    @Override
    public List<Model> listContact() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        List<Model> listModel;
         ResultSet rs=null;
        try {
            //conn = JdbcUtil.getConnection();
            String listSql = "Select * from contact_infor";
            QueryRunner queryRunner=new QueryRunner(JdbcUtil2.getDataSources());
            listModel=(List<Model>)queryRunner.query(listSql, new BeanListHandler(Model.class), new Object[]{});
            /*pstmt = conn.prepareStatement(listSql);
             rs = pstmt.executeQuery();
            listModel = new ArrayList<>();
            while (rs.next()) {
                Model model = new Model();
                model.setId(rs.getInt("id"));
                model.setName(rs.getString("name"));
                model.setGender(rs.getString("gender"));
                model.setAge(rs.getInt("age"));
                model.setEmail(rs.getString("email"));
                model.setPhone(rs.getLong("phone"));
                model.setQQ(rs.getInt("qq"));
                listModel.add(model);
            }*/
            return listModel;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            //JdbcUtil.close(rs,pstmt, conn);
        }
    }

    @Override
    public Model getContact(int id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        Model model = null;
        ResultSet rs=null;
        try {
           // conn = JdbcUtil.getConnection();
            QueryRunner queryRunner=new QueryRunner(JdbcUtil2.getDataSources());
            String listSql = "Select * from contact_infor WHERE id=?";
             model = (Model) queryRunner.query(listSql, new BeanHandler(Model.class), new Object[]{id});
            /*pstmt = conn.prepareStatement(listSql);
            pstmt.setInt(1,id);
            rs = pstmt.executeQuery();
            if (rs.next()){
                model = new Model();
                model.setId(rs.getInt("id"));
                model.setName(rs.getString("name"));
                model.setGender(rs.getString("gender"));
                model.setAge(rs.getInt("age"));
                model.setEmail(rs.getString("email"));
                model.setPhone(rs.getLong("phone"));
                model.setQQ(rs.getInt("qq"));
            }*/
            return model;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            //JdbcUtil.close(rs,pstmt, conn);
        }
    }

    @Override
    public boolean checkNameExist(String name) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            //conn = JdbcUtil.getConnection();
            conn= JdbcUtil2.getConnection();
            String listSql = "Select * from contact_infor WHERE name=?";
            pstmt = conn.prepareStatement(listSql);
            pstmt.setString(1,name);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            //JdbcUtil.close(pstmt, conn);
        }
    }
}