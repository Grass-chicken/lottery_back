package com.example.demo.service;

import com.example.demo.entity.Instructor;
import com.example.demo.entity.PeopleInformation;
import com.example.demo.util.Mapper.InstructorMapper;
import com.example.demo.util.Mapper.PeopleInformationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

/**
 * @author xiongtao
 * @date 2023--09--15
 */
@Service
@RequiredArgsConstructor
public class CalculateService {


    private final PeopleInformationMapper peopleInformationMapper;

    private final InstructorMapper instructorMapper;

    public void initialization() {
        List<PeopleInformation> infos = peopleInformationMapper.getAll();
        List<Instructor> instructors = instructorMapper.getAll();

        instructors.forEach(x -> {
            double lotusStu = x.getAmount()
                    / (infos.get(0).getNumber() + infos.get(1).getNumber() + infos.get(2).getNumber())
                    * (infos.get(0).getNumber() + infos.get(1).getNumber());

            lotusStu=Double.parseDouble(new DecimalFormat("#.").format(lotusStu)) ;

            double originStu = x.getAmount() - lotusStu;
            instructorMapper.initStu(x.getId(), lotusStu, originStu);
        });

    }

}




