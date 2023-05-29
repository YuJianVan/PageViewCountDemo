package com.test.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.test.api.entity.Diary;
import com.test.api.mapper.DiaryMapper;
import com.test.api.service.DiaryService;
import com.test.api.vo.DiaryVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DiaryServiceImpl implements DiaryService {
    @Autowired
    private DiaryMapper diaryMapper;

    @Override
    public void addDiary(DiaryVo diaryVo) {
        List<String> pictures = diaryVo.getPic();
        StringBuilder stringBuilder=new StringBuilder();
        for (String picture:pictures) {
            stringBuilder.append(picture);
            stringBuilder.append(";");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);

        Diary diary=new Diary();
        BeanUtils.copyProperties(diaryVo,diary);
        diary.setPic(stringBuilder.toString());
        diaryMapper.insert(diary);
    }

    @Override
    public List<DiaryVo> queryDiary(DiaryVo diaryVo) {
        Integer userId = diaryVo.getUserId();
        String city = diaryVo.getCity();
        List<Diary> diaryList=null;
        if(null==userId&&!StringUtils.hasText(city)){
            diaryList = diaryMapper.selectList(null);
        }else if(null==userId){
            diaryList = diaryMapper.selectList(new LambdaQueryWrapper<Diary>().like(Diary::getCity,diaryVo.getCity()));
        }else if(!StringUtils.hasText(city)){
            diaryList = diaryMapper.selectList(new LambdaQueryWrapper<Diary>().eq(Diary::getUserId,diaryVo.getUserId()));
        }else{
            diaryList = diaryMapper.selectList(new LambdaQueryWrapper<Diary>().like(Diary::getCity,diaryVo.getCity()).eq(Diary::getUserId,diaryVo.getUserId()));
        }
        List<DiaryVo> diaryVoList=null;
        if(diaryList!=null){
            diaryVoList = diaryList.stream().map(item -> {
                String pic = item.getPic();
                String[] picArray = pic.split(";");
                ArrayList<String> picList = new ArrayList<>();
                for (String s : picArray) {
                    if (StringUtils.hasText(s)) {
                        picList.add(s);
                    }
                }
                DiaryVo diaryVo1 = new DiaryVo();
                BeanUtils.copyProperties(item, diaryVo1);
                diaryVo1.setPic(picList);
                return diaryVo1;
            }).collect(Collectors.toList());
        }
        return diaryVoList;
    }
}
