package com.fyj.startdemo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fyj.startdemo.entity.Film;
import com.fyj.startdemo.mapper.FilmMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FilmController {
    @Autowired
    private FilmMapper filmMapper;

    @GetMapping("/")
    public List<Film> getAllResult(){
        return filmMapper.selectList(null);
    }
}
