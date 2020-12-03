package Frame;

import SQLmanager.SQLManager;
import Table.Students;
import resource.ResourceStudents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RegisterPanel extends JPanel {
    Box baseBox, box1, box2, bigBox;
    JTextField stu_idTextField, stu_nameTextField, stu_mmTextField, stu_proTextField, stu_ageTextField, stu_tleTextField;
    JComboBox<String> stu_gradeComboBox = new JComboBox<String>();
    JComboBox<String> stu_sexComboBox = new JComboBox<String>();
    Frame frame;
    List<Students> studentsList;

    public RegisterPanel(Frame frame) {
        this.frame = frame;
        this.studentsList = ResourceStudents.StudentL.getStudentList();
        removeAll();
        init();
        setVisible(true);
        validate();
    }

    void init() {
//        removeAll();
//        JLabel register = new JLabel("注册");
//        register.setFont(new java.awt.Font("宋体",1,20));
//        add(register);
//        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
//        int width = 500;
//        int height = 500;


        bigBox = Box.createVerticalBox();
        JLabel register = new JLabel("注 册");
        register.setFont(new java.awt.Font("宋体", 1, 28));
//        register.setBounds((dimension.width - width) / 2, (dimension.height - height) / 2, width, height);
        bigBox.add(Box.createVerticalStrut(30));
        bigBox.add(register);
        bigBox.add(Box.createVerticalStrut(20));

        box1 = Box.createVerticalBox();
        box1.add(new JLabel("学号："));
        box1.add(Box.createVerticalStrut(13));
        box1.add(new JLabel("姓名："));
        box1.add(Box.createVerticalStrut(13));
        box1.add(new JLabel("设置密码："));
        box1.add(Box.createVerticalStrut(13));
        box1.add(new JLabel("性别："));
        box1.add(Box.createVerticalStrut(13));
        box1.add(new JLabel("年级："));
        box1.add(Box.createVerticalStrut(13));
        box1.add(new JLabel("专业："));
        box1.add(Box.createVerticalStrut(13));
        box1.add(new JLabel("年龄："));
        box1.add(Box.createVerticalStrut(13));
        box1.add(new JLabel("电话："));


        box2 = Box.createVerticalBox();
        stu_idTextField = new JTextField(10);
        box2.add(stu_idTextField);

        box2.add(Box.createVerticalStrut(8));
        stu_nameTextField = new JTextField(10);
        box2.add(stu_nameTextField);

        box2.add(Box.createVerticalStrut(8));
        stu_mmTextField = new JTextField(10);
        box2.add(stu_mmTextField);

        box2.add(Box.createVerticalStrut(8));
        stu_sexComboBox.addItem("男");
        stu_sexComboBox.addItem("女");
        box2.add(stu_sexComboBox);

        box2.add(Box.createVerticalStrut(8));
        stu_gradeComboBox.addItem("2014");
        stu_gradeComboBox.addItem("2015");
        stu_gradeComboBox.addItem("2016");
        stu_gradeComboBox.addItem("2017");
        stu_gradeComboBox.addItem("2018");
        stu_gradeComboBox.addItem("2019");
        stu_gradeComboBox.addItem("2020");
        box2.add(stu_gradeComboBox);

        box2.add(Box.createVerticalStrut(8));
        stu_proTextField = new JTextField(10);
        box2.add(stu_proTextField);

        box2.add(Box.createVerticalStrut(8));
        stu_ageTextField = new JTextField(10);
        box2.add(stu_ageTextField);

        box2.add(Box.createVerticalStrut(8));
        stu_tleTextField = new JTextField(10);
        box2.add(stu_tleTextField);


        baseBox = Box.createHorizontalBox();
        baseBox.add(box1);

        baseBox.add(Box.createHorizontalStrut(10));
        baseBox.add(box2);
        bigBox.add(baseBox);

        bigBox.add(Box.createVerticalStrut(25));
        JButton button = new JButton("注 册");//创建一个按钮
//        button.setBorderPainted(false);
        button.setPreferredSize(new Dimension(100, 30));//设置按钮大小
        button.addActionListener(new ReaderListen());
        bigBox.add(button);

        add(bigBox);

        validate();//保证组件正确显示
        setLayout(new FlowLayout());
    }

    class ReaderListen implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Integer integer = null;
            String Stu_id = stu_idTextField.getText().trim();
            String Stu_name = stu_nameTextField.getText().trim();
            String Stu_mm = stu_mmTextField.getText().trim();
            String Stu_sex = stu_sexComboBox.getSelectedItem().toString();
            System.out.println(Stu_sex);
            int Stu_age = -1;
            try {
                Stu_age = Integer.parseInt(stu_ageTextField.getText().trim());
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
            System.out.println(Stu_age);
            String Stu_grade = stu_gradeComboBox.getSelectedItem().toString();
            String Stu_pro = stu_proTextField.getText().trim();
            String Stu_tle = stu_tleTextField.getText().trim();


            try {//如果异常退出try
                if (Stu_id.equals("")) throw new RuntimeException("学号不能为空");//比较字符串的内容是否相同，内容异常的错误信息
                if (Stu_name.equals("")) throw new RuntimeException("姓名不能为空");
                if (Stu_mm.equals("")) throw new RuntimeException("密码不能为空");
                if (Stu_age == -1) throw new RuntimeException("年龄不能为空");
                if (Stu_pro.equals("")) throw new RuntimeException("专业不能为空");
                if (Stu_tle.equals("")) throw new RuntimeException("电话不能为空");
                Students students = new Students();
                students.setStu_id(Stu_id);
                for (Students s : studentsList) {
                    if (Stu_id.equals(s.getStu_id())) throw new RuntimeException("该学号已经注册");
                }
                studentsList.add(students);
//                JOptionPane.showMessageDialog(frame, "注册成功", "提示", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception exception) {//这是一个异常类
                JOptionPane.showMessageDialog(frame, exception.getMessage(), "提示", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Connection three = SQLManager.getConnection();
            int  result = -1;
            try {
                PreparedStatement pst = three.prepareStatement("insert  into  students values (?,?,?,?,?,?,?,?)");
                pst.setString(1, Stu_id);
                pst.setString(2, Stu_name);
                pst.setString(3, Stu_sex);
                pst.setInt(4, Stu_age);
                pst.setString(5, Stu_grade);
                pst.setString(6, Stu_pro);
                pst.setString(7, Stu_tle);
                pst.setString(8, Stu_mm);
                result = pst.executeUpdate();
                System.out.println(result);

            } catch (SQLException e1) {
                e1.printStackTrace();
            }

            if (result==1) {
                JOptionPane.showMessageDialog(frame, "注册成功", "提示", JOptionPane.INFORMATION_MESSAGE);
                frame.remove(frame.register);
                frame.setState(0);
                frame.init();
            }
            else {
                JOptionPane.showMessageDialog(frame, "注册失败", "提示", JOptionPane.INFORMATION_MESSAGE);
            }
//            while(rs.next()){
//                System.out.println(rs.getString("sno")+" "+rs.getString("s_addr"));
//                shopList.add(new Shop(rs.getString("sno"),rs.getString("s_addr")));



        }

    }
}
