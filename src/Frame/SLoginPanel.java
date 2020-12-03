package Frame;

import SQLmanager.SQLManager;
import Table.Students;
import resource.ResourceStudents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SLoginPanel extends JPanel {
    Box baseBox, box1, box2, box4, box3;
    JTextField stu_idTextField, stu_mmTextField;
    Frame frame;
    List<Students> studentsList;

    public SLoginPanel(Frame frame) {
        this.frame = frame;
        this.studentsList = ResourceStudents.StudentL.getStudentList();
        init();
        setVisible(true);
        validate();
    }

    void init() {
//        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
//        int width = 500;
//        int height = 500;
        baseBox = Box.createVerticalBox();
        box1 = Box.createHorizontalBox();
        box2 = Box.createHorizontalBox();
        box3 = Box.createHorizontalBox();
        box4 = Box.createHorizontalBox();


        JLabel register = new JLabel("学生登录");
        register.setFont(new Font("宋体", 1, 28));
//        register.setBounds((dimension.width - width) / 2, (dimension.height - height) / 2, width, height);

        box1.add(Box.createHorizontalStrut(10));
        box1.add(new JLabel("学号："));
        box2.add(Box.createHorizontalStrut(10));
        box2.add(new JLabel("密码："));

        stu_idTextField = new JTextField(6);
        stu_mmTextField = new JTextField(6);



        JButton button1 = new JButton("注 册");//创建一个按钮
        button1.setPreferredSize(new Dimension(50, 20));//设置按钮大小
        button1.addActionListener(new ReaderListen1());

        JButton button2 = new JButton("登 录");//创建一个按钮
        button2.setPreferredSize(new Dimension(100, 30));//设置按钮大小
        button2.addActionListener(new ReaderListen2());


        JButton mlogin = new JButton("管理员登录 >>");
        mlogin.setFont(new Font("宋体", 1, 12));
        mlogin.setForeground(Color.blue);
        Color c = new Color(0, 0, 255);//背影颜色随便设任意值,只起占位作用。
        mlogin.setBackground(c);
        mlogin.setOpaque(false);//透明
        mlogin.setBorderPainted(false);//去掉边框
        mlogin.addActionListener(new ReaderListen3());


        box1.add(Box.createHorizontalStrut(10));
        box1.add(stu_idTextField);
        box1.add(Box.createHorizontalStrut(15));

        box2.add(Box.createHorizontalStrut(10));
        box2.add(stu_mmTextField);
        box2.add(Box.createHorizontalStrut(15));


        box3.add(button1);
        box3.add(Box.createHorizontalStrut(70));
        box3.add(button2);
        box4.add(Box.createHorizontalStrut(150));
        box4.add(mlogin);

        //  baseBox.add(Box.createVerticalStrut(40) );

        baseBox.add(register);
        //    baseBox.add(Box.createVerticalStrut(30) );
        baseBox.add(box1);
        baseBox.add(Box.createVerticalStrut(20) );
        baseBox.add(box2);
        baseBox.add(Box.createVerticalStrut(30) );
        baseBox.add(box3);
        baseBox.add(Box.createVerticalStrut(25) );
        baseBox.add(box4);

//        FlowLayout flowLayout = new FlowLayout();
//        flowLayout.setAlignment(1
//        );
//        flowLayout.setVgap(10);
//        flowLayout.setHgap(200);
//        setLayout(flowLayout);

        FlowLayout fl = new FlowLayout();
        fl.setHgap(20000);
        fl.setVgap(30);
        setLayout(fl);
        add(register);
        add(baseBox);
//        baseBox.setPreferredSize(new Dimension(200,200));

        validate();
    }


    class ReaderListen1 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.remove(frame.slogin);
            frame.setState(2);
            frame.init();
        }

    }


    class ReaderListen2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String Stu_id = stu_idTextField.getText().trim();
            String Stu_mm = stu_mmTextField.getText().trim();
            try {//如果异常退出try
                if (Stu_id.equals("")) throw new RuntimeException("学号不能为空");
                if (Stu_mm.equals("")) throw new RuntimeException("密码不能为空");

//                JOptionPane.showMessageDialog(frame, "注册成功", "提示", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception exception) {//这是一个异常类
                JOptionPane.showMessageDialog(frame, exception.getMessage(), "提示", JOptionPane.WARNING_MESSAGE);
                return;
            }
            Connection three = SQLManager.getConnection();
            try {
                PreparedStatement pst = three.prepareStatement("select stu_mm from students where stu_id=?");
                pst.setString(1, Stu_id);
                ResultSet rs = pst.executeQuery();
                if (rs.equals(Stu_mm)) throw new RuntimeException("用户名或密码有误");
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            frame.remove(frame.slogin);
            frame.setState(3);
            frame.init();
        }
    }


    private class ReaderListen3 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.remove(frame.slogin);
            frame.setState(1);
            frame.init();
        }
    }
}

