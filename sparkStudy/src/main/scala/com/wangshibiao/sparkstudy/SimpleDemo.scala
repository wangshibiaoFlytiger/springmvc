package com.wangshibiao.sparkstudy

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by Wang Shibiao on 2017/1/20.
  */
object SimpleDemo {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("sparkStudy").setMaster("local[*]")
    val sc = new SparkContext(conf)
    val textFile = sc.textFile("file:///F:/github/springmvc/sparkStudy/src/main/java/com/wangshibiao/sparkstudy/RDD.txt")
    val count = textFile.count()
    textFile.first()
  }
}
