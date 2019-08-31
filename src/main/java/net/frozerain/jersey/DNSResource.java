package net.frozerain.jersey;

import net.frozerain.jersey.db.DBManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DNSResource {
    private Connection connection = null;
    private static int max;
    private static String url = "jdbc:h2:tcp://localhost:9092/nio:~/db/DNSdb;AUTO_SERVER=TRUE";

    public DNSResource() {
        DBManager manager = new DBManager(url, "sa", "");
        this.connection = manager.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("select max(ID) from DOMAINNAMES");
            if (set.next()) {
                max = set.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public List<DNSModel> getAllRecordDB(){
        List<DNSModel> list = new ArrayList<>();
        String sql = "select * from domainnames";
        try {
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(sql);
            while (resultSet.next()){
                DNSModel dm = new DNSModel();
                dm.setDomen(resultSet.getString(1));
                dm.setAddress(resultSet.getString(2));
                dm.setId(resultSet.getInt(3));
                list.add(dm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public DNSModel getRecordDB(int id){
        String sql = "select * from domainnames where ID=?";
        PreparedStatement st = null;
        DNSModel dm = null;
        try {
            st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet resultSet = st.executeQuery();
            if (resultSet.next()){
                dm = new DNSModel();
                dm.setDomen(resultSet.getString(1));
                dm.setAddress(resultSet.getString(2));
                dm.setId(resultSet.getInt(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dm;
    }
    public boolean addRecordDB(DNSModel model){
        String sql = "insert into DOMAINNAMES values (?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, model.getDomen());
            statement.setString(2, model.getAddress());
            statement.setInt(3, max + 1);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public void updateRecordDB(DNSModel model){
        String sql = "update DOMAINNAMES set DOMAIN=?, ADDRESS=? where ID=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, model.getDomen());
            statement.setString(2, model.getAddress());
            statement.setInt(3, model.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteRecordDB(int id) {
        String sql = "delete from DOMAINNAMES where ID=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
