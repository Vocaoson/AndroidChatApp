package thedarkknighttech.chatapp.Bean;

public class Chat {
    private String image;
    private String FriendName;
    private String lastMessage;
    private String time;

    public Chat(String image, String friendName, String lastMessage, String time) {
        this.image = image;
        FriendName = friendName;
        this.lastMessage = lastMessage;
        this.time = time;
    }
    public Chat(String friendName) {
        FriendName = friendName;
    }

    public String getFriendName() {
        return FriendName;
    }

    public void setFriendName(String friendName) {
        FriendName = friendName;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
