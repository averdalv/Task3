package ua.training.model;

import ua.training.exception.SameLoginException;

import javax.xml.crypto.Data;
import java.util.GregorianCalendar;

public class NotebookEntry {
    private Name subscriberName;
    private String subscriberNickName;
    private String commentForSubscriber;
    private String subscriberMobilePhoneNumber;
    private String subscriberHomePhoneNumber;
    private String subscriberEmail;
    private String subscriberSkypeLogin;
    private Address subscriberAddress;
    private GregorianCalendar dateFirstRecord;
    private GregorianCalendar dateLastRecord;


    public Name getSubscriberName() {
        return subscriberName;
    }

    public void setSubscriberName(Name subscriberName) {
        this.subscriberName = subscriberName;
    }

    public String getSubscriberNickName() {
        return subscriberNickName;
    }

    public void setSubscriberNickName(String subscriberNickName) {
        this.subscriberNickName = subscriberNickName;
    }

    public String getCommentForSubscriber() {
        return commentForSubscriber;
    }

    public void setCommentForSubscriber(String commentForSubscriber) {
        this.commentForSubscriber = commentForSubscriber;
    }

    public String getSubscriberMobilePhoneNumber() {
        return subscriberMobilePhoneNumber;
    }

    public void setSubscriberMobilePhoneNumber(String subscriberMobilePhoneNumber) {
        this.subscriberMobilePhoneNumber = subscriberMobilePhoneNumber;
    }

    public String getSubscriberHomePhoneNumber() {
        return subscriberHomePhoneNumber;
    }

    public void setSubscriberHomePhoneNumber(String subscriberHomePhoneNumber) {
        this.subscriberHomePhoneNumber = subscriberHomePhoneNumber;
    }

    public String getSubscriberEmail() {
        return subscriberEmail;
    }

    public void setSubscriberEmail(String subscriberEmail) {
        this.subscriberEmail = subscriberEmail;
    }

    public String getSubscriberSkypeLogin() {
        return subscriberSkypeLogin;
    }

    public void setSubscriberSkypeLogin(String subscriberSkypeLogin) {
        this.subscriberSkypeLogin = subscriberSkypeLogin;
    }

    public Address getSubscriberAddress() {
        return subscriberAddress;
    }

    public void setSubscriberAddress(Address subscriberAddress) {
        this.subscriberAddress = subscriberAddress;
    }

    public GregorianCalendar getDateFirstRecord() {
        return dateFirstRecord;
    }

    public void setDateFirstRecord(GregorianCalendar dateFirstRecord) {
        this.dateFirstRecord = dateFirstRecord;
    }

    public GregorianCalendar getDateLastRecord() {
        return dateLastRecord;
    }

    public void setDateLastRecord(GregorianCalendar dateLastRecord) {
        this.dateLastRecord = dateLastRecord;
    }
    public boolean checkUniqueSkypeLogin(DataBaseMock dataBaseMock) {
        DataBaseMock []values = dataBaseMock.values();
        for(DataBaseMock mock :values) {
            if(getSubscriberSkypeLogin().equals(mock.getSkypeLogin()))
                throw new SameLoginException();
        }
        return true;
    }
}
