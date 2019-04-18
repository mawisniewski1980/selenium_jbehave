package enums;

public enum JSCommands {

    SCROLLTOBOTTOM1("window.scrollTo(0, document.body.scrollHeight);"),
    SCROLLTOBOTTOM2("window.scrollTo(0, Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));"),
    SCROLLTO("arguments[0].scrollIntoView(true);");

    String command;

    JSCommands(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
