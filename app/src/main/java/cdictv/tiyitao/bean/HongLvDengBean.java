package cdictv.tiyitao.bean;

import java.util.List;

public class HongLvDengBean {


    /**
     * code : 1
     * data : [{"id":1,"red":10,"green":3,"yellow":9},{"id":2,"red":12,"green":12,"yellow":6},{"id":3,"red":12,"green":17,"yellow":3},{"id":4,"red":12,"green":17,"yellow":19},{"id":5,"red":7,"green":19,"yellow":17}]
     */

    public int code;
    public List<DataBean> data;

    public static class DataBean {
        /**
         * id : 1
         * red : 10
         * green : 3
         * yellow : 9
         */

        public int id;
        public int red;
        public int green;
        public int yellow;
    }
}
