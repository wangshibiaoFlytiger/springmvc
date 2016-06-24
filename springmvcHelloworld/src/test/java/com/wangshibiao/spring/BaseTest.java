package com.wangshibiao.spring;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Wang Shibiao on 2016/6/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/mainCtx.xml")
@Transactional
public class BaseTest {
}
