package org.kurs.utils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
import org.kurs.beans.Agreement;
import org.kurs.beans.RegAgreement;
import org.kurs.beans.RegRequest;
import org.kurs.beans.Request;
import org.kurs.beans.UserAccount;
public class DBUtils {
	public static UserAccount findUser(Connection conn, //
            String userName, String password) throws SQLException {
 
        String sql = "Select a.User_Name, a.Password, a.Gender from User_Account a " //
                + " where a.User_Name = ? and a.password= ?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
        pstm.setString(2, password);
        ResultSet rs = pstm.executeQuery();
 
        if (rs.next()) {
            String gender = rs.getString("Gender");
            UserAccount user = new UserAccount();
            user.setUserName(userName);
            user.setPassword(password);
            user.setGender(gender);
            return user;
        }
        return null;
    }
 
    public static UserAccount findUser(Connection conn, String userName) throws SQLException {
 
        String sql = "Select a.User_Name, a.Password, a.Gender from User_Account a "//
                + " where a.User_Name = ? ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
 
        ResultSet rs = pstm.executeQuery();
 
        if (rs.next()) {
            String password = rs.getString("Password");
            String gender = rs.getString("Gender");
            UserAccount user = new UserAccount();
            user.setUserName(userName);
            user.setPassword(password);
            user.setGender(gender);
            return user;
        }
        return null;
    }
 
    public static List<Agreement> queryAgreement(Connection conn) throws SQLException {
        String sql = "Select a.id, a.FIO, a.Service,a.kind,a.type,a.price from agreement a ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        ResultSet rs = pstm.executeQuery();
        List<Agreement> list = new ArrayList<Agreement>();
        while (rs.next()) {
            String FIO = rs.getString("FIO");
            String usluga = rs.getString("Service");
            String price = rs.getString("price");
            String type = rs.getString("type");
            String kind = rs.getString("kind");
            String idd = rs.getString("id");
            Agreement agreement = new Agreement();
            agreement.setFIO(FIO);
            agreement.setidd(idd);
            agreement.setkind(kind);
            agreement.setPrice(price);
            agreement.settype(type);
            agreement.setusluga(usluga);
            list.add(agreement);
        }
        return list;
    }
 
    public static Agreement findAgreement(Connection conn, String id) throws SQLException {
        String sql = "Select a.id, a.FIO, a.Service,a.type,a.kind,a.price from agreement a where a.id=?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, id);
 
        ResultSet rs = pstm.executeQuery();
 
        while (rs.next()) {
        	String FIO = rs.getString("FIO");
            String usluga = rs.getString("Service");
            String price = rs.getString("price");
            String type = rs.getString("type");
            String kind = rs.getString("kind");
            String idd = rs.getString("id");
 
            Agreement agreement = new Agreement( FIO,usluga,price,type,kind,idd);
            return agreement;
        }
        return null;
    }
 
    public static void updateAgreement(Connection conn, Agreement agreement) throws SQLException {
        String sql = "Update agreement set FIO =?, Service=?, kind=?, type=?, price=? where id=? ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, agreement.getFIO());
        pstm.setString(2, agreement.getusluga());
        pstm.setString(3, agreement.getkind());
        pstm.setString(4, agreement.gettype());
        pstm.setString(5, agreement.getPrice());
        pstm.setString(6, agreement.getidd());
        pstm.executeUpdate();
    }
 
    public static void insertAgreement(Connection conn, Agreement agreement) throws SQLException {
        String sql = "Insert into agreement(id, FIO, Service, kind,type,price) values (?,?,?,?,?,?)";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
       
        pstm.setString(1, agreement.getidd());
        pstm.setString(2, agreement.getFIO());
        pstm.setString(3, agreement.getusluga());
        pstm.setString(4, agreement.getkind());
        pstm.setString(5, agreement.gettype());
        pstm.setString(6, agreement.getPrice());
        
        pstm.executeUpdate();
    }
 
    public static void deleteAgreement(Connection conn, String id) throws SQLException {
        String sql = "Delete From agreement where id= ?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, id);
 
        pstm.executeUpdate();
    }
    public static List<RegAgreement> queryRegAgreement(Connection conn) throws SQLException {
        String sql = "Select a.id,a.Data, a.FIO, a.OI, a.type, a.kind from regagreement a ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        ResultSet rs = pstm.executeQuery();
        List<RegAgreement> list = new ArrayList<RegAgreement>();
        while (rs.next()) {
            String FIO = rs.getString("FIO");
            String Data = rs.getString("Data");
            String OI = rs.getString("OI");
            String type = rs.getString("type");
            String kind = rs.getString("kind");
            String idd = rs.getString("id");
            RegAgreement regagreement = new RegAgreement();
            regagreement.setFIO(FIO);
            regagreement.setid(idd);
            regagreement.setkind(kind);
            regagreement.setOI(OI);
            regagreement.settype(type);
            regagreement.setdata(Data);
            list.add(regagreement);
        }
        return list;
    }
 
    public static RegAgreement findRegAgreement(Connection conn, String idd) throws SQLException {
        String sql = "Select a.id,a.Data, a.FIO, a.OI, a.type, a.kind from regagreement a where a.id=?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, idd);
 
        ResultSet rs = pstm.executeQuery();
 
        while (rs.next()) {
        	String FIO = rs.getString("FIO");
            String Data = rs.getString("Data");
            String OI = rs.getString("OI");
            String type = rs.getString("type");
            String kind = rs.getString("kind");
            String id = rs.getString("id");
 
            RegAgreement regagreement = new RegAgreement( FIO,Data,OI, type,kind, id);
            return regagreement;
        }
        return null;
    }
    public static void updateRegAgreement(Connection conn, RegAgreement regagreement) throws SQLException {
        String sql = "Update regagreement set Data =?, FIO=?, OI=?, type=?, kind=? where id=? ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, regagreement.getdata());
        pstm.setString(2, regagreement.getFIO());
        pstm.setString(3, regagreement.getOI());
        pstm.setString(4, regagreement.gettype());
        pstm.setString(5, regagreement.getkind());
        pstm.setString(6, regagreement.getid());
        pstm.executeUpdate();
    }
   /* public static void updateRegAgreement(Connection conn, RegAgreement regagreement) throws SQLException {
        String sql = "Update regagreement set Data =?, set FIO =?, OI=?, type=?, kind=? where id=? ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, regagreement.getdata());
        pstm.setString(2, regagreement.getFIO());
        pstm.setString(3, regagreement.getOI());
        pstm.setString(4, regagreement.gettype());
        pstm.setString(5, regagreement.getkind());
        pstm.setString(6, regagreement.getid());
        pstm.executeUpdate();
    }*/
 
    public static void insertRegAgreement(Connection conn, RegAgreement regagreement) throws SQLException {
        String sql = "Insert into regagreement(id,Data,FIO,OI,type,kind) values (?,?,?,?,?,?)";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
       
        pstm.setString(1, regagreement.getid());
        pstm.setString(2, regagreement.getdata());
        pstm.setString(3, regagreement.getFIO());
        pstm.setString(4, regagreement.getOI());
        pstm.setString(5, regagreement.gettype());
        pstm.setString(6, regagreement.getkind());
        
        
        pstm.executeUpdate();
    }
 
    public static void deleteRegAgreement(Connection conn, String id) throws SQLException {
        String sql = "Delete From regagreement where id= ?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, id);
 
        pstm.executeUpdate();
    }
    public static List<RegRequest> queryRegRequest(Connection conn) throws SQLException {
        String sql = "Select a.id,a.Data, a.FIO, a.State, a.Service from regrequest a ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        ResultSet rs = pstm.executeQuery();
        List<RegRequest> list = new ArrayList<RegRequest>();
        while (rs.next()) {
            String FIO = rs.getString("FIO");
            String Data = rs.getString("Data");
            String State = rs.getString("State");
            String Service = rs.getString("Service");
            String id = rs.getString("id");
            RegRequest regrequest = new RegRequest();
            regrequest.setFIO(FIO);
            regrequest.setid(id);
            regrequest.setusluga(Service);
            regrequest.setdata(Data);
            regrequest.setstate(State);
    
            list.add(regrequest);
        }
        return list;
    }
 
    public static RegRequest findRegRequest(Connection conn, String idr) throws SQLException {
        String sql = "Select a.id,a.Data, a.FIO, a.State, a.Service from regrequest a where a.id=?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, idr);
 
        ResultSet rs = pstm.executeQuery();
 
        while (rs.next()) {
        	String FIO = rs.getString("FIO");
            String Data = rs.getString("Data");
            String State = rs.getString("State");
            String Service = rs.getString("Service");
            String id = rs.getString("id");
 
            RegRequest regreq = new RegRequest(FIO,Service,Data,State,id);
            return regreq;
        }
        return null;
    }
    public static void updateRegRequest(Connection conn, RegRequest regrequest) throws SQLException {
        String sql = "Update regrequest set Data =?, FIO=?, State=?, Service=? where id=? ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, regrequest.getdata());
        pstm.setString(2, regrequest.getFIO());
        pstm.setString(3, regrequest.getstate());
        pstm.setString(4, regrequest.getusluga());
        pstm.setString(5, regrequest.getid());
        pstm.executeUpdate();
    }
   /* public static void updateRegRequest(Connection conn, RegRequest regreq) throws SQLException {
        String sql = "Update regrequest set Data =?, set FIO =?, State=?, Service=? where id=? ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, regreq.getdata());
        pstm.setString(2, regreq.getFIO());
        pstm.setString(3, regreq.getstate());
        pstm.setString(4, regreq.getusluga());
        pstm.setString(5, regreq.getid());
        pstm.executeUpdate();
    }*/
 
    public static void insertRegRequest(Connection conn, RegRequest regreq) throws SQLException {
        String sql = "Insert into regrequest(id,Data,FIO,State,Service) values (?,?,?,?,?)";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
       
        pstm.setString(1, regreq.getid());
        pstm.setString(2, regreq.getdata());
        pstm.setString(3, regreq.getFIO());
        pstm.setString(4, regreq.getstate());
        pstm.setString(5, regreq.getusluga());

        pstm.executeUpdate();
    }
 
    public static void deleteRegRequest(Connection conn, String id) throws SQLException {
        String sql = "Delete From regrequest where id= ?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, id);
 
        pstm.executeUpdate();
    }
    public static List<Request> queryRequest(Connection conn) throws SQLException {
        String sql = "Select a.id,a.FIO,a.Service,a.Telephone,a.Email from request a ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        ResultSet rs = pstm.executeQuery();
        List<Request> list = new ArrayList<Request>();
        while (rs.next()) {
            String FIO = rs.getString("FIO");
            String Service = rs.getString("Service");
            String Email = rs.getString("Email");
            String Telephone = rs.getString("Telephone");
            String id = rs.getString("id");
            Request request = new Request();
            request.setFIO(FIO);
            request.setidr(id);
            request.setusluga(Service);
            request.settelephone(Telephone);;
            request.setEmail(Email);
    
            list.add(request);
        }
        return list;
    }
 
    public static Request findRequest(Connection conn, String idr) throws SQLException {
        String sql = "Select a.id,a.FIO,a.Service,a.Telephone,a.Email from request a  where a.id=?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, idr);
 
        ResultSet rs = pstm.executeQuery();
 
        while (rs.next()) {
        	 String FIO = rs.getString("FIO");
             String Service = rs.getString("Service");
             String Email = rs.getString("Email");
             String Telephone = rs.getString("Telephone");
             String id = rs.getString("id");
            Request req = new Request(FIO,Service,Telephone,Email,id);
            return req;
        }
        return null;
    }
    public static void updateRequest(Connection conn, Request request) throws SQLException {
        String sql = "Update request set FIO =?, Service=?, Telephone=?, Email=? where id=? ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, request.getFIO());
        pstm.setString(2, request.getusluga());
        pstm.setString(3, request.gettelephone());
        pstm.setString(4, request.getEmail());
        pstm.setString(5, request.getidr());
        pstm.executeUpdate();
    }
 
  /*  public static void updateRequest(Connection conn, Request req) throws SQLException {
        String sql = "Update request set FIO =?,Service=?, set Telephone =?, set Email =?  where id=? ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);

        pstm.setString(1, req.getFIO());
        pstm.setString(2, req.getusluga());
        pstm.setString(3, req.gettelephone());
        pstm.setString(4, req.getEmail());
        pstm.setString(5, req.getidr());
        pstm.executeUpdate();
    }*/
 
    public static void insertRequest(Connection conn, Request req) throws SQLException {
        String sql = "Insert into request(id,FIO,Service,Telephone,Email) values (?,?,?,?,?)";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
       
        pstm.setString(1, req.getidr());
        pstm.setString(2, req.getFIO());
        pstm.setString(3, req.getusluga());
        pstm.setString(4, req.gettelephone());
        pstm.setString(5, req.getEmail());

        pstm.executeUpdate();
    }
 
    public static void deleteRequest(Connection conn, String id) throws SQLException {
        String sql = "Delete From request where id= ?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, id);
 
        pstm.executeUpdate();
    }
}
