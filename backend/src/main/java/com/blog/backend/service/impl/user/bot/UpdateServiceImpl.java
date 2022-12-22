//package com.blog.backend.service.impl.user.bot;
//
//import com.blog.backend.mapper.BotMapper;
//import com.blog.backend.pojo.Bot;
//import com.blog.backend.pojo.User;
//import com.blog.backend.service.impl.utils.UserDetailsImpl;
//import com.blog.backend.service.user.bot.UpdateService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Service;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//@Service
//public class UpdateServiceImpl implements UpdateService {
//    @Autowired
//    private BotMapper botMapper;
//
//    @Override
//    public Map<String, String> update(Map<String, String> data) {
//        UsernamePasswordAuthenticationToken authenticationToken =
//                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
//        UserDetailsImpl loginUser = (UserDetailsImpl) authenticationToken.getPrincipal();
//        User user = loginUser.getUser();
//
//        int id = Integer.parseInt(data.get("id"));
//
//        String title = data.get("title");
//        String content = data.get("content");
//
//        Map<String, String> map = new HashMap<>();
//
//        if (title == null || title.length() == 0) {
//            map.put("error_message", "标题不能为空");
//            return map;
//        }
//
//        if (title.length() > 100) {
//            map.put("error_message", "标题长度不能大于100");
//            return map;
//        }
//
//        if (content.length() > 10000) {
//            map.put("error_message", "内容不能大于10000");
//            return map;
//        }
//
//        if (content == null || content.length() == 0) {
//            map.put("error_message", "内容不能为空");
//            return map;
//        }
//
//        Bot bot = botMapper.selectById(id);
//
//        if (bot == null) {
//            map.put("error_message", "帖子不存在或已被删除");
//            return map;
//        }
//
//        if (!bot.getUserId().equals(user.getId())) {
//            map.put("error_message", "没有权限修改该贴");
//            return map;
//        }
//
//        Bot new_bot = new Bot(
//                bot.getId(),
//                user.getId(),
//                content,
//                bot.getCreatetime(),
//                title,
//                new Date()
//        );
//
//        botMapper.updateById(new_bot);
//
//        map.put("error_message", "success");
//        return map;
//    }
//}
