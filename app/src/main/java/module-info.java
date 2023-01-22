module telepodcast.app {
    requires org.apache.logging.log4j;
    requires org.apache.logging.log4j.core;
    requires jcommander;
    requires com.googlecode.lanterna;
    requires emoji.java;
    requires lombok;
    requires transitive telepodcast.telegram;
    requires transitive telepodcast.youtubedl;
}
