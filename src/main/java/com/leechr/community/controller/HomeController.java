package com.leechr.community.controller;

import com.leechr.community.entity.DiscussPost;
import com.leechr.community.entity.Page;
import com.leechr.community.entity.User;
import com.leechr.community.service.DiscussPostService;
import com.leechr.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    DiscussPostService discussPostService;
    @Autowired
    UserService userService;

    @GetMapping("/index")
    public String getIndexPage(Model model, Page page){
        //SpringMVC会把所有请求数据装入model里,包括page，所以不用返回page，修改page就行。
        page.setRows(discussPostService.findDiscussPostRows(0));
        page.setPath("/index");
        ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        List<DiscussPost> discussPosts = discussPostService.findDiscussPosts(0, page.getOffset(), page.getLimit());
        for (DiscussPost post : discussPosts) {
            HashMap<String, Object> map = new HashMap<>();
            int userId = post.getUserId();
            User user = userService.findUserById(userId);
            map.put("post", post);
            map.put("user",user);
            list.add(map);
        }
        model.addAttribute("discussPosts",list);
        model.addAttribute("page",page);
        return "/index";
    }

}
