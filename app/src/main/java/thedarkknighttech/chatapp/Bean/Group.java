package thedarkknighttech.chatapp.Bean;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Group implements Serializable {
    private String groupKey;
    private ArrayList<ChatMessage> messages;
    private String groupName;
    private String groupDescription;

    public Group(){
        messages = new ArrayList<>();
    }
    public Group(String groupName, String groupDescription) {
        this.groupName = groupName;
        this.groupDescription = groupDescription;
        this.messages = new ArrayList<>();
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
    }

    public String getGroupKey() {
        return groupKey;
    }

    public void setGroupKey(String groupKey) {
        this.groupKey = groupKey;
    }

    public ArrayList<ChatMessage> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<ChatMessage> messages) {
        this.messages = messages;
    }
}
