package com.baizhi.jbc.Action;

import com.baizhi.jbc.Service.AdminService;

import com.baizhi.jbc.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminAction {

    @Autowired
    private AdminService adminService;

    //管理员登陆
    @RequestMapping("/login")
    public String login(String name, String password, HttpSession session, String code1) throws Exception {
        Admin admin = adminService.login(name, password);
        String code = (String) session.getAttribute("code");
        session.setAttribute("name", name);
        if (code1.equals(code)) {
            if (admin != null) {
                return "/main/main";
            } else {
                return "redirect:/login/login.jsp";
            }
        } else {
            return "redirect:/login/login.jsp";
        }

    }

    //退出登陆
    @RequestMapping("tuichu")
    public String tuichu(HttpSession session) throws Exception {
        session.invalidate();
        return "redirect:/login/login.jsp";

    }
    //dsjakdjaskldjsakldjs
    //djksadjks

    //wodkhjdhsjd
//    尖峰时刻晶方科技
//    ersgf


}
