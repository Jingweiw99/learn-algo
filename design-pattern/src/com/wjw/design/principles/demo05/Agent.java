package com.wjw.design.principles.demo05;

/*
经纪类 聚合 明星 粉丝公司
 */
public class Agent {
    private Star star;
    private Fans fans;
    private Company company;

    public Star getStar() {
        return star;
    }

    public Fans getFans() {
        return fans;
    }

    public Company getCompany() {
        return company;
    }

    public void setStar(Star star) {
        this.star = star;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setFans(Fans fans) {
        this.fans = fans;
    }

    // 安排明星和粉丝见面
    public void meeting() {
        System.out.println("明星" + getStar().getName() + "与粉丝" + getFans().getName() + "见面");
    }
    // 安排明星和公司商谈业务
    public void business() {
        System.out.println("明星" + getStar().getName() + "与公司" + getCompany().getName() + "商谈业务");
    }
}
