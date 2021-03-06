package parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static parser.Constants.*;

public class Log {
    private static Logger logger;

    public Log() {
        String defaultName = LOGGER_NAME;
        logger = setName(defaultName);
    }

    public Log(String name) {
        setLogger(name);
    }

    private Logger setName(String name) {
        return LoggerFactory.getLogger(name);
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(String name) {
        logger = setName(name);
    }

    public void logError(String message) {
        logger.error(message);
    }
}
