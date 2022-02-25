package com.novel.novel.custom;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.novel.novel.dao.UserDao;
import com.novel.novel.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义用户信息服务
 *
 */
@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDao usersDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 根据用户名从数据库查询用户
        UserEntity user = usersDao.selectOne(new QueryWrapper<UserEntity>().eq("nickname", username));
        // 判空
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在！");
        }
        //声明一个用于存放用户权限的列表
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        // 把该用户的角色添加到列表中, ROLE_ 前缀是 SpringSecurity 的规定写法
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
        // 查询数据库返回对象，获得用户名和密码
        return new User(user.getNickname(), user.getPassword(), grantedAuthorities);
    }
}
