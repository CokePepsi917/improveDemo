package com.cokepepsi.querydsldemo.jpatest;

import com.cokepepsi.querydsldemo.QueryDslDemoApplication;
import com.cokepepsi.querydsldemo.model.po.UserPO;
import com.cokepepsi.querydsldemo.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author CokePepsi
 * @date 2023/9/22 16:41
 */
@SpringBootTest(classes = {QueryDslDemoApplication.class})
@RunWith(SpringRunner.class)
public class JpaTest {

    @Test
    public void testJpaRepository() {
        UserPO userPO = UserPO.builder()
                .username("coke")
                .createTime(new Date())
                .build();

        UserPO save = userRepository.save(userPO);
        System.out.println(save);
    }


    @Test
    public void testDate() {
        Date date = new Date();
        System.out.println(date);
    }
    @Resource
    UserRepository userRepository;
}
