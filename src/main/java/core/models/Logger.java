package core.models;


import core.mvp.view.View;

public class Logger implements LoggerInterface{
    private String log = "";
    private View view;

    public Logger(View view) {
        this.view = view;
    }


    @Override
    public void appendLog(String logMessage) {
        log = String.format("%s%s\n", log, logMessage);
    }

    @Override
    public void showLog() {
        view.set(log);
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }
}
