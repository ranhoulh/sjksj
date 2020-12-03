package resource;

import SQLmanager.SQLManager;
import Table.Students;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResourceStudents {
    protected List<Students> studentList;

    public static ResourceStudents StudentL = new ResourceStudents();

    private ResourceStudents(){


        Connection school = SQLManager.getConnection();

        PreparedStatement pst = null;
        List<Students> studentsList = new ArrayList<>();

        try {
            pst = school.prepareStatement("select * from Students");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
//                studentsList.add(new Shop(rs.getString("sno"),rs.getString("s_addr")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }



        this.studentList = new ArrayList<>();
    }

    public List<Students> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Students> studentList) {
        this.studentList = studentList;
    }
}
