package com.wangshibiao.springboot_jooqdemo.jooq;

import org.jooq.Transaction;
import org.springframework.transaction.TransactionStatus;

/**
 * Created by Wang Shibiao on 2017/3/1.
 */
public class SpringTransaction  implements Transaction {
    final TransactionStatus tx;

    SpringTransaction(TransactionStatus tx) {
        this.tx = tx;
    }
}
