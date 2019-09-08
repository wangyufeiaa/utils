package utils;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*  
字符串工具类：
	1.	判断源字符串是否有值，空引号也算没值	String 源字符串
	2.	判断源字符串是否有值，空引号和空格也算没值	String 源字符串
	3.	判断是否为手机号码	String 源字符串
	4.	判断是否为电子邮箱	String 源字符串
	5.	判断是否全部为字母	String源字符串
	6.	获取n位随机英文字符串   
	7.	获取n位随机英文和数字字符串
	8.	获取n个随机中文字符串
*/
public class StringUtil {
	
	/**
	 * 判断源字符串是否有值(null)，空引号("")也算没值 , 空格字符也算没值("   ")
	 * @param str
	 * @return
	 */
	public static boolean isNullOrEmpty(String str){
		if (str==null || "".equals(str.trim()) || "null".equals(str.trim()) ){
			return true;
		}
		return false;
	}
	

	/**
	 * 判断是否为手机号码
	 * @param mobile
	 * @return
	 */
	public static boolean isMobileNumber(String mobile){
		return mobile.matches("^1[3|4|5|7|8]\\d{9}$");
	}
	
	
	/**
	 * 判断是否为电子邮箱
	 * @param email
	 * @return
	 */
	public static boolean isEmail(String email){
		return email.matches("\\w+@(\\w+\\.)+[a-z]{2,3}"); 
	}
	
	
	/**
	 * 判断是否全部为字母
	 * @param str
	 * @return
	 */
	public static boolean is_alpha(String str){
		if(str==null) return false;
	    return str.matches("[a-zA-Z]+");
	}
	
	/**
	 * 获取n位随机英文字符串
	 * @param n
	 * @return
	 */
	public static String getRandomString(int n) {
		StringBuffer buffer = new StringBuffer();
		
		for (int i=0; i<n; i++) {
			char randomChar = (char)((Math.random()*58)+65);
			randomChar = randomChar > 90 && randomChar < 97 ? (char)(randomChar + 8) : randomChar;
			buffer.append(randomChar);
		}
		
		return buffer.toString();
	}
	
	/**
	 * 获取n位随机英文和数字字符串
	 * @param n
	 * @return
	 */
	public static String getNumStringRandom(int n){
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i <n; i++) {
			String randString =  random.nextInt(2)%2==0?"char":"num";
			
			if("char".equals(randString)){
				
				String randomString = getRandomString(1);
				sb.append(randomString);
				
			}else if("num".equals(randString)){
				
				String numRandom = getNumRandom(1);
				sb.append(numRandom);
			}
		}
		return sb.toString();
	}

	/**
	 * 生成随机数字 
	 * @param length
	 * @return
	 */
	public static String getNumRandom(int length) {  
        String val = "";  
        Random random = new Random();  
        //参数length，表示生成几位随机数  
        for(int i = 0; i < length; i++) {  
            val += String.valueOf(random.nextInt(10));  
        }  
        return val;  
    }
    
    
    /**
     * 获取n个随机中文字符串
     * @param n		需要获取字符串长度
     * @return
     */
	public static String genChineseString(int n) {
		StringBuffer buffer = new StringBuffer();
		int start = Integer.valueOf("4e00", 16);
		int end = Integer.valueOf("9fa5", 16);
		// 生成中文字符的算法如下：
		for (int i=0; i < n; i++) {
			char randomChar = (char)((Math.random()*(end-start+1))+start);
			buffer.append(randomChar);
		}
		
		return buffer.toString();
	}
	
	
	/**
	 * 判断是否是数字
	 * @param src 
	 * @return
	 */
	public static boolean isNumber(String src) {
		boolean result = false;
		
		try {
			double number = Double.valueOf(src);
			result = true;
		} catch (NumberFormatException e) {
			result = false;
		}
		
		return result;
	}
	
	
	/**
	 * 根据正则表达式提取源字符串中的一个部分
	 * @param src	需要操作的字符串
	 * @param regex 条件正则表达式
	 * @return
	 */
	public static String getMatcher(String src, String regex) {
		String result = "";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(src);
		while (matcher.find()) {
			result = matcher.group();
		}
		return result;
	}
}
