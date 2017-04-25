package ua.training.model;

public enum DataBaseMock {
    TEST_LOGIN1("Vasya9"),TEST_LOGIN2("alex1"),TEST_LOGIN3("petro");
    private String skypeLogin;
    private DataBaseMock(String login)
    {
        this.skypeLogin = login;
    }
    public String getSkypeLogin() {
        return skypeLogin;
    }

}
