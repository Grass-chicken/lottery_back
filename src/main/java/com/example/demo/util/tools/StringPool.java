package com.example.demo.util.tools;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author:王景阳
 * @DateTime:2022/6/7 21:41
 */
public class StringPool {

    public final static Integer LOCK = 1;

    public final static String EXPORT = "导出成功！";

    public final static String USERNAME_NO_EXIST = "学号不存在！";

    public final static String WRONG_PASSWORD = "姓名错误！";

    public final static String LOGIN_SUCCESSFUL = "登录成功！";

    public final static String ADDRESS = "address";

    public final static String INSTRUCTOR = "instructor";

    public final static String MALE = "男";

    public final static String EMPTY = "";

    public final static Set<String> BAI = new HashSet<String>(){{ add("冯骁");add("涂意泽");add("李杰");
                                            add("邓海军");add("林家荣");add("唐嘉琦");add("李纳尔");}};

    public final static Set<String> DECISION = new HashSet<String>(){{ add("郑和铟");}};

    public final static String LI_JIA_LIN = "李佳霖";

    public final static int WHITE_HORSE_LAKE_MIDDLE_SCHOOL_ID = 6;

    public final static int WEN_CHANG_MIDDLE_SCHOOL_ID = 4;

    public final static int TAO_YUAN_ONE_MIDDLE_SCHOOL_ID = 3;

    public final static int ORIGIN_STU = 1;

    public final static int SHI_FAN_STU = 2;

    public final static int FU_RONG_STU = 3;

    public final static int SHANG_WU_STU=4;

    public final static int SHANG_WU_STU_FU_PIN=5;

    public final static int ORIGIN_TCH = 0;

    public final static int FU_RONG_TCH = 1;

    public final static int SHANG_WU_TCH=2;

    public final static String FU_RONG_NUB ="fuRongNub";

    public final static String SHI_FAN_NUB ="shiFanNub";

    public final static String ORIGIN_NUB ="originNub";

    public final static String LOTUS_NUB ="lotusNub";

    public final static String SHANG_WU_NUB ="shanWuNub";

    public final static List<String> MIDDLE_SCHOOL = Arrays.asList("","常德市第五中学","常德外国语学校","文理学院附属中学十三中学","常德一中育才中学","常德市芷兰实验学校");

    public final static String FEMALE = "女";

    public final static String TEMPLATE_DB_PATH = System.getProperty("user.dir")+"/db/lottery_template.db";

    public final static String MASTER_DB_PATH = System.getProperty("user.dir")+"/db/lottery.db";

}
