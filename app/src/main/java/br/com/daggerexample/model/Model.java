package br.com.daggerexample.model;

public class Model {

    private Integer image;
    private String title;
    private String description;

    public Model(){

    }

    public Model(Integer image, String title, String description){
        this();
        this.image = image;
        this.title = title;
        this.description = description;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
