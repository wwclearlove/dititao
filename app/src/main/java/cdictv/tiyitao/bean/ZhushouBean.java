package cdictv.tiyitao.bean;

public class ZhushouBean  {

    /**
     * code : 1
     * data : {"wendu":"17","shidu":"58","pm":286,"guangzhao":"integer(0,100)"}
     */

    public int code;
    public DataBean data;

    public static class DataBean {
        /**
         * wendu : 17
         * shidu : 58
         * pm : 286
         * guangzhao : integer(0,100)
         */

        public String wendu;
        public String shidu;
        public int pm;
        public String guangzhao;
    }
}
