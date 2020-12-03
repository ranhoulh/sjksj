package Frame;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    //0学生登录 1管理员登录 2注册 3学生已登录 4管理员已登录
    private int state = 0;
    public JPanel slogin =  new SLoginPanel(this);
    public JPanel register =  new RegisterPanel(this);
    public JPanel mlogin =  new MLoginPanel(this);
    public JPanel smain =  new SMainPanel(this);
    public JPanel mmain =  new MMainPanel(this);


    JTabbedPane p1;
    JTabbedPane p2;

    public Frame(){
        setBounds(100,100,800,500);
        init();
        setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void init() {

        switch (state){
            case 0:{

                slogin();break;
            }
            case 1:{
                mlogin();
                break;
            }
            case 2:{
                register();
                break;
            }
            case 3:{
                smain();
                break;
            }
            case 4:{
                mmain();
                break;
            }
            default:{slogin();}
        }
    }

    //跳转页面

    private void slogin() {
        add(slogin);
//        add(testPanel);
        validate();

    }

    private void register() {
        add(register);
        validate();
    }

    private void mlogin(){
        add(mlogin);
        validate();
    }

    private void mmain() {
        add(mmain);
        p2 = new JTabbedPane(JTabbedPane.TOP);

        p2.add("图书信息", new MMainPanel(this));
        p2.add("添加图书", new AddPanel(this));
        p2.add("删除图书", new ReducePanel(this));

        p2.validate();
        add(p2, BorderLayout.CENTER);
        validate();
    }

    private void smain() {
        add(smain);
        p1 = new JTabbedPane(JTabbedPane.TOP);

        p1.add("图书信息", new SMainPanel(this));
        p1.add("借阅信息", new MessagePanel(this));

        p1.validate();
        add(p1, BorderLayout.CENTER);
        validate();
    }

    @Override
    public int getState() {
        return state;
    }

    @Override
    public void setState(int state) {
        this.state = state;
    }
}
