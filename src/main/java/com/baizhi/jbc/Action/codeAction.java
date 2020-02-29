package com.baizhi.jbc.Action;


import com.baizhi.jbc.util.ImageCodeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;

@Controller
@RequestMapping("code")
public class codeAction {

    @RequestMapping("code")
    public void code(HttpSession session, HttpServletResponse response)throws  Exception{
        String code = ImageCodeUtil.getSecurityCode();
        session.setAttribute("code",code);
        BufferedImage image = ImageCodeUtil.createImage(code);
        ImageIO.write(image,"png",response.getOutputStream());
    }


}
