package cdictv.tiyitao.bean;

import java.util.List;

public class Weather {

    /**
     * code : 1
     * data : {"didian":"四川","wendu":"19","tianqi":[{"wendu":"21/12","state":"多云转阴"},{"wendu":"29/9","state":"多云转阴"},{"wendu":"11/2","state":"阴转多云"},{"wendu":"21/12","state":"晴"},{"wendu":"21/10","state":"晴"}]}
     */

    private int code;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * didian : 四川
         * wendu : 19
         * tianqi : [{"wendu":"21/12","state":"多云转阴"},{"wendu":"29/9","state":"多云转阴"},{"wendu":"11/2","state":"阴转多云"},{"wendu":"21/12","state":"晴"},{"wendu":"21/10","state":"晴"}]
         */

        private String didian;
        private String wendu;
        private List<TianqiBean> tianqi;

        public String getDidian() {
            return didian;
        }

        public void setDidian(String didian) {
            this.didian = didian;
        }

        public String getWendu() {
            return wendu;
        }

        public void setWendu(String wendu) {
            this.wendu = wendu;
        }

        public List<TianqiBean> getTianqi() {
            return tianqi;
        }

        public void setTianqi(List<TianqiBean> tianqi) {
            this.tianqi = tianqi;
        }

        public static class TianqiBean {
            /**
             * wendu : 21/12
             * state : 多云转阴
             */

            private String wendu;
            private String state;

            public String getWendu() {
                return wendu;
            }

            public void setWendu(String wendu) {
                this.wendu = wendu;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            @Override
            public String toString() {
                return "TianqiBean{" +
                        "wendu='" + wendu + '\'' +
                        ", state='" + state + '\'' +
                        '}';
            }

        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "didian='" + didian + '\'' +
                    ", wendu='" + wendu + '\'' +
                    ", tianqi=" + tianqi +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Weather{" +
                "code=" + code +
                ", data=" + data +
                '}';
    }
}
