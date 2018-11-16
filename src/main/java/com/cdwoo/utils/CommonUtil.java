package com.cdwoo.utils;

/**
 * File：CommonUtil.java
 * Author：cdwoo
 * Date：2016年4月6日 下午2:43:38
 */
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

/**
 * 通用工具类.
 * 
 * @author zhaolingfei
 */
public class CommonUtil {
  
  /**
   * 判断对象或对象数组中每一个对象是否为空.<br>
   * 例如: 对象为null，字符序列长度为0，集合类、Map为empty.
   * 
   * @Author zhaolingfei
   * @Date 2016年4月6日
   * @param obj
   *        需要判断是否为空的对象
   * @return boolean
   */
  public static boolean isNullOrEmpty(Object obj) {
    if (obj == null) {
      return true;
    }
    if (obj instanceof CharSequence) {
      return ((CharSequence) obj).length() == 0;
    }
    if (obj instanceof Collection) {
      return ((Collection<?>) obj).isEmpty();
    }
    if (obj instanceof Map) {
      return ((Map<?, ?>) obj).isEmpty();
    }
    if (obj instanceof Object[]) {
      Object[] object = (Object[]) obj;
      if (object.length == 0) {
        return true;
      }
      boolean empty = true;
      for (int i = 0; i < object.length; i++) {
        if (!isNullOrEmpty(object[i])) {
          empty = false;
          break;
        }
      }
      return empty;
    }
    return false;
  }
  /**
   * 判断字符串是否是数字.
   * 
   * @Author zhaolingfei
   * @Date 2016年4月12日
   * @param str
   *        需要判断的字符串
   * @return boolean
   */
  public static boolean isNumber(String str) {
    return str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
  }
  /**
   * 将list转换为以逗号分隔的字符串.
   * 
   * @Author zhaolingfei
   * @Date 2016年4月15日
   * @param <T>
   *        可以转换的类型
   * @param li
   *        需要转换的list 一般转换String Integer等
   * @return String
   */
  public static <T> String list2String(List<T> li) {
    StringBuilder str = new StringBuilder("");
    for (T t : li) {
      if (StringUtils.isBlank(str.toString())) {
        str.append(t);
      } else {
        str.append("," + t);
      }
    }
    return str.toString();
  }

  /**
   * 验证字符串为邮箱格式.
   * 
   * @Author：cdwoo
   * @Date：2016年4月21日 下午5:12:21
   * @param str
   *        待验证邮箱
   * @return boolean
   */
  public static boolean isEmail(String str) {
    boolean b = false;
    Pattern p = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
    Matcher ma = p.matcher(str);
    b = ma.find();
    return b;
  }
  /**
   * 获取访问者ip地址.
   * 
   * @Author：cdwoo
   * @Date：2016年4月21日 下午5:15:54
   * @param request
   *        请求实体
   * @return String
   */
  public static String getRemoteHost(HttpServletRequest request) {
    String ip = request.getHeader("x-forwarded-for");
    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getHeader("Proxy-Client-IP");
    }
    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getHeader("WL-Proxy-Client-IP");
    }
    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getRemoteAddr();
    }
    return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
  }
  /**
   * request辅助工具 设置编码(UTF8)..
   * 
   * @Author：cdwoo
   * @Date：2016年4月25日 下午2:31:27
   * @param request
   *        请求实体.
   * @return HttpServletRequest HttpServletRequest
   * @throws IOException
   *         HttpServletRequest
   */
  public static HttpServletRequest requestHelper(HttpServletRequest request) throws IOException {
    /* 设置字符集为'UTF-8' */
    request.setCharacterEncoding("UTF-8");
    return request;
  }
  /**
   * request辅助工具 设置编码(UTF8) 及返回格式(application/json).
   * respone.setContentType("application/json")
   * 
   * @Author：cdwoo
   * @Date：2016年4月21日 下午5:24:22
   * @param response
   *        响应实体
   * @return HttpServletResponse
   * @throws IOException
   *         HttpServletResponse
   */
  public static HttpServletResponse responseHelper(HttpServletResponse response) throws IOException {
    /* 设置格式为text/json */
    // response.setContentType("application/json");
    response.setContentType("text/html");
    /* 设置字符集为'UTF-8' */
    response.setCharacterEncoding("UTF-8");
    return response;
  }
  /**
   * request辅助工具 设置编码.
   * 
   * @Author：cdwoo
   * @Date：2016年4月21日 下午5:23:33
   * @param request
   *        请求实体
   * @param character
   *        字符集编码
   * @return HttpServletRequest
   * @throws IOException
   *         HttpServletRequest
   */
  public static HttpServletRequest requestHelperWithCharacter(HttpServletRequest request, String character) throws IOException {
    /* 设置字符集为'UTF-8' */
    request.setCharacterEncoding(character);
    return request;
  }
  /**
   * request辅助工具 设置编码 及返回格式.
   * 
   * @Author：cdwoo
   * @Date：2016年4月21日 下午5:22:44
   * @param response
   *        响应实体
   * @param character
   *        字符集编码
   * @param cType
   *        内容返回格式
   * @return HttpServletResponse
   * @throws IOException
   *         HttpServletResponse
   */
  public static HttpServletResponse responseHelperWithCharacterAndContentType(HttpServletResponse response, String character, String cType) throws IOException {
    response.setContentType(cType);
    /* 设置字符集为'UTF-8' */
    response.setCharacterEncoding(character);
    return response;
  }
  /**
   * Desc : 手工分页 .
   * @author 
   * @date 2017年3月27日 下午4:10:28
   * @param rows 需要分页的数据
   * @param pagesize 页长
   * @param page 当前页
   * @return 分页后的数据
   */
  public static List<Map<String, Object>> getPage(List<Map<String, Object>> rows, Integer pagesize, Integer page) {
    if (CommonUtil.isNullOrEmpty(rows)) {
      return rows;
    }
    // 总量
    int total = rows.size();
    // 起始位置
    int start = (page - 1) * pagesize;
    // 结束位置
    int end = 0;
    if ((start + pagesize) <= total) {
      // 如果起始位置+分页长度小于总和，结束为止就是开始加页长
      end = start + pagesize;
    } else if (start < total && (start + pagesize) > total) {
      end = total;
    } else if (start >= total) {
      start = total - pagesize >= 0 ? (total - pagesize) : 0;
      end = total;
    }
    return rows.subList(start, end);
  }
}