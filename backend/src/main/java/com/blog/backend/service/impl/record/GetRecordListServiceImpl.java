package com.blog.backend.service.impl.record;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.backend.mapper.BotMapper;
import com.blog.backend.pojo.Bot;
import com.blog.backend.service.record.GetRecordListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class GetRecordListServiceImpl implements GetRecordListService {
    @Autowired
    private BotMapper botMapper;
    @Override
    public JSONObject getList(Integer page) {
        IPage<Bot> botIPage = new Page<>(page, 4);
        QueryWrapper<Bot> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        List<Bot> bots = botMapper.selectPage(botIPage, queryWrapper).getRecords();
        JSONObject resp = new JSONObject();
        List<JSONObject> items = new LinkedList<>();
        for(Bot bot: bots) {
            JSONObject item = new JSONObject();
            item.put("bot", bot);
            items.add(item);
        }
        resp.put("records", items);
        resp.put("records_count", botMapper.selectCount(null));
        return resp;
    }
}
