package project.autobg.chat;

public class ChatMessage {
    private String sender;
    private String content;
    private MessageType type;

    private ChatMessage() {
    }

    public static ChatMessageBuilder builder() {
        return new ChatMessageBuilder();
    }

    public static class ChatMessageBuilder {
        private final ChatMessage chatMessage;

        private ChatMessageBuilder() {
            this.chatMessage = new ChatMessage();
        }

        public ChatMessageBuilder sender(String sender) {
            this.chatMessage.sender = sender;
            return this;
        }

        public ChatMessageBuilder content(String content) {
            this.chatMessage.content = content;
            return this;
        }

        public ChatMessageBuilder type(MessageType type) {
            this.chatMessage.type = type;
            return this;
        }

        public ChatMessage build() {
            return this.chatMessage;
        }
    }

    public String getSender() {
        return sender;
    }

    public ChatMessage setSender(String sender) {
        this.sender = sender;
        return this;
    }

    public String getContent() {
        return content;
    }

    public ChatMessage setContent(String content) {
        this.content = content;
        return this;
    }

    public MessageType getType() {
        return type;
    }

    public ChatMessage setType(MessageType type) {
        this.type = type;
        return this;
    }
}
