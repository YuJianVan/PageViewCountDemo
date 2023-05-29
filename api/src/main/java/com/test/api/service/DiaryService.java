package com.test.api.service;

import com.test.api.vo.DiaryVo;

import java.util.List;

public interface DiaryService {

    void addDiary(DiaryVo diaryVo);

    List<DiaryVo>  queryDiary(DiaryVo diaryVo);
}
