package cn.pojo;

public class Orderll {
    private Integer oid;
    private Integer oname;
    private Integer ocommodity;
    private Integer ostate;
    private Integer onumber;
    private Integer omoney;
    private Pshoping pshoping;


    public Pshoping getPshoping() {
        return pshoping;
    }

    public void setPshoping(Pshoping pshoping) {
        this.pshoping = pshoping;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getOname() {
        return oname;
    }

    public void setOname(Integer oname) {
        this.oname = oname;
    }

    public Integer getOcommodity() {
        return ocommodity;
    }

    public void setOcommodity(Integer ocommodity) {
        this.ocommodity = ocommodity;
    }

    public Integer getOstate() {
        return ostate;
    }

    public void setOstate(Integer ostate) {
        this.ostate = ostate;
    }

    public Integer getOnumber() {
        return onumber;
    }

    public void setOnumber(Integer onumber) {
        this.onumber = onumber;
    }

    public Integer getOmoney() {
        return omoney;
    }

    public void setOmoney(Integer omoney) {
        this.omoney = omoney;
    }

}
