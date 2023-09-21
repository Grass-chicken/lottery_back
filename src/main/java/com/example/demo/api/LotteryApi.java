package com.example.demo.api;


import com.example.demo.service.ExtractService;
import com.example.demo.service.LotteryService;
import com.example.demo.util.Mapper.InstructorMapper;
import com.example.demo.util.rest.R;
import com.example.demo.util.tools.StringPool;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 抽取实习地点接口
 *
 * @Author:王景阳
 * @DateTime:2022/6/7 21:42
 */
@RestController
@RequiredArgsConstructor
public class LotteryApi {

    private final LotteryService lotteryService;

    private final ExtractService extractService;

    private final InstructorMapper instructorMapper;
    @GetMapping("/lottery/address/{id}")
    public R<?> lottery(@PathVariable("id") String id) {
        Map<String, Integer> map = new HashMap<>(1);
            map.put(StringPool.ADDRESS, lotteryService.randomGetAddressId(id));
        return R.data(map);
    }

    @GetMapping("/lottery/instructor/{id}")
    public R<?> extract(@PathVariable("id") String id){

            return R.data(instructorMapper.getAll(), extractService.randomGetInstructorId(id));

    }

}
