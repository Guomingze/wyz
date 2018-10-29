package cn.pojo;

public class Trolley {
    private long tid;
    private long tuid;
    private long tpid;
    private long tnumber;
    private long tmoney;
    private long tstate;
    private Pshoping ps;
    private Users us;

    public Users getUs() { return this.us; }

    public void setUs(Users us) { this.us = us; }

    public Pshoping getPs() { return this.ps; }

    public void setPs(Pshoping ps) { this.ps = ps; }

    public long getTid() { return this.tid; }

    public void setTid(long tid) { this.tid = tid; }

    public long getTuid() { return this.tuid; }

    public void setTuid(long tuid) { this.tuid = tuid; }

    public long getTpid() {
        return this.tpid;
    }

    public void setTpid(long tpid) {
        this.tpid = tpid;
    }

    public long getTnumber() {
        return this.tnumber;
    }

    public void setTnumber(long tnumber) {
        this.tnumber = tnumber;
    }

    public long getTmoney() {
        return this.tmoney;
    }

    public void setTmoney(long tmoney) {
        this.tmoney = tmoney;
    }

    public long getTstate() {
        return this.tstate;
    }

    public void setTstate(long tstate) {
        this.tstate = tstate;
    }

}
