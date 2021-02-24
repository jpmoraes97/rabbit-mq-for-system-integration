package br.com.moraesit.rabbitmqproducer.entity;

public class Message {
    private String to;
    private String subject;

    public Message() {

    }

    public Message(String to, String subject) {
        this.to = to;
        this.subject = subject;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTo() {
        return to;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }
}
