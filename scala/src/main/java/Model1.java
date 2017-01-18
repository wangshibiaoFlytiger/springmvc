import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Wang Shibiao on 2017/1/17.
 */
public class Model1 {
    public static Map fun1(String in){
        Map<String, String> outMap = new HashMap<>();
        outMap.put("in", in);
        outMap.put("msg", "我是自定义java类的方法");

        return outMap;
    }
}
