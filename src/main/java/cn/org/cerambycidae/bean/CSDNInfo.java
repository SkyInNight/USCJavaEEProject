package cn.org.cerambycidae.bean;

public class CSDNInfo {
    private String _id;
    private String created_time;
    private String article_title;
    private String article_type;
    private String nick_name;
    private String article_link;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCreated_time() {
        return created_time;
    }

    public void setCreated_time(String created_time) {
        this.created_time = created_time;
    }

    public String getArticle_title() {
        return article_title;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }

    public String getArticle_type() {
        return article_type;
    }

    public void setArticle_type(String article_type) {
        this.article_type = article_type;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getArticle_link() {
        return article_link;
    }

    public void setArticle_link(String article_link) {
        this.article_link = article_link;
    }
}
