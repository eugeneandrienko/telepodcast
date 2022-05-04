module telepodcast.app {
    requires org.slf4j;
    requires org.slf4j.simple;
    requires com.beust.jcommander;
    requires lombok;
    requires transitive telepodcast.telegram;
    requires transitive telepodcast.youtubedl;
}
