package com.core.common;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Utils {
    private static final Logger l = LoggerFactory.getLogger(Utils.class);

    private static HttpServletResponse resp ;


    public static boolean isPagingParam(String para) {
        if ("page_SIZE".equals(para) || "page_START".equals(para)
                || "startPage".equals(para) || "endPage".equals(para)) {
            return true;
        }
        return false;
    }

    /**
     * 这个字串提供了通用的ORACLE分页解决方案。这个版本是用名称绑定参数的。
     */
    public static final String template = "select pageOutter.* " + "from ("
            + "select pageInner.*, rownum rn " + "from (%s) pageInner "
            + "where rownum<=:endPage "
            + ") pageOutter where pageOutter.rn>:startPage";

    /**
     * 这个版本使用占位符进行位置绑定。
     */
    public static final String templatePlace = "select pageOutter.* "
            + "from (" + "select pageInner.*, rownum rn "
            + "from (%s) pageInner " + "where rownum<=? "
            + ") pageOutter where pageOutter.rn>?";

    public static final String templateCount = "select count(*) from %s";

    /**
     * 返回求结果集count的SQL
     *
     * @param sql
     * @return
     */
    public static String count(String sql) {
        return String.format(templateCount, sql);
    }

    public static String countSQL(String sql) {
        return String.format("select count(*) from (%s)", sql);
    }

    /**
     * 命名参数绑定化SQL。
     *
     * @param sql
     * @return
     */
    public static String paginationName(String sql) {
        return String.format(template, sql);
    }

    /**
     * 位置参数绑定化SQL。
     *
     * @param sql
     * @return
     */
    public static String paginationLocation(String sql) {
        return String.format(templatePlace, sql);
    }

    /**
     * 页面上分页框架的服务端支持，将page_START,page_SIZE,转化为oracle 理解的分页参数。
     *
     * @param map
     */
    public static void paginationCalculator(Map<String, Object> map) {
        /**
         * 从一开始的
         */
        Integer start = (Integer) map.get("page_START");
        Integer max = (Integer) map.get("page_SIZE");

        if (start != null && max != null) {
            int startPage = (start - 1);
            int endPage = start + max - 1;

            map.put("startPage", startPage);
            map.put("endPage", endPage);
        }
    }

    // 该方法用于报表查询分页参数设置
    public static void paginationCalculatorReport(Map<String, Object> map) {
        /**
         * 从一开始的
         */
        Integer start = (Integer) map.get("page_START");
        Integer max = (Integer) map.get("page_SIZE");

        if (start != null && max != null) {
            int startPage = start;
            int endPage = start + max;

            map.put("startPage", startPage);
            map.put("endPage", endPage);
        }
    }

    public static void close(ResultSet rs, PreparedStatement ps) {
        try {
            rs.close();
        } catch (Exception e) {
        }
        try {
            ps.close();
        } catch (Exception e) {
        }
    }

    public static String getVersion(long version) {
        StringBuilder sb = new StringBuilder(30);

        sb.append("<version>").append(version).append("</version>");

        return sb.toString();
    }

    /**
     * 通过读取ResultSet元数据，返回结果集表示的列名数组。
     *
     * @param rs
     * @return
     * @throws SQLException
     */
    private static String[] getColumnMap(ResultSet rs) throws SQLException {
        ResultSetMetaData md = rs.getMetaData();
        String[] map = new String[md.getColumnCount()];
        for (int i = 0; i < map.length; i++) {
            map[i] = md.getColumnLabel(i + 1);
        }
        return map;
    }

    /**
     * 提供通用的sql in 绑定参数解决方案，通过在sql中添加N个占位符，来提供 绑定参数支持。
     * 在目前的oracle环境中，这是一个糟糕的解决方案。 好的办法是 字符串 in: select * from dual where dummy
     * in (select * from table( cast(string_split(?) as tbl_string) )) ; 数字in:
     * select worker_code from t_sys_employee where worker_id in (select * from
     * table( cast(number_split(?) as tbl_number) )) ;
     * 注意，以上SQL中的string_split，number_split函数是自定义的，
     * tbl_string，tbl_number类型也是自定义的。
     *
     * @param length
     * @return
     */
    @Deprecated
    public static String getBindIn(int length) {
        if (length == 0) {
            return "null";
        } else {
            StringBuilder sb = new StringBuilder(2 * length - 1);
            for (int i = 0; i < length; i++) {
                sb.append("?");
                if (i != length - 1) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
    }

    /**
     * 向PreparedStatement中绑定参数，支持空值。
     *
     * @param params
     * @param ps
     * @throws SQLException
     */
    public static void fillPrepareStatement(Object[] params,
                                            PreparedStatement ps) throws SQLException {
        for (int i = 0; i < params.length; i++) {
            int location = i + 1;
            Object para = params[i];

            if (para == null) {
                ps.setNull(location, Types.NULL);
            } else {
                if (para instanceof Long) {
                    Long l = (Long) para;
                    ps.setLong(location, l);
                } else if (para instanceof Double) {
                    Double d = (Double) para;
                    ps.setDouble(location, d);
                } else if (para instanceof Integer) {
                    Integer j = (Integer) para;
                    ps.setInt(location, j);
                } else if (para instanceof Float) {
                    Float f = (Float) para;
                    ps.setFloat(location, f);
                } else if (para instanceof Date) {
                    Timestamp ts = new Timestamp(((Date) para).getTime());
                    ps.setTimestamp(location, ts);
                } else if (para instanceof String) {
                    String s = (String) para;
                    ps.setString(location, s);
                } else if (para instanceof Boolean) {
                    Boolean b = (Boolean) para;
                    ps.setBoolean(location, b);
                }
            }
        }

    }

    /**
     * 查询一个长整型数字的简便方法。
     *
     * @param conn
     * @param sql
     * @param args
     * @return
     * @throws SQLException
     */
    public static Long getLong(Connection conn, String sql, Object... args)
            throws SQLException {
        l.debug("Utils.getLong: {}", sql);
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            rs = ps.executeQuery();
            if (rs.next()) {
                BigDecimal ob = rs.getBigDecimal(1);
                if (ob == null) {
                    return null;
                }
                return ob.longValue();
            } else {
                return null;
            }
        } finally {
            close(rs, ps);
        }
    }

    public static void sqlXML(Connection conn, String sql, String[] map,
                              String wrapName, Writer os, String extra, Object... args)
            throws SQLException {
        sqlXML(conn, sql, map, wrapName, os, extra, -1, args);
    }

    public static void sqlXML(Connection conn, String sql, String[] map,
                              String wrapName, Writer os, String extra, long coId)
            throws SQLException {
        sqlXML(conn, sql, map, wrapName, os, extra, new Object[] { coId });
    }

    public static void sqlXML(Connection conn, String sql, String[] map,
                              String wrapName, Writer os, long coId) throws SQLException {
        sqlXML(conn, sql, map, wrapName, os, null, coId);
    }

    /**
     * 将结果集直接转化为csv格式的文本数据。
     *
     * @param rs
     * @param os
     * @param headers
     * @throws SQLException
     * @throws IOException
     */
    public static void resultSetCSV(ResultSet rs, Writer os, String[] headers)
            throws SQLException, IOException {
        String[] map = getColumnMap(rs);
        if (headers == null) {
            headers = map;
        }

        for (int i = 0; i < map.length; i++) {
            os.write(map[i]);
            if (i != map.length - 1) {
                os.write(",");
            }
        }
        os.write("\n");

        while (rs.next()) {
            for (int i = 0; i < map.length; i++) {
                os.write(nvl(rs.getString(i + 1)));
                if (i != map.length - 1) {
                    os.write(",");
                }
            }
            os.write("\n");
        }
      os.flush();
  }

    public static void resultSetCSV(ResultSet rs, Writer os)
            throws SQLException, IOException {
        resultSetCSV(rs, os, null);
    }

    /**
     * 空或值
     *
     * @param input
     * @param def
     * @return
     */
    public static String nvl(String input, String def) {
        if (input == null) {
            return def;
        }
        return input;
    }

    public static String nvl(String input) {
        return nvl(input, "");
    }


    public static String getStr(int num, String str) {
        StringBuffer sb = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            sb.append(str);
        }
        return sb.toString();
    }



    /**
     * 快速将日志转化成一个标准字符串，注意这里有的format格式 可以是空值，提供了 yyyy-MM-dd 的默认格式。
     *
     * @param date
     *            日期对象
     * @param format
     *            格式
     * @return
     */
    public static String format(Date date, String format) {
        if (date == null) {
            return "";
        }
        if (format == null) {
            format = "yyyy-MM-dd";
        }
        return new SimpleDateFormat(format).format(date);
    }



    public static void checkNull(Object... notNulls) {
        for (Object object : notNulls) {
            if (object == null) {
                throw new RuntimeException("No null value is accepted here.");
            }
        }
    }

    /**
     * 将消息以application/xml的context-type发送到客户端。
     *
     * @param resp
     * @param msg
     * @throws IOException
     */
    public static void sayXML(HttpServletResponse resp, String msg)
            throws IOException {
        resp.setContentType("application/xml");
        say(resp, msg);
    }

    /**
     * 直接将数据发送到客户端。
     *
     * @param resp
     * @param msg
     * @throws IOException
     */
    public static void say(HttpServletResponse resp, String msg)
            throws IOException {
        PrintWriter pw = resp.getWriter();
        pw.println(msg);
        pw.flush();
        pw.close();
    }

    @SuppressWarnings("unchecked")
    public static void testOutputParams(HttpServletRequest req) {
        System.out.println("The query string is " + req.getQueryString());
        System.out.println("The query contains ");
        Enumeration<String> enu = req.getParameterNames();
        while (enu.hasMoreElements()) {
            String key = enu.nextElement();
            System.out.println(key + ": " + req.getParameter(key));
        }
    }

    /**
     * 输出EXT消费的JSON响应。 事实上EXT只关心返回对象的success属性， 用以确定回调成功或是失败函数。
     *
     * @param resp
     * @throws IOException
     */
    public static void saySuccesss(HttpServletResponse resp) throws IOException {
        say(resp, "{success:true}");
    }

    public static void saySuccesss(HttpServletResponse resp, String msg)
            throws IOException {
        say(resp, String.format("{success:true, msg:'%s'}", msg));
    }

    public static void sayFailure(HttpServletResponse resp, String msg)
            throws IOException {
        say(resp, String.format("{success:false, msg:'%s'}", msg));
    }



    public static String getUser(HttpServletRequest req) {
        return (String) req.getSession().getAttribute("token");
    }

    public static void setUser(HttpServletRequest req, Object uid) {
        req.getSession(true).setAttribute("token", uid);
    }

    public static String utf8ToISO(String msg) {
        try {
            return new String(msg.getBytes("utf-8"), "iso8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 简便方法，利用内置的HttpURLConnection通过后缀名来猜测文件类型。
     *
     * @param name
     * @return
     */
    public static String guessContentTypeByName(String name) {
        return HttpURLConnection.guessContentTypeFromName(name);
    }

    public static String toUrlEncode(String msg) {
        try {
            return URLEncoder.encode(msg, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static Long getLongOrNull(String value) {
        Long res = null;

        try {
            res = Long.valueOf(value);
        } catch (Exception e) {
        }

        return res;
    }

    public static Integer getIntegerOrNull(String value) {
        Integer res = null;

        try {
            res = Integer.valueOf(value);
        } catch (Exception e) {
        }
        return res;
    }

    public static Double getDoubleOrNull(String value) {
        Double res = null;

        try {
            res = Double.valueOf(value);
        } catch (Exception e) {
        }

        return res;
    }

    public static boolean isEmpty(String str) {
        boolean flag = false;
        try {
            if (str == null || "".equals(str) || str.length() == 0) {
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            flag = true;
        }
        return flag;
    }

    /**
     * @return
     */
    public static String jsonOutput(List<Object[]> data) {
        if (data == null) {
            throw new IllegalArgumentException(
                    "data, names parameter must not be null and shall have the same length");
        }

        StringBuilder sb = new StringBuilder();

        sb.append("{count:");
        sb.append(data.size());
        sb.append(", data:[");

        for (int i = 0; i < data.size(); i++) {
            Object[] obs = data.get(i);
            sb.append("[");
            for (int j = 0; j < obs.length; j++) {
                sb.append("\"");
                sb.append(obs[j].toString());
                sb.append("\"");
                if (j != obs.length - 1) {
                    sb.append(",");
                }
            }
            sb.append("]");
            if (i != data.size() - 1) {
                sb.append(",");
            }
        }
        sb.append("]}");
        return sb.toString();
    }


    private static long cal(int[] ver) {
        long l = 0;
        for (int i = 0; i < ver.length; i++) {
            l += ver[i] * Math.pow(10000, (ver.length - i - 1));
        }
        return l;
    }




    public static String InputStreamTOString(InputStream in) throws Exception {

        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] data = new byte[200];
        int count = -1;
        while ((count = in.read(data, 0, 200)) != -1)
            outStream.write(data, 0, count);

        data = null;
        return new String(outStream.toByteArray(), "UTF-8");// ISO-8859-1
    }

    public static String escapeTxt(String str) {
        // 特殊字符替换为 ， 逗号
        return str.replaceAll("[\\pP|~|$|^|<|>|\\||\\+|=|￥]*", " ");

    }

    @Test
    public void testStringFilter() {
        String str = "*adCVs*34_a _09_b5*[/435^*&城池()^$$&*).{}+.|.)%%*(*.中国}34{45[]12.fd'*&999下面是中文的字符￥……{}【】。，；’“‘”？";
        System.out.println(str);
        System.out.println(escapeTxt(str));
    }

    public static Object getFloat(String str) {

        return Float.parseFloat((str==null||str.trim()=="")?"0":str);
    }

    public static Properties getPreps(String fileName) {

        Properties prop = null;

        try {
            //System.out.println(fileName+".properties");
            prop = new Properties();
            prop.load(Utils.class.getClassLoader().getResourceAsStream(
                    fileName+".properties"));

        } catch (Exception e) {
            e.printStackTrace();

        }
        return prop;
    }

    public static HttpServletResponse getResp() {
        return resp;
    }

    public static void setResp(HttpServletResponse resp) {
        Utils.resp = resp;
    }


}

