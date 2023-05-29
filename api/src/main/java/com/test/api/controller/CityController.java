package com.test.api.controller;

import com.test.api.entity.City;
import com.test.api.service.CityService;
import com.test.api.utils.Result;
import com.test.api.vo.CityVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class CityController {
    @Autowired
    private CityService cityService;

    /**
     * 查询城市
     */
    @PostMapping("/getCity")
    public CityVo queryCity(@RequestBody CityVo cityVo){
        return cityService.queryCity(cityVo);
    }

    /**
     * 点亮、想去城市
     */
    @PostMapping("setCity")
    public Result setCity(@RequestBody CityVo cityVo){
        cityService.setCity(cityVo);
        return new Result();
    }
}
