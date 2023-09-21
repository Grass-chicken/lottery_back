package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.entity.WorkAddress;
import com.example.demo.util.tools.StringPool;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @Author:王景阳
 * @DateTime:2022/6/8 18:59
 */
@Service
@RequiredArgsConstructor
public class LotteryService {

    private final WorkAddressService workAddressService;

    private final UserService userService;

    /**
     * 随机获取实习地点，并分配给指定用户
     *
     * @param id 用户的id
     * @return 实习地点
     */
    public int randomGetAddressId(String id) {
        int addressId = 0;
        synchronized (id.intern()) {
            User user = userService.findUserById(id);
            List<WorkAddress> workAddressList = workAddressService.getAllWorkAddress();
            if (user.getIsLottery() == 0) {
                addressId = getWorkAddressIdAndUpdateUser(workAddressList, user.getSex());
                if (addressId == 0) {
                    return 0;
                }
                userService.updateIsLotteryById(id, userService.findUserById(id).getIsLottery() + 1);
                userService.updateAddressById(id,workAddressService.getById(addressId).getAddress(), addressId);
                workAddressService.updateAmountById(addressId, workAddressList.get(addressId - 1).getAmount(), id);

            } else {
                addressId=userService.findUserById(id).getWorkId();
            }
        }
        return addressId;
    }

    /**
     * 获取实习地点的 id
     *
     * @param workAddresses 当前可分配工作的实习地点
     * @return 实习地点的 id
     */
    private int getWorkAddressIdAndUpdateUser(List<WorkAddress> workAddresses, String sex) {
        int weightSum = 0;
        int addressId = 1;
        Random random = new Random();
        for (WorkAddress workAddress : workAddresses) {
            if (check(workAddress, sex)) {
                weightSum += workAddress.getAmount() * 10000;
            }
        }
        if (weightSum == 0) {
            return 0;
        }
        int numberRand = random.nextInt(weightSum);
        weightSum = 0;
        for (WorkAddress workAddress : workAddresses) {
            if (check(workAddress, sex)) {
                weightSum += workAddress.getAmount() * 10000;
                if (weightSum >= numberRand) {
                    addressId = workAddress.getId();
                    break;
                }
            }
        }
        return addressId;
    }

    private boolean check(WorkAddress workAddress, String sex) {
        return !(workAddress.getAmount() <= workAddress.getDefaultNumber() ||
                (workAddress.getSexLimit().equals(StringPool.FEMALE) && sex.equals(StringPool.MALE)));
    }

    /**
     * 检查改用户是否有内定的实习地点
     * 如果有，返回 1（表示内定地点为“白马湖中学”）和 2（表示内定地点为“文昌中学”）
     * 没有，就返回 0
     *
     * @param name 用户姓名
     */
    private int isDefault(String name) {
        if (StringPool.BAI.contains(name)) {
            return StringPool.WHITE_HORSE_LAKE_MIDDLE_SCHOOL_ID;
        } else if (name.equals(StringPool.LI_JIA_LIN)) {
            return StringPool.WEN_CHANG_MIDDLE_SCHOOL_ID;
        } else {
            return 0;
        }
    }

    /**
     * 如果当前用户性别为 “女”，并且桃花源一中还需实习人员，
     * 就使当前用户去桃花源一中去实习
     *
     * @param user            当前用户
     * @param workAddressList 所有实习地点
     * @return 返回 “false”表示当前用户实习地点不是桃花源一中，返回 “true”表示当前用户实习地点是桃花源一中
     */
    private boolean isCanGoTaoYuan(User user, List<WorkAddress> workAddressList) {
        if (user.getSex().equals(StringPool.FEMALE) && workAddressList.get(StringPool.TAO_YUAN_ONE_MIDDLE_SCHOOL_ID - 1).getAmount() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
