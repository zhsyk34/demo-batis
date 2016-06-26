package com.cat.demo.dao;

import com.cat.demo.constant.DictEnum;
import com.cat.demo.entity.Order;
import com.cat.demo.util.FormatUtil;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

/**
 * Created by Archimedes on 2016/6/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class OrderDaoTest {

    @Resource
    private OrderDao orderDao;

    @Test
    public void save() throws Exception {
        int types = DictEnum.GridType.values().length;
        int status = DictEnum.OrderStatus.values().length;

        long current = System.currentTimeMillis();
        for (int i = 10; i < 30; i++) {
            Order order = new Order();
            order.setOrderNo("1000" + i);

            order.setGridType(DictEnum.GridType.values()[RandomUtils.nextInt(0, types)]);
            order.setTenantId(RandomUtils.nextInt(1, 4));
            order.setHouseId(RandomUtils.nextInt(1, 4));

            long offset = RandomUtils.nextLong(3 * 365, 5 * 365) * (1000 * 3600 * 24);

            order.setBegin(new Date(current - offset));
            order.setEnd(new Date(current + offset));
            order.setHappen(new Date(current - offset - 3600));

            order.setStatus(DictEnum.OrderStatus.values()[RandomUtils.nextInt(0, status)]);

            orderDao.save(order);
        }
    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void delete1() throws Exception {

    }

    @Test
    public void delete2() throws Exception {

    }

    @Test
    public void delete3() throws Exception {

    }

    @Test
    public void update() throws Exception {

    }

    @Test
    public void find1() throws Exception {
        List<Order> orders = orderDao.findList(null, -1, -1, DictEnum.GridType.HOUSE, null, null);
        orders.forEach(order -> System.out.println(order));
    }

    @Test
    public void find2() throws Exception {
        List<Order> orders = orderDao.findList(null, 3, -1, null, null, null);
        System.out.println("=======result:========");
        orders.forEach(order -> System.out.println(order));
    }

    @Test
    public void findList() throws Exception {

        List<Order> orders = orderDao.findList(null, -1, -1, null, FormatUtil.stringToDate("2012-11-13 10:00:00", null), null);
        System.out.println("=======result:========");
        orders.forEach(order -> System.out.println(order));
    }

    @Test
    public void count() throws Exception {

    }

}
