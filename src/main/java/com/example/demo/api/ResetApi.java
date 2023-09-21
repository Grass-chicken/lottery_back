package com.example.demo.api;

import com.example.demo.service.CalculateService;
import com.example.demo.util.rest.R;
import com.example.demo.util.tools.FileTool;
import com.example.demo.util.tools.StringPool;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:王景阳
 * @DateTime:2022/6/10 8:50
 */
@RestController
@RequiredArgsConstructor
public class ResetApi {


    private final CalculateService calculateService;

    @GetMapping("/reset/database")
    public R<?> resetDb() {
        FileTool.copyFile(StringPool.TEMPLATE_DB_PATH, StringPool.MASTER_DB_PATH);
//        calculateService.initialization();
        return R.ok();
    }

}
