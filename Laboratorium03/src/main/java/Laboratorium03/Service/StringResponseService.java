package Laboratorium03.Service;


    public class StringResponseService {
        public Boolean result;

        public StringResponseService(Boolean x) {
            result = x;
        }

        public Boolean getResult() {
            return result;
        }

        public void setResult(Boolean result) {
            this.result = result;
        }
    }