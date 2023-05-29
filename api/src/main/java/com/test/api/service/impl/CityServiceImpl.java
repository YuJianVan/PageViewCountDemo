package com.test.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.test.api.entity.City;
import com.test.api.mapper.CityMapper;
import com.test.api.service.CityService;
import com.test.api.vo.CityVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;


@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityMapper cityMapper;

    @Override
    public CityVo queryCity(CityVo cityVo) {
        List<City> cityList = cityMapper.selectList(new LambdaQueryWrapper<City>().eq(City::getUserId,cityVo.getUserId()).eq(City::getType,1));
        // 设置除了city数组以外的字段
        CityVo resCityVo=new CityVo();
        City city = cityList.get(0);
        BeanUtils.copyProperties(city,resCityVo);

        // 取出城市名
        List<String> cityNameList = new ArrayList<>();
        for (City c: cityList) {
            String[] cityArray = c.getCity().split(";");
            for (String s : cityArray) {
                if (StringUtils.hasText(s)) {
                    cityNameList.add(s);
                }
            }
        }
        resCityVo.setCity(cityNameList);
        return resCityVo;
    }

    @Override
    public void setCity(CityVo cityVo) {
        List<String> cityVoCity = cityVo.getCity();
        StringBuilder stringBuilder=new StringBuilder();
        for (String c:cityVoCity) {
            stringBuilder.append(c);
            stringBuilder.append(";");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);

        City city=new City();
        BeanUtils.copyProperties(cityVo,city);
        city.setCity(stringBuilder.toString());
        cityMapper.insert(city);
    }
}
