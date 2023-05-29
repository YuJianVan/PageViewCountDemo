package com.test.api.controller;

import com.test.api.entity.City;
import com.test.api.entity.Diary;
import com.test.api.service.DiaryService;
import com.test.api.utils.ResponseResult;
import com.test.api.utils.Result;
import com.test.api.vo.DiaryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DiaryController {
    @Autowired
    private DiaryService diaryService;

    /**
     * 查询日记
     */
    @PostMapping("/getDiary")
    public List<DiaryVo> queryDiary(@RequestBody DiaryVo diaryVo){
        return diaryService.queryDiary(diaryVo);
    }

    /**
     * 添加日记
     */
    @PostMapping("/setDiary")
    public Result addDiary(@RequestBody DiaryVo diaryVo){
        diaryService.addDiary(diaryVo);
        return new Result();
    }

}
