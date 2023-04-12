package com.leechr.community;

import com.leechr.community.dao.DiscussPostMapper;
import com.leechr.community.dao.UserMapper;
import com.leechr.community.entity.DiscussPost;
import com.leechr.community.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTests {
    @Autowired
    UserMapper userMapper;
    @Autowired
    DiscussPostMapper discussPostMapper;

    @Test
    public void testSelect() {
        User user = userMapper.selectById(101);
        System.out.println(user);
        user = userMapper.selectByName("aaa");
        System.out.println(user);
        user = userMapper.selectByEmail("nowcoder25@sina.com");
        System.out.println(user);
    }

    @Test
    public void testInsertUser() {
        User user = new User();
        user.setEmail("13690275487@163.com");
        user.setPassword("123456");
        user.setUsername("leechr");
        System.out.println(userMapper.insertUser(user));
    }

    @Test
    public void testUpdate() {
        System.out.println(userMapper.updateStatus(150, 1));
        System.out.println(userMapper.updateHeader(150, "null"));
        System.out.println(userMapper.updatePassword(150, "666888666"));
    }

//    @Test
//    public void testDiscussPost() {
//        List<DiscussPost> discussPosts = discussPostMapper.selectDiscussPosts(150);
//        for (DiscussPost discussPost : discussPosts) {
//            System.out.println(discussPost);
//        }
//        System.out.println("=======================");
//        int i = discussPostMapper.selectDiscussPostRows(150);
//        System.out.println(i);
//    }


}
