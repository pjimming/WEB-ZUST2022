package com.blog.backend.service.impl.user.bot;

import com.blog.backend.mapper.BotMapper;
import com.blog.backend.pojo.Bot;
import com.blog.backend.pojo.User;
import com.blog.backend.service.impl.utils.UserDetailsImpl;
import com.blog.backend.service.user.bot.RemoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RemoveServiceImpl implements RemoveService {
    @Autowired
    private BotMapper botMapper;

    @Override
    public Map<String, String> remove(Map<String, String> data) {
        UsernamePasswordAuthenticationToken authenticationToken =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl loginUser = (UserDetailsImpl) authenticationToken.getPrincipal();
        User user = loginUser.getUser();

        int id = Integer.parseInt(data.get("id"));
        Bot bot = botMapper.selectById(id);

        Map<String, String> map = new HashMap<>();

        if(bot == null) {
            map.put("error_message", "文章不存在或已被删除");
            return map;
        }
        if(!bot.getUserId().equals(user.getId())) {
            map.put("error_message", "没有权限删除");
            return map;
        }
        botMapper.deleteById(id);

        map.put("error_message", "success");
        return map;
    }
}
