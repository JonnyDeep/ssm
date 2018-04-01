package cn.hlq.testssm.po;

import java.util.Date;

public class User {
    private Integer iduser;

    private String name;

    private String passwd;

    private Date birthday;

    private String userpic;

    private String tbUsercol;

    private byte[] detail;

    public User(Integer iduser, String name, String passwd, Date birthday, String userpic, String tbUsercol, byte[] detail) {
        this.iduser = iduser;
        this.name = name;
        this.passwd = passwd;
        this.birthday = birthday;
        this.userpic = userpic;
        this.tbUsercol = tbUsercol;
        this.detail = detail;
    }

    public User() {
        super();
    }

    public Integer getIduser() {
        return iduser;
    }

    public void setIduser(Integer iduser) {
        this.iduser = iduser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd == null ? null : passwd.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getUserpic() {
        return userpic;
    }

    public void setUserpic(String userpic) {
        this.userpic = userpic == null ? null : userpic.trim();
    }

    public String getTbUsercol() {
        return tbUsercol;
    }

    public void setTbUsercol(String tbUsercol) {
        this.tbUsercol = tbUsercol == null ? null : tbUsercol.trim();
    }

    public byte[] getDetail() {
        return detail;
    }

    public void setDetail(byte[] detail) {
        this.detail = detail;
    }
}