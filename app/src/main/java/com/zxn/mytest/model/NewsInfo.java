package com.zxn.mytest.model;

import java.util.List;

public class NewsInfo {


    /**
     * status : ok
     * paramz : {"feeds":[{"id":298930,"oid":288236,"category":"article","data":{"subject":"脑癌患者临终设计APP 造福病人","summary":"荷兰一名末期脑癌病人在临终前，协助催生了专为癌症病患而设的APP。","cover":"/Attachs/Article/288236/18f0e7939842482ab4f222a70bd67da3_padmini.JPG","pic":"","format":"txt","changed":"2015-09-19 14:29:00"}}],"PageIndex":1,"PageSize":1,"TotalCount":26874,"TotalPage":26874}
     */

    private String status;
    private ParamzBean paramz;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ParamzBean getParamz() {
        return paramz;
    }

    public void setParamz(ParamzBean paramz) {
        this.paramz = paramz;
    }

    public static class ParamzBean {
        /**
         * feeds : [{"id":298930,"oid":288236,"category":"article","data":{"subject":"脑癌患者临终设计APP 造福病人","summary":"荷兰一名末期脑癌病人在临终前，协助催生了专为癌症病患而设的APP。","cover":"/Attachs/Article/288236/18f0e7939842482ab4f222a70bd67da3_padmini.JPG","pic":"","format":"txt","changed":"2015-09-19 14:29:00"}}]
         * PageIndex : 1
         * PageSize : 1
         * TotalCount : 26874
         * TotalPage : 26874
         */

        private int PageIndex;
        private int PageSize;
        private int TotalCount;
        private int TotalPage;
        private List<FeedsBean> feeds;

        public int getPageIndex() {
            return PageIndex;
        }

        public void setPageIndex(int PageIndex) {
            this.PageIndex = PageIndex;
        }

        public int getPageSize() {
            return PageSize;
        }

        public void setPageSize(int PageSize) {
            this.PageSize = PageSize;
        }

        public int getTotalCount() {
            return TotalCount;
        }

        public void setTotalCount(int TotalCount) {
            this.TotalCount = TotalCount;
        }

        public int getTotalPage() {
            return TotalPage;
        }

        public void setTotalPage(int TotalPage) {
            this.TotalPage = TotalPage;
        }

        public List<FeedsBean> getFeeds() {
            return feeds;
        }

        public void setFeeds(List<FeedsBean> feeds) {
            this.feeds = feeds;
        }

        public static class FeedsBean {
            /**
             * id : 298930
             * oid : 288236
             * category : article
             * data : {"subject":"脑癌患者临终设计APP 造福病人","summary":"荷兰一名末期脑癌病人在临终前，协助催生了专为癌症病患而设的APP。","cover":"/Attachs/Article/288236/18f0e7939842482ab4f222a70bd67da3_padmini.JPG","pic":"","format":"txt","changed":"2015-09-19 14:29:00"}
             */

            private int id;
            private int oid;
            private String category;
            private DataBean data;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getOid() {
                return oid;
            }

            public void setOid(int oid) {
                this.oid = oid;
            }

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public DataBean getData() {
                return data;
            }

            public void setData(DataBean data) {
                this.data = data;
            }

            public static class DataBean {
                /**
                 * subject : 脑癌患者临终设计APP 造福病人
                 * summary : 荷兰一名末期脑癌病人在临终前，协助催生了专为癌症病患而设的APP。
                 * cover : /Attachs/Article/288236/18f0e7939842482ab4f222a70bd67da3_padmini.JPG
                 * pic :
                 * format : txt
                 * changed : 2015-09-19 14:29:00
                 */

                private String subject;
                private String summary;
                private String cover;
                private String pic;
                private String format;
                private String changed;

                public String getSubject() {
                    return subject;
                }

                public void setSubject(String subject) {
                    this.subject = subject;
                }

                public String getSummary() {
                    return summary;
                }

                public void setSummary(String summary) {
                    this.summary = summary;
                }

                public String getCover() {
                    return cover;
                }

                public void setCover(String cover) {
                    this.cover = cover;
                }

                public String getPic() {
                    return pic;
                }

                public void setPic(String pic) {
                    this.pic = pic;
                }

                public String getFormat() {
                    return format;
                }

                public void setFormat(String format) {
                    this.format = format;
                }

                public String getChanged() {
                    return changed;
                }

                public void setChanged(String changed) {
                    this.changed = changed;
                }
            }
        }
    }
}
