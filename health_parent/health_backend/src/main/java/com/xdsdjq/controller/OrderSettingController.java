package com.xdsdjq.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xdsdjq.constant.MessageConstant;
import com.xdsdjq.entity.QueryPageBean;
import com.xdsdjq.entity.Result;
import com.xdsdjq.pojo.Member;
import com.xdsdjq.pojo.Order;
import com.xdsdjq.pojo.OrderSetting;
import com.xdsdjq.service.MemberService;
import com.xdsdjq.service.OrderSettingService;
import com.xdsdjq.utils.DateUtils;
import com.xdsdjq.utils.POIUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orderSetting")
public class OrderSettingController {

    @Reference
    private OrderSettingService orderSettingService;

    @Reference
    private MemberService memberService;

    /**
     * 文件上传实现 预约设置批量导入
     *
     * @param excelFile
     * @return
     */
    @RequestMapping("/upload")
    public Result upload(@RequestParam("excelFile") MultipartFile excelFile) {
        try {
            List<String[]> strList = POIUtils.readExcel(excelFile);
            List<OrderSetting> data = new ArrayList<>();
            for (String[] strings : strList) {
                String orderDate = strings[0];
                String number = strings[1];
                OrderSetting orderSetting = new OrderSetting(new Date(orderDate), Integer.parseInt(number));
                data.add(orderSetting);
            }
            orderSettingService.add(data);
            return new Result(true, MessageConstant.IMPORT_ORDERSETTING_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            //文件解析失败
            return new Result(false, MessageConstant.IMPORT_ORDERSETTING_FAIL);
        }
    }

    @RequestMapping("/findOrderSettingByMonth")
    public Result findOrderSettingByMonth(String date) { //格式yyyy-MM
        try {
            List<Map> list = orderSettingService.findOrderSettingByMonth(date);
            return new Result(true, MessageConstant.QUERY_ORDER_SUCCESS, list);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_ORDER_FAIL);
        }
    }

    @RequestMapping("/editNumberByDate")
    public Result editNumberByDate(@RequestBody OrderSetting orderSetting) {

        try {
            orderSettingService.editNumberByDate(orderSetting);
            return new Result(true, MessageConstant.ORDERSETTING_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.ORDERSETTING_FAIL);
        }
    }

    /**
     * 用户管理分页
     * @param queryPageBean
     * @return
     * @throws Exception
     */

    @RequestMapping("/findOrdersPage")
    public Map findOrdersPage(@RequestBody QueryPageBean queryPageBean) throws Exception {
        Map map = orderSettingService.findOrdersPage(queryPageBean);
        return map;
    }

    @RequestMapping("/submit")
    public Result submit(Integer[] setmealIds,@RequestBody Map<String,Object> map){
        try {
            //从map集合中获取预约的时间，检验当前日期是否进行了预约设置
            String orderDate = (String) map.get("orderDate");
            Date date = DateUtils.parseString2Date(orderDate);
            OrderSetting orderSetting = orderSettingService.findByOrderDate(date);
            if (orderSetting == null) {
                return new Result(false, MessageConstant.SELECTED_DATE_CANNOT_ORDER);
            }
            //检查当前日期是否已经预约满
            int number = orderSetting.getNumber();
            int reservations = orderSetting.getReservations();
            if (reservations >= number) {
                return new Result(false, MessageConstant.ORDER_FULL);
            }
            //获取用户手机号码
            String telephone = (String) map.get("phoneNumber");
            Member member = memberService.findByTelephone(telephone);

            //判断用户是否是会员，不是自动添加成会员
            if (member == null) {
                //不是会员，自动注册成会员
                member = new Member();
                member.setName((String) map.get("name"));
                member.setSex((String) map.get("sex"));
                member.setIdCard((String) map.get("idCard"));
                member.setPhoneNumber(telephone);
                member.setRegTime(new Date());
                int add = memberService.add(member);
                member.setId(add);
            }
            map.put("member_id",member.getId());
            System.out.println(map+"=================================");
            orderSettingService.submit(setmealIds,map);
            orderSetting.setReservations(orderSetting.getReservations() + 1);
            orderSettingService.editReservationsByOrderDate(orderSetting);

            return new Result(true,MessageConstant.ADD_ORDERSETTING_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.ADD_ORDERSETTING_FAIL);
        }
    }

    @RequestMapping("/deleteOrderById")
    public Result deleteOrderById(Integer id){
        try {
            String status= orderSettingService.findByStatus(id);
            if (status.equals(Order.ORDERSTATUS_NO)) {
                orderSettingService.deleteOrderById(id);
                return new Result(true, MessageConstant.DELETE_ORDER_SUCCESS);
            }else {
                return new Result(false,MessageConstant.DELETEALL_ORDER_FAIL);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.DELETE_ORDER_FAIL);
        }
    }
    @RequestMapping("/deleteAll")
    public Result deleteAll(Integer[] orderIds){
        try {
            for (Integer id : orderIds) {
                String byStatus = orderSettingService.findByStatus(id);
                if (byStatus.equals(Order.ORDERSTATUS_YES)){
                    return new Result(false,MessageConstant.DELETEALL_ORDER_FAIL);
                }
            }
            orderSettingService.deleteAll(orderIds);
            return new Result(true,MessageConstant.DELETE_ORDERS_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.DELETE_ORDERS_FAIL);
        }
    }

}
