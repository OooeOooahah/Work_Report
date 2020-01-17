public class test {
    public static void main(String[] args) {
        String key="columnameList[2].newOrder";
        System.out.println(key.indexOf("name"));
        if (key.indexOf("name")==-1 && key.indexOf("descript")==-1){
            System.out.println("不能存在该字符串");
        }else {
            System.out.println("存在字符串");
        }
    }
}
