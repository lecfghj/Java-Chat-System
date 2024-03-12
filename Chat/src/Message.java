public class Message {
    private String content;
    private int reaction;
    private Contact author;
    //Status flag is used to determine whether message was read or not; false - not read, true - read
    private boolean status;

    public Message(){
        reaction = 0;
        status = false;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getReaction() {
        return reaction;
    }

    public void setReaction(int reaction) {
        this.reaction = reaction;
    }

    public Contact getAuthor() {
        return author;
    }

    public void setAuthor(Contact author) {
        this.author = author;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
