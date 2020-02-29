package com.baizhi.jbc.Action;


import com.baizhi.jbc.Service.GrunService;
import com.baizhi.jbc.entity.Grun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Grun")
public class GrunAction {

    @Autowired
    private GrunService grunService;

    @RequestMapping("/page")
    @ResponseBody
    public Map<String,Object> page(Integer page,Integer rows)throws Exception{
        Map<String, Object> map = new HashMap<>();
        List<Grun> page1 = grunService.page(page, rows);
        map.put("rows",page1);
        map.put("page",page);

        Integer totalcount = grunService.totalcount();
        map.put("records",totalcount);

        Integer pagecount = 0;
        if (totalcount % rows == 0) {
            pagecount = totalcount / rows;
        } else {
            pagecount = totalcount / rows + 1;
        }
        map.put("total", pagecount);
        return map;
    }

}
