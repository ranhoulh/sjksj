package Table;

public class Br {
    String br_id;
    String Stu_id;
    String b_id;
    String br_btime;
    String br_rtime;
    String br_overtime;
    int br_fee;


    public String getStu_id() { return Stu_id; }
    public void setStu_id(String Stu_id) { this.Stu_id = Stu_id; }

    public String getb_id() { return b_id; }
    public void setb_id(String b_id) { this.b_id = b_id; }

    public String getbr_btime() { return br_btime; }
    public void setbr_btime(String br_btime) { this.br_btime = br_btime; }

    public String getbr_rtime() { return br_rtime; }
    public void setbr_rtime(String br_rtime) { this.br_rtime = br_rtime; }

    public String getbr_overtime() { return br_overtime; }
    public void setbr_overtime(String br_overtime) { this.br_overtime = br_overtime; }

    public int  getbr_fee() { return br_fee; }
    public void setbr_fee(int br_fee) { this.br_fee = br_fee; }
}
