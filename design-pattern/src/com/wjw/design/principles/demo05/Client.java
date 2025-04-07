package com.wjw.design.principles.demo05;

public class Client {
    public static void main(String[] args) {
        Fans fan = new Fans("赵四");
        Star star = new Star("刘亦菲");
        Company company = new Company("不知名传媒有限公司");
        Agent agent = new Agent();
        agent.setCompany(company);
        agent.setFans(fan);
        agent.setStar(star);

        agent.meeting();
        agent.business();
    }
}
