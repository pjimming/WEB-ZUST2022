package com.blog.backend.service.impl.user.bot;

import com.blog.backend.mapper.BotMapper;
import com.blog.backend.pojo.Bot;
import com.blog.backend.pojo.User;
import com.blog.backend.service.impl.utils.UserDetailsImpl;
import com.blog.backend.service.user.bot.AddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class AddServiceImpl implements AddService {

    @Autowired
    private BotMapper botMapper;

    @Override
    public Map<String, String> add(Map<String, String> data) {
        UsernamePasswordAuthenticationToken authenticationToken =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl loginUser = (UserDetailsImpl) authenticationToken.getPrincipal();
        User user = loginUser.getUser();

        String content = data.get("content");

        Map<String, String> map = new HashMap<>();

        if (content.length() > 300) {
            map.put("error_message", "内容的长度不能大于300");
            return map;
        }

        if (content.length() > 10000) {
            map.put("error_message", "内容的长度不能超过10000");
            return map;
        }

        Date now = new Date();
        Bot bot = new Bot(null, user.getUsername(), content, now, user.getId());

        botMapper.insert(bot);
        map.put("error_message", "success");

        return map;
    }
}
