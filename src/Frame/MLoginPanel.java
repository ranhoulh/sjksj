package Frame;

import SQLmanager.SQLManager;
import Table.Manager;
import Table.Students;
import resource.ResourceManager;
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

public class MLoginPanel extends JPanel {
    Box box1,box2,baseBox,bigBox;
    JTextField m_idTextField, m_mmTextField;
    Frame frame;
    List<Manager> managerList;
    public MLoginPanel(Frame frame) {
        this.frame = frame;
        this.managerList = ResourceManager.ManagerL.getManagerList();
        removeAll();
        init();
        setVisible(true);
        validate();
    }

    void init(){
        bigBox = Box.createVerticalBox();
        JLabel register = new JLabel("管理员登录");
        register.setFont(new Font("宋体", 1, 28));
        bigBox.add(Box.createVerticalStrut(30));
        bigBox.add(Box.createVerticalStrut(20));

        box1 = Box.createVerticalBox();
        box1.add(new JLabel("帐号："));
        box1.add(Box.createVerticalStrut(18));
        box1.add(new JLabel("密码："));

        box2 = Box.createVerticalBox();
        m_idTextField = new JTextField(10);
        box2.add(m_idTextField);
        box2.add(Box.createVerticalStrut(13));
        m_mmTextField = new JTextField(10);
        box2.add(m_mmTextField);

        baseBox = Box.createHorizontalBox();
        baseBox.add(box1);
        baseBox.add(Box.createHorizontalStrut(10));
        baseBox.add(box2);
        bigBox.add(baseBox);

        bigBox.add(Box.createVerticalStrut(30));
        JButton button = new JButton("登 录");//创建一个按钮
        button.setPreferredSize(new Dimension(100, 30));//设置按钮大小
        button.addActionListener(new ReaderListen());
        bigBox.add(button);
        add(bigBox);


        FlowLayout fl = new FlowLayout();
        fl.setHgap(20000);
        fl.setVgap(30);
        setLayout(fl);
        add(register);
        add(baseBox);
//        baseBox.setPreferredSize(new Dimension(200,200));

        validate();
    }


    private class ReaderListen implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String m_id = m_idTextField.getText().trim();
            String m_mm = m_mmTextField.getText().trim();
            try {//如果异常退出try
                if (m_id.equals("")) throw new RuntimeException("帐号不能为空");
                if (m_mm.equals("")) throw new RuntimeException("密码不能为空");

            } catch (Exception exception) {//这是一个异常类
                JOptionPane.showMessageDialog(frame, exception.getMessage(), "提示", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Connection three = SQLManager.getConnection();
            try {
                PreparedStatement pst = three.prepareStatement("select m_mm from manager where m_id=?");
                pst.setString(1, m_id);
                ResultSet rs = pst.executeQuery();
                if (rs.equals(m_mm)) throw new RuntimeException("用户名或密码有误");
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            frame.remove(frame.mlogin);
            frame.setState(4);
            frame.init();
        }
    }
}
