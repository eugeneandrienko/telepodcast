module telepodcast.app {
    requires org.apache.logging.log4j;
    requires org.apache.logging.log4j.core;
    requires jcommander;
    requires net.fellbaum.jemoji;
    requires com.googlecode.lanterna;
    requires lombok;
    requires transitive telepodcast.telegram;
    requires transitive telepodcast.youtubedl;
}
