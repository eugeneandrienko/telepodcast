module telepodcast.app {
    requires org.slf4j;
    requires org.slf4j.simple;
    requires com.beust.jcommander;
    requires transitive telepodcast.telegram;
    requires transitive telepodcast.youtubedl;
}
