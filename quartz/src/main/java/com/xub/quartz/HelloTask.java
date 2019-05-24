package com.xub.quartz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xub
 * @Name: HelloTask
 * @Description: TODO
 * @date 2019/5/24  9:30
 */
@Component
public class HelloTask {
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    /**
     * 第一种形式：fixedRate：定时执行（每隔多少毫秒执行一次，扩展性较差）
     */
    @Scheduled(fixedRate = 3000)
    public void task1(){
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        logger.info("任务1执行时间：{}",simpleDateFormat.format(date));
    }

    /**
     * 第一种形式：cron表达式：定时执行（扩展性较强，可根据用户需要进行定制）
     *
     * 　corn从左到右（用空格隔开）：秒 分 小时 月份中的日期 月份 星期中的日期 年份
     *
     * 　　二、各字段的含义
     *
     *
     * 字段	允许值	允许的特殊字符
     * 秒（Seconds）	0~59的整数	, - * /    四个字符
     * 分（Minutes）	0~59的整数	, - * /    四个字符
     * 小时（Hours）	0~23的整数	, - * /    四个字符
     * 日期（DayofMonth）	1~31的整数（但是你需要考虑你月的天数）	,- * ? / L W C     八个字符
     * 月份（Month）	1~12的整数或者 JAN-DEC	, - * /    四个字符
     * 星期（DayofWeek）	1~7的整数或者 SUN-SAT （1=SUN）	, - * ? / L C #     八个字符
     * 年(可选，留空)（Year）	1970~2099	, - * /    四个字符
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     * 　　注意事项：
     *
     * 　　每一个域都使用数字，但还可以出现如下特殊字符，它们的含义是：
     *
     * 　　（1）*：表示匹配该域的任意值。假如在Minutes域使用*, 即表示每分钟都会触发事件。
     *
     * 　　（2）?：只能用在DayofMonth和DayofWeek两个域。它也匹配域的任意值，但实际不会。因为DayofMonth和DayofWeek会相互影响。例如想在每月的20日触发调度，不管20日到底是星期几，则只能使用如下写法： 13 13 15 20 * ?, 其中最后一位只能用？，而不能使用*，如果使用*表示不管星期几都会触发，实际上并不是这样。
     *
     * 　　（3）-：表示范围。例如在Minutes域使用5-20，表示从5分到20分钟每分钟触发一次
     *
     * 　　（4）/：表示起始时间开始触发，然后每隔固定时间触发一次。例如在Minutes域使用5/20,则意味着5分钟触发一次，而25，45等分别触发一次.
     *
     * 　　（5）,：表示列出枚举值。例如：在Minutes域使用5,20，则意味着在5和20分每分钟触发一次。
     *
     * 　　（6）L：表示最后，只能出现在DayofWeek和DayofMonth域。如果在DayofWeek域使用5L,意味着在最后的一个星期四触发。
     *
     * 　　（7）W:表示有效工作日(周一到周五),只能出现在DayofMonth域，系统将在离指定日期的最近的有效工作日触发事件。例如：在 DayofMonth使用5W，如果5日是星期六，则将在最近的工作日：星期五，即4日触发。如果5日是星期天，则在6日(周一)触发；如果5日在星期一到星期五中的一天，则就在5日触发。另外一点，W的最近寻找不会跨过月份 。
     *
     * 　　（8）LW:这两个字符可以连用，表示在某个月最后一个工作日，即最后一个星期五。
     *
     * 　　（9）#:用于确定每个月第几个星期几，只能出现在DayofMonth域。例如在4#2，表示某月的第二个星期三。
     * 在线cron表达式生成： http://cron.qqe2.com/
     */
    @Scheduled(cron = "0/5 * * * * ? ")
    public void task2(){
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        logger.info("任务2执行时间：{}",simpleDateFormat.format(date));
    }

}
