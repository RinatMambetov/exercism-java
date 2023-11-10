public class LogLine {
    private final String logLine;

    public LogLine(String logLine) {
        this.logLine = logLine;
    }

    public LogLevel getLogLevel() {
        LogLevel ll;
        switch (logLine.substring(1, 4)) {
            case "TRC" -> ll = LogLevel.TRACE;
            case "DBG" -> ll = LogLevel.DEBUG;
            case "INF" -> ll = LogLevel.INFO;
            case "WRN" -> ll = LogLevel.WARNING;
            case "ERR" -> ll = LogLevel.ERROR;
            case "FTL" -> ll = LogLevel.FATAL;
            default -> ll = LogLevel.UNKNOWN;
        }
        return ll;
    }

    public String getOutputForShortLog() {
        String message = ":" + logLine.substring(logLine.indexOf(" ") + 1);
        return getLogLevel().getNum() + message;
    }
}
