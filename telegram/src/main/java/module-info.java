module telepodcast.telegram {
    exports com.eugene_andrienko.telegram.api;
    exports com.eugene_andrienko.telegram.api.exceptions;
    requires org.apache.logging.log4j;
    requires org.apache.logging.log4j.core;
    requires lombok;
    requires org.apache.commons.lang3;
}
