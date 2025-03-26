public class bookinfo{     // CLASS TO STORE BOOK RELATED PARAMETERS
    public int id;
    public String title;
    public String author;
    public String genre;
    public Boolean status;

    public bookinfo(int id, String title, String author, String genre, Boolean status) {  // CONSTRUCTOR TO INITIALIZE VARIABLES
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.status = status;
    }

//GETTERS AND SETTERS METHOD OF ALL VARIABLES

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

}
