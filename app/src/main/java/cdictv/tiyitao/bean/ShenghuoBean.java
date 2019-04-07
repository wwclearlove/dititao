package cdictv.tiyitao.bean;

public class ShenghuoBean {

    /**
     * code : 1
     * data : {"ziwaixian":4086,"ganmao":3,"chuanyi":24,"yundong":4266,"wuran":93}
     */

    public int code;
    public DataBean data;

    public static class DataBean {
        /**
         * ziwaixian : 4086
         * ganmao : 3
         * chuanyi : 24
         * yundong : 4266
         * wuran : 93
         */

        public int ziwaixian;
        public int ganmao;
        public int chuanyi;
        public int yundong;
        public int wuran;
    }
}
