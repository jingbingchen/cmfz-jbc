package com.baizhi.jbc.Action;

import com.baizhi.jbc.Service.UserService;
import com.baizhi.jbc.entity.City;
import com.baizhi.jbc.entity.Mouth;
import com.baizhi.jbc.entity.ProDTO;
import com.baizhi.jbc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping("/User")
public class UserAction {

    @Autowired
    private UserService userService;

    //分页
    @RequestMapping("page")
    @ResponseBody
    public Map<String, Object> page(Integer page, Integer rows) throws Exception {
        Map<String, Object> map = new HashMap<>();

        List<User> page1 = userService.page(page, rows);

        map.put("rows", page1);
        map.put("page", page);

        Integer totalcount = userService.totalcount();
        map.put("records", totalcount);

        Integer pagecount = 0;
        if (totalcount % rows == 0) {
            pagecount = totalcount / rows;
        } else {
            pagecount = totalcount / rows + 1;
        }
        map.put("total", pagecount);
        return map;

    }

    //修改用户状态
    @RequestMapping("/update")
    @ResponseBody
    public void update(User user) throws Exception {
        userService.update(user);
    }

    //导出用户数据
    @RequestMapping("/export")
    @ResponseBody
    public HashMap<String, String> export() throws Exception {
        HashMap<String, String> hashMap = new HashMap<>();
        userService.export();
        try {
            hashMap.put("message", "导出成功");
        } catch (Exception e) {
            e.printStackTrace();
            hashMap.put("message", "导出失败");

        }
        return hashMap;
    }


    //查询地图男
    @RequestMapping("/selectByCity")
    @ResponseBody
    public ArrayList<Object> selectByCity(String sex, String sexx) throws Exception {
        ArrayList<Object> list = new ArrayList<>();
        List<City> cities = userService.selectBycity(sex);
        ArrayList<City> list1 = new ArrayList<>();
        for (int i = 0; i < cities.size(); i++) {
            list1.add(new City(cities.get(i).getName(), cities.get(i).getValue()));
        }

        List<City> cities1 = userService.selectBycity(sexx);
        ArrayList<City> list2 = new ArrayList<>();
        for (int i = 0; i < cities1.size(); i++) {
            list2.add(new City(cities1.get(i).getName(), cities1.get(i).getValue()));
        }

        ProDTO proDTO = new ProDTO("男", list1);
        ProDTO proDTO1 = new ProDTO("女", list2);
        list.add(proDTO);
        list.add(proDTO1);

        return list;
    }

    //查询月份
    @RequestMapping("/month")
    @ResponseBody
    public HashMap<String, Object> selctBymonth(String sex, String sexx) throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        String arr[] = {"1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"};
        map.put("months", Arrays.asList(arr));
        List<Mouth> mouths = userService.selectBymonth(sex);
        map.put("boys", Arrays.asList(mouths.get(0).getCount(), mouths.get(1).getCount(), mouths.get(2).getCount(),
                mouths.get(3).getCount(), mouths.get(4).getCount(), mouths.get(5).getCount(), mouths.get(6).getCount(),
                mouths.get(7).getCount(), mouths.get(8).getCount(), mouths.get(9).getCount(), mouths.get(10).getCount(),
                mouths.get(11).getCount()));
        List<Mouth> mouths1 = userService.selectBymonth(sexx);
        map.put("girls", Arrays.asList(mouths1.get(0).getCount(), mouths1.get(1).getCount(), mouths1.get(2).getCount(),
                mouths1.get(3).getCount(), mouths1.get(4).getCount(), mouths1.get(5).getCount(), mouths1.get(6).getCount(),
                mouths1.get(7).getCount(), mouths1.get(8).getCount(), mouths1.get(9).getCount(), mouths1.get(10).getCount(),
                mouths1.get(11).getCount()));
        return map;

    }

   /* //模拟
    @ResponseBody
    @RequestMapping("/insert")
    public void insert(User user){
        userService.insert(user);
    }
*/
}
