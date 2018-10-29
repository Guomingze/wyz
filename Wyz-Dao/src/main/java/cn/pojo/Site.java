package cn.pojo;

public class Site {
    private long sid;
    private long suid;
    private String saddress;
    private int statte;
    private String sphone;

    public String getSphone() {
        return sphone;
    }

    public void setSphone(String sphone) {
        this.sphone = sphone;
    }

    public long getSid() {
        return this.sid;
    }

    public void setSid(long sid) {
        this.sid = sid;
    }

    public long getSuid() {
        return this.suid;
    }

    public void setSuid(long suid) {
        this.suid = suid;
    }

    public String getSaddress() {
        return this.saddress;
    }

    public void setSaddress(String saddress) {
        this.saddress = saddress;
    }

    public int getStatte() {
        return this.statte;
    }

    public void setStatte(int statte) {
        this.statte = statte;
    }
}
