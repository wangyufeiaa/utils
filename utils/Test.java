package utils;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
	public static void main(String[] args) {
		
		String news[] = {
	   "外汇局：美国认定中国“汇率操纵”根本站不住脚|http://news.cnstock.com/news,yw-201908-4413224.htm|8|2019-08-08 07:37:32",
	   "二线城市房贷利率接连上调 房贷利率区间波动或成常态|http://news.cnstock.com/news,yw-201908-4413229.htm|5| ",
	   "资产负债管理顶层设计亮相 引导险企向高质量发展转型|http://news.cnstock.com/news,yw-201908-4413222.htm||2019-08-08 07:36:50",
	   "泰康在线获泰康集团增资20亿元|http://news.cnstock.com/news,jg-201908-4413369.htm|7|2019-08-08 09:25:53",
	   "人民银行：中国7月外汇储备为3.1037万亿美元|http://news.cnstock.com/news,bwkx-201908-4412982.htm|10|2019-08-07 16:43:13",
	   "百度战略投资有赞 布局电商小程序|http://news.cnstock.com/news,bwkx-201908-4413414.htm||2019-08-08 10:57:59",
	   "MSCI：8只个股将被新增入MSCI中国指数|http://news.cnstock.com/news,bwkx-201908-4413216.htm|9|2019-08-08 07:28:58",
	   "全球三大指数巨头进入“中国时间”|http://stock.cnstock.com/stock/smk_gszbs/201908/4413244.htm|10|2019-08-08 07:47:08",
	   "8月8日沪深两市最新交易提示|http://news.cnstock.com/news,bwkx-201908-4413227.htm||2019-08-08 07:39:05",
	   "华为发布面向2025十大趋势|http://news.cnstock.com/news,bwkx-201908-4413402.htm|8|2019-08-06 10:19:49",
	   "网易第二季度净收入188亿元 创新业务毛利率转正|http://news.cnstock.com/news,bwkx-201908-4413415.htm||2019-08-08 10:58:39",
	   "中欧班列（郑州）开通俄罗斯新线路|http://news.cnstock.com/news,bwkx-201908-4413425.htm|7|2019-08-08 11:15:24",
	   "我国股权投资市场规模突破10万亿元|http://news.cnstock.com/news,yw-201908-4412690.htm|9|2019-08-07 07:59:11",
	   "临港新片区聚焦高端制造 A股公司提前布局|http://news.cnstock.com/news,yw-201908-4412640.htm|2|2019-08-07 07:42:29",
	   "中国人民银行关于美国财政部将中国列为“汇率操纵国”的声明|http://news.cnstock.com/news,yw-201908-4412630.htm|10| "
	 };
		
	for (String string : news) {
		
		String[] split = string.split("\\|");
		
		String id = StringUtil.getMatcher(split[1], "(\\d{6,8})");
		
		Integer ids = null;
		if(StringUtil.isNumber(id)){
			ids = Integer.parseInt(id);
		}
		
		
		Integer score = 0;
		
		if(!StringUtil.isNullOrEmpty(split[2])){
			score = Integer.parseInt(split[2]);
		}
		
		String created = "";
		if(!StringUtil.isNullOrEmpty(split[3])){
			created = split[3];
		}else{
			created = DateUtil.dateToString(new Date(),"yyyy-MM-dd HH:mm:ss");
		}
		
		News n = new News(ids, split[0], split[1], score ,created);
		
	}
		
		
		
		
		
		
		
		
		
		
		
	}
}
